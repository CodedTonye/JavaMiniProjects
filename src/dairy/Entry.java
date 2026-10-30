package dairy;

public class Entry {
    private int Id;
    private String title;

    private String body;


    public Entry(int Id, String title, String body) {
        this.Id = Id;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
