package exam04;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class Ex01 {
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("data.dat");
            DataOutputStream dos = new DataOutputStream(fos)){

            dos.writeInt(100);
            dos.writeBoolean(true);
            dos.writeUTF("안녕하세요");

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
