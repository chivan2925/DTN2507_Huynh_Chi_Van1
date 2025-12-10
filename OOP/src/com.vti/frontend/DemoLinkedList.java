import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Iterator;

public class DemoLinkedList {
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
        Student student1 = new Student(1, "a", "an@example.com");
        Student student2 = new Student(2, "b", "binh@example.com");
        Student student3 = new Student(3, "c", "cuong@example.com");
        Student student4 = new Student(4, "d", "dung@example.com");
        Student student5 = new Student(5, "e", "hai@example.com");

    
        LinkedList<Student> studentList = new LinkedList<>();

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student3);

        
        studentList.addFirst(student4); 
        studentList.addLast(student5);
        
        System.out.println("\n--- 2. Sau khi thêm vào đầu và cuối ---");
        studentList.remove(2); 
        System.out.println("Đã xóa Student 2 (Bình) bằng index.");

        // 4. Duyệt và in danh sách còn lại
        System.out.println("\n--- 3. Danh sách còn lại (Duyệt Iterator) ---");
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 5. Minh họa hoạt động như Queue (FIFO)
        System.out.println("\n--- 4. Minh họa hoạt động như Queue (poll/peek) ---");
        
        
        Student head = studentList.peek(); 
        System.out.println("Phần tử đầu (peek): " + head);
        
       
        Student removedHead = studentList.poll(); 
        System.out.println("Phần tử đã xóa (poll): " + removedHead);
        
        System.out.println("Kích thước sau poll: " + studentList.size());
    }
}