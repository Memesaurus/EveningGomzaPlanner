package com.example.demo.models;

public enum PlansValue {
    LOL,
    NOT_LOL,
    PIVO,
    LATE;

    public String getPlansValue() {
        return this.name();
    }
}
