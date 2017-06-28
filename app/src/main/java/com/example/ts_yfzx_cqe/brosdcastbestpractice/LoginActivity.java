package com.example.ts_yfzx_cqe.brosdcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ts_yfzx_cqe.collector.BasicActivity;

/**
 * Created by TS-YFZX-CQE on 2017/6/28.
 */

public class LoginActivity extends BasicActivity {

    private EditText account_ed;
    private EditText password_ed;
    private Button login_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initEvent();
    }

    /** 初始化控件 **/
    private void initView() {
        account_ed = (EditText)findViewById(R.id.account_input);
        password_ed = (EditText)findViewById(R.id.password_input);
        login_bt = (Button)findViewById(R.id.login);
    }

    /** 注册交互事件 **/
    private void initEvent() {
        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = account_ed.getText().toString().trim();
                String password = password_ed.getText().toString().trim();
                //判断账号是否为admin，密码是否为12345，是则登陆成功
                if (account.equals("admin") && password.equals("12345")){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,"account or password is invalid",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
