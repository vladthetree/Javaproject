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

        for (int i = 0; i < test.length; i++) {
            for (int i1 = 0; i1 < test[i].length ; i1++) {
                System.out.print(test[i][i1]+" ");
            }
            System.out.println();
        }


    }
}
