package org.example.cli;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.example.cli.Arguments.StatisticsMode;

public class ArgumentParser {
    public Arguments parse(String[] args) {
        StatisticsMode statisticsMode = StatisticsMode.NONE;
        boolean append = false;
        Path outputDir = Paths.get(".");
        String prefix = "";

        List<Path> inputFiles = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            switch (arg) {
                case "-s":
                    statisticsMode = StatisticsMode.SHORT;
                    break;
                case "-f":
                    statisticsMode = StatisticsMode.FULL;
                    break;
                case "-a":
                    append = true;
                    break;
                case "-o":
                    if (i + 1 >= args.length) {
                        throw new IllegalArgumentException("Укажите путь");
                    }
                    outputDir = Paths.get(args[++i]);
                    break;
                case "-p":
                    if (i + 1 >= args.length) {
                        throw new IllegalArgumentException("Укажите префикс");
                    }
                    prefix = args[++i];
                    break;
                default:
                    inputFiles.add(Paths.get(arg));
            }
        }
        if (inputFiles.isEmpty()) {
            throw new IllegalArgumentException("Введите данные");
        }
        return new Arguments(statisticsMode, append, outputDir, prefix, inputFiles);
    }
}
