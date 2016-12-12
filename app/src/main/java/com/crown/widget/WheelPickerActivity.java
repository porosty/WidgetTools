package com.crown.widget;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.crown.widget.ui.WheelPicker;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author AigeStudio 2015-12-06
 * @author AigeStudio 2016-07-08
 */
public class WheelPickerActivity extends Activity implements WheelPicker.OnItemSelectedListener {
    @InjectView(R.id.tv_id_type)
    TextView tvIdType;
    private TextView tv_choose_id;
    private List<String> list;
    private String idType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_preview);
        ButterKnife.inject(this);
        list = new ArrayList<>();
        list.add("身份证");
        list.add("军官证");
        list.add("护照");
        list.add("香港通行证");
        list.add("澳门通行证或旅行证");
        findViewById(R.id.tv_choose_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(list);
            }
        });

    }

    private void showDialog(List<String> list) {
        final Dialog dialog = new Dialog(this, R.style.dialog);
        dialog.setContentView(R.layout.ac_preview1);
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams params = dialogWindow.getAttributes();
        params.width = (getWindow().getWindowManager().getDefaultDisplay().getWidth());
        params.height = 500;
        params.gravity = Gravity.CENTER | Gravity.BOTTOM;
        dialogWindow.setAttributes(params);
        WheelPicker wheelLeft = (WheelPicker) dialog.findViewById(R.id.main_wheel_left);
        TextView tv_choose_id = (TextView) dialog.findViewById(R.id.tv_choose_id);
        wheelLeft.setData(list);
        wheelLeft.setIndicatorColor(Color.BLUE);
        wheelLeft.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                Toast.makeText(WheelPickerActivity.this, data + "----" + position, Toast.LENGTH_SHORT).show();
                idType = (String) data;
            }
        });
        tv_choose_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                tvIdType.setText(idType);
            }
        });
        dialog.show();
    }


    @Override
    public void onItemSelected(WheelPicker picker, Object data, int position) {
        String text = "";
        switch (picker.getId()) {
            case R.id.main_wheel_left:
                text = "Left:";
                break;
        }
        Toast.makeText(this, text + String.valueOf(data), Toast.LENGTH_SHORT).show();
    }
}