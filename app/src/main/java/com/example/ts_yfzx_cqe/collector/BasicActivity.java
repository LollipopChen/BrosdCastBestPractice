package com.example.ts_yfzx_cqe.collector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.example.ts_yfzx_cqe.brosdcastbestpractice.LoginActivity;

/**
 * 所有活动的父类
 * Created by TS-YFZX-CQE on 2017/6/28.
 */

public class BasicActivity extends AppCompatActivity {

    private ForceOffLineReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    @Override
    protected void onResume() {//在用户跟手机进行交互的时候注册广播
        super.onResume();
        //动态注册广播接收器
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.FORCE_OFF_LINE");
        receiver = new ForceOffLineReceiver();
        registerReceiver(receiver,intentFilter);
    }

    @Override
    protected void onPause() {  //在系统准备启动或者恢复另一个活动的时候调用此方法，将广播销毁
        super.onPause();
        //动态注册的广播需要销毁
        if (receiver != null){
            unregisterReceiver(receiver);
        }
    }

    //关闭接收器
    class ForceOffLineReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(final Context context, Intent intent) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
            alertDialog.setTitle("Warning");
            alertDialog.setMessage("You are forced to be offline . Please try to login again");
            alertDialog.setCancelable(false);
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finishAll();//销毁所有的活动
                    Intent intent = new Intent(context, LoginActivity.class);
                    context.startActivity(intent);//重新启动LoginActivity
                }
            });
            alertDialog.show();
        }
    }
}
