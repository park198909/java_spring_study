package exam01;

import java.io.File;

public class Ex06 {
    public static void main(String[] args){
        String path = "D:" + File.separator + "tmp";
        File file = new File(path);
        System.out.printf("디렉토리? %s%n",file.isDirectory());

        String path2 = "D:" + File.separator + "tmp";
        File file2 = new File(path2);
        System.out.printf("파일용량? %d%n",file2.length());
    }
}
