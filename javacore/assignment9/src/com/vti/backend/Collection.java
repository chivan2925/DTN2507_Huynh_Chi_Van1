package com.vti.backend;

import com.vti.entity.Student;
import java.util.*;
import java.util.stream.Collectors;

public class Collection {

    // --- Question 1: List ---
    public void question1List() {
        System.out.println("--- Question 1: List ---");
        
        List<Student> students = new ArrayList<>();
        students.add(new Student("Nguyen Van Nam"));
        students.add(new Student("Tran Van Huyen"));
        students.add(new Student("Nguyen Van Nam")); // Trung ten
        students.add(new Student("Le Thi A"));
        students.add(new Student("Pham Van B"));
        students.add(new Student("Nguyen Van Nam")); // Trung ten

        System.out.println("Danh sach students ban dau:");
        students.forEach(System.out::println);

        // a) In ra tong so phan tu
        System.out.println("\na) Tong so phan tu: " + students.size());

        // b) Lay phan tu thu 4 (index = 3)
        System.out.println("b) Phan tu thu 4: " + students.get(3));

        // c) In ra phan tu dau va cuoi
        System.out.println("c) Phan tu dau: " + students.get(0));
        System.out.println("c) Phan tu cuoi: " + students.get(students.size() - 1));

        // d) Them 1 phan tu vao vi tri dau
        students.add(0, new Student("Nguyen Van C (Dau)"));
        System.out.println("d) Sau khi them vao dau: " + students.get(0));

        // e) Them 1 phan tu vao vi tri cuoi
        students.add(new Student("Tran Thi D (Cuoi)"));
        System.out.println("e) Sau khi them vao cuoi: " + students.get(students.size() - 1));

        // f) Dao nguoc vi tri
        Collections.reverse(students);
        System.out.println("\nf) Danh sach dao nguoc (Head/Tail): " + students.get(0) + "/" + students.get(students.size()-1));
        Collections.reverse(students); 

        // g) Tim kiem student theo id
        System.out.print("\ng) Tim kiem ID=2: "); findStudentById(students, 2);

        // h) Tim kiem student theo name
        System.out.println("h) Tim kiem Name='Nguyen Van Nam':"); findStudentsByName(students, "Nguyen Van Nam");

        // i) In ra cac student co trung ten
        System.out.println("i) Cac student co trung ten:"); printDuplicateNames(students);

        // j) Xoa name cua student co id = 2
        Student studentToUpdateName = students.stream().filter(s -> s.getId() == 2).findFirst().orElse(null);
        if (studentToUpdateName != null) {
            studentToUpdateName.setName("Name bi xoa"); 
            System.out.println("\nj) Student ID=2 sau khi xoa name: " + studentToUpdateName);
        }

        // k) Delete student co id = 5
        students.removeIf(s -> s.getId() == 5);
        System.out.println("\nk) Danh sach sau khi xoa student ID=5 (size): " + students.size());

        // l) Tao studentCopies
        List<Student> studentCopies = new ArrayList<>(students);
        System.out.println("l) studentCopies size: " + studentCopies.size());
    }
    
    // Method g)
    public void findStudentById(List<Student> students, int id) {
        students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Khong tim thay ID=" + id));
    }

    // Method h)
    public void findStudentsByName(List<Student> students, String name) {
        students.stream()
                .filter(s -> Objects.equals(s.getName(), name))
                .forEach(System.out::println);
    }

