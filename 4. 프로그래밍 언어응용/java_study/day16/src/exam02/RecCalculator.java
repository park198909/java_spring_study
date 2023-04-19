package exam02;

public class RecCalculator extends Calculator{
    @Override
    public long factorial(long num) {
        if(num < 1)
            return 1;

        return num*factorial(num-1);
    }
}
