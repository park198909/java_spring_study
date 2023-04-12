package exam01;

public class Ex03 {
    public static void main(String[] args) {
        Book book1 = new Book("책1","저자1",10000);
        Book book2 = new Book("책1","저자1",10000);

        System.out.println(" == :  "+(book1==book2));
        System.out.println(" equals : "+book1.equals(book2));

    }
}
