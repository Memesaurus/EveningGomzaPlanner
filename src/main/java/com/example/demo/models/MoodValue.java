package com.example.demo.models;

public enum MoodValue {
    ANGRY,
    SAD,
    READY_TO_PUMP,
    SERIOUS,
    PIVO;

    public String getMoodValue() {
        return this.name();
    }
}
