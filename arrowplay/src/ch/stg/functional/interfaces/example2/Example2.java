package ch.stg.functional.interfaces.example2;

import ch.stg.functional.interfaces.mocks.Student;
import ch.stg.functional.interfaces.mocks.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Example2 {

    private static Function<List<Student>, Map<String, Double>> studentFunction = (students -> {
        Map<String, Double> studentGrademap = new HashMap<>();
        students.forEach(student -> {
            studentGrademap.put(student.getName(), student.getGpa());
        });
        return studentGrademap;
    });

    public static void main(String[] args) {
        System.out.println(studentFunction.apply(StudentDataBase.getAllStudents()));
    }
}
