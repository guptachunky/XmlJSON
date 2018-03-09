
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;

public class JsonToFile {
    public static void main(String[] args) throws JSONException {

        JSONObject address = new JSONObject();
        address.put("street", "num1");
        address.put("city", "Delhi");

        JSONObject dept=new JSONObject();
        dept.put("deptid",1);
        dept.put("deptName","dept name 1");
        JSONObject employee = new JSONObject();
        employee.put("id", 1);
        employee.put("name", "chunks");
        employee.put(("address"),address);
        employee.put("department",dept);
        try (FileWriter file = new FileWriter("/home/chunky/events/XmlJSON/src/main/test.json")) {

            file.write(employee.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(employee);

    }
}
