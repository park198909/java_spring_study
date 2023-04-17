package exam01;

import java.util.function.IntBinaryOperator;

public class Ex02 {
    public static void main(String[] args){
        Calculator cal = new Calculator();

//        IntBinaryOperator func1 = (a,b)->cal.add(a,b);
        IntBinaryOperator func1 = cal::add;
        int result = func1.applyAsInt(10,20);
        System.out.println(result);

    }
}
