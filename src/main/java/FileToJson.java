import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileToJson {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader("/home/chunky/events/XmlJSON/src/main/test.json"));

            JSONObject employee = (JSONObject) obj;
            System.out.println(employee);
            String name = (String) employee.get("name");
            System.out.println(name);

            long id = (long)employee.get("id");
            System.out.println(id);

            JSONObject address=(JSONObject) employee.get("address");
            System.out.println(address.get("street"));
            System.out.println(address.get("city"));

            JSONObject dept=(JSONObject)employee.get("department");
            System.out.println(dept.get("deptid"));
            System.out.println(dept.get("deptname"));
            // loop array
//            Iterator<String> iterator = msg.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
