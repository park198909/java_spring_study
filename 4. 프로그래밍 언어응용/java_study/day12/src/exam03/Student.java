package exam03;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hashCode='" + hashCode() + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Student){
            Student s = (Student)o;
            if(id == s.id && name.equals(s.name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Student o) {
//        return id-o.id; // 오름차순
//        return o.id-id; // 내림차순
//        return Integer.valueOf(id).compareTo(o.id); // 오름차순
//        return Integer.valueOf(id).compareTo(o.id) * -1; // 내림차순
//        return name.compareTo(o.name);  // 오름차순
        return name.compareTo(o.name) * -1;  // 내림차순

    }
}