    // Method i)
    public void printDuplicateNames(List<Student> students) {
        students.stream()
                .filter(s -> s.getName() != null)
                .collect(Collectors.groupingBy(Student::getName, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println("- Ten trung: " + entry.getKey() + " (x" + entry.getValue() + ")"));
    }

    // --- Question 2: Stack & Queue ---
    public void question2StackAndQueue() {
        System.out.println("\n--- Question 2: Stack & Queue ---");
        String[] interviewees = {"Nguyen Van Nam", "Nguyen Van Huyen", "Tran Van Nam", "Nguyen Van A"};

        // a) Stack: LIFO (Muon nhat toi Som nhat)
        printInterviewOrderStack(interviewees); 

        // b) Queue: FIFO (Som nhat toi Muon nhat)
        printInterviewOrderQueue(interviewees);
    }

    // a) Stack (Muon nhat toi Som nhat)
    public void printInterviewOrderStack(String[] names) {
        System.out.println("\na) Thu tu TU MUON NHAT TOI SOM NHAT (Stack):");
        Stack<String> stack = new Stack<>();
        for (String name : names) {
            stack.push(name);
        }
        while (!stack.isEmpty()) {
            System.out.println("- " + stack.pop());
        }
    }

    // b) Queue (Som nhat toi Muon nhat)
    public void printInterviewOrderQueue(String[] names) {
        System.out.println("\nb) Thu tu TU SOM NHAT TOI MUON NHAT (Queue):");
        Queue<String> queue = new LinkedList<>();
        for (String name : names) {
            queue.add(name);
        }
        while (!queue.isEmpty()) {
            System.out.println("- " + queue.poll());
        }
    }
    
    // --- Question 3, 4, 5: Set ---
    public void question345Set() {
        System.out.println("\n--- Question 3, 4, 5: Set ---");
        
        // Dung TreeSet (sap xep theo ten) cho Q5.
        // Comparator.comparing(Student::getName) can thiet vi Student khong implement Comparable.
        Set<Student> studentsSet = new TreeSet<>(Comparator.comparing(Student::getName));
        
        studentsSet.add(new Student("Nguyen Van Nam"));
        studentsSet.add(new Student("Tran Van Huyen"));
        studentsSet.add(new Student("Nguyen Van Nam")); // Bi loai bo vi ten trung (dua tren equals/hashCode)
        studentsSet.add(new Student("Le Thi A"));

        // Q4 & Q5 (Set loai bo trung lap va sap xep theo Name)
        System.out.println("\nQ4 & Q5: Danh sach student KHONG TRUNG TEN va SAP XEP THEO NAME:");
        studentsSet.forEach(System.out::println);
        
        // Q3a) In ra tong so phan tu
        System.out.println("\nQ3a) Tong so phan tu: " + studentsSet.size());
        
        // Q3c) In ra phan tu dau va phan tu cuoi (Chi co the voi TreeSet)
        if (studentsSet instanceof TreeSet) {
            TreeSet<Student> treeSet = (TreeSet<Student>) studentsSet;
            System.out.println("Q3c) Phan tu dau (theo ten): " + treeSet.first());
            System.out.println("Q3c) Phan tu cuoi (theo ten): " + treeSet.last());
        }

        // Q3k) Delete student co id = 4
        studentsSet.removeIf(s -> s.getId() == 4);
        System.out.println("Q3k) Kich thuoc Set sau khi xoa ID=4: " + studentsSet.size());
    }

    // --- Question 6 & 7: Map ---
    public void question6and7Map() {
        System.out.println("\n--- Question 6 & 7: Map ---");
        
        // Q6: Map key=id, value=name
        Map<Integer, String> studentsMap = new HashMap<>();
        studentsMap.put(1, "Nguyen Van Nam");
        studentsMap.put(2, "Tran Van Huyen");
        studentsMap.put(3, "Nguyen Van Nam");
        studentsMap.put(4, "Le Thi A");

        // Q7a) In ra cac key
        System.out.println("\na) Keys (ID): " + studentsMap.keySet());

        // Q7b) In ra value
        System.out.println("b) Values (Name): " + studentsMap.values());

        // Q7c) In ra danh sach students duoc sap xep theo ten (value)
        System.out.println("c) Danh sach sap xep theo ten (Value):");
        studentsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println("- ID: " + entry.getKey() + ", Name: " + entry.getValue()));

        // Q7d) Chuyen doi map students sang set
        Set<Map.Entry<Integer, String>> studentsSetFromMap = studentsMap.entrySet();
        System.out.println("\nd) Map chuyen sang Set (Set<Map.Entry>): " + studentsSetFromMap.size() + " phan tu.");
        studentsSetFromMap.forEach(entry -> System.out.println("- " + entry));
    }
}