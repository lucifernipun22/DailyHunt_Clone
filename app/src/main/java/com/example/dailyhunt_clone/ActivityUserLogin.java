package com.example.dailyhunt_clone;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityUserLogin extends AppCompatActivity {
    private Button btnLogin;
    private Intent intent;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        btnLogin = findViewById(R.id.btn_update1);
        btnRegister = findViewById(R.id.btn_create);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ActivityUserLogin.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ActivityUserLogin.this, ActivityUserRegister.class);
                startActivity(intent);

            }
        });
    }
}