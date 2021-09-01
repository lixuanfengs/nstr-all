package com.nstr.search.vo;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 单台套科学仪器设备
 *
 * @author lixuanfeng
 * @email lixf19970809@gmail.com
 * @date 2021-06-10 16:40:45
 */
@Data
@ToString
public class SingleInstrumentVo {

    /**
     * 数据库中唯一标识
     */
    private Integer id;
    /**
     * 中文名称
     */
    private String cname;
    /**
     * 英文名称
     */
    private String ename;
    /**
     * 所属单位
     */
    private Integer ins;
    /**
     * 所属单位标识
     */
    private String insCode;
    /**
     * 所属仪器类型
     */
    private Integer instrBelongsType;
    /**
     * 所属仪器编号
     */
    private Integer instrBelongsId;
    /**
     * 所属科学仪器中心id
     */
    private Integer instrBelongsCenterId;
    /**
     * 所属大型科学装置id
     */
    private Integer instrBelongsDeviceId;
    /**
     * 所属科学服务单元id
     */
    private Integer instrBelongsUnitId;
    /**
     * 所属仪器内部编号
     */
    private String instrBelongsName;
    /**
     * 所在单位仪器编号
     */
    private String innerId;
    /**
     * 设备分类编码
     */
    private String instrCategory;
    /**
     * 仪器设备来源
     */
    private Integer instrSource;
    /**
     * 海关监管情况(0：否，1：是)
     */
    private Integer instrSupervise;
    /**
     * 原值（万元）
     */
    private Double worth;
    /**
     * 产地国别代码
     */
    private String nation;
    /**
     * 生产制造商
     */
    private String manufacturer;
    /**
     * 启用日期
     */
    private Date beginDate;
    /**
     * 仪器设备类别
     */
    private Integer type;
    /**
     * 规格型号
     */
    private String instrVersion;
    /**
     * 主要技术指标
     */
    private String technical;
    /**
     * 主要功能
     */
    /**
     * 主要学科领域
     */
    private String subject;
    /**
     * 服务内容
     */
    private String serviceContent;
    /**
     * 服务的典型成果
     */
    private String achievement;
    /**
     * 图片
     */
    private Integer image;
    /**
     * 运行状态
     */
    private Integer status;
    /**
     * 对外开放共享规定
     */
    private String requirement;
    /**
     * 参考收费标准
     */
    private String fee;
    /**
     * 预约服务地址
     */
    private String serviceUrl;
    /**
     * 仪器安放地址的地区代码
     */
    private String locationCode;
    /**
     * 安放地址-街道
     */
    private String location;
    /**
     * 仪器联系人
     */
    private String contact;
    /**
     * 电话
     */
    private String phone;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 通讯地址
     */
    private String address;
    /**
     * 邮政编码
     */
    private String postalcode;
    /**
     * 属于哪类科研设施与仪器，该字段用于查询及建索引
     */
    private Integer instruType;
    /**
     * 仪器所在地经度
     */
    private BigDecimal lng;
    /**
     * 仪器所在地纬度
     */
    private BigDecimal lat;
    /**
     * 数据状态标识，0：未建索引，1：已建索引，2：已建索引且需要更新
     */
    private Integer dataHint;
    /**
     * 入网年份
     */
    private String year;
    /**
     * 审核状态：-1：未提交、0：待审核、1：审核通过、2：审核不通过
     */
    private Integer auditStatus;
    /**
     * 审核不通过的原因
     */
    private String auditReason;
    /**
     * 数据标识（11：未修改的资源调查数据、12：已修改的资源调查数据、21：新增得到的大仪平台数据）
     */
    private Integer flag;
    /**
     * 共享模式
     */
    private Integer shareMode;
    /**
     * 数据录入时间
     */
    private Date filltime;
    /**
     * 标志
     */
    private String reportType;
    /**
     * 插入时间
     */
    private Date insertTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 审核时间
     */
    private Date auditTime;
    /**
     * 运行机时
     */
    private Double runMachine;
    /**
     * 服务机时
     */
    private Double serviceMachine;
    /**
     * 对外服务收入
     */
    private Double serviceIncome;
    /**
     * 更新和资料上报时间
     */
    private Date addResultTime;
    /**
     * 购置经费来源
     */
    private String funds;
    /**
     * 所属单位内部门
     */
    private String insideDepart;
    /**
     * 仪器隶属国家重点实验室、国家工程技术研究中心、生物种质资源库馆的名称
     */
    private String resourceName;
    /**
     * 判断单位信息是否修改
     */
    private Integer ifUpdateStatus;
    /**
     * 创新成效1
     */
    private String singleRemarkOne;
    /**
     * 创新成效2
     */
    private String singleRemarkTwo;
    /**
     * 科技成效填报完成情况（0：未完成；1：已完成）
     */
    private Integer remarkFlag;
    /**
     * 通过接口上报数据时间
     */
    private Date interfaceTime;

}
