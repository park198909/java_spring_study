package exam02;

import static exam02.Transportation.*;  // 상수 호출을 위한 명령

public class Ex04 {
    public static void main(String[] args){
//        Transportation trans1 = BUS; // public static final
        int busFare = BUS.getBasicFare();
        int subwayFare = SUBWAY.getBasicFare();
        System.out.println("busFare : "+busFare);
        System.out.println("subwayFare : "+subwayFare);
        System.out.println("busTotalFare : " +BUS.getTotalFare(10));
    }
}
