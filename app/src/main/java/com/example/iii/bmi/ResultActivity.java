package com.example.iii.bmi;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        InitialComponent();

        float bmi = getIntent().getExtras().getFloat(Dictionary.item_result);

        tvresult.setText(String.format("%.2f", bmi));
        if (bmi > 25) {
            tvsuggest.setText("過重，該減肥囉!!");
            tvsuggest.setTextColor(Color.RED);
            imgimg.setImageResource(R.drawable.fat);
        } else if (bmi < 20) {
            tvsuggest.setText("過輕，多吃點!!");
            tvsuggest.setTextColor(Color.YELLOW);
            imgimg.setImageResource(R.drawable.slim);
        } else {
            tvsuggest.setText("恭喜你，BMI很正常，請保持!!");
            tvsuggest.setTextColor(0xFF437100);
            imgimg.setImageResource(R.drawable.health);
        }

    }

    private void InitialComponent() {
        tvresult = findViewById(R.id.tvresult);
        tvsuggest = findViewById(R.id.tvsuggest);
        imgimg = findViewById(R.id.imgimg);

    }

    TextView tvresult;
    TextView tvsuggest;
    ImageView imgimg;

}