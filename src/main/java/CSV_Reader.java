import au.com.bytecode.opencsv.CSVReader;

import java.io.*;
import java.util.List;

public class CSV_Reader {


    public static void main(String[] args) throws IOException {
        String path = "G://sample.csv";
        Reader reader = new FileReader(path);

        List<String[]> data = readCSV(reader);

        for (String[] datum : data) {
            for (int i = 0; i < datum.length; i++) {
                System.out.println(datum[i]);
            }
        }
    }

    public static List<String[]> readCSV(Reader reader) throws IOException {
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

}

