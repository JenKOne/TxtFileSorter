package org.example.filter;

import org.example.model.DataType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class LineClassifierTest {
    private final LineClassifier classifier = new LineClassifier();

    @Test
    void integerLine() {
        ClassificationResult result = classifier.classify("451");
        assertEquals(DataType.INTEGER, result.getType());
        assertEquals(new BigInteger("451"), result.getValue());
    }

    @Test
    void floatLine() {
        ClassificationResult result = classifier.classify("36.6");
        assertEquals(DataType.FLOAT, result.getType());
        assertEquals(new BigDecimal("36.6"), result.getValue());
    }

    @Test
    void stringLine() {
        ClassificationResult result = classifier.classify("heavens waiting for you");
        assertEquals(DataType.STRING, result.getType());
        assertEquals("heavens waiting for you", result.getValue());
    }
}
