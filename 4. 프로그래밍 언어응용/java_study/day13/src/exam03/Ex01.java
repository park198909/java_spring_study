package exam03;

public class Ex01 {
    public static void main(String[] args) {
        /*
        Calculator cal = new Calculator() {
            @Override
            public int add(int num1, int num2) {
                return num1+num2;
            }
        };
         */
        Calculator cal = (a,b)->a+b;
        add(cal);

       /*
        add(new Calculator(){
            public int add(int num1, int num2) {
                return num1+num2;
            }
        });
        */
        add((a,b)->a+b);

        Calculator cal2 = getCalculator();
        int result = cal.add(10,20);
        System.out.println(result);
    }

    public static void add(Calculator cal){
        int result = cal.add(10,20);
        System.out.println(result);
    }

    public static Calculator getCalculator(){
        return (a,b)->a+b;
    }
}
