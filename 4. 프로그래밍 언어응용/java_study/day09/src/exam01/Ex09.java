package exam01;

public class Ex09 extends Object{
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = new String("abc");
        checkEquals(str1,str2);

        String str3 = new StringBuffer("abc").toString();
        checkEquals(str1,str3);
    }
    
    static void checkEquals(String str1, String str2){
//        System.out.println(str1==str2); // 동일성 비교
        System.out.println(str1.equals(str2)); // 동등성 비교
    }
}
