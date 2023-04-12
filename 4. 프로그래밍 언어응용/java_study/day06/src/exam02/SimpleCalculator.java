package exam02;

public class SimpleCalculator implements Calculator{

    @Override
    public int add(int num1, int num2) {
        return num1+num2;
    }

    @Override
    public int minus(int num1, int num2) {
        int result;
        if(num2>num1){ result = num2-num1; }
        else{ result = num1-num2; }
        return result;
    }
}
