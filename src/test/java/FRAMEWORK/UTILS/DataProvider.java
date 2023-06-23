package FRAMEWORK.UTILS;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DataProvider {
    
    private static final String filePathTables = "testData/TablesData.json";
    
    @org.testng.annotations.DataProvider(name = "TablesData")
    public static Object[][] getData() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj;
    
        obj = (JSONObject) parser.parse(new FileReader(filePathTables));
    
    
        JSONArray array = (JSONArray) obj.get("tests");
    
        Object[][] arr = new Object[array.size()][6];
        Map<String, String> dataMap = new HashMap<>();
        Iterator entriesIterator;
    
        int j = 0;
        for (Object js : array) {
            System.out.println(js);
            JSONObject obj1 = (JSONObject) js;
            obj1.keySet().forEach(key -> {
                dataMap.put(String.valueOf(key), String.valueOf(obj1.get(key)));
            });
            Set entries = dataMap.entrySet();
            entriesIterator = entries.iterator();
    
            int i = 0;
            while (entriesIterator.hasNext()) {
                Map.Entry mapping = (Map.Entry) entriesIterator.next();
                arr[j][i] = mapping.getKey();
                arr[j][i] = mapping.getValue();
                i++;
            }
            j++;
        }
        return arr;
    }
    
}