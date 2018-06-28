package com.example.administrator.myapplication;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private AlertDialog.Builder builder;
    Dialog dialog;
    ProgressDialog Pdialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnWait=findViewById(R.id.btnWait);
        btnWait.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Pdialog = ProgressDialog.show(MainActivity.this, "製作中…", "請等待三年…", true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            Pdialog.dismiss();
                        }
                    }
                }).start();
            }
        });
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }

            private void Login() {
                LayoutInflater factory = LayoutInflater.from( MainActivity.this);
                final View v1=factory.inflate(R.layout.Login,null);
                builder = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Login")
                        .setView(v1)
                        .setPositiveButton("登入", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.create();
                dialog.show();
            }
        });
    }
}
