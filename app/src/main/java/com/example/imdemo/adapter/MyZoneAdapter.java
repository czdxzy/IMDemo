package com.example.imdemo.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.imdemo.R;
import com.example.imdemo.model.Comment;
import com.example.imdemo.model.ItemState;
import com.example.imdemo.model.ItemWeixin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/9/30.
 */
public class MyZoneAdapter extends ArrayAdapter<ItemState>{
    private String myName;
    private Context mContent;
    int mItemStateId;
    private ListView mListView;
    private List<ItemState> mItemStateList;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String discuss = (String) msg.obj;
            int position = msg.what;
            Comment comment = new Comment();
            comment.setName("landscape");
            comment.setContent(discuss);
            updateView(position,comment);

        }
    };
    public void setListView(ListView listView){
        this.mListView = listView;
    }
    public MyZoneAdapter(Context context, int itemStateId, List<ItemState> itemStateList) {
        super(context, itemStateId, itemStateList);
        mItemStateId = itemStateId;
        mContent = context;
        mItemStateList = itemStateList;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ItemState itemState = getItem(position);
        View view ;
        final ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(mContent).inflate(mItemStateId, null);
            viewHolder = new ViewHolder();
            //viewHolder.faceImageView = (ImageView) view.findViewById(R.id.state_message_face);
            viewHolder.nameTextView = (TextView) view.findViewById(R.id.tv_state_name);
            viewHolder.timeTextView = (TextView) view.findViewById(R.id.tv_state_time);
            viewHolder.stateTextView = (TextView) view.findViewById(R.id.tv_state_content);
            viewHolder.discussTextView = (TextView) view.findViewById(R.id.tv_state_discuss);
            viewHolder.commentEditText = (EditText) view.findViewById(R.id.et_comment);
            viewHolder.sendCommentButton = (Button) view.findViewById(R.id.btn_send_comment);
            viewHolder.sendCommentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!viewHolder.commentEditText.getText().toString().equals("")){
                        Message message = new Message();
                        message.what = position;
                        message.obj = viewHolder.commentEditText.getText().toString();
                        handler.handleMessage(message);
                    }
                }
            });
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        //viewHolder.faceImageView.setImageBitmap(itemState.getFace());
        viewHolder.nameTextView.setText(itemState.getName());
        viewHolder.timeTextView.setText(itemState.getTime());
        viewHolder.stateTextView.setText(itemState.getState());
        viewHolder.discussTextView.setText(itemState.getComments());
        return view;
    }
    class ViewHolder{
        //ImageView faceImageView;
        public Button sendCommentButton;
        public TextView nameTextView;
        public TextView timeTextView;
        public TextView stateTextView;
        public TextView discussTextView;
        public EditText commentEditText;
    }
    private void updateView(int position,Comment comment){
        int visiblePosition = mListView.getFirstVisiblePosition();
        if (position-visiblePosition < 0)
            return;
        View view = mListView.getChildAt(position-visiblePosition);
        ViewHolder viewholder = (ViewHolder) view.getTag();
        String beforeUpdateDiscuss = viewholder.discussTextView.getText().toString();
        List<Comment> commentList = mItemStateList.get(position).getCommentList();
        viewholder.discussTextView.setText(beforeUpdateDiscuss+comment.toString()+"\n");
        viewholder.commentEditText.setText("");
        commentList.add(comment);
        mItemStateList.get(position).setCommentList(commentList);
    }
}
