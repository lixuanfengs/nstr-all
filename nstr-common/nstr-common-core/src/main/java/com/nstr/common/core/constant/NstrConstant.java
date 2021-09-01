package com.nstr.common.core.constant;

public interface NstrConstant {


    String NSTR_CLOUD = "nstr-cloud";
    String NSTR_AUTH = "nstr-auth";
    String NSTR_COMMON = "nstr-common";
    String NSTR_GATEWAY = "nstr-gateway";
    String NSTR_SERVER = "nstr-server";
    String NSTR_INSTRUMENT = "nstr-instrument";
    String NSTR_SEARCH = "nstr-search";
    String NSTR_SYSTEM = "nstr-system";
    String NSTR_TEST = "nstr-test";


    /**
     * 排序规则：降序
     */
    String ORDER_DESC = "descending";
    /**
     * 排序规则：升序
     */
    String ORDER_ASC = "ascending";

    /**
     * Gateway 请求头TOKEN名称（不要有空格）
     */
    String GATEWAY_TOKEN_HEADER = "GatewayToken";
    /**
     * Gateway 请求头TOKEN值
     */
    String GATEWAY_TOKEN_VALUE = "nstr:gateway:123456";

    /**
     * gif类型
     */
    String GIF = "gif";
    /**
     * png类型
     */
    String PNG = "png";

    /**
     * 验证码 key前缀
     */
    String CODE_PREFIX = "nstr.captcha.";

    /**
     * Java默认临时目录
     */
    String JAVA_TEMP_DIR = "java.io.tmpdir";

    /**
     * 异步线程池名称
     */
    String ASYNC_POOL = "nstrAsyncThreadPool";

    /**
     * OAUTH2 令牌类型 https://oauth.net/2/bearer-tokens/
     */
    String OAUTH2_TOKEN_TYPE = "bearer";

}
