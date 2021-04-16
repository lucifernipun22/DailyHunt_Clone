package com.example.dailyhunt_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityUserRegister extends AppCompatActivity {

    private Button btnLogin;
    private Intent intent;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        btnRegister = findViewById(R.id.btn_update);
        btnLogin = findViewById(R.id.btn_login2);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ActivityUserRegister.this, ActivityUserLogin.class);
                startActivity(intent);

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ActivityUserRegister.this, HomeActivity.class);
                startActivity(intent);

            }
        });
    }
}