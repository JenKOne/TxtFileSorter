package org.example;

import org.example.cli.Arguments;
import org.example.cli.ArgumentParser;
import org.example.filter.ClassificationResult;
import org.example.filter.LineClassifier;
import org.example.io.TxtFileWriter;
import org.example.statistics.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        Arguments arguments;
        try {
            arguments = new ArgumentParser().parse(args);
        } catch (Exception e) {
            System.err.println("Ошибка аргументов: " + e.getMessage());
            return;
        }

        LineClassifier classifier = new LineClassifier();

        GeneralStatistics<BigInteger> intStats = new IntegerStatistics();
        GeneralStatistics<BigDecimal> floatStats = new FloatStatistics();
        GeneralStatistics<String> stringStats = new StringStatistics();

        List<String> integersOut = new ArrayList<>();
        List<String> floatsOut = new ArrayList<>();
        List<String> stringsOut = new ArrayList<>();

        for (Path inputFile : arguments.getInputFiles()) {

            if (!Files.exists(inputFile)) {
                System.err.println("Файл не найден: " + inputFile);
                continue;
            }

            try {
                List<String> lines = Files.readAllLines(inputFile);

                for (String line : lines) {
                    ClassificationResult result = classifier.classify(line);

                    switch (result.getType()) {
                        case INTEGER -> {
                            BigInteger v = result.getValue();
                            intStats.accept(v);
                            integersOut.add(v.toString());
                        }
                        case FLOAT -> {
                            BigDecimal v = result.getValue();
                            floatStats.accept(v);
                            floatsOut.add(v.toString());
                        }
                        case STRING -> {
                            String v = result.getValue();
                            stringStats.accept(v);
                            stringsOut.add(v);
                        }
                    }
                }

            } catch (Exception e) {
                System.err.println("Ошибка чтения файла " + inputFile + ": " + e.getMessage());
            }
        }

        try {
            TxtFileWriter writer = new TxtFileWriter(
                    arguments.getOutputDir(),
                    arguments.getPrefix(),
                    arguments.isAppend()
            );

            writer.writeIfNotEmpty("integers", integersOut);
            writer.writeIfNotEmpty("floats", floatsOut);
            writer.writeIfNotEmpty("strings", stringsOut);

        } catch (Exception e) {
            System.err.println("Ошибка записи файлов: " + e.getMessage());
        }

        boolean fullStats = arguments.getStatisticsMode() == Arguments.StatisticsMode.FULL;
        boolean shortStats = arguments.getStatisticsMode() == Arguments.StatisticsMode.SHORT;

        if (fullStats || shortStats) {
            intStats.print(fullStats);
            floatStats.print(fullStats);
            stringStats.print(fullStats);
        }
    }
}
