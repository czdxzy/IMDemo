package com.example.imdemo.view.activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.imdemo.view.fragment.ContactFragment;
import com.example.imdemo.view.fragment.DiscoverFragment;
import com.example.imdemo.view.fragment.MineFragment;
import com.example.imdemo.R;
import com.example.imdemo.view.fragment.WeixinFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private LinearLayout mWeixinLinearLayout;
    private LinearLayout mContactLinearLayout;
    private LinearLayout mDiscoverLinearLayout;
    private LinearLayout mMineLinearLayout;
    private TextView mWeixinTextView;
    private TextView mContactTextView;
    private TextView mDiscoverTextView;
    private TextView mMineTextView;
    private Button mWeixinButton;
    private Button mContactButton;
    private Button mDiscoverButton;
    private Button mMineButton;
    private ViewPager mViewPager;
    private List<Fragment> mFragments;
    private FragmentPagerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initEvent() {

    }

    private void initView() {
        mWeixinLinearLayout = (LinearLayout) findViewById(R.id.ll_weixin);
        mContactLinearLayout = (LinearLayout) findViewById(R.id.ll_contact);
        mDiscoverLinearLayout = (LinearLayout) findViewById(R.id.ll_discover);
        mMineLinearLayout = (LinearLayout) findViewById(R.id.ll_mine);
        mWeixinButton = (Button) findViewById(R.id.btn_bottom_weixin);
        mContactButton = (Button) findViewById(R.id.btn_bottom_contact);
        mDiscoverButton = (Button) findViewById(R.id.btn_bottom_discover);
        mMineButton = (Button) findViewById(R.id.btn_bottom_mine);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mFragments = new ArrayList<>();
        WeixinFragment weixinFragment = new WeixinFragment();
        ContactFragment contactFragment = new ContactFragment();
        DiscoverFragment discoverFragment = new DiscoverFragment();
        MineFragment mineFragment = new MineFragment();
        mFragments.add(weixinFragment);
        mFragments.add(contactFragment);
        mFragments.add(discoverFragment);
        mFragments.add(mineFragment);
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };
        mViewPager.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View v) {
        mWeixinLinearLayout.setOnClickListener(this);
        mContactLinearLayout.setOnClickListener(this);
        mDiscoverLinearLayout.setOnClickListener(this);
        mMineLinearLayout.setOnClickListener(this);
    }
}
