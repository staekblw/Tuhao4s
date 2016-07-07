package com.tuhao.domain.order;

/**
 * Created by apple on 2/27/16.
 */
public class Location {
    private String name;

    Location() {
    }

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
