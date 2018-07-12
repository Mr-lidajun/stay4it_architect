package com.ldj.lib;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lidajun on 2018/6/17.
 */

public class VerifyHelper {

    private static final String PATTERN_EMAIL = "^1\\d{10}$";
    private static final java.lang.String PATTERN_MOBILE = "";
    private ArrayList<Item> list;

    public enum VerifyType {
        NO_EMPTY,
        MOBILE,
        EMAIL,
        IDCARD,
        TRUE,
        FALSE,
    }

    public class Item {
        Object value;
        String tip;
        VerifyType type;

        public Item(Object value, String tip, VerifyType type) {
            this.value = value;
            this.tip = tip;
            this.type = type;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public String getTip() {
            return tip;
        }

        public void setTip(String tip) {
            this.tip = tip;
        }

        public VerifyType getType() {
            return type;
        }

        public void setType(VerifyType type) {
            this.type = type;
        }
    }

    public VerifyHelper() {
        this.list = new ArrayList<>();
    }

    public interface VerifyListener {
        void onSuccess();
    }

    public static VerifyHelper getInstance() {
        return new VerifyHelper();
    }

    public VerifyHelper add(String value, String tip, VerifyType type) {
        list.add(new Item(value, tip, type));
        return this;
    }

    public VerifyHelper add(Boolean value, String tip, VerifyType type) {
        list.add(new Item(value, tip, type));
        return this;
    }

    public void verify(VerifyListener listener) {
        boolean success = true;
        try {
            for (Item item : list) {
                Object value = item.getValue();
                String tip = item.getTip();

                if (value instanceof String) {
                    String str = (String) value;
                    switch (item.getType()) {
                        case NO_EMPTY:
                            verifyEmpty(str, tip);
                            break;
                        case MOBILE:
                            verifyMobile(str, tip);
                            break;
                        case EMAIL:
                            verifyEmail(str, tip);
                            break;
                        case IDCARD:
                            verifyIDcard(str, tip);
                            break;
                    }
                }

                if (value instanceof Boolean) {
                    Boolean flag = (Boolean) value;
                    switch (item.getType()) {
                        case TRUE:
                            verifyTrue(flag, tip);
                            break;
                        case FALSE:
                            verifyFalse(flag, tip);
                            break;
                    }
                }
            }
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
        }
        if (success) {
            listener.onSuccess();
        }
    }

    private void verifyFalse(Boolean flag, String tip) {
        if (flag) {
            throw new RuntimeException(tip);
        }
    }

    private void verifyTrue(Boolean flag, String tip) {
        if (!flag) {
            throw new RuntimeException(tip);
        }
    }

    private void verifyIDcard(String value, String tip) {
        if (!is18ByteIdCard(value)) {
            throw new RuntimeException(tip);
        }
    }

    private void verifyEmail(String value, String tip) {
        Pattern r = Pattern.compile(PATTERN_EMAIL);
        Matcher m = r.matcher(value);
        if (!m.find()) {
            throw new RuntimeException(tip);
        }
    }

    private void verifyMobile(String value, String tip) {
        Pattern r = Pattern.compile(PATTERN_MOBILE);
        Matcher m = r.matcher(value);
        if (!m.find()) {
            throw new RuntimeException(tip);
        }
    }

    private void verifyEmpty(String value, String tip) {
        if (value == null || "".equals(value.trim())) {
            throw new RuntimeException(tip);
        }
    }

    private boolean is18ByteIdCard(String value) {
        return false;
    }

}
