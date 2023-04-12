package exam01;

public class Ex05 {
    public static void main(String[] args){
        String str = "abc";
        System.out.println(System.identityHashCode(str));

        str += "def";
        System.out.println(System.identityHashCode(str));

        str += "ghi";
        System.out.println(System.identityHashCode(str));

        str += "jkl";
        System.out.println(System.identityHashCode(str));
    }
}
