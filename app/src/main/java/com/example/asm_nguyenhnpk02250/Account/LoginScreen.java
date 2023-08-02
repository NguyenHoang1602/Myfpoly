package com.example.asm_nguyenhnpk02250.Account;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asm_nguyenhnpk02250.MainActivity;
import com.example.asm_nguyenhnpk02250.Model.Product;
import com.example.asm_nguyenhnpk02250.Model.User;
import com.example.asm_nguyenhnpk02250.R;
import com.example.asm_nguyenhnpk02250.services.APIService;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginScreen extends AppCompatActivity {

    private TextInputEditText txt_username, txt_password;
    private TextView tv_Register;
    private Button btn_login;
    private ProgressDialog progressDialog;
    String Email , Pass;
    ArrayList<User> list;
    private User muser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        getdata();
        register();
        login();

    }
    private void getdata() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.base_link)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<ArrayList<User>> response = service.getUser();
        response.enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                list = response.body();
                Toast.makeText(LoginScreen.this, "" + list.size(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                Toast.makeText(LoginScreen.this, "Call API fail !", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public Boolean validateUsername(){
        String val = txt_username.getText().toString().trim();
        if (val.isEmpty()){
            txt_username.setError("Email không được để trống !");
            return false;
        } else {
            txt_username.setError(null);
            return true;
        }
    }

    public Boolean validatePassword(){
        String val = txt_password.getText().toString().trim();
        if (val.isEmpty()){
            txt_password.setError("Mật khẩu không được để trống !");
            return false;
        } else {
            txt_password.setError(null);
            return true;
        }
    }
    public void register(){
        tv_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginScreen.this, RegisterScreen.class));
            }
        });
    }
    public void login(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateUsername() | !validatePassword()){

                } else {
                    checkUser();
                }
            }
        });

    }
    private void checkUser(){
        progressDialog.setMessage("Đang đăng nhập...");
        progressDialog.setTitle("Đang đăng nhập");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        Email = txt_username.getText().toString().trim();
        Pass = txt_password.getText().toString().trim();
        if(list == null || list.isEmpty()){
            return;
        }
        boolean isHasUser = false;
        for(User user : list){
            if(Email.equals(user.getEmail()) && Pass.equals(user.getPass())){
                isHasUser = true;
                muser = user;
                break;
            }
        }
        if (isHasUser){
            Intent intent = new Intent(LoginScreen.this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("Object_User",muser);
            intent.putExtras(bundle);
            startActivity(intent);
            Toast.makeText(LoginScreen.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            finish();

        }else {
            progressDialog.dismiss();
            Toast.makeText(LoginScreen.this, "Email hoac mat khau khong dung !", Toast.LENGTH_SHORT).show();
        }

    }
    public void init(){
        txt_username = findViewById(R.id.txt_username);
        txt_password = findViewById(R.id.txt_password);
        btn_login = findViewById(R.id.btn_login);
        tv_Register = findViewById(R.id.tv_register);
        progressDialog = new ProgressDialog(this);
    }
}