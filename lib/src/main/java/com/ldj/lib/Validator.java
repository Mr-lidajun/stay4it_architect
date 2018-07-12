package com.ldj.lib;

import java.util.ArrayList;

/**
 * Created by lidajun on 2018/6/17.
 */

public class Validator {
    private final ArrayList<Item> items;

    public Validator() {
        items = new ArrayList<>();
    }

    public class Item {
        public String content;
        public String tip;
        public IValidater validater;

        public Item(String value, String tip, IValidater validater) {
            this.content = value;
            this.tip = tip;
            this.validater = validater;
        }
    }

    public Validator add(String content, String tip, IValidater validater) {
        items.add(new Item(content, tip, validater));
        return this;
    }

    public void verify(ValidatorCallback callback) {
        for (Item item : items) {
            if (item.validater.verify(item.content)) {
                continue;
            } else {
                if (callback != null) {
                    callback.onFailure(item.tip);
                    return;
                }
            }
        }
        if (callback != null) {
            callback.onSuccess();
        }
    }

    public interface IValidater {
        boolean verify(String content);
    }

    public interface ValidatorCallback {
        void onSuccess();
        void onFailure(String message);
    }
}
