package com.example.imdemo.model;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2015/9/30.
 */
public class ItemWeixin {
    private Bitmap face;
    private String content;
    private String title;

    public Bitmap getFace() {
        return face;
    }

    public void setFace(Bitmap face) {
        this.face = face;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
