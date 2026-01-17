package org.example;

import org.example.cli.ArgumentParser;
import org.example.cli.Arguments;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        try {
            ArgumentParser parser = new ArgumentParser();
            Arguments arguments = parser.parse(args);

            System.out.println("Statistics mode: " + arguments.getStatisticsMode());
            System.out.println("Append: " + arguments.isAppend());
            System.out.println("Output directory: " + arguments.getOutputDir());
            System.out.println("Prefix: " + arguments.getPrefix());
            System.out.println("Input files: " + arguments.getInputFiles());

        } catch (Exception e) {
            System.err.println("Ошибка запуска: " + e.getMessage());
        }
        TxtFileWriter txtFileWriter = new TxtFileWriter();
        txtFileWriter.writeFiles();
        System.out.println("что-то произошло, проверяй");
    }
}
