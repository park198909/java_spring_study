package exam01;

public class Ex06 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(100);

        /*
        StringBuffer sb2 = sb.append("abc");
        StringBuffer sb3 = sb2.append("def");
        StringBuffer sb4 = sb3.append("ghi");
        */

        //메서드체이닝
        sb.append("abc").append("def").append("ghi");


        sb.append("jkl");
//        System.out.println(System.identityHashCode(sb));

        String str = sb.toString();
        System.out.println(str);
        System.out.println(System.identityHashCode(str));

    }
}
