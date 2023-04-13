package exam02;

import java.util.Objects;

public class Student {
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

}
