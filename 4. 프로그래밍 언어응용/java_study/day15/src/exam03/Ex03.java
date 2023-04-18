package exam03;

import java.util.*;

import static java.util.stream.Collectors.*;

public class Ex03 {
    public static void main(String[] args){
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

//        List<String> names = students.stream().map(Student::getName).collect(Collectors.toList());
//        System.out.println(names);

//        Set<String> names = students.stream().map(Student::getName).collect(Collectors.toSet());
//        System.out.println(names);

        Map<Integer ,Student> students2 = students.stream()
                .collect(toMap(Ex03::keyMapper,s->s));
        students2.entrySet().stream().forEach(System.out::println);
    }

    private static int keyMapper(Student s) {
        return Objects.hash(s.getBan(), s.getGrade(), s.getGender(), s.getName());
    }
}
