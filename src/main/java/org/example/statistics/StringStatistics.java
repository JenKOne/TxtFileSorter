package org.example.statistics;

public class StringStatistics implements GeneralStatistics<String>{
    private long count = 0;
    private Integer minLength;
    private Integer maxLength;

    @Override
    public void accept(String value) {
        if (value == null) return;

        count++;
        int len = value.length();

        if (minLength == null || len < minLength) {
            minLength = len;
        }

        if (maxLength == null || len > maxLength) {
            maxLength = len;
        }
    }

    @Override
    public boolean hasData() {
        return count > 0;
    }

    @Override
    public void print(boolean full) {
        if (!hasData()) return;

        System.out.println("Strings:");
        System.out.println("  count = " + count);

        if (full) {
            System.out.println("  min length = " + minLength);
            System.out.println("  max length = " + maxLength);
        }
    }
}
