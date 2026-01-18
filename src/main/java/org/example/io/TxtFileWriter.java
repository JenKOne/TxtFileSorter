package org.example.io;

import org.example.model.DataType;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TxtFileWriter {
    private final Path outputDir;
    private final String prefix;
    private final boolean appendMode;

    public TxtFileWriter(Path outputDir, String prefix, boolean appendMode) {
        this.outputDir = outputDir;
        this.prefix = prefix == null ? "" : prefix;
        this.appendMode = appendMode;
    }

    public void writeIfNotEmpty(String baseName, List<String> lines) throws IOException {
        if (lines == null || lines.isEmpty()) {
            return;
        }

        Files.createDirectories(outputDir);

        Path file = outputDir.resolve(prefix + baseName + ".txt");

        OpenOption[] options = appendMode
                ? new OpenOption[]{StandardOpenOption.CREATE,StandardOpenOption.APPEND}
                : new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING};

        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8, options)){
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
