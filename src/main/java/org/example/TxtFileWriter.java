package org.example;

import org.example.model.DataType;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

public class TxtFileWriter {
    private final Path outputDir;
    private final String prefix;
    private final boolean appendMode;
    private final Map<DataType, BufferedWriter> writers = new HashMap<>();
    private final Map<DataType, Boolean> hasData = new HashMap<>();

    public TxtFileWriter(Path outputDir, String prefix, boolean appendMode) {
        this.outputDir = outputDir;
        this.prefix = prefix;
        this.appendMode = appendMode;
    }

    //    List<Float> floats;
//    List<Integer> integers;
//    List<String> strings;
//    TxtFileReader txtFileReader = new TxtFileReader();
//    StringFilter stringFilter = new StringFilter();
//    Path path = Paths.get("D:\\IdeaProjects\\TxtFileSorter\\src\\main\\resources\\In1.txt");


    public void writeFiles(DataType type, String content) throws IOException {
        if (!hasData.containsKey(type)) {
            hasData.put(type, true);
            openWriter(type);
        }
        writers.get(type).write(content);
//        Path intsFile = Paths.get("ints.txt");
//        Path floatsFile = Paths.get("floats.txt");
//        Path stringsFile = Paths.get("strings.txt");
//        integers = stringFilter.integers(txtFileReader.readTxt(path));
//        strings = stringFilter.strings(txtFileReader.readTxt(path));
//        floats = stringFilter.floats(txtFileReader.readTxt(path));
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(intsFile)))) {
//            for (Integer line : integers) {
//                writer.write(String.valueOf(line));
//                writer.newLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(floatsFile)))) {
//            for (Float line : floats) {
//                writer.write(String.valueOf(line));
//                writer.newLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(stringsFile)))) {
//            for (String line : strings) {
//                writer.write(String.valueOf(line));
//                writer.newLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    private void openWriter(DataType type) throws IOException {
        String fileName = prefix + type.name().toLowerCase() + "s.txt";
        Path filePath = outputDir.resolve(fileName);
        Files.createDirectories(outputDir);
        StandardOpenOption openOption = appendMode ? StandardOpenOption.APPEND : StandardOpenOption.TRUNCATE_EXISTING;
        BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, openOption);
        writers.put(type, writer);
    }

    public void closeAll() throws IOException {
        for (BufferedWriter writer : writers.values()) {
            writer.close();
        }
    }

    public boolean hasDataFor(DataType type) {
        return hasData.getOrDefault(type, false);
    }
}
