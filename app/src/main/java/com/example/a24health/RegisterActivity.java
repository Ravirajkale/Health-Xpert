package com.example.a24health;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edUsername,edPassword,edEmail,edConfirm;
    Button btn;
    TextView tv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        edUsername = findViewById(R.id.editTextLTBFullName);
        edPassword =findViewById(R.id.editTextLTBPinccode);
        edEmail = findViewById(R.id.editTextLTBAddress);
        edConfirm=findViewById(R.id.editTextLTBContactNumber);
        btn = findViewById(R.id.buttonCLBack);
        tv = findViewById(R.id.textViewExistingUser);

        //for going back to login page
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        //for Register button conditions and actions
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                String email = edEmail.getText().toString();
                String confirm = edConfirm.getText().toString();
                Database db = new Database(getApplicationContext(),"healthcare",null,1);
                if (username.length()==0 || password.length()==0){
                    Toast.makeText(getApplicationContext(),"Please fill all Details",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password.compareTo(confirm) == 0) {
                       if (isValid(password)){
                           db.register(username,email,password);

                           Toast.makeText(getApplicationContext(), "Register Succesful", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(RegisterActivity.this,HomeActivity.class));
                       }else {
                           Toast.makeText(getApplicationContext(),"password must contain 8 character,having letter,digit,special character",Toast.LENGTH_SHORT).show();
                       }


                    } else {
                        Toast.makeText(getApplicationContext(),"Password and Confirm password didn't match",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    //for Valid password
    public static  boolean isValid(String passwordhere){
        int f1=0,f2=0,f3=0;
        if (passwordhere.length()<8){
            return  false;
        }else {
            for (int p=0;p<passwordhere.length();p++){
                if (Character.isLetter(passwordhere.charAt(p))){
                    f1=1;
                }
            }
            for (int r=0;r<passwordhere.length();r++){
                if (Character.isDigit(passwordhere.charAt(r))){
                    f2=1;
                }
            }
            for (int s=0;s<passwordhere.length();s++){
                char c=passwordhere.charAt(s);
                if (c>=33&&c<=46||c==64){
                    f3=1;
                }
            }
            if (f1==1 && f2==1 && f3==1)
                return true;
            return false;
        }
    }
}