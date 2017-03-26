package com.lzd.backgroundservice;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lzd.backgroundservice.service.BackgroundService;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        Intent intent = new Intent();
        intent.setClass(this, BackgroundService.class);
//        startService(intent);

        bindService(intent, null, 0);

        mHandler = new Handler();
//        TextView button = (TextView) findViewById(R.id.text_view);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mHandler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        WindowUtils.showPopupWindow(MainActivity.this);
//                    }
//                }, 1000 * 3);
//            }
//        });
    }
}
