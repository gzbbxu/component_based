package com.example.loginmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.base.RouterConstants;

@Route(path = RouterConstants.LOGIN_MODULE)
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

            }
        });
    }
}
