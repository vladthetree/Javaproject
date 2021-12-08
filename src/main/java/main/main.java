package main;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static reader.CSV_Reader.*;
import static reader.Datacolumn.getSingleCSVDataColumns;
import static reader.Datacolumn.getSingleCSVRow;


public class main {

    public static void main(String[] args) throws IOException {
        String path = "G://sample.csv";
        Reader reader = new FileReader(path);

        List<String[]> arrayList = csvToArrayList(reader);


    }
}
