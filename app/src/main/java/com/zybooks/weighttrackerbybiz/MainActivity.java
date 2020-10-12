package com.zybooks.weighttrackerbybiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button eTargetButton;
    private Button cWeightButton;
    private TextView tHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTargetButton = (Button) findViewById(R.id.buttonTarget);
        cWeightButton = (Button) findViewById(R.id.buttonCurrent);
        tHistory = (TextView) findViewById(R.id.textHistory);

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
}