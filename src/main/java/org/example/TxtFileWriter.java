package org.example;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TxtFileWriter {
    Path textFile = Paths.get("sample.txt");
    BufferedWriter bufferedWriter = Files.newBufferedWriter(textFile);
}
