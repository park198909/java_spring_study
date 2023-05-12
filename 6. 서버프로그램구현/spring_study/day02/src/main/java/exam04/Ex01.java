package exam04;

public class Ex01 {
    public static void main(String[] args) {
        Calculator simCal = new ProxyCalculator(new SimpleCalculator());
        Calculator recCal = new ProxyCalculator(new RecCalculator());

        long result1 = simCal.factorial(20);
        System.out.printf("cal1=%d%n",result1);

        long result2 = recCal.factorial(20);
        System.out.printf("cal2=%d%n",result2);

    }
}
