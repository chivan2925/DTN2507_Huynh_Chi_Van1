import java.util.Queue;
import java.util.Iterator;
import java.util.LinkedList;
// import java.util.ArrayList; 
// import java.util.List;

public class DemoQueue {

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

        Queue<Student> studentQueue = new LinkedList<Student>();
        studentQueue.offer(student1);
        studentQueue.offer(student2);
        studentQueue.offer(student3);
        studentQueue.offer(student4);
        studentQueue.offer(student5);

        System.out.println("queue");     
        Iterator<Student> iterator = studentQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("");
       
        studentQueue.poll();
        studentQueue.poll();
        
        System.out.println(studentQueue.isEmpty());
       
        iterator = studentQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
    }
}