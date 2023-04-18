package exam03;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex06 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(1,3,'F',"천이름"),
                new Student(2,3,'F',"이이름"),
                new Student(3,3,'M',"김이름"),
                new Student(1,2,'F',"박이름"),
                new Student(1,2,'M',"최이름"),
                new Student(1,2,'F',"강이름"),
                new Student(3,1,'M',"구이름"),
                new Student(2,1,'F',"홍이름"),
                new Student(1,1,'M',"하이름"),
                new Student(1,1,'F',"이이름")
        );

        Map<Integer,List<Student>> studentsByGrade = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade));

        IntStream.rangeClosed(1,3).mapToObj(studentsByGrade::get).forEach(System.out::println);

    }
}
