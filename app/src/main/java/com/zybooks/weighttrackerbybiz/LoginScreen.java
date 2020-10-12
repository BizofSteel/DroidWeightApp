package com.zybooks.weighttrackerbybiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {

    private EditText mTextUserName;
    private EditText mTextPassword;
    private TextView mTextLogin;
    private TextView mForgotPassUser;
    private TextView mNewMember;
    private DataBaseAldana db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        db = new DataBaseAldana(this);
        mTextUserName = (EditText) findViewById(R.id.userSubmitText);
        mTextPassword = (EditText) findViewById(R.id.passwordSubmitText);
        mTextLogin = (TextView) findViewById(R.id.textLogin);
        mForgotPassUser = (TextView) findViewById(R.id.forgotpwText);
        mNewMember = (TextView) findViewById(R.id.signupText);

        mNewMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewMember();
            }
        });

        mTextLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUserName.getText().toString().trim();
                String password = mTextPassword.getText().toString().trim();
                Boolean result = db.checkLoginCreds(user, password);
                if(result == true){
                    grantMainAct();
                }
                else{
                    Toast.makeText(LoginScreen.this, "Login Credentials are Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openNewMember(){
        Intent intent = new Intent (this, CreateAccount.class);
        startActivity(intent);
    }

    public void grantMainAct(){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

}