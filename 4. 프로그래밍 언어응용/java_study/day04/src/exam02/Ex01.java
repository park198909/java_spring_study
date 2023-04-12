package exam02;

import exam03.B;

public class Ex01 {
    public static void main(String[] args) {
        Schedule s1 = new Schedule();
        s1.setYear(2023);
        s1.setMonth(2);
        s1.setDay(31);

        s1.showInfo();

        System.out.println(s1.getYear());

        int month = s1.getMonth();
        System.out.println(month);
        System.out.println(s1.getDay());

/*        s1.year = 2023;
          s1.month = 2;
          s1.day = 31;
          s1.showInfo();   */


    }
}
