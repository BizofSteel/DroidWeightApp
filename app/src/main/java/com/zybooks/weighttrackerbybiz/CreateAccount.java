package com.zybooks.weighttrackerbybiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {

    private EditText mCreateUserName;
    private EditText mCreatePassword;
    private EditText mConfirmPassword;
    private EditText mPhoneNumber;
    private TextView mTextCreate;
    private DataBaseAldana db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        db = new DataBaseAldana(this);
        mCreateUserName = (EditText) findViewById(R.id.createUserName);
        mCreatePassword = (EditText) findViewById(R.id.createUserPassword);
        mConfirmPassword = (EditText) findViewById(R.id.createConfPassword);
        mPhoneNumber = (EditText) findViewById(R.id.createCellNumber);
        mTextCreate = (TextView) findViewById(R.id.CreateLoginSubmitText);
        mTextCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mCreateUserName.getText().toString().trim();
                String password = mCreatePassword.getText().toString().trim();
                String confpassword = mConfirmPassword.getText().toString().trim();
                String cellnumber = mPhoneNumber.getText().toString().trim();

                if(password.equals(confpassword)){
                    long checkdb = db.addNewMember(user, password, cellnumber);
                    if(checkdb>0){
                        toastMessage("You Are Now Registered");
                        openLoginScreen();
                    }
                    else{
                        toastMessage("Registration Not Valid, PLease try again");
                    }

                }
                else{
                    toastMessage("Your Passwords Do Not Match");
                }
            }
        });
    }

    public void openLoginScreen(){
        Intent intent = new Intent (this, LoginScreen.class);
        startActivity(intent);
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}