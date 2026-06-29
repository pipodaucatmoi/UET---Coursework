package bai511;

public class Message {
    String id;
    String content;

    public Message(String id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
