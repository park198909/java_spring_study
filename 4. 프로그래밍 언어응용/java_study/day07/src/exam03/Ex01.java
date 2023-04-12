package exam03;

public class Ex01 {
    public static void main(String[] args) {
        LoginService service = new LoginService();
        try{
            service.Login("user","12345");

            System.out.println("실행 코드!");
        }catch (IDNotFoundException e){
            System.out.println(e.getMessage());
        }catch (PWIncorrectException e){
            System.out.println(e.getMessage());
        }
    }
}
