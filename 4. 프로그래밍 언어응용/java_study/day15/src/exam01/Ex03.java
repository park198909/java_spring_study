package exam01;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Ex03 {
    public static void main(String[] args) {
        String[] fruits = {"Apple","Orange","Mango","Melon","banana"};

        IntStream istm = Arrays.stream(fruits).mapToInt(s->s.length());
        IntSummaryStatistics summary = istm.summaryStatistics();
        double avg = summary.getAverage();
        long sum = summary.getSum();
        long count = summary.getCount();
        long max = summary.getMax();
        long min = summary.getMin();

        System.out.println("avg="+avg+", sum="+sum+", count="+count+", max="+max+", min="+min);

//        int sum = istm.sum();
//        System.out.println("sum="+sum);
//        double avg = istm.average().getAsDouble();
//        System.out.println("avg="+avg);
    }
}
