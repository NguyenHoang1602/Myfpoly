package com.example.asm_nguyenhnpk02250.Account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.asm_nguyenhnpk02250.R;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterScreen extends AppCompatActivity {

    private TextInputEditText txt_name, txt_email, txt_contactnum, txt_password, txt_confirmpass;
    private Button btn_register;
    TextView tv_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        init();
        backlogin();
    }

    public void backlogin(){
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterScreen.this, LoginScreen.class));
                finish();
            }
        });
    }
    public void init(){
        txt_name = findViewById(R.id.txt_username);
        txt_email = findViewById(R.id.txt_email);
        txt_contactnum = findViewById(R.id.txt_number);
        txt_password = findViewById(R.id.txt_password);
        txt_confirmpass = findViewById(R.id.txt_confirm);
        btn_register = findViewById(R.id.btn_register);
        tv_login = findViewById(R.id.tv_login);

    }
}