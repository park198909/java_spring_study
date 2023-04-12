package exam01;

public class SimpleCalculator extends Calculator{
    @Override
    public int add(int num1, int num2){

        return num1+num2;
    }

    @Override
    public int minus(int num1, int num2) {
        return num1-num2;
    }
}
