

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
public class DemoMap {
    public static void main(String args[]){
        Map<String,String> studentMap = new HashMap<String, String>();
        studentMap.put("vti1", "Van"); 
        studentMap.put("vti2", "Chi"); 
        studentMap.put("vti3", "Huynh"); 
        
        // Di chuyển vòng lặp for vào bên trong phương thức main
        for(Map.Entry<String, String> entry: studentMap.entrySet()){
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
