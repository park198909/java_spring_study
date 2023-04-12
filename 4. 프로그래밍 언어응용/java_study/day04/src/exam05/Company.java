package exam05;

public class Company {
    private Company() {}    // 생성자 함수
    private static Company instance;    // 객체 중복생성 방지용 변수

    public static Company getInstance(){    // 참조함수
        if(instance == null){
            instance = new Company();
        }
        return instance;
    }
}
