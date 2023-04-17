package exam02;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Ex03 {
    public static void main(String[] args){
        String[] strs = {"A","B","C","D"};
//        forEach(strs, s-> System.out.println(s));
        forEach(strs, new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    public static <T> void forEach(T[] datas, Consumer<T> consumer){
        for(T data : datas){    // 내부 반복
            consumer.accept(data);
        }
    }
}
