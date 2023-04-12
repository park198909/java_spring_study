package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Student s1 = new Student(1000, "이름1");
        Student s2 = new Student(1000, "이름1");

        System.out.println("s1==s2 : "+(s1==s2));               // 동일성 비교
        System.out.println("s1.equals(s2) : "+s1.equals(s2));   // 동일성 비교 -> 동등성으로 재정의
        System.out.println("s1.hashCode : "+s1.hashCode());
        System.out.println("s2.hashCode : "+s2.hashCode());
    }
}
