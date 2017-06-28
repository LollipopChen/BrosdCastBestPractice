package com.example.ts_yfzx_cqe.brosdcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;

import com.example.ts_yfzx_cqe.collector.BasicActivity;

public class MainActivity extends BasicActivity {

    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = (Button)findViewById(R.id.force_offline);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.FORCE_OFF_LINE");
                sendBroadcast(intent);
            }
        });
    }
}
