package Toolbox.Json_Methodes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// LinkedHashmap :
//        + Maintains insertionorder
//        - Not Threadsafe -> inconsistenz value
//         */
public class JsonFileCreator {

    public static void main(String[] args) throws FileNotFoundException {

        JSONObject jsonObject = new JSONObject();

        Map<String, Integer> objectValues = new HashMap<>();
        objectValues.put("Alpha", 2);
        objectValues.put("Betha", 3);
        objectValues.put("Gamma", 4);
        objectValues.put("Omega", 5);
        objectValues.put("Gaga", 8);

        Map<String,String>singleValues = new HashMap<>();
        singleValues.put("asOfDate","99.99.9999");
        singleValues.put("Customername","Franzo");


        createManyJsonArrays(jsonObject, objectValues);
        createSingleValues(jsonObject,singleValues);

        PrintWriter pw = new PrintWriter("G:\\Workload\\JSONExample.json");
        pw.write(jsonObject.toJSONString());

        pw.flush();
        pw.close();
    }

    private static void createJsonObject(JSONObject jsonObject, String declaration, int amount) {
        Map<String, String> linkedHashMap = new LinkedHashMap<>(amount);

        for (int i = 0; i < amount; i++) {
            linkedHashMap.put("name_" + (i+1) + "_" + declaration, "value_" + (i+1) + "_" + declaration); // i wird iteriert weil, lHashmap unique ist
        }
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(linkedHashMap);
        jsonObject.put(declaration, jsonArray);

    }

    private static void createManyJsonArrays(JSONObject jsonObject, Map<String, Integer> map) {
        for (Map.Entry<String, Integer> set : map.entrySet()) {
            createJsonObject(jsonObject, set.getKey(), set.getValue());
        }
    }

    private static void createSingleValues(JSONObject jsonObject,Map<String,String>map){
        jsonObject.putAll(map);

    }
}



