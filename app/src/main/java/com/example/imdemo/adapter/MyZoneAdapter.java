package com.example.imdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imdemo.R;
import com.example.imdemo.model.ItemState;
import com.example.imdemo.model.ItemWeixin;

import java.util.List;

/**
 * Created by Administrator on 2015/9/30.
 */
public class MyZoneAdapter extends ArrayAdapter<ItemState>{
    private Context mContent;
    int mItemStateId;
    private List<ItemState> mItemStateList;
    public MyZoneAdapter(Context context, int itemStateId, List<ItemState> itemStateList) {
        super(context,itemStateId,itemStateList);
        mItemStateId = itemStateId;
        mContent = context;
        mItemStateList = itemStateList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemState itemState = getItem(position);
        View view ;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(mContent).inflate(mItemStateId, null);
            viewHolder = new ViewHolder();
            viewHolder.weixinImgae = (ImageView) view.findViewById(R.id.iv_item_weixin_face);
            viewHolder.weixinTitle = (TextView) view.findViewById(R.id.tv_item_weixin_title);
            viewHolder.weixinContent = (TextView) view.findViewById(R.id.tv_item_weixin_content);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.weixinImgae.setImageBitmap(itemWeixin.getFace());
        viewHolder.weixinTitle.setText(itemWeixin.getTitle());
        viewHolder.weixinContent.setText(itemWeixin.getContent());
        return view;
    }
    class ViewHolder{
        ImageView face;
        TextView weixinTitle;
        TextView weixinContent;
    }
}
