package exam01;

import java.util.HashSet;

public class Ex03 {
    public static void main(String[] args){
        HashSet<Student> data = new HashSet<>();
        data.add(new Student(1000,"이름1"));
        data.add(new Student(1001,"이름2"));
        data.add(new Student(1000,"이름1"));

        for(Student s : data){
            System.out.println(s);
        }

    }
}
