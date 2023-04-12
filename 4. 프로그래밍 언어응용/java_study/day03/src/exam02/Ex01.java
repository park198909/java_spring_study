package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Student s1 = new Student();         // Student라는 객체를 가진 s1이라는 변수를 정의한 코드
        s1.id = 1000;
        s1.name = "이름1";
        s1.subject = "과목1";

//        s1.study();

        boolean result = s1 instanceof Student;
        System.out.println(result);
    }
}
