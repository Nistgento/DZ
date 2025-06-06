package lesson2_6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        Student student1 = new Student("Ivan", "Group 1", 1,
                new HashMap<>(Map.of("Mathematics", 4, "Physics", 5, "History", 3)));
        Student student2 = new Student("Peter", "Group 2", 2,
                new HashMap<>(Map.of("Mathematics", 2, "Physics", 3, "History", 2)));
        Student student3 = new Student("Alex", "Group 1", 1,
                new HashMap<>(Map.of("Mathematics", 5, "Physics", 5, "History", 5)));

        students.add(student1);
        students.add(student2);
        students.add(student3);

        System.out.println("All students:");
        students.forEach(System.out::println);

        Student.removeUnderperformingStudents(students);
        System.out.println("\nStudents after removing the underachievers:");
        students.forEach(System.out::println);

        Student.promoteStudents(students);
        System.out.println("\nStudents after transfer to the next course:");
        students.forEach(System.out::println);

        Student.printStudents(students, 2);
    }
}