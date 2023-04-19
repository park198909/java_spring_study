package exam02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args) {
        try(FileReader fr = new FileReader("20230417.log");
            BufferedReader br = new BufferedReader(fr)){

            String line = null;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
