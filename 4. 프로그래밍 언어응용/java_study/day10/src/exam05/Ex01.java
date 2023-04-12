package exam05;

public class Ex01 {
    public static void main(String[] args) {
//        Class cls = new Student().getClass(); // 객체에서 클래스정보를 획득
        Class cls = Student.class;              // 정적클래스로부터 클래스정보를 획득
        MyAnno anno = (MyAnno) cls.getAnnotation(MyAnno.class);
        String value = anno.value();            // anno에 저장된 MyAnno클래스정보로부터 value()의 값을 호출
        System.out.println(value);
//        System.out.println(anno instanceof MyAnno);

    }
}
