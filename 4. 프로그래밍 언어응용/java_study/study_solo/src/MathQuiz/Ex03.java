package MathQuiz;

public class Ex03 {
    public static void main(String[] args) {
        // 건물 목상과의 각도(deg)가 45도, 건물까지의 거리(a)가  17.8미터 일때, 건물의 높이(b)는?
        double deg = 45;
        double dis = 17.8;
        double b;

        double rad = Math.toRadians(deg);


        b = dis * (Math.tan(rad));
        System.out.println(Math.tan(rad));
        System.out.println(b);
    }
}
