package com.crown.widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.crown.widget.ui.AutofitTextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AnimationActivity extends AppCompatActivity {
    //移动属性
    private TranslateAnimation ta;
    private TranslateAnimation ta1;
    private ImageView v;
    private TextView tv_dot1;
    private TextView tv_dot2;
    private TextView tv_dot3;
    private AlphaAnimation sa;
    private AlphaAnimation sa1;
    private AlphaAnimation sa2;
    private AutofitTextView tv_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        v = (ImageView) findViewById(R.id.iv_animation);
        tv_dot1 = (TextView) findViewById(R.id.tv_dot1);
        tv_dot2 = (TextView) findViewById(R.id.tv_dot2);
        tv_dot3 = (TextView) findViewById(R.id.tv_dot3);
        //实例化移动对象
        //相对于自身向右移动200，向下移动200
        ta = new TranslateAnimation(0, 0, 0, 200);
        ta1 = new TranslateAnimation(0, 0, 200, 0);
        sa = new AlphaAnimation(0f, 1f);
        sa1 = new AlphaAnimation(0f, 1f);
        sa2 = new AlphaAnimation(0f, 1f);
        //持续时间，不设置值无效果
        ta.setDuration(1000);
        ta1.setDuration(1000);
        sa.setDuration(400);
        sa.setRepeatCount(Animation.INFINITE);
        sa1.setDuration(400);
        sa1.setRepeatCount(Animation.INFINITE);
        sa1.setStartOffset(400);
        sa2.setDuration(400);
        sa2.setRepeatCount(Animation.INFINITE);
        sa2.setStartOffset(800);
        tv_dot1.startAnimation(sa);
        tv_dot2.startAnimation(sa1);
        tv_dot3.startAnimation(sa2);
        startAnimation();

        ta.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                v.startAnimation(ta1);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        ta1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void startAnimation() {
        v.startAnimation(ta);
    }

}
