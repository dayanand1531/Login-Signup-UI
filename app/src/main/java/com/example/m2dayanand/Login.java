package com.example.m2dayanand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
EditText userid,password;
TextView usernameerrorlogin,passworderror,signup;
Button login;
CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userid=findViewById(R.id.etuserid);
        password=findViewById(R.id.etpassword);
        usernameerrorlogin=findViewById(R.id.tvuseriderror);
        passworderror=findViewById(R.id.tvpassworderror);
        signup=findViewById(R.id.tvsignup);
        login=findViewById(R.id.btnlogin);
        checkBox=findViewById(R.id.cbremember);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window w = getWindow(); // in Activity's onCreate() for instance
//            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        }
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Remamber",Toast.LENGTH_LONG).show();
                }
            }
        });
        userid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String usernameid =userid.getText().toString().trim();
                if (userid.getText().toString().isEmpty()){
                    usernameerrorlogin.setVisibility(View.VISIBLE);
                    usernameerrorlogin.setText("*Please enter username.");

                }else if(usernameid.matches("^[6-9]\\d{9}$")){
                    usernameerrorlogin.setVisibility(View.INVISIBLE);
                  //  usernameerrorlogin.setText("*Please enter username.");
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(usernameid).matches()){
                    usernameerrorlogin.setVisibility(View.VISIBLE);
                    usernameerrorlogin.setText("*Please enter username");
                }

                else {
                    usernameerrorlogin.setVisibility(View.INVISIBLE);
                    usernameerrorlogin.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (password.getText().toString().isEmpty()){
                    passworderror.setVisibility(View.VISIBLE);
                    passworderror.setText("*Please enter password.");

                }


                else {
                    passworderror.setVisibility(View.INVISIBLE);
                    passworderror.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!vadillogin()){
                    Intent intent = new Intent(Login.this, task.class);
                    startActivity(intent);

                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Signup.class);
                startActivity(intent);

            }
        });

    }

    public  boolean vadillogin(){
        if (userid.getText().toString().isEmpty()){
            usernameerrorlogin.setVisibility(View.VISIBLE);
            usernameerrorlogin.setText("*Please enter username.");
            userid.requestFocus();
            return true;
        }
       else if (password.getText().toString().isEmpty()){
            passworderror.setVisibility(View.VISIBLE);
            passworderror.setText("*Please enter password.");
            password.requestFocus();
            return true;
        }

return false;

    }
}
