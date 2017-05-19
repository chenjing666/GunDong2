package com.biaoke.gundong;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private String[] items = {"测试1", "测试2", "测试3", "测试4", "测试5"};

    private ScrollTextView verticalScrollTV;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        editText = (EditText) findViewById(R.id.et);
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(listen);

        verticalScrollTV = (ScrollTextView) findViewById(R.id.avst);
        //设置轮播数据
        verticalScrollTV.setItems(items);
        //开启轮播
        verticalScrollTV.startScroll(2000);

    }

    private View.OnClickListener listen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String msg = editText.getText().toString();
            items = new String[]{msg};
            verticalScrollTV.setItems(items);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
