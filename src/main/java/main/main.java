package main;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static Toolbox.csv_Methodes.CSV_Reader.*;


public class main {

    public static void main(String[] args){
        String path = "C://Users//vlady//Documents//TestFiles//A//TextCSV.csv";
        Reader reader = new FileReader(path);

        List<String[]> arrayList = csvToArrayList(reader);


    }
}
