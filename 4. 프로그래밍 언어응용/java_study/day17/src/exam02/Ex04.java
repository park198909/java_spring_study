package exam02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

public class Ex04 {
    public static void main(String[] args){
        try(FileInputStream fis = new FileInputStream("data.obj");
            ObjectInputStream ois = new ObjectInputStream(fis)){

            Map<String, Object> data = (Map<String, Object>)ois.readObject();

            Book book2 = (Book)data.get("book2");
            Book book1 = (Book)data.get("book1");
            String str = (String)data.get("str");

            System.out.println(book2);
            System.out.println(book1);
            System.out.println(str);

        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
