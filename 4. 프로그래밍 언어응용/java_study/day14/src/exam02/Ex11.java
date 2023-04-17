package exam02;

import java.util.Arrays;
import java.util.List;

public class Ex11 {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("책1", "저자1"),
                new Book("책1", "저자1"),
                new Book("책2", "저자2"),
                new Book("책3", "저자3"),
                new Book("책4", "저자4")
        );

        List<Book> books2 = books.stream().distinct().toList();
        for(Book book : books2){
            System.out.println(book);
        }
    }
}