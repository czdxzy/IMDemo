package com.example.imdemo.view.activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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
    private ImageButton mWeixinButton;
    private ImageButton mContactButton;
    private ImageButton mDiscoverButton;
    private ImageButton mMineButton;
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
        mWeixinLinearLayout.setOnClickListener(this);
        mContactLinearLayout.setOnClickListener(this);
        mDiscoverLinearLayout.setOnClickListener(this);
        mMineLinearLayout.setOnClickListener(this);
    }

    private void initView() {
        mWeixinLinearLayout = (LinearLayout) findViewById(R.id.ll_weixin);
        mContactLinearLayout = (LinearLayout) findViewById(R.id.ll_contact);
        mDiscoverLinearLayout = (LinearLayout) findViewById(R.id.ll_discover);
        mMineLinearLayout = (LinearLayout) findViewById(R.id.ll_mine);
        mWeixinButton = (ImageButton) findViewById(R.id.btn_bottom_weixin);
        mContactButton = (ImageButton) findViewById(R.id.btn_bottom_contact);
        mDiscoverButton = (ImageButton) findViewById(R.id.btn_bottom_discover);
        mMineButton = (ImageButton) findViewById(R.id.btn_bottom_mine);
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
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resectButtonImage();
                int currentItem = mViewPager.getCurrentItem();
                switch (currentItem){
                    case 0:
                        mWeixinButton.setImageResource(R.drawable.weixin_check);
                        break;
                    case 1:
                        mContactButton.setImageResource(R.drawable.contact_check);
                        break;
                    case 2:
                        mDiscoverButton.setImageResource(R.drawable.discover_check);
                        break;
                    case 3:
                        mMineButton.setImageResource(R.drawable.mine_check);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }



    @Override
    public void onClick(View v) {
        resectButtonImage();
        switch (v.getId()){
            case R.id.ll_weixin:
                mViewPager.setCurrentItem(0);
                mWeixinButton.setImageResource(R.drawable.weixin_check);
                break;
            case R.id.ll_contact:
                mViewPager.setCurrentItem(1);
                mContactButton.setImageResource(R.drawable.contact_check);
                break;
            case R.id.ll_discover:
                mViewPager.setCurrentItem(2);
                mDiscoverButton.setImageResource(R.drawable.discover_check);
                break;
            case R.id.ll_mine:
                mViewPager.setCurrentItem(3);
                mMineButton.setImageResource(R.drawable.mine_check);
                break;
        }
    }

    private void resectButtonImage() {
        mWeixinButton.setImageResource(R.drawable.weixin_normal);
        mContactButton.setImageResource(R.drawable.contact_normal);
        mDiscoverButton.setImageResource(R.drawable.discover_normal);
        mMineButton.setImageResource(R.drawable.mine_normal);
    }
}
