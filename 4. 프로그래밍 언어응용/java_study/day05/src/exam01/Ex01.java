package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Company c1 = Company.getInstance();
        Company c2 = Company.getInstance();


//        Company c1 = new Company();
//        Company c2 = new Company();
        System.out.println("c1= "+System.identityHashCode(c1));
        System.out.println("c2= "+System.identityHashCode(c2));
    }
}
