package com.targetcompetitions.retrofittutorial;

public class Post {
    private Integer id = null;
    private int userId;
    private String title;
    private String body;

    public Post(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }
}
