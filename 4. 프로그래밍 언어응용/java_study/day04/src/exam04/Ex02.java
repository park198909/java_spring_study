package exam04;

public class Ex02 {
    public static void main(String[] args){
        Student.id = 1000;      // 정적변수를 수정할 때는 클래스명.변수명으로 접근가능하다.
        System.out.println(Student.id);

        Student.printStaticInfo();
    }
}
