package com.care4india.restapi;

/**
 * Created by rameshkale on 08/08/20.
 */
public class Greetings {

    private final long id;
    private final String content;

    public Greetings(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}