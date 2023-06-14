package Entities;

public class Tweet {
    long id;
    String content;
    String source;
    Boolean isRetweet;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Boolean getRetweet() {
        return isRetweet;
    }

    public void setRetweet(Boolean retweet) {
        isRetweet = retweet;
    }
}
