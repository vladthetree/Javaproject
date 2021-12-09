package Json_Methodes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonFileCreator {

    public static void main(String[] args) throws FileNotFoundException
    {
        // creating JSONObject
        JSONObject jsonObject = new JSONObject();

        // putting data to JSONObject
        jsonObject.put("asOfDate", "99.99.999");
        /*
        LinkedHashmap :
        + Maintains insertionorder
        - Not Threadsafe -> inconsistenz value
         */
        Map linkedHashMap = new LinkedHashMap(2);
        linkedHashMap.put("name", "Company B");
        linkedHashMap.put("value",12.5);


        jsonObject.put("SomeValue", linkedHashMap);

        // for phone numbers, first create JSONArray
        JSONArray jsonArray = new JSONArray();

        linkedHashMap = new LinkedHashMap(2);
        linkedHashMap.put("name", "Company Alpha");
        linkedHashMap.put("value", 12.909);

        // adding map to list
        jsonArray.add(linkedHashMap);

        linkedHashMap = new LinkedHashMap(2);
        linkedHashMap.put("name", "Company Betha");
        linkedHashMap.put("value", 0.01);

        // adding map to list
        jsonArray.add(linkedHashMap);

        // putting phoneNumbers to JSONObject
        jsonObject.put("Companys", jsonArray);

        // writing JSON to file:"JSONExample.json" in cwd
        PrintWriter pw = new PrintWriter("G:\\Workload\\JSONExample.json");
        pw.write(jsonObject.toJSONString());

        pw.flush();
        pw.close();
    }
}
