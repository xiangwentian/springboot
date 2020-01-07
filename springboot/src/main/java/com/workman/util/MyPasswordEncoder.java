package com.workman.util;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description TODO
 * @Auth 向问天
 * @Date 2020/1/7 11:03
 * @Version 1.0
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return charSequence.equals(s.toString());
    }
}
