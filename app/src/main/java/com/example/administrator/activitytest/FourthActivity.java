package com.example.administrator.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_layout);

        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Log.d("FourthActivity", "+++++++++++++++++" + data + "+++++++++++++++++++++++++");

        Button button = (Button)findViewById(R.id.button_fourth_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*finish方法返回上一级，同时返回数据给上一级调用(方法：setResult)
                * 方法：setResult接收两个参数(Ok或CANCELED， Intent)
                *
                * 如果没有按钮，而是点击的手机自带的back按钮，需要重写onBackPressed方法
                * */
                Intent intent1 = new Intent();
                intent1.putExtra("data_return", "Hello FirstActivity");
                setResult(RESULT_OK, intent1);
                finish();
            }
        });
    }

    /*如果点击手机自带的back返回上一级调用，同样可以回传数据到上一级*/
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello FirstActivity");
        setResult(RESULT_OK, intent);
        finish();
    }
}
