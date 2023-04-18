package exam03;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex01 {
    public static void main(String[] args) {
        List<Student> student = Arrays.asList(
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

        List<String> names = student.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(names);

        Set<String> names2 = student.stream().map(Student::getName).collect(Collectors.toSet());
        System.out.println(names2);

        ArrayList<String> names3 = student.stream().map(Student::getName)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(names3);

        Map<Integer, Student> student2 = student.stream().collect(Collectors
                .toMap(s->Objects.hash(s.getBan(),s.getGrade(),s.getGender(),s.getName()), Function.identity()));
        student2.entrySet().stream().forEach(System.out::println);

    }
}
