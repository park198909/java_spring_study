package exam02;

public class Ex04 {
    public static void main(String[] args) {
        A ac = new C();
        A ad = new D();
        if(ad instanceof C) {
            C c1 = (C) ad;
        }

        System.out.println(ac instanceof A);
        System.out.println(ac instanceof B);
        System.out.println(ac instanceof C);
        System.out.println(ac instanceof D);
        System.out.println(ad instanceof A);
        System.out.println(ad instanceof B);
        System.out.println(ad instanceof C);
        System.out.println(ad instanceof D);
    }
}
