package org.example.filter;

import org.example.model.DataType;

import java.math.BigDecimal;
import java.math.BigInteger;

public class LineClassifier {

    public ClassificationResult classify(String line) {

        if (line == null) {
            return new ClassificationResult(DataType.STRING, "null");
        }

        String value = line.trim();
        if (value.isEmpty()) {
            return new ClassificationResult(DataType.STRING, value);
        }

        //если это целое число
        if (!value.contains(".") && !value.contains("e") && !value.contains("E")) {
            try {
                return new ClassificationResult(
                        DataType.INTEGER,
                        new BigInteger(value)
                );
            } catch (NumberFormatException ignored) {
            }
        }

        //если нет, то пробуем вещественное
        try {
            return new ClassificationResult(
                    DataType.FLOAT,
                    new BigDecimal(value)
            );
        } catch (NumberFormatException ignored) {
        }

        // всё остальное - стрки
        return new ClassificationResult(DataType.STRING, value);
    }
}
