package com.example.dailyhunt_clone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;

public class ActivityProfile extends AppCompatActivity {
    ProgressDialog progressDialog;
    MaterialRippleLayout btn_logout;
    MyApplication myApplication;

    View lyt_sign_in, lyt_sign_out;
    TextView txt_login;
    TextView txt_register, txt_username, txt_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        findViewById(R.id.btn_about).setOnClickListener(view ->
                aboutDialog());

        findViewById(R.id.btn_logout).setOnClickListener(view -> logoutDialog());

    }

    public void logoutDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityProfile.this);
        builder.setTitle(R.string.logout_title);
        builder.setMessage(R.string.logout_message);
        builder.setPositiveButton(R.string.dialog_yes, (di, i) -> {

            progressDialog = new ProgressDialog(ActivityProfile.this);
            progressDialog.setTitle(getResources().getString(R.string.title_please_wait));
            progressDialog.setMessage(getResources().getString(R.string.logout_process));
            progressDialog.setCancelable(false);
            progressDialog.show();

            MyApplication.getInstance().saveIsLogin(false);

            new Handler().postDelayed(() -> {
                progressDialog.dismiss();
                AlertDialog.Builder builder1 = new AlertDialog.Builder(ActivityProfile.this);
                builder1.setMessage(R.string.logout_success);
                builder1.setPositiveButton(R.string.dialog_ok, (dialogInterface, i1) -> finish());
                builder1.setCancelable(false);
                builder1.show();
            }, Constant.DELAY_PROGRESS_DIALOG);

        });
        builder.setNegativeButton(R.string.dialog_cancel, null);
        builder.show();

    }

    public void aboutDialog() {
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(ActivityProfile.this);
        View view = layoutInflaterAndroid.inflate(R.layout.custom_dialog_about, null);
        final AlertDialog.Builder alert = new AlertDialog.Builder(ActivityProfile.this);
        alert.setView(view);
        alert.setCancelable(false);
        alert.setPositiveButton(R.string.dialog_ok, (dialog, which) -> dialog.dismiss());
        alert.show();
    }

}