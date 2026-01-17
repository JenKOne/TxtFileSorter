package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TxtFileWriter {
    List<Float> floats;
    List<Integer> integers;
    List<String> strings;
    TxtFileReader txtFileReader = new TxtFileReader();
    StringFilter stringFilter = new StringFilter();
    Path path = Paths.get("D:\\IdeaProjects\\заданиеШифт\\TxtFilterUtil\\src\\main\\resources\\In1.txt");


    public void writeFiles() {
        Path textFile = Paths.get("ints.txt");
        integers = stringFilter.integers(txtFileReader.readTxt(path));
        System.out.println(integers);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(textFile)))) {
            for (Integer line : integers) {
                writer.write(String.valueOf(line));
                writer.newLine(); // добавляем перевод строки
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TxtFileWriter() throws IOException {
    }
}
