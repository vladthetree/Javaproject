package main;

import Toolbox.csv_Methodes.CsvConverter;
import Toolbox.print.PrinterFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class main {

    public static void main(String[] args) {
        String path = "C://Users//vlady//Documents//TestFiles//A//TextCSV.csv";
        List<String[]> strings = CsvConverter.csvToStringArrayList(path).stream().skip(3).toList();
        Map<String, String> stringStringMap = CsvConverter.mapTwoCsvColumn(strings, 1, 3);

        PrinterFactory.prettyPringMap(stringStringMap);

    }
}
