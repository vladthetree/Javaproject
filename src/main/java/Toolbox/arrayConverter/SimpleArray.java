package Toolbox.arrayConverter;

import java.util.Arrays;
import java.util.List;

import static Toolbox.csv_Methodes.CsvConverter.adjustCsvStringList;

public class SimpleArray {

    public static String[][] arrayListTo2dArray(List<String[]> arrayList) {
        String[][] doubleArray = getSizeOf2dArray(arrayList);
        adjustCsvStringList(arrayList, doubleArray);
        return doubleArray;
    }

    protected static String[][] getSizeOf2dArray(List<String[]> data) {
        int length = Arrays.toString(data.get(0)).split(";").length;
        return new String[data.size()][length];
    }

}
