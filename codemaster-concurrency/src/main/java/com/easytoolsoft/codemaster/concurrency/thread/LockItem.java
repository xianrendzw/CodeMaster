package com.easytoolsoft.codemaster.concurrency.thread;

/**
 * Created by tomdeng on 16/11/17.
 */
public class LockItem {
    private int value;

    public LockItem(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
