package exam02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Ex02 {
    public static void main(String[] args){
        try(FileInputStream fis = new FileInputStream("book.obj");
            ObjectInputStream ois = new ObjectInputStream(fis)){
            /*
            Book book = (Book)ois.readObject();
            Book book2 = (Book)ois.readObject();

            String str = (String)ois.readObject();
            */
//            System.out.printf("book=%s%nbook2=%s%n",book,book2);
//            System.out.println(str);

            List<Object> data = (List<Object>)ois.readObject();
            data.stream().forEach(System.out::println);

        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
