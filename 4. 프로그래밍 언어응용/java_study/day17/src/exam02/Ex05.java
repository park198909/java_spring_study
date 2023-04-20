package exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ex05 {
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("data2.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){

            oos.writeObject(new Book("제목1","책제목1"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
