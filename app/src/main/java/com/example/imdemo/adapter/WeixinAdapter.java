package com.example.imdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imdemo.model.ItemWeixin;
import com.example.imdemo.R;

import java.util.List;

/**
 * Created by Administrator on 2015/9/30.
 */
public class WeixinAdapter extends ArrayAdapter<ItemWeixin>{
    private Context mContent;
    int mItemWeixinId;
    private List<ItemWeixin> mWeixinList;
    public WeixinAdapter(Context context,int itemWeixinId, List<ItemWeixin> weixinList) {
        super(context,itemWeixinId,weixinList);
        mItemWeixinId = itemWeixinId;
        mContent = context;
        mWeixinList = weixinList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemWeixin itemWeixin = getItem(position);
        View view ;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(mContent).inflate(mItemWeixinId, null);
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
        ImageView weixinImgae;
        TextView weixinTitle;
        TextView weixinContent;
    }
}
