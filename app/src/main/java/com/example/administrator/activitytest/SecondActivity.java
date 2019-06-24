package com.example.administrator.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        Button button = (Button)findViewById(R.id.button_second_1);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /*finish方法销毁此活动，相当于手机本身的Back返回按钮*/
                finish();
            }
        });
    }
}
