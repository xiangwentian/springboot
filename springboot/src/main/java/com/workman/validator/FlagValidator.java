package com.workman.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Description TODO
 * @Auth 向问天
 * @Date 2020/1/1 21:27
 * @Version 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy = FlagValidatorClass.class)
public @interface FlagValidator {
    //flag的有效值多个使用","隔开
    String value();

    //提示内容
    String message() default "flag不存在";

    Class<?>[] groups() default {};

    Class<? extends Payload[]>[] payload() default {};
}
