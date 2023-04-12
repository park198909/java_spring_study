package exam04;

public class Student {
    static int id;

    String name;

    String subject;

    public static void printStaticInfo() {
        System.out.println("정적 메서드!");
//        this.printInfo();
//        this.name
        id = 1000;
        staticMethod();

    }

    public static void staticMethod(){

    }

    public void printInfo(){
        System.out.println("인스턴스 메서드!");
        name = "이름";

        id = 1000;
        staticMethod();

    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
