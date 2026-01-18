package org.example.cli;

import java.nio.file.Path;
import java.util.List;

public class Arguments {
    public enum StatisticsMode {
        NONE, SHORT, FULL
    }

    private final StatisticsMode statisticsMode;
    private final boolean append;
    private final Path outputDir;
    private final String prefix;
    private final List<Path> inputFiles;

    public Arguments(StatisticsMode statisticsMode, boolean append, Path outputDir, String prefix, List<Path> inputFiles) {
        this.statisticsMode = statisticsMode;
        this.append = append;
        this.outputDir = outputDir;
        this.prefix = prefix;
        this.inputFiles = inputFiles;
    }

    public StatisticsMode getStatisticsMode() {
        return statisticsMode;
    }

    public boolean isAppend() {
        return append;
    }
    public boolean isFullStats() {
        return statisticsMode == StatisticsMode.FULL;
    }

    public Path getOutputDir() {
        return outputDir;
    }

    public String getPrefix() {
        return prefix;
    }

    public List<Path> getInputFiles() {
        return inputFiles;
    }
}
