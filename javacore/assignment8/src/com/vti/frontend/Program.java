package com.vti.frontend;

// Các lớp HinhChuNhat, HinhHoc, HinhTron, MyMath, StudentV2 đã được import qua `*`
import com.vti.entity.static_learning.*;
// Import đầy đủ để tránh nhầm lẫn giữa các lớp Student và PrimaryStudent
import com.vti.entity.static_learning.Student;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        // --- EXERCISE 1: STATIC ---
        System.out.println("--- EXERCISE 1: STATIC ---");
        question1And4();
        question2();
        question3();
        question5();
        question6And7();
        question8();

        // --- EXERCISE 2: FINAL ---
        // Các bài tập về final chủ yếu thể hiện qua lỗi biên dịch khi cố gắng
        // thay đổi giá trị hoặc override, nên không có output cụ thể để chạy.
        // Bạn có thể xem comment trong các file entity/final_learning.
        System.out.println("\n--- EXERCISE 2: FINAL ---");
        System.out.println("Các bài tập về final được thể hiện qua code và comment trong các lớp thuộc gói com.vti.entity.final_learning.");
    }

    public static void question1And4() {
        System.out.println("\n--- Question 1 & 4 ---");
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Nguyễn Văn A"));
        students.add(new Student(2, "Nguyễn Văn B"));
        students.add(new Student(3, "Nguyễn Văn C"));

        System.out.println("Thông tin sinh viên ban đầu:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Thay đổi trường đại học
        Student.setCollege("Đại học công nghệ");

        System.out.println("\nThông tin sinh viên sau khi đổi trường:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void question2() {
        System.out.println("\n--- Question 2 ---");
        // Khởi tạo 3 student để mô phỏng
        Student student1 = new Student(1, "Student 1");
        Student student2 = new Student(2, "Student 2");
        Student student3 = new Student(3, "Student 3");

        // B1: Mỗi student nộp 100k
        Student.moneyGroup += 3 * 100_000;
        System.out.println("B1: Sau khi 3 student mỗi người nộp 100k, quỹ lớp là: " + Student.moneyGroup);

        // B2: Student 1 lấy 50k
        Student.moneyGroup -= 50_000;
        System.out.println("B2: Student 1 lấy 50k, quỹ lớp còn: " + Student.moneyGroup);

        // B3: Student 2 lấy 20k
        Student.moneyGroup -= 20_000;
        System.out.println("B3: Student 2 lấy 20k, quỹ lớp còn: " + Student.moneyGroup);

        // B4: Student 3 lấy 150k
        Student.moneyGroup -= 150_000;
        System.out.println("B4: Student 3 lấy 150k, quỹ lớp còn: " + Student.moneyGroup);

        // B5: Cả nhóm mỗi người đóng 50k
        Student.moneyGroup += 3 * 50_000;
        System.out.println("B5: Cả 3 student mỗi người đóng 50k, quỹ lớp cuối cùng là: " + Student.moneyGroup);
    }

    public static void question3() {
        System.out.println("\n--- Question 3 ---");
        int a = 10, b = 5;
        System.out.println("Min của " + a + " và " + b + " là: " + MyMath.min(a, b));
        System.out.println("Sum của " + a + " và " + b + " là: " + MyMath.sum(a, b));
    }

    public static void question5() {
        System.out.println("\n--- Question 5 ---");
        // Số lượng student đã được tạo từ các câu hỏi trước
        System.out.println("Tổng số student đã được sinh ra: " + Student.getStudentCount());
    }

    public static void question6And7() {
        System.out.println("\n--- Question 6 & 7 ---");
        try {
            StudentV2[] students = new StudentV2[8]; // Cố tình tạo mảng 8 phần tử để mô phỏng lỗi
            students[0] = new com.vti.entity.static_learning.PrimaryStudent(1, "Primary 1");
            students[1] = new com.vti.entity.static_learning.PrimaryStudent(2, "Primary 2");
            students[2] = new com.vti.entity.static_learning.SecondaryStudent(3, "Secondary 1");
            students[3] = new com.vti.entity.static_learning.SecondaryStudent(4, "Secondary 2");
            students[4] = new com.vti.entity.static_learning.SecondaryStudent(5, "Secondary 3");
            students[5] = new com.vti.entity.static_learning.SecondaryStudent(6, "Secondary 4");
            students[6] = new StudentV2(7, "Normal Student"); // Tạo student thứ 7

            System.out.println("Đã tạo thành công 7 học sinh. Thử tạo học sinh thứ 8...");
            students[7] = new StudentV2(8, "Student 8"); // Dòng này sẽ gây ra Exception

        } catch (Exception e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
        System.out.println("Tổng số Student (V2) đã tạo: " + com.vti.entity.static_learning.StudentV2.getStudentCount());
        System.out.println("Số PrimaryStudent đã tạo: " + com.vti.entity.static_learning.PrimaryStudent.getPrimaryStudentCount());
        System.out.println("Số SecondaryStudent đã tạo: " + com.vti.entity.static_learning.SecondaryStudent.getSecondaryStudentCount());
    }

    public static void question8() {
        System.out.println("\n--- Question 8 ---");
        try {
            HinhHoc[] hinhHocs = new HinhHoc[Configs.SO_LUONG_HINH_TOI_DA + 1];
            for (int i = 0; i < hinhHocs.length; i++) {
                System.out.println("Đang tạo hình thứ " + (i + 1));
                // Tạo xen kẽ HinhTron và HinhChuNhat để demo
                if (i % 2 == 0) {
                    hinhHocs[i] = new HinhTron(10);
                } else {
                    hinhHocs[i] = new HinhChuNhat(5, 10);
                }
            }
        } catch (HinhHocException e) {
            System.err.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }
}