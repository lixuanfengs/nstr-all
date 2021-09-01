package com.nstr.common.core.converter;

import com.nstr.common.core.utils.DateUtil;
import com.wuwenze.poi.convert.WriteConverter;
import com.wuwenze.poi.exception.ExcelKitWriteConverterException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;

/**
 * Execl导出时间类型字段格式化
 */
@Slf4j
public class TimeConverter implements WriteConverter {
    @Override
    public String convert(Object o) {
        if (o == null) {
            return StringUtils.EMPTY;
        } else {
            try {
                return DateUtil.formatCSTTime(o.toString(), DateUtil.FULL_TIME_SPLIT_PATTERN);
            } catch (ParseException e) {
                String message = "时间转换异常";
                log.error(message, e);
                throw new ExcelKitWriteConverterException(message);
            }
        }
    }
}
