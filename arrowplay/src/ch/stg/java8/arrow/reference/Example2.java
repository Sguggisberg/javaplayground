package ch.stg.java8.arrow.reference;

import ch.stg.java8.mocks.Student;
import ch.stg.java8.mocks.StudentDataBase;

import java.util.function.Consumer;

public class Example2 {
    private static Consumer<Student> c1 = p -> System.out.println(p);
    private static Consumer<Student> c2 = System.out::println;

    public static void main(String[] args) {
        StudentDataBase.getAllStudents().forEach(c1);
        StudentDataBase.getAllStudents().forEach(c2);

    }
}
