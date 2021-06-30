package com.ranzan.intentsandintentfilterswe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText username;
    private EditText password;
    private Button btn;
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initValues();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isValidEmail=isValidEmail();
                boolean isValidPassword=isValidPassword();
                boolean isValidUserName=isValidUserName();
                if(isValidEmail && isValidPassword && isValidUserName){
                    Intent intent=new Intent(MainActivity.this,secondPage.class);
                    intent.putExtra("username",username.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }

    private void initValues() {
        email = findViewById(R.id.tvemail);
        username = findViewById(R.id.tvusername);
        password = findViewById(R.id.tvpassword);
        btn = findViewById(R.id.btnLogin);
    }
    private boolean isValidEmail(){
        if(email.getText().toString().matches(emailValidation)){
            return true;
        }
        else{
            email.setError("INVALID");
            return false;
        }
    }
    private boolean isValidPassword(){
        if(password.getText().toString().length()>=6){
            return true;
        }
        else{
            password.setError("Password should have 6 character");
            return false;
        }
    }
    private boolean isValidUserName(){
        if(username.getText().toString().trim().length()>4){
            return true;
        }
        else{
            username.setError("Invalid UserName");
            return false;
        }
    }
}