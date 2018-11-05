package com.example.iii.bmi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActMain extends Activity {

    private View.OnClickListener btn_calculate_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                float height = Float.valueOf(edtheight.getText().toString());
                float weight = Float.valueOf(edtweight.getText().toString());
                float bmi;
                if(height==0){
                    ShowMsgDialog("身高不可為0");
                }else if(weight==0){
                    ShowMsgDialog("體重不可為0");
                }else {
                    height = height / 100;
                    bmi = weight / (height * height);
                    Bundle bund = new Bundle();
                    bund.putFloat(Dictionary.item_result, bmi);
                    Intent intent = new Intent(ActMain.this, ResultActivity.class);
                    intent.putExtras(bund);
                    startActivity(intent);
                }

            } catch (Exception e) {
                ShowMsgDialog("未輸入身高或體重");
            }
        }
    };


    private void ShowMsgDialog(String Msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("錯誤");
        builder.setMessage(Msg);
        DialogInterface.OnClickListener OkClick = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        };

        builder.setPositiveButton("確認", OkClick);
        builder.show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);
        InitialComponent();

    }

    private void InitialComponent() {
        btn_calculate = findViewById(R.id.btn_calculate);
        btn_calculate.setOnClickListener(btn_calculate_click);
        edtheight = findViewById(R.id.edtheight);
        edtweight = findViewById(R.id.edtweight);
    }

    Button btn_calculate;
    EditText edtweight;
    EditText edtheight;


}
