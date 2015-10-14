package com.example.imdemo.model;

import android.graphics.Bitmap;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Administrator on 2015/10/10.
 */
public class ItemState {
    private String name;
    private String state;
    private String time;
    private Bitmap face;
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private List<Comment> commentList;

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getFace() {
        return face;
    }

    public void setFace(Bitmap face) {
        this.face = face;
    }
    public  String getComments(){
        String comments=new String();
        for (int i=0;i<this.commentList.size();i++){
            Comment comment = commentList.get(i);
            comments += comment.toString()+"\n";
        }
        return comments;
    }
}
