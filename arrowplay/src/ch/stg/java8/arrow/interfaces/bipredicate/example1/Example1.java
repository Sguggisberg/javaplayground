package ch.stg.java8.arrow.interfaces.bipredicate.example1;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

import ch.stg.java8.mocks.Student;
import ch.stg.java8.mocks.StudentDataBase;

public class Example1 {

	private static BiPredicate<Integer, Double> biPredicate = (gradeLevel, gpa) -> gradeLevel >= 3 && gpa >= 3.9;
	private static BiConsumer<String, List<String>> studentBiConsumer = (name, activities) -> System.out
			.println(name + " : " + activities);
	private static Consumer<Student> studentConsumer = (student -> {
		if (biPredicate.test(student.getGradeLevel(), student.getGpa())) {
			studentBiConsumer.accept(student.getName(), student.getActivities());
		}
	});

	public static void main(String[] args) {
		List<Student> students = StudentDataBase.getAllStudents();
		students.forEach(studentConsumer);
	}
}