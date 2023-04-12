package exam01;

import java.util.Objects;

public class Student extends Object{
    private int id;
    private String name;

    public Student(int id, String name) {
        super();    // new Object();
        this.id = id;
        this.name = name;
    }

    public final void method(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {   // Object o = new Student()...
        if(o instanceof Student){
                Student s = (Student)o;
                if(id == s.id && name.equals(s.name)){
                    return true;
                }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode()+id;
        // name -> String 클래스 객체
    }
}
