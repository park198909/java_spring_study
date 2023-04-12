package exam08;

public class dsfsd {
    public Calculator method(int num3){
        Calculator cal = new Calculator() {
            public int add(int num1, int num2) {
                // num3을 상수화하여 스택에서 사라지지 않게 한다.
                // final int num3 = 30; 으로 저장된다.
                return num1+num2+num3;
            }
        };
        return cal;
    }
}
