package org.example.statistics;

public interface GeneralStatistics<T> {
    void accept(T value);

    void print(boolean full);

    boolean hasData();
}
