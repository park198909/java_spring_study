package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Transportation trans = Transportation.SUBWAY;

//       System.out.println(trans == Transportation.SUBWAY);

        switch (trans){
            case BUS :
                System.out.println("버스!");
                break;
            case SUBWAY:
                System.out.println("지하철!");
                break;
            case TRAIN:
                System.out.println("기차!");
        }
    }
}
