package com.workman.entity;

import com.workman.validator.FlagValidator;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Description 参数校验 demo
 * @Auth 向问天
 * @Date 2020/1/1 19:44
 * @Version 1.0
 */
@Getter
@Setter
public class ValidatorDemoEntity implements Serializable {
    @NotBlank
    @Length(min = 2, max = 10)
    private String name;
    @Min(value = 1)
    private int age;
    @NotBlank
    @Email
    private String mail;
    @FlagValidator(value = "1,2,3")
    private String flag;

}
