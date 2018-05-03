package com.example.loginmodule;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.base.RouterConstants;
import com.example.base.provider.ILoginProvider;

@Route(path = ILoginProvider.LOGIN_MAIN_ACTIVITY)
public class LoginActivity extends AppCompatActivity {
    private EditText et_user, et_pwd;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_user = findViewById(R.id.et_user);
        et_pwd = findViewById(R.id.et_pwd);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String etuser = et_user.getText().toString();
                String etpwd = et_pwd.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("name",etuser);
                intent.putExtra("pwd",etpwd);
                setResult(Activity.RESULT_OK, intent);
                finish();

            }
        });
    }
}
