package com.nstr.common.core.validator;

import com.nstr.common.core.annotation.IsMobile;
import com.nstr.common.core.constant.RegexpConstant;
import com.nstr.common.core.utils.NstrUtils;
import org.apache.commons.lang3.StringUtils;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileValidator implements ConstraintValidator<IsMobile, String> {
    @Override
    public void initialize(IsMobile constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if (StringUtils.isBlank(s)) {
                return true;
            } else {
                String regex = RegexpConstant.MOBILE_REG;
                return NstrUtils.match(regex, s);
            }
        } catch (Exception e) {
            return false;
        }
    }
}
