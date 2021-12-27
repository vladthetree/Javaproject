package Toolbox.csv_Methodes;

import au.com.bytecode.opencsv.CSVReader;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CsvMethods {

    public static Reader getPathReader(String path) {
        Reader reader = null;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.out.println(
                    "CSV_Reader -> getFile() - File could not be found. Path " + path + " is not right. " + e);
        }
        return reader;
    }

    public static List<String[]> readerToStringArrayList(Reader reader) {
        CSVReader read = new CSVReader(reader);

        List<String[]> readerList = null;
        try {
            readerList = read.readAll();
        } catch (IOException e) {
            System.out.println("CSV_Reader -> csvToArrayList() - readerList could not be read. " + e);
        }
        try {
            reader.close();
            read.close();
        } catch (IOException e) {
            System.out.println("CSV_Reader -> csvToArrayList() - CSVReader/Reader could not be closed. " + e);
        }

        return readerList;
    }

    public static List<String[]> csvToStringArrayList(String path) {
        Reader pathReader = getPathReader(path);
        return readerToStringArrayList(pathReader);

    }

    public static String[][] csvTo2dArray(String path) {
        Reader pathReader = getPathReader(path);
        List<String[]> strings = readerToStringArrayList(pathReader);
        return arrayListTo2dArray(strings);
    }

    public static String[][] arrayListTo2dArray(List<String[]> arrayList) {
        String[][] doubleArray = getSizeOf2dArray(arrayList);
        adjust1dArrayto2dArray(arrayList, doubleArray);
        return doubleArray;
    }

    private static void adjust1dArrayto2dArray(List<String[]> data, String[][] doubleArray) {
        for (int i = 0; i < data.size(); i++) {
            String[] strings = deleteBracketsInside1dArray(data.get(i));
            for (int k = 0; k < strings.length; k++) {
                doubleArray[i][k] = strings[k];
            }
        }
    }

    private static String[][] getSizeOf2dArray(List<String[]> data) {
        int length = Arrays.toString(data.get(0)).split(";").length;
        return new String[data.size()][length];
    }


    private static String[] deleteBracketsInside1dArray(String[] array) {
        String s = Arrays.toString(array);
        String s1 = s.replaceAll("\\[", "");
        String s2 = s1.replaceAll("]", "");
        return s2.split(";");
    }

    public static void printStringArrayList(List<String[]> arrayList) {
        String[][] to2dArray = arrayListTo2dArray(arrayList);
        for (String[] row : to2dArray) {
            for (String rowValue : row) {
                System.out.print(rowValue + " ");
            }
            System.out.println();
        }
    }

    public static void printCSV(String path){
        List<String[]> strings = csvToStringArrayList(path);
        printStringArrayList(strings);
    }


}