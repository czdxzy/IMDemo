package com.example.imdemo.view.fragment;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.imdemo.model.ItemWeixin;
import com.example.imdemo.R;
import com.example.imdemo.adapter.WeixinAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/9/30.
 */
public class WeixinFragment extends ListFragment {
    private List<ItemWeixin> weixinList=new ArrayList<>();
    private WeixinAdapter adapter =null;
    private ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_weixin,container,false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWeixin();
        adapter = new WeixinAdapter(getActivity(),R.layout.item_weixin,weixinList);
        setListAdapter(adapter);
    }

    private void initWeixin() {
        for (int i = 0; i<20 ; i++){
            ItemWeixin weixin = new ItemWeixin();
            weixin.setContent("content"+i);
            weixin.setTitle("title" + i);
            weixin.setFace(BitmapFactory.decodeResource(this.getResources(), R.drawable.a));
            weixinList.add(weixin);
        }
    }
}
