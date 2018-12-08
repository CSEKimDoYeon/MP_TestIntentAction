package com.example.kimdoyeon.mp01_06_201402324;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final int GET_STRING = 1;

    RadioGroup radioGroup;
    RadioButton option1;
    RadioButton option2;
    RadioButton option3;

    Button btn_call;
    Button btn_internet;

    public String phone_Num = "";
    public String internet_Address = "";

    TextView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup =(RadioGroup) findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(mRadioCheck);

        option1 = (RadioButton) findViewById(R.id.radio_domino);
        option2 = (RadioButton) findViewById(R.id.radio_mr);
        option3 = (RadioButton) findViewById(R.id.radio_hut);

        btn_call = (Button) findViewById(R.id.button_call);
        btn_internet = (Button) findViewById(R.id.button_internet);

        list = (TextView) findViewById(R.id.order_list);

    }

    RadioGroup.OnCheckedChangeListener mRadioCheck =
            new RadioGroup.OnCheckedChangeListener(){
                public void onCheckedChanged(RadioGroup group, int checkedId){
                    if (group.getId() == R.id.radio_group){
                        switch (checkedId){
                            case R.id.radio_domino:
                                btn_call.setEnabled(true);
                                btn_internet.setEnabled(true);

                                phone_Num = "tel:(+82)15773082";
                                internet_Address = "https://web.dominos.co.kr/gate";
                                break;
                            case R.id.radio_mr:
                                btn_call.setEnabled(true);
                                btn_internet.setEnabled(true);

                                phone_Num = "tel:(+82)15770077";
                                internet_Address = "http://www.mrpizza.co.kr/index";
                                break;
                            case R.id.radio_hut:
                                btn_call.setEnabled(true);
                                btn_internet.setEnabled(true);

                                phone_Num = "tel:(+82)15885588";
                                internet_Address = "https://www.pizzahut.co.kr/main";
                                break;
                        }
                    }
                }
            };

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == GET_STRING){
            if(resultCode == RESULT_OK){
                list.setText(data.getStringExtra("INPUT_TEXT"));
            }
        }
    }

    public void doOrder(View view) {
        Intent intent = new Intent(this, SubActivity.class);
        startActivityForResult(intent, GET_STRING);
    }

    public void order_Call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(phone_Num));
        startActivity(intent);
    }

    public void order_Internet(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(internet_Address));
        startActivity(intent);
    }
}
