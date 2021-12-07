package reader;

import java.util.List;

import static reader.CSV_Reader.arrayListTo2dArray;

public class Datacolumns {

    public static String[] getSingleCSVDataColumns(List<String[]> arrayList, int columnNumber) {
        String[][] strings = arrayListTo2dArray(arrayList);
        String[] column = new String[strings.length];

        for (int x = 0; x < strings.length; x++) {
            column[x] = strings[x][columnNumber];
        }
        return column;
    }

    public static String[] getSingleCSVRow(List<String[]> arrayList, int rowNumber) {
        String[][] strings = arrayListTo2dArray(arrayList);
        String[] row = new String[strings[rowNumber].length];

        for (int x = 0; x < strings[rowNumber].length; x++) {
            row[x] = strings[rowNumber][x];
        }
        return row;
    }


}
