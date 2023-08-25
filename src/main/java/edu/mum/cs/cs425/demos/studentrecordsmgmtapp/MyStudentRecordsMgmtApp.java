package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MyStudentRecordsMgmtApp {
    private static final List<Student> studentList = new ArrayList<>();
    public static void main(String[] args) {
        MyStudentRecordsMgmtApp app = new MyStudentRecordsMgmtApp();
        app.init();
        app.print(studentList);

        List<Student> platinumList = app.getListOfPlatinumAlumniStudents();
        System.out.println("\n-----------------------\nprinting platinum students");
        app.print(platinumList);

        System.out.println("\n-----------------------\nprintHelloWorld()");
        app.printHelloWorld(new int[]{1,5,7,35,4});

        System.out.println("\n-----------------------\nfindSecondBiggest()");
        System.out.println(app.findSecondBiggest(new int[]{1,2,3,4,5}));
        System.out.println(app.findSecondBiggest(new int[]{19,9,11,0,12}));
    }

    private void init() {
        Student s1 = new Student(110001, "Dave", LocalDate.of(1951, 11, 18));
        studentList.add(s1);
        Student s2 = new Student(110002, "Anna", LocalDate.of(1990, 7, 12));
        studentList.add(s2);
        Student s3 = new Student(110003, "Erica", LocalDate.of(1974, 1, 31));
        studentList.add(s3);
        Student s4 = new Student(110004, "Carlos", LocalDate.of(2009, 8, 22));
        studentList.add(s4);
        Student s5 = new Student(110005, "Bob", LocalDate.of(1990, 3, 5));
        studentList.add(s5);
    }

    private void print(List<Student> list) {
        list.forEach(System.out::println);
    }

    private List<Student> getListOfPlatinumAlumniStudents() {
        List<Student> result = new ArrayList<>();
        LocalDate todayBefore = LocalDate.now().minusYears(30);
        for (Student s: studentList) {
            if (s.getDateOfAdmission().isBefore(todayBefore)) {
                result.add(s);
            }
        }
        return result;
    }

    private void printHelloWorld(int[] numbers) {
        for (int i: numbers) {
            if (i % 5 == 0) {
                System.out.print("Hello");
            }
            if (i % 7 == 0) {
                System.out.print("World");
            }
            System.out.println();
        }
    }

    private int findSecondBiggest(int[] numbers) {
        int localMax = Integer.MIN_VALUE;
        int previousMax = Integer.MIN_VALUE;
        for (int i: numbers) {
            if (i > localMax) {
                previousMax = localMax;
                localMax = i;
            } else if (i > previousMax) {
                previousMax = i;
            }
        }

        return previousMax;
    }
}
