package com.crown.widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.crown.widget.ui.AutofitTextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AutoTextViewActivity extends AppCompatActivity {

    @InjectView(R.id.tv_01)
    EditText tv01;
    @InjectView(R.id.tv_auto_text)
    AutofitTextView tvAutoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_textview);
        ButterKnife.inject(this);
        tv01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tvAutoText.setText(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
