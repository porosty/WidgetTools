package com.crown.widget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @InjectView(R.id.tv_01)
    TextView tv01;
    @InjectView(R.id.tv_02)
    TextView tv02;
    @InjectView(R.id.tv_03)
    TextView tv03;
    @InjectView(R.id.tv_04)
    TextView tv04;
    @InjectView(R.id.tv_05)
    TextView tv05;
    @InjectView(R.id.tv_06)
    TextView tv06;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        tv01.setOnClickListener(this);
        tv02.setOnClickListener(this);
        tv03.setOnClickListener(this);
        tv04.setOnClickListener(this);
        tv05.setOnClickListener(this);
        tv06.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_01:
                startActivity(new Intent(this, AutoTextViewActivity.class));
                break;
            case R.id.tv_02:
                startActivity(new Intent(this, AnimationActivity.class));

                break;
            case R.id.tv_03:
                startActivity(new Intent(this, WheelPickerActivity.class));
                break;
            case R.id.tv_04:

                break;
            case R.id.tv_05:

                break;
            case R.id.tv_06:

                break;
        }
    }
}
