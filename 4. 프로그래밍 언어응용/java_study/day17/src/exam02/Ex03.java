package exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Ex03 {
    public static void main(String[] args){
        Map<String, Object> data = new HashMap<>();
        data.put("book1", new Book("제목1", "책이름1"));
        data.put("book2", new Book("제목2", "책이름2"));
        data.put("str", "문구");

        try(FileOutputStream fos = new FileOutputStream("data.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){

            oos.writeObject(data);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
