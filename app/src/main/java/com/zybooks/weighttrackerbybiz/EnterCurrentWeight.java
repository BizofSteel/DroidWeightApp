package com.zybooks.weighttrackerbybiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EnterCurrentWeight extends AppCompatActivity {

    DataBaseWeight mDatabaseWeight;
    private TextView cDateText;
    private String myDate_Str;
    private EditText newCurrentWeight;
    private Button submitCurrentWeight;
    private ImageView homeLogo;
    private String tWeightText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_current_weight);

        myDate_Str = new SimpleDateFormat("MMM.dd.yyyy ' / ' HH:mm:ss z", Locale.getDefault()).format(new Date());
        cDateText = findViewById(R.id.textCurrentDate);
        cDateText.setText(myDate_Str);

        SharedPreferences settWeight = getSharedPreferences("myPref",0);
        if(settWeight.contains("Key_2")){
            tWeightText = settWeight.getString("Key_2",null);
        } else {
            tWeightText = "Boo";
        }

        homeLogo = findViewById(R.id.imageLogo);
        newCurrentWeight = findViewById(R.id.editCurrentWeight);
        submitCurrentWeight = findViewById(R.id.buttonCurrentSubmit);
        mDatabaseWeight = new DataBaseWeight(this);




        submitCurrentWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newcWeight = newCurrentWeight.getText().toString();
                if (newCurrentWeight.length() != 0){
                    SharedPreferences saveCWeight = getSharedPreferences("myPref", 0);
                    SharedPreferences.Editor editor = saveCWeight.edit();
                    editor.putString("Key_1", newcWeight);
                    editor.apply();
                    AddWeight(tWeightText, newcWeight, myDate_Str);
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

    public void AddWeight(String ntWeight, String ncWeight, String nDate){
        boolean insertWeight = mDatabaseWeight.addData(ntWeight, ncWeight, nDate);
        if (insertWeight) {
            toastMessage("New Weight Entered Successfully!");
        }
        else {
            toastMessage("Something Went Wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void toMainAct(){
        Intent intent = new Intent (this, MainActivity.class);

        startActivity(intent);
    }

}
