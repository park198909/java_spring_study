package exam03;

import java.io.*;

public class Ex02 {
    public static void main(String[] args) {
        long sTime = System.currentTimeMillis();
        try(FileInputStream fis = new FileInputStream("docs.zip");
            BufferedInputStream bis = new BufferedInputStream(fis);
            FileOutputStream fos = new FileOutputStream("copied2_docs.zip");
            BufferedOutputStream bos = new BufferedOutputStream(fos)){

            while(bis.available()>0){
                bos.write(bis.read());
            }

        }catch(IOException e) {
            e.printStackTrace();
        }
        long eTime = System.currentTimeMillis();
        System.out.println("걸린시간 : "+(eTime-sTime));
    }
}
