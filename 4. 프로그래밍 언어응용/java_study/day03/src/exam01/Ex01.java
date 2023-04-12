package exam01;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        int[][] nums = new int[2][3];
//        int[][] nums = {{1,2,3},{4,5,6}};
        nums[0][0] = 10;
        nums[0][1] = 20;
        nums[0][2] = 30;

        nums[1][0] = 40;
        nums[1][1] = 50;
        nums[1][2] = 60;

        System.out.println(Arrays.deepToString(nums));
    }
}
