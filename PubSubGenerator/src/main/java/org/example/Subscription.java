package org.example;

public class Subscription {
    private final String field;
    private final String operator;
    private final String value;

    public Subscription(String field, String operator, String value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s,%s)", field, operator, value);
    }
}

