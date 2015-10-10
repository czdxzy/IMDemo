package com.example.imdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.imdemo.R;
import com.example.imdemo.model.ItemWeixin;
import com.example.imdemo.model.Message;

import java.util.List;

/**
 * Created by Administrator on 2015/9/30.
 */
public class ChatAdapter extends ArrayAdapter<Message>{
    private Context mContent;
    int mItemChatId;
    private List<Message> mMessageList;
    public ChatAdapter(Context context, int itemChatId, List<Message> messageList) {
        super(context,itemChatId,messageList);
        mItemChatId = itemChatId;
        mContent = context;
        mMessageList = messageList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = getItem(position);
        View view ;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(mContent).inflate(mItemChatId, null);
            viewHolder = new ViewHolder();
            viewHolder.receiveMessageLayout = (LinearLayout) view.findViewById(R.id.ll_receive_message);
            viewHolder.sendMessageLayout = (LinearLayout) view.findViewById(R.id.ll_send_message);
            viewHolder.receiveMessageTextView = (TextView) view.findViewById(R.id.tv_receive_message);
            viewHolder.sendMessageTextView = (TextView) view.findViewById(R.id.tv_send_message);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        if (message.getType() == Message.TYPE_RECEIVE){
            viewHolder.receiveMessageLayout.setVisibility(View.VISIBLE);
            viewHolder.sendMessageLayout.setVisibility(View.GONE);
            viewHolder.receiveMessageTextView.setText(message.getContent());
        }else if (message.getType() == Message.TYPE_SEND){
            viewHolder.sendMessageLayout.setVisibility(View.VISIBLE);
            viewHolder.receiveMessageLayout.setVisibility(View.GONE);
            viewHolder.sendMessageTextView.setText(message.getContent());
        }
        return view;
    }
    class ViewHolder{
        LinearLayout receiveMessageLayout;
        LinearLayout sendMessageLayout;
        TextView sendMessageTextView;
        TextView receiveMessageTextView;
    }
}
