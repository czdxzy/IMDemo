package com.example.imdemo;

import android.app.Application;
import android.util.Log;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.im.v2.AVIMClient;
import com.avos.avoscloud.im.v2.AVIMConversation;
import com.avos.avoscloud.im.v2.AVIMException;
import com.avos.avoscloud.im.v2.AVIMMessage;
import com.avos.avoscloud.im.v2.AVIMMessageHandler;
import com.avos.avoscloud.im.v2.AVIMMessageManager;
import com.avos.avoscloud.im.v2.callback.AVIMClientCallback;
import com.avos.avoscloud.im.v2.messages.AVIMTextMessage;

/**
 * Created by Administrator on 2015/9/25.
 */
public class MyApplication extends Application{
    public static class CustomMessageHandler extends AVIMMessageHandler {
        //接收到消息后的处理逻辑
        @Override
        public void onMessage(AVIMMessage message,AVIMConversation conversation,AVIMClient client){
            if(message instanceof AVIMTextMessage){
                Log.d("MainActivity", ((AVIMTextMessage) message).getText());
            }
        }

        public void onMessageReceipt(AVIMMessage message,AVIMConversation conversation,AVIMClient client){

        }
    }
    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.initialize(this, "UURdslFKYnEkTt3OaMuqHXBD", "rlPfO5kggipXQvYNj4yA9VV8");
        AVIMMessageManager.registerDefaultMessageHandler(new CustomMessageHandler());
        jerryReceiveMsgFromTom();
    }
    public void jerryReceiveMsgFromTom(){
        //Jerry登录
        AVIMClient jerry = AVIMClient.getInstance("Jerry");
        jerry.open(new AVIMClientCallback() {

            @Override
            public void done(AVIMClient client, AVIMException e) {
                if (e == null) {
                    //登录成功后的逻辑
                }
            }
        });
    }
}

