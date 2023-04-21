package exam01;

public class Ex02 {
    public static void main(String[] args) {
        // 건물의 높이를 구하시오.
        // 건물에서 20m 떨어진 지점에서 건물의 꼭대기를 올려본 각을 측정해보니 60°였다고 한다.
        // 관측자의 눈 높이는 지상으로부터 1.5m 떨어져 있다고 한다.
        double sight = 1.5;
        double radi = Math.toRadians(60);
        double ht = (Math.tan(radi) * 20) + sight;
        System.out.printf("건물의 높이는 %fM 이다",ht);
    }
}
