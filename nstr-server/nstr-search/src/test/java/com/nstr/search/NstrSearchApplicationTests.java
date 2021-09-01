package com.nstr.search;

import com.alibaba.fastjson.JSON;
import com.nstr.search.config.NstrElasticSearchConfig;
import lombok.Data;
import lombok.ToString;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.Avg;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class NstrSearchApplicationTests {

    @Autowired
    private RestHighLevelClient client;

    @Test
    void contextLoads() throws IOException {

        IndexRequest indexRequest = new IndexRequest("users");
        indexRequest.id("1");
        User user = new User("zhangsan", "M", 18);
        indexRequest.source(JSON.toJSONString(user), XContentType.JSON);
        IndexResponse index = client.index(indexRequest, NstrElasticSearchConfig.COMMON_OPTIONS);
        System.out.println(index);
        System.out.println(client);
    }

    @Test
    void searchTest() throws IOException {
        SearchRequest searchRequest = new SearchRequest().indices("bank");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //searchSourceBuilder.sort();
        //searchSourceBuilder.from();
        //searchSourceBuilder.size();
        //searchSourceBuilder.aggregation();
        //searchSourceBuilder.query(QueryBuilders.matchQuery());
        searchSourceBuilder.query(QueryBuilders.matchQuery("address", "mill"));
        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("aggAge").field("age").size(10);
        searchSourceBuilder.aggregation(termsAggregationBuilder);

        AvgAggregationBuilder avgAggregationBuilder = AggregationBuilders.avg("balanceAvg").field("balance");
        searchSourceBuilder.aggregation(avgAggregationBuilder);

        searchRequest.source(searchSourceBuilder);

        SearchResponse search = client.search(searchRequest, NstrElasticSearchConfig.COMMON_OPTIONS);
        SearchHit[] hits = search.getHits().getHits();
        for (SearchHit hit : hits) {
            String sourceAsString = hit.getSourceAsString();
            Account account = JSON.parseObject(sourceAsString, Account.class);
            System.out.println("搜索结果是： " + account);
        }

        Aggregations aggregations = search.getAggregations();
        Terms terms = aggregations.get("aggAge");
        for (Terms.Bucket term : terms.getBuckets()) {
            System.out.println("年龄分布： " + term.getKeyAsString() + " " + term.getDocCount() + " 个");
        }
        Avg avg = aggregations.get("balanceAvg");
        System.out.println("平均薪资： " + avg.getValue());
    }

}

class User {
    private String userName;
    private String gender;
    private Integer age;

    public User(String userName, String gender, Integer age) {
        this.userName = userName;
        this.gender = gender;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

@Data
@ToString
class Account {
    private int account_number;
    private int balance;
    private String firstname;
    private String lastname;
    private int age;
    private String gender;
    private String address;
    private String employer;
    private String email;
    private String city;
    private String state;
}
