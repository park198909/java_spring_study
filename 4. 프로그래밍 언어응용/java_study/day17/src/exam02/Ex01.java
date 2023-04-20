package exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Ex01 {
    public static void main(String[] args){
        try(FileOutputStream fos = new FileOutputStream("book.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            List<Object> data = new ArrayList<>();

                Book book = new Book("제목1","책이름1");
//                oos.writeObject(book);
                data.add(book);

                Book book2 = new Book("제목2","책이름2");
//                oos.writeObject(book2);
                data.add(book2);

//                oos.writeObject("문구!!!");
                data.add("문구!!");
                oos.writeObject(data);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
