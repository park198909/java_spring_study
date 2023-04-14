package exam02;

public class Ex02 {
    public static void main(String[] args) {
        /*
        int c = 20;
        Calculator cal = (a, b)->{ // 용도가 한정된 메서드를 간략히 표현하는 람다식 -> 인터페이스에 단일기능만이 존재해야 한다.
            return a + b + c;       // c는 상수화 되므로 변경불가
        };
        */
        Calculator cal = (a,b) -> a+b;
        int result = cal.add(10,20);
        System.out.println(result);

        add(cal);

        add((a,b)->a+b);
    }

    public static void add(Calculator a){
        int result = a.add(10,20);
        System.out.println(result);
    }

}
