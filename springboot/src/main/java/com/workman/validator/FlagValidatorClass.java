package com.workman.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description TODO
 * @Auth 向问天
 * @Date 2020/1/1 21:32
 * @Version 1.0
 */
public class FlagValidatorClass implements ConstraintValidator<FlagValidator, Object> {

    //临时变量保存flag值列表
    private String values;

    @Override
    public void initialize(FlagValidator constraintAnnotation) {
        this.values = constraintAnnotation.value();
    }

    //实现验证
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        //分隔定义的有效值
        String[] value_array = values.split(",");
        boolean isFlag = false;
        //遍历比对有效性
        for (int i = 0; i < value_array.length; i++) {
            //存在一致跳出循环，赋值isFlag=true
            if (value_array[i].equals(value)) {
                isFlag = true;
                break;
            }
        }
        //返回是否存在boolean
        return isFlag;
    }
}
