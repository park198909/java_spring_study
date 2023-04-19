package exam04;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args){
        try(FileInputStream fis = new FileInputStream("scores.dat");
            DataInputStream dis = new DataInputStream(fis)){

            int total=0, count=0;
            try {
                while (true) {
                    int score = dis.readInt();
                    total += score;
                    count++;
                }
            }catch(EOFException e){
                System.out.println("합계 : "+total);
                System.out.println("평균 : "+Math.round(total/count));
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
