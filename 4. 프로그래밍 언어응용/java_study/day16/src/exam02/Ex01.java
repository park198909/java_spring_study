package exam02;

public class Ex01 {
    public static void main(String[] args) {
        ImplCalculator cal1 = new ImplCalculator();
        RecCalculator cal2 = new RecCalculator();

        long sTime = System.nanoTime();
        long result1 = cal1.factorial(10);
        System.out.println("cal1="+result1);
        long eTime = System.nanoTime();
        System.out.println("cal1이 걸린 시간 : "+(eTime-sTime));


        sTime = System.nanoTime();
        long result2 = cal2.factorial(10);
        System.out.println("cal2="+result2);
        eTime = System.nanoTime();
        System.out.println("cal2이 걸린 시간 : "+(eTime-sTime));
    }
}
