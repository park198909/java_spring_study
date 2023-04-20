package exam01;

import java.io.File;
import java.io.IOException;

public class Ex03 {
    public static void main(String[] args) throws Exception {
//        String filePath = "D:" + File.separator + "tmp" + File.separator+ "file.txt";
//        System.out.println(filePath);
//        File file = new File(filePath);
//        file.createNewFile();   // 빈 파일 생성

        String dirPath = "D:" + File.separator + "tmp";
        File file = File.createTempFile("tmp",".log",new File(dirPath));

        Thread.sleep(5000);
        file.deleteOnExit();

    }
}
