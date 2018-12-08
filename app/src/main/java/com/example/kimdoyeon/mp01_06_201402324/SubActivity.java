package com.example.kimdoyeon.mp01_06_201402324;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SubActivity extends AppCompatActivity {

    CheckBox cbx_Pizza;
    CheckBox cbx_Pasta;

    Button plus_Pizza;
    Button minus_Pizza;

    Button plus_Pasta;
    Button minus_Pasta;

    TextView tv_Pizza;
    TextView tv_Pasta;

    Button btn_Ok;

    public int count_Pizza = 0;
    public int count_Pasta = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        cbx_Pizza = (CheckBox) findViewById(R.id.checkbox_pizza);
        cbx_Pizza.setOnCheckedChangeListener(mCheckChange);
        cbx_Pasta = (CheckBox) findViewById(R.id.checkbox_pasta);
        cbx_Pasta.setOnCheckedChangeListener(mCheckChange);

        plus_Pizza = (Button) findViewById(R.id.plus_pizza);
        minus_Pizza = (Button) findViewById(R.id.minus_pizza);

        plus_Pasta = (Button) findViewById(R.id.plus_pasta);
        minus_Pasta = (Button) findViewById(R.id.minus_pasta);

        tv_Pizza = (TextView) findViewById(R.id.text_pizza);
        tv_Pasta = (TextView) findViewById(R.id.text_pasta);

        btn_Ok = (Button) findViewById(R.id.button_ok);

    }

    CompoundButton.OnCheckedChangeListener mCheckChange =
            new CompoundButton.OnCheckedChangeListener(){
                public void onCheckedChanged (CompoundButton buttonView, boolean isChecked){
                    if (buttonView.getId()==R.id.checkbox_pizza){
                        if(isChecked){
                           // mSample.setBackgroundColor(Color.WHITE);
                            plus_Pizza.setEnabled(true);
                            minus_Pizza.setEnabled(true);
                        } else{
                          //  mSample.setBackgroundColor(Color.TRANSPARENT);
                            plus_Pizza.setEnabled(false);
                            minus_Pizza.setEnabled(false);
                            count_Pizza = 0;
                            tv_Pizza.setText("피자=0");
                        }
                    }
                    if (buttonView.getId() == R.id.checkbox_pasta){
                        if(isChecked){
                            //mSample.setText("샘플");
                            plus_Pasta.setEnabled(true);
                            minus_Pasta.setEnabled(true);
                        } else{
                            //mSample.setText("Sample");
                            plus_Pasta.setEnabled(false);
                            minus_Pasta.setEnabled(false);
                            count_Pasta = 0;
                            tv_Pasta.setText("스파게티=0");
                        }
                    }
                }
            };

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.plus_pizza:
                count_Pizza++;
                tv_Pizza.setText("피자="+count_Pizza);
                break;
            case R.id.minus_pizza:
                if (count_Pizza !=0) {
                    count_Pizza--;
                    tv_Pizza.setText("피자=" + count_Pizza);
                }
                break;
            case R.id.plus_pasta:
                count_Pasta++;
                tv_Pasta.setText("스파게티="+count_Pasta);
                break;
            case R.id.minus_pasta:
                if (count_Pasta !=0){
                    count_Pasta--;
                    tv_Pasta.setText("스파게티="+count_Pasta);
                }
                break;
        }
    }

    public void ok(View view) {
        Intent intent = new Intent();
        intent.putExtra("INPUT_TEXT","피자="+count_Pizza+", 스파게티="+ count_Pasta );
        setResult(RESULT_OK, intent);
        finish();

    }
}
