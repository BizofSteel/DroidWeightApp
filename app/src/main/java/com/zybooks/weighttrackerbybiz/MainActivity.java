package com.zybooks.weighttrackerbybiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Set Local Variables
    private Button eTargetButton;
    private Button cWeightButton;
    private TextView tHistory;
    private TextView cWeight;
    private TextView tWeight;
    private String cWeightText;
    private String tWeightText;
    DataBaseWeight Weightdb;
    private StringBuilder weightHistory;
    private Cursor data;
    private TextView mScrollText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tie Local Variables to Activity XML
        eTargetButton = (Button) findViewById(R.id.buttonTarget);
        cWeightButton = (Button) findViewById(R.id.buttonCurrent);
        tHistory = (TextView) findViewById(R.id.textHistory);
        cWeight = (TextView) findViewById(R.id.weightDis1);
        tWeight = (TextView) findViewById(R.id.weightDis2);
        mScrollText = (TextView) findViewById(R.id.mainScrollText);

        //Set Current Weight Display
        SharedPreferences setCWeight = getSharedPreferences("myPref",0);
        if(setCWeight.contains("Key_1")){
            cWeightText = setCWeight.getString("Key_1",null);
        } else {
            cWeightText = null;
        }
        cWeight.setText(cWeightText);

        //Set Target Weight Display
        SharedPreferences settWeight = getSharedPreferences("myPref",0);
        if(settWeight.contains("Key_2")){
            tWeightText = setCWeight.getString("Key_2",null);
        } else {
            tWeightText = null;
        }
        tWeight.setText(tWeightText);


        //Set "Road to Target" Display
        Weightdb = new DataBaseWeight(this);
        data = Weightdb.getListContents();
        weightHistory = new StringBuilder();
        if(data.getCount() == 0){
            mScrollText.setText("You have No Weight History");
        }
        else{
            while (data.moveToNext()){
                weightHistory.append("\n" + data.getString(3) + " - " + data.getString(2) + " lbs" );
                mScrollText.setText(weightHistory);
            }
        }

        

        eTargetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEnterTargetWeight();
            }
        });

        cWeightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEnterCurrentWeight();
            }
        });

        tHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenHistoricalData();
            }
        });
    }

    public void openEnterTargetWeight(){
        Intent intent = new Intent (this, EnterTargetWeight.class);
        startActivity(intent);
    }

    public void openEnterCurrentWeight(){
        Intent intent = new Intent (this, EnterCurrentWeight.class);
        startActivity(intent);
    }

    public void OpenHistoricalData(){
        Intent intent = new Intent (this, HistoricalData.class);
        startActivity(intent);
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}