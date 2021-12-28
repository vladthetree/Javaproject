package main;


import DB.MongoConnection;
import Toolbox.csv_Methodes.CsvConverter;
import Toolbox.json_Methodes.JsonConverter;
import Toolbox.json_Methodes.JsonCreator;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;


public class main {


    public static void main(String[] args) {

        String path = "C://Users//vlady//Documents//TestFiles//A//TextCSV.csv";

        List<String[]> strings = CsvConverter.csvToStringArrayList(path).stream().skip(3).toList();
        Map<String, String> stringStringMap = CsvConverter.mapTwoCsvColumn(strings, 1, 3);
        JSONObject jsonObject = JsonCreator.stringMaptoJsonObject(stringStringMap);
        Document bsonFile = JsonConverter.jsonToBson(jsonObject);

        MongoCollection col = MongoConnection.getCollectionFromDatabase("uat", "bsonObject");
//        col.insertOne(bsonFile);
        //col.deleteMany(bsonFile);

    }
}
