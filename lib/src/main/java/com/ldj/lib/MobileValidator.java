package com.ldj.lib;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lidajun
 * @date 2018/6/17
 */

public class MobileValidator implements Validator.IValidater {

    private static final String PATTERN_MOBILE = "^1\\d{10}$";

    @Override
    public boolean verify(String content) {
        Pattern r = Pattern.compile(PATTERN_MOBILE);
        Matcher m = r.matcher(content);
        if (m.find()) {
            return true;
        }
        return false;
    }
}
