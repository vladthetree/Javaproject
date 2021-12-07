package main;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static reader.CSV_Reader.*;

public class main {

    public static void main(String[] args) throws IOException {
        String path = "G://sample.csv";
        Reader reader = new FileReader(path);

        List<String[] > data = csvToArrayList(reader);

        String [][] test = to2DArray(data);

        for (String[] strings : test) {
            System.out.println(strings[0]);
        }


    }
}
