package reader;

import au.com.bytecode.opencsv.CSVReader;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CSV_Reader {

    public static void printCSV(List<String[]> arrayList) {
        String[][] to2dArray = arrayListTo2dArray(arrayList);
        for (String[] strings : to2dArray) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }

    }

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

    public static String[][] arrayListTo2dArray(List<String[]> arrayList) {
        String[][] doubleArray = getSizeOf2dArray(arrayList);
        adjust1dArrayto2dArray(arrayList, doubleArray);
        return doubleArray;
    }

    private static void adjust1dArrayto2dArray(List<String[]> data, String[][] doubleArray) {
        for (int i = 0; i < data.size(); i++) {
            String[] strings = deleteBracketsinside1DArray(data.get(i));
            for (int k = 0; k < strings.length; k++) {
                doubleArray[i][k] = strings[k];
            }
        }
    }

    private static String[][] getSizeOf2dArray(List<String[]> data) {
        int length = Arrays.toString(data.get(0)).split(";").length;
        return new String[data.size()][length];
    }


    private static String[] deleteBracketsinside1DArray(String[] array) {
        String s = Arrays.toString(array);
        String s1 = s.replaceAll("\\[", "");
        String s2 = s1.replaceAll("]", "");
        return s2.split(";");
    }


}