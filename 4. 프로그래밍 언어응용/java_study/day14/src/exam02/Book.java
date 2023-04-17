package exam02;

import java.util.Objects;

public class Book implements Comparable<Book>{
    private String title;
    private String author;

    public Book(String title,String author){
        this.author = author;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public int compareTo(Book o){
        return title.compareTo(o.title);
    }
    
    public int compareToAuthor(Book o){
        return o.author.compareTo(author);  // 내림차순
    }
}
