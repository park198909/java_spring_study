package exam05;

public class Ex05 {
    public static void main(String[] args) {
//        Company c1 = new Company();
//        Company c2 = new Company();

        Company c1 = Company.getInstance();  // 객체 생성

        Company c2 = Company.getInstance();  // 동일한 객체 호출
        System.out.println(c1==c2);
    }
}
