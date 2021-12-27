package Toolbox.print;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static Toolbox.arrayConverter.SimpleArray.arrayListTo2dArray;
import static Toolbox.csv_Methodes.CsvConverter.csvToStringArrayList;

public class PrinterFactory {

    public static void printStringArrayList(List<String[]> arrayList) {
        String[][] to2dArray = arrayListTo2dArray(arrayList);
        for (String[] row : to2dArray) {
            for (String rowValue : row) {
                System.out.print(rowValue + " ");
            }
            System.out.println();
        }
    }

    public static void printCsv(String path) {
        List<String[]> strings = csvToStringArrayList(path);
        printStringArrayList(strings);
    }

    public static void prettyPringMap(Map<String,String> map){
        for (Map.Entry<String, String> stringMap : map.entrySet()) {
            System.out.println(stringMap.getKey()+"/"+stringMap.getValue());
        }
    }

    public static String[] deleteBracketsInside1dArray(String[] array) {
        String s = Arrays.toString(array);
        String s1 = s.replaceAll("\\[", "");
        String s2 = s1.replaceAll("]", "");
        return s2.split(";");
    }
}
