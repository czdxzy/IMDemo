package com.example.imdemo.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imdemo.R;
import com.example.imdemo.adapter.ChatAdapter;
import com.example.imdemo.model.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/8.
 */
public class ChatActivity extends BaseActivity{
    private List<Message> messageList;
    private ChatAdapter adapter;
    private ListView chatListView;
    private Button sendButton;
    private EditText sendEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
        messageList = new ArrayList<>();
        initView();
        initData();
        adapter = new ChatAdapter(ChatActivity.this,R.layout.item_chat,messageList);
        chatListView.setAdapter(adapter);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = sendEditText.getText().toString();
                if (! content.equals("")){
                    Message message = new Message();
                    message.setType(Message.TYPE_SEND);
                    message.setContent(content);
                    messageList.add(message);
                    adapter.notifyDataSetChanged();
                    chatListView.setSelection(messageList.size());
                    sendEditText.setText("");
                }
            }
        });
    }

    private void initView() {
        chatListView = (ListView) findViewById(R.id.lv_chat);
        sendButton = (Button) findViewById(R.id.btn_send);
        sendEditText = (EditText) findViewById(R.id.et_message);
    }

    private void initData() {
        for (int i=0;i<20;i++){
            Message message1 = new Message();
            message1.setType(Message.TYPE_RECEIVE);
            message1.setContent("content receive content receivecontent receivecontent receivecontent receive" + i);
            messageList.add(message1);
            Message message2 = new Message();
            message2.setType(Message.TYPE_SEND);
            message2.setContent("content send ." +
                    "" + i);
            messageList.add(message2);
        }
    }


}
