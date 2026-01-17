package org.example.statistics;

import java.math.BigDecimal;
import java.math.MathContext;

public class FloatStatistics implements GeneralStatistics<BigDecimal> {
    private long count = 0;
    private BigDecimal min;
    private BigDecimal max;
    private BigDecimal sum = BigDecimal.ZERO;

    @Override
    public void accept(BigDecimal value) {
        if (value == null) return;

        count++;

        if (min == null || value.compareTo(min) < 0) {
            min = value;
        }

        if (max == null || value.compareTo(max) > 0) {
            max = value;
        }

        sum = sum.add(value);
    }

    @Override
    public boolean hasData() {
        return count > 0;
    }

    @Override
    public void print(boolean full) {
        if (!hasData()) return;

        System.out.println("Floats:");
        System.out.println("  count = " + count);

        if (full) {
            System.out.println("  min   = " + min);
            System.out.println("  max   = " + max);
            System.out.println("  sum   = " + sum);
            System.out.println("  avg   = " +
                    sum.divide(BigDecimal.valueOf(count), MathContext.DECIMAL128));
        }
    }
}

