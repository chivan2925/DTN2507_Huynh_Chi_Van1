package assignment4.E1.frontend;
// package frontend;
import java.util.Iterator;
import java.util.ArrayList;
public class demoArrayList {
    public static void main(String[] args) {
        ArrayList<String> student = new ArrayList<String>();
        student.add("Van");
        student.add("Chi"); 
        student.add("Huynh");

        for(int i =0; i<student.size(); i++){
            System.out.println(student.get(i));
        }
        for(String s : student){
            System.out.println(s);
        }
        System.out.println("\n Iterator");
        Iterator<String> itr = student.iterator();
        while(itr.hasNext()){
            String s = itr.next();
            if(s == "Chi"){
                itr.remove();
            }else{
                System.out.println(s);
            }
        }
    }
}