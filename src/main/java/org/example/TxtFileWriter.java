package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TxtFileWriter {
    List<Float> floats;
    List<Integer> integers;
    List<String> strings;
    TxtFileReader txtFileReader = new TxtFileReader();
    StringFilter stringFilter = new StringFilter();
    Path path = Paths.get("D:\\IdeaProjects\\TxtFileSorter\\src\\main\\resources\\In1.txt");


    public void writeFiles() {
        Path intsFile = Paths.get("ints.txt");
        Path floatsFile = Paths.get("floats.txt");
        Path stringsFile = Paths.get("strings.txt");
        integers = stringFilter.integers(txtFileReader.readTxt(path));
        strings = stringFilter.strings(txtFileReader.readTxt(path));
        floats = stringFilter.floats(txtFileReader.readTxt(path));
        System.out.println(integers);
        System.out.println(strings);
        System.out.println(floats);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(intsFile)))) {
            for (Integer line : integers) {
                writer.write(String.valueOf(line));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(floatsFile)))) {
            for (Float line : floats) {
                writer.write(String.valueOf(line));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(stringsFile)))) {
            for (String line : strings) {
                writer.write(String.valueOf(line));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TxtFileWriter() throws IOException {
    }
}
