package Json_Methodes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

// LinkedHashmap :
//        + Maintains insertionorder
//        - Not Threadsafe -> inconsistenz value
//         */
public class JsonFileCreator {

    public static void main(String[] args) throws FileNotFoundException {

        JSONObject jsonObject = new JSONObject();
        createJsonObjects(jsonObject,"Dach",5);
        PrintWriter pw = new PrintWriter("G:\\Workload\\JSONExample.json");
        pw.write(jsonObject.toJSONString());

        pw.flush();
        pw.close();
    }

    private static JSONObject createJsonObjects(JSONObject jsonObject, String suffix, int amount) {
        Map<String, String> linkedHashMap = new LinkedHashMap<>(amount);


        for (int i = 0; i < amount; i++) {
            linkedHashMap.put("name_"+i+"_" + suffix, "value_"+i+"_"+suffix); // i wird iteriert weil, lHashmap unique ist
        }
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(linkedHashMap);
        jsonObject.put(suffix, jsonArray);

        return jsonObject;
    }

    private static void Json(int amounOfObjects){


    }


}
