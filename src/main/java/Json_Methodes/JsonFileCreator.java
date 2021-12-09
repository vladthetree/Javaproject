package Json_Methodes;

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

        Map<String, Integer> values = new HashMap<>();
        values.put("Alpha", 2);
        values.put("Betha", 3);
        values.put("Gamma", 4);
        values.put("Omega", 5);
        values.put("Gaga", 8);
        giveNamesToObjects(jsonObject, values);

        PrintWriter pw = new PrintWriter("G:\\Workload\\JSONExample.json");
        pw.write(jsonObject.toJSONString());

        pw.flush();
        pw.close();
    }

    private static void createJsonObject(JSONObject jsonObject, String suffix, int amount) {
        Map<String, String> linkedHashMap = new LinkedHashMap<>(amount);


        for (int i = 0; i < amount; i++) {
            linkedHashMap.put("name_" + i + "_" + suffix, "value_" + i + "_" + suffix); // i wird iteriert weil, lHashmap unique ist
        }
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(linkedHashMap);
        jsonObject.put(suffix, jsonArray);

    }


    private static void giveNamesToObjects(JSONObject jsonObject, Map<String, Integer> map) {
        for (Map.Entry<String, Integer> set : map.entrySet()) {
            createJsonObject(jsonObject, set.getKey(), set.getValue());
        }

    }
}



