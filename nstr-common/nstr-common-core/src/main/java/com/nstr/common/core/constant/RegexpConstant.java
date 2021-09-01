package com.nstr.common.core.constant;

import java.util.regex.Pattern;

public interface RegexpConstant {
    // 简单手机号正则（这里只是简单校验是否为 11位，实际规则更复杂）
    String MOBILE_REG = "[1]\\d{10}";

    /**
     * 中文正则
     */
    Pattern CHINESE = Pattern.compile("[\u4e00-\u9fa5]");
}
