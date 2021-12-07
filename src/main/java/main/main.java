package main;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import static reader.CSV_Reader.*;
import static reader.Datacolumns.getSingleCSVDataColumns;
import static reader.Datacolumns.getSingleCSVRow;


public class main {

    public static void main(String[] args) throws IOException {
        String path = "G://sample.csv";
        Reader reader = new FileReader(path);

        List<String[] > arrayList = csvToArrayList(reader);
        printCSV(arrayList);

    }
}
