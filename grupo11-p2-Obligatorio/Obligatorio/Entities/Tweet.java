package Entities;

public class Tweet {
    private long id;
    private String content;
    private String source;
    private Boolean isRetweet;
    private String fechaTweet;

    public Tweet(long id, String content, String source,String fechaTweet ,Boolean isRetweet) {
        this.id = id;
        this.content = content;
        this.source = source;
        this.isRetweet = isRetweet;
        this.fechaTweet = fechaTweet;

    }

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

    public String getFechaTweet() {
        return fechaTweet;
    }

    public void setFechaTweet(String fechaTweet) {
        this.fechaTweet = fechaTweet;
    }
}
