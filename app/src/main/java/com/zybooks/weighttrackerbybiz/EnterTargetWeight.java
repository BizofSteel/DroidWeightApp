package com.zybooks.weighttrackerbybiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class EnterTargetWeight extends AppCompatActivity {

    private ImageView homeLogo;
    private EditText newTargetWeight;
    private Button submitTargetWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_target_weight);

        homeLogo = findViewById(R.id.imageLogo);
        newTargetWeight = findViewById(R.id.editTargetWeight);
        submitTargetWeight = findViewById(R.id.buttonTargetSubmit);

        submitTargetWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newWeight = newTargetWeight.getText().toString();
                if (newTargetWeight.length() != 0){
                    SharedPreferences saveTWeight = getSharedPreferences("myPref", 0);
                    SharedPreferences.Editor editor = saveTWeight.edit();
                    editor.putString("Key_2", newWeight);
                    editor.apply();
                    toMainAct();
                }
                else{
                    toastMessage("You Must Enter Weight to Submit");
                }
            }
        });


        homeLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toMainAct();
            }
        });
    }

    public void toMainAct(){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}