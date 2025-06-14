package com.shri.spring.stock.advisor.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderType {
    BUY,
    SELL;

    @JsonValue
    public String getValue() {
        return name().toLowerCase();
    }

    @JsonCreator
    public static OrderType fromValue(String value) {
        if (value == null) {
            return null;
        }
        for (OrderType type : OrderType.values()) {
            if (type.getValue().equalsIgnoreCase(value) || type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown enum type " + value + ", Allowed values are " + java.util.Arrays.toString(values()));
    }
}
