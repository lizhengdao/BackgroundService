package com.lzd.backgroundservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

import com.lzd.backgroundservice.MainActivity;
import com.lzd.backgroundservice.WindowUtils;

/**
 * Created by lzd on 2017/3/26.
 */

public class BackgroundService extends Service {

    private boolean isShow = false;
    Handler handler = null;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Log.i("--->", "BackgroundService --- onBind ---");
        return null;


    }

    @Override
    public void onCreate() {
        super.onCreate();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (WindowUtils.isShown) {
                    WindowUtils.hidePopupWindow();
                } else {
                    WindowUtils.showPopupWindow(getApplicationContext());
                }
                handler.sendEmptyMessageDelayed(1, 1000);
            }
        };
        handler.sendEmptyMessage(1);


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i("--->", "BackgroundService --- onStartCommand ---");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.i("--->", "BackgroundService --- onStart ---");
    }

}
