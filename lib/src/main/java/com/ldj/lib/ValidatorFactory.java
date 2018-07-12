package com.ldj.lib;

/**
 *
 * @author lidajun
 * @date 2018/6/17
 */

public class ValidatorFactory {
    public enum VerifyType {
        NO_EMPTY,
        MOBILE,
        EMAIL,
        IDCARD,
        TRUE,
        FALSE,
    }

    public static MobileValidator create(VerifyType type){
        switch (type) {
            case NO_EMPTY:
                return new MobileValidator();
            case MOBILE:
                break;
            case EMAIL:
                break;
            case IDCARD:
                break;
        }
        return null;
    }
}
