package com.tuhao.common.id;

/**
 * Created by apple on 2/27/16.
 */
public class Identifier {
    private String value;

    Identifier() {
    }

    public Identifier(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
