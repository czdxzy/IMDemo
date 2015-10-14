package com.example.imdemo.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.imdemo.R;
import com.example.imdemo.adapter.MyZoneAdapter;
import com.example.imdemo.model.Comment;
import com.example.imdemo.model.ItemState;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/12.
 */
public class MyZoneActivity extends BaseActivity{
    private ListView listView;
    private List<ItemState> itemStateList = new ArrayList<ItemState>();
    private Button writeMyStateButton;
    private MyZoneAdapter adapter;
    private EditText commentEditText;
    private Button sendCommentButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myzone);
        initView();
        initData();
        adapter = new MyZoneAdapter(this,R.layout.item_myzone,itemStateList);
        adapter.setListView(listView);
        listView.setAdapter(adapter);
        writeMyStateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void initData() {
                for (int i=0;i<10;i++){
                    ItemState itemState = new ItemState();
                    itemState.setName("landscape" + i);
                    itemState.setTime("Thursday 8:10 PM" + i);
                    itemState.setState("这是测试这是测试这是测试这是测试这是测试这是测试" + i);
                    List<Comment> commentList = new ArrayList<>();
                    for (int j =0; j<5;j++){
                        Comment comment = new Comment();
                        comment.setName("huanzi"+i);
                        comment.setContent("haogege");
                        commentList.add(comment);
                    }
                    itemState.setCommentList(commentList);
                    itemStateList.add(itemState);
                }
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.lv_friend_states);
        writeMyStateButton = (Button) findViewById(R.id.btn_write_my_state);
        commentEditText = (EditText) findViewById(R.id.et_comment);
        sendCommentButton = (Button) findViewById(R.id.btn_send_comment);
    }
    private void refresh(List<ItemState> itemStateList){
        this.itemStateList = itemStateList;
        adapter.notifyDataSetChanged();
    }

}
