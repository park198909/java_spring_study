package exam01;

import java.io.File;
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        String path = "D:"+File.separator + "tmp" + File.separator + "tmp2"+ File.separator + "tmp3";
        File dir = new File(path);
        if(!dir.exists()){
//            dir.mkdir();
            dir.mkdirs();
        }
    }
}
