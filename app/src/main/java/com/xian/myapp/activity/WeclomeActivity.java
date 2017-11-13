package com.xian.myapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xian.myapp.R;
import com.xian.myapp.Utils.Utils;
import com.xian.myapp.adapter.ViewPagerAdapter;
import com.xian.myapp.base.BaseActivity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WeclomeActivity extends BaseActivity {


    @Bind(R.id.weclome_layout)
    ViewPager weclomeLayout;
    @Bind(R.id.points_layout)
    LinearLayout pointsLayout;
    @Bind(R.id.red_point)
    ImageView redPoint;
    @Bind(R.id.write_weclome)
    TextView writeWeclome;
    private ArrayList<ImageView> imageViews;
    private int dip;


    @Override
    protected void initData() {
        dip = Utils.px2dip(WeclomeActivity.this, 20);
//        with = Utils.px2dip(WeclomeActivity.this, 10);
        int weclomImagesID[] = {R.drawable.weclome_1, R.drawable.weclome_2, R.drawable.weclome_3, R.drawable.weclome_4};
        imageViews = new ArrayList<>();
        for (int ImagesID : weclomImagesID) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(ImagesID);
            imageViews.add(imageView);
        }
        // 动态得出圆点的个数，距离，并添加到线性布局中
        for (int i = 0; i < weclomImagesID.length; i++) {
            ImageView circleView = new ImageView(this);
            circleView.setBackgroundResource(R.drawable.enablefalse);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            if (i > 0) {
                params.leftMargin = dip;
            }
            circleView.setLayoutParams(params);
            pointsLayout.addView(circleView);//在添加到布局文件中是的时需要注意一点：要添加的父布局是什么布局，这里添加的就是什么布局。
        }


    }

    @Override
    protected void initView() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(imageViews);
        weclomeLayout.setAdapter(viewPagerAdapter);
        weclomeLayout.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                System.out.println("positionOffsetPixels:" + positionOffsetPixels + "positionOffset:" + positionOffset);
                int width = pointsLayout.getChildAt(0).getMeasuredWidth();
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)
                        redPoint.getLayoutParams();
                int leftMargin = (int) (position * (width + dip) + positionOffset * (width + dip));
                params.leftMargin = leftMargin;
                System.out.println("leftMargin:" + leftMargin);
                redPoint.setLayoutParams(params);
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 3) {
                    writeWeclome.setVisibility(View.VISIBLE);
                } else {
                    writeWeclome.setVisibility(View.GONE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_weclome;
    }


    @OnClick(R.id.write_weclome)
    public void onViewClicked() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
