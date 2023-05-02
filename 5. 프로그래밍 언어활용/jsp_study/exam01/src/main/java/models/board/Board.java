package models.board;

public class Board {
    private Long id;    // 번호
    private String subject; // 제목
    private String poster;  // 작성자

    public Board(Long id, String subject, String poster) {
        this.id = id;
        this.subject = subject;
        this.poster = poster;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
