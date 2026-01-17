package org.example.filter;

import org.example.model.DataType;

public class ClassificationResult {
    private final DataType type;
    private final Object value;

    public ClassificationResult(DataType type, Object value) {
        this.type = type;
        this.value = value;
    }

    public DataType getType() {
        return type;
    }

    @SuppressWarnings("unchecked")
    public <T> T getValue() {
        return (T) value;
    }
}
