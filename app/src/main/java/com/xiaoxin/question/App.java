package com.xiaoxin.question;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 2016/8/30.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //第一：默认初始化
        Bmob.initialize(this, "3b716f5d273795a568f2fd789dfbadef");
    }
}
