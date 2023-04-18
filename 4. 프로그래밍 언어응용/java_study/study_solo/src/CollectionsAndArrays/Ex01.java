package CollectionsAndArrays;

import java.util.*;

import static java.util.Arrays.asList;

public class Ex01 {
    public static void main(String[] args) {
        List<String> names = asList("name1","name2","name3");
        System.out.println(names);

        String[][] names1 = {{"name1","name2","name3"},{"name1","name5","name3"}};
        String[][] names2 = {{"name1","name2","name3"},{"name1","name2","name3"}};

        boolean check;
        if (Arrays.deepEquals(names1, names2)) check = true;
        else check = false;
        System.out.println(check);
        System.out.println(Arrays.deepToString(names1));

        int[][] nums = {{1,2,3},{4,5,6}};

    }

}
