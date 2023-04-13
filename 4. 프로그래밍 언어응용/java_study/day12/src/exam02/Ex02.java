package exam02;

import java.util.HashSet;
import java.util.Iterator;

public class Ex02 {
    public static void main(String[] args){
        HashSet<Student> students = new HashSet<>();
        students.add(new Student(1000,"이름1"));
        students.add(new Student(1000,"이름1"));
        students.add(new Student(1001,"이름2"));
        students.add(new Student(1002,"이름3"));
        students.add(new Student(1003,"이름4"));

        Iterator<Student> iter = students.iterator();
        while(iter.hasNext()){
            Student s = iter.next();
            System.out.println(s);
        }

        iter = students.iterator();
        while(iter.hasNext()){
            Student s = iter.next();
            System.out.println(s);
        }

        /*
        for (Student student : students){
            System.out.println(student);
        }

         */
    }
}
