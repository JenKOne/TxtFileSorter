package org.example;

import org.example.cli.Arguments;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringFilter {

    private final Arguments args;
    private final TxtFileWriter txtFileWriter;

    public StringFilter(Arguments args) {
        this.args = args;
        this.txtFileWriter = new TxtFileWriter(args.getOutputDir(), args.getPrefix(), args.isAppend());
    }



//    public List<Integer> integers(List<String> incomingList) {
//        List<Integer> result = new ArrayList<>(); //сюда будем складывать результаты
//
//        for (String s : incomingList) { //перебираем список
//            if (INTEGER_PATTERN.matcher(s).matches()) { //проверяем строку на соответствие
//                try {
//                    result.add(Integer.parseInt(s)); //преобразуем строку в инт и добавляем в список
//                } catch (NumberFormatException e) {
//                    System.err.println("Ошибка преобразования строки '" + s + "' в число."); //обрабатываем возможные исключения
//                }
//            }
//        }
//        return result;
//    }
//
//    public List<Float> floats(List<String> incomingList) {
//        List<Float> result = new ArrayList<>(); //сюда будем складывать результаты
//        for (String s : incomingList) { //перебираем список
//            if (FLOAT_PATTERN.matcher(s).matches()) { //проверяем строку на соответствие
//                try {
//                    result.add(Float.parseFloat(s)); //преобразуем строку в инт и добавляем в список
//                } catch (NumberFormatException e) {
//                    System.err.println("Ошибка преобразования строки '" + s + "' в число."); //обрабатываем возможные исключения
//                }
//            }
//        }
//        return result;
//    }
//
//    public List<String> strings(List<String> incomingList) {
//        List<String> result = new ArrayList<>();
//        for (String s : incomingList) {
//            if (!FLOAT_PATTERN.matcher(s).matches() && !INTEGER_PATTERN.matcher(s).matches()) {
//                result.add(s);
//            }
//        }
//        return result;
//    }
}
