package main;


import DB.Mongo.MongoConnection;
import Toolbox.csv_Methodes.CsvConverter;
import Toolbox.json_Methodes.JsonConverter;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.json.simple.JSONObject;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Map;

@EnableMongoRepositories(basePackages = "DB.Mongo.Configuration")
public class main {


    public static void main(String[] args) {

        String path = "C://Users//vlady//Documents//TestFiles//A//TextCSV.csv";

        List<String[]> strings = CsvConverter.csvToStringArrayList(path).stream().skip(4).toList();
        Map<String, String> stringStringMap = CsvConverter.mapTwoCsvColumn(strings, 1, 3);
//        JSONObject jsonObject = JsonCreator.stringMaptoJsonObject(stringStringMap);
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name", "test1");
        jsonObject1.put("id", "123");
        jsonObject1.put("map", stringStringMap); // TODO DAS ALS METHODE UMSETZEN


        Document bsonFile = JsonConverter.jsonToBson(jsonObject1);

        MongoCollection col = MongoConnection.getCollectionFromDatabase("uat", "bsonObject");
        col.insertOne(bsonFile);


    }
}
