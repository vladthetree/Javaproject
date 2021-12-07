package reader;

import au.com.bytecode.opencsv.CSVReader;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CSV_Reader {

    public static List<String[]> csvToArrayList(Reader reader) throws IOException {
        CSVReader read = new CSVReader(reader);

        List<String[]> readerList = null;
        try {
            readerList = read.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }

        reader.close();
        read.close();
        return readerList;
    }

    public static String[][] to2DArray(List<String[]> data) {
        String[][] doubleArray = getSizeOf2dArray(data);

        for (int i = 0; i < data.size(); i++) {
            String[] strings = data.get(i);
            covertOneDtoTwoD(strings, doubleArray, i);
        }
        return doubleArray;
    }

    private static String[][] getSizeOf2dArray(List<String[]> data) {
        int length = Arrays.toString(data.get(0)).split(";").length;
        String[][] doubleArray = new String[data.size()][length];
        return doubleArray;
    }

    public static String[][] covertOneDtoTwoD(String[] array, String[][] twoD, int line) {
        String[] strings = extractValueAndCreateNew1dArray(array,";");

        for (int i = 0; i < twoD[line].length; i++) {
            twoD[line][i] = strings[i];
        }
        return twoD;
    }

    private static String[] extractValueAndCreateNew1dArray(String[] array, String delimiter) {
        String s = Arrays.toString(array);
        String[] split = s.split(delimiter);
        return split;
    }

    //TODO DIe [ Zeichen wegbekommen


}

