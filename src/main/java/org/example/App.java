package org.example;

import org.example.filter.ClassificationResult;
import org.example.filter.LineClassifier;
import org.example.statistics.FloatStatistics;
import org.example.statistics.GeneralStatistics;
import org.example.statistics.IntegerStatistics;
import org.example.statistics.StringStatistics;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public static void main(String[] args) {
        GeneralStatistics<BigInteger> intStats = new IntegerStatistics();
        GeneralStatistics<BigDecimal> floatStats = new FloatStatistics();
        GeneralStatistics<String> stringStats = new StringStatistics();
        LineClassifier classifier = new LineClassifier();

        TxtFileReader txtFileReader = new TxtFileReader();

        Path path = Paths.get("D:\\IdeaProjects\\TxtFileSorter\\src\\main\\resources\\In1.txt");


        List<String> testLines = txtFileReader.readTxt(path);

        for (String line : testLines) {
            ClassificationResult result = classifier.classify(line);
            switch (result.getType()) {
                case INTEGER:
                    BigInteger bi = result.getValue();
                    intStats.accept(result.getValue());
                    System.out.println("INTEGER: " + bi);
                    break;
                case FLOAT:
                    BigDecimal bd = result.getValue();
                    floatStats.accept(result.getValue());
                    System.out.println("FLOAT: " + bd);
                    break;
                case STRING:
                    String st = result.getValue();
                    stringStats.accept(result.getValue());
                    System.out.println("STRING: " + st);
                    break;
            }
        }
        intStats.print(true);
        floatStats.print(true);
        stringStats.print(true);
    }
}
