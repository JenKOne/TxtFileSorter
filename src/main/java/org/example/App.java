package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Float> floats;
        List<Integer> integers;
        List<String> strings;
        TxtFileReader txtFileReader = new TxtFileReader();
        StringFilter stringFilter = new StringFilter();
        Path path = Paths.get("D:\\IdeaProjects\\заданиеШифт\\TxtFilterUtil\\src\\main\\resources\\In1.txt");


        integers = stringFilter.integers(txtFileReader.readTxt(path));
        floats = stringFilter.floats(txtFileReader.readTxt(path));
        strings = stringFilter.strings(txtFileReader.readTxt(path));
        System.out.println(integers);
        System.out.println(floats);
        System.out.println(strings);
    }
}
