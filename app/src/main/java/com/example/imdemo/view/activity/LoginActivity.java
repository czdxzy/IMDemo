package com.example.imdemo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.imdemo.R;

/**
 * Created by Administrator on 2015/9/25.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener{
    private Button mLoginButton;
    private EditText mLoginNumberEditText;
    private EditText mLoginPasswordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        mLoginButton.setOnClickListener(this);
}

    private void initView() {
        mLoginButton = (Button) findViewById(R.id.btn_login);
        mLoginNumberEditText = (EditText) findViewById(R.id.ed_login_number);
        mLoginPasswordEditText = (EditText) findViewById(R.id.ed_login_password);
    }

    @Override
    public void onClick(View v) {
        if (mLoginNumberEditText.getText().toString().equals("") || mLoginPasswordEditText.getText().toString().equals("")) {
            Toast.makeText(LoginActivity.this, "用户名或密码为空，请重新输入", Toast.LENGTH_SHORT).show();
        }else if(mLoginNumberEditText.getText().toString().equals("123456") && mLoginPasswordEditText.getText().toString().equals("123456")){
            Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
