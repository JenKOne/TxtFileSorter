package org.example.statistics;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class IntegerStatistics implements GeneralStatistics<BigInteger> {
    private long count = 0;
    private BigInteger min;
    private BigInteger max;
    private BigInteger sum = BigInteger.ZERO;

    @Override
    public void accept(BigInteger value) {
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

        System.out.println("Integers:");
        System.out.println("  count = " + count);

        if (full) {
            System.out.println("  min   = " + min);
            System.out.println("  max   = " + max);
            System.out.println("  sum   = " + sum);

            BigDecimal avg = new BigDecimal(sum)
                    .divide(BigDecimal.valueOf(count), 10, RoundingMode.HALF_UP);

            System.out.println("  avg   = " + avg);
        }
    }
}
