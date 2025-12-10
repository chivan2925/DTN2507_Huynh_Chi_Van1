import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DemoHashSet {

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
        @Override
        public int hashCode() {
            return Integer.hashCode(id); 
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Student student = (Student) obj;
            return id == student.id; 
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(1, "A", "a");
        // Student student2 = new Student(2, "B", "b");
        Student student3 = new Student(3, "C", "c");
         Student student2 = new Student(2, "B", "b");
        
        
        Student student2_dup = new Student(2, "Bc", "k"); 
        
        Student student4 = new Student(4, "D", "d");

        Set<Student> studentHashSet = new HashSet<>();
        
        studentHashSet.add(student1);
        studentHashSet.add(student2); 
        studentHashSet.add(student3);

        boolean added = studentHashSet.add(student2_dup);
        System.out.println("s2 da ton tai");
        
        studentHashSet.add(student4);
        
        System.out.println("\n--- 1. HashSet sau khi them ---");
        System.out.println("Tong so phan tu: " + studentHashSet.size()); 
        
        
        System.out.println("\n--- 2. Thu tu cac phan tu");
        for (Student sv : studentHashSet) {
            System.out.println(sv);
        }

    
        System.out.println("\n--- 3. Xoa phan tu ---");
        boolean removed = studentHashSet.remove(student4);
        System.out.println("Xoa Student 4 thanh cong? " + removed);
        
        System.out.println("Tong so phan tu sau khi xoa: " + studentHashSet.size()); 
        
        boolean removed_dup = studentHashSet.remove(student2_dup); 
        System.out.println("Xoa Student 2 bang doi tuong trung lap (student2_dup): " + removed_dup);
        
        System.out.println("Tong so phan tu cuoi cung: " + studentHashSet.size()); 
    }
}