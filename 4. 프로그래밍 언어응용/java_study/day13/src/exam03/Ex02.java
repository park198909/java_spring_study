package exam03;

public class Ex02 {
    public static void main(String[] args) {
        Calculator cal = (a, b)-> a + b;
    }

    public static void add(Calculator cal){
        int result = cal.add(10,20);
        System.out.println(result);
    }
}
