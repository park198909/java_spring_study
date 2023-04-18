package exam03;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

public class Ex05 {
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

        Map<Boolean,List<Student>> studentsByGender = students.stream()
                .collect(partitioningBy(Student::isFemale));

        List<Student> females = studentsByGender.get(true);
        List<Student> males = studentsByGender.get(false);
        System.out.println("females="+females);
        System.out.println("males="+males);
    }
}
