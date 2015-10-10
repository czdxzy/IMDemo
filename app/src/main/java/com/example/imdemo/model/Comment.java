package com.example.imdemo.model;

/**
 * Created by Administrator on 2015/10/10.
 */
public class Comment {
    private String name;
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return name+":"+content;
    }
}
