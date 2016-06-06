package com.dmytriaha.model;

public enum OperationType {
    ADD("add"),
    SUBTRACT("subtract"),
    MULTIPLY("multiply"),
    DIVIDE("divide");

    private final String text;

    private OperationType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
