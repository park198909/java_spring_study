package exam04;

public class Ex01 {
    public static void main(String[] args) {
        try {
            LoginService service = new LoginService();
            service.login("user1", "1234");
        } catch(RuntimeException e){
            System.out.println(e.getMessage());
        }

        System.out.println("코드 실행!");
    }
}
