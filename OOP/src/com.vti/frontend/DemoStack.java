import java.util.Stack;
import java.util.Iterator;
// import java.util.ArrayList; 
// import java.util.List;

public class DemoStack {

      public static class Student {
        private int id;
        private String name;
        private String email;

        public Student(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }
        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name;
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(1, "a", "an.nv@hcmut.edu.vn");
        Student student2 = new Student(2, "b", "binh.lt@hcmut.edu.vn");
        Student student3 = new Student(3, "c", "cuong.tv@hcmut.edu.vn");
        Student student4 = new Student(4, "d", "dung.pt@hcmut.edu.vn");
        Student student5 = new Student(5, "e", "hai.hm@hcmut.edu.vn");

        Stack<Student> studentStack = new Stack<>();
        
        studentStack.push(student1);
        studentStack.push(student2);
        studentStack.push(student3);
        studentStack.push(student4);
        studentStack.push(student5); 

        Iterator<Student> iterator = studentStack.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student);
        }
        System.out.println("poppppp");
        System.out.println(studentStack.pop());

        System.out.println("-----------------------------");
        iterator = studentStack.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student);
        }
        
    }
}