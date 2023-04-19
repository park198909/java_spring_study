package exam01;

import java.io.FileOutputStream;
import java.io.IOException;

public class Ex06 {
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("20230417.log",true)) {
            for( char ch = 'A'; ch<='Z'; ch++){
                fos.write(ch);
            }
            fos.write('\n');
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
