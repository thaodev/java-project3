package libraryManager;
public class Book {
    private String id;
    private String title;
    private String author;
    private Boolean isBorrowed = false;

    public Book(String id, String title, String author, Boolean isBorrowed) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = isBorrowed;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor(){
        return author;
    }

    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public boolean getBorrowed() {
        return isBorrowed;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-20s%-20s%-20s", id, title, author, isBorrowed);

    }
}