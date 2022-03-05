package com.example.tute2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity<Public> extends AppCompatActivity {

    EditText et_temp;
    RadioButton radBut_C;
    RadioButton radBut_F;
    Button btn;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_temp = findViewById(R.id.et_temp);
        radBut_C = findViewById(R.id.radBut_C);
        radBut_F = findViewById(R.id.radBut_F);
        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);

    }

    @Override
    protected void onResume() {
        super.onResume();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAnswer();
            }
        });
    }
    public void calculateAnswer(){
        Calculation cal = new Calculation();
        String value = et_temp.getText().toString();

        if(TextUtils.isEmpty(value)){
            Toast.makeText(this, "Please add a temperature value",
                    Toast.LENGTH_LONG).show();
        }else{
            Float temp = Float.parseFloat(value);
            if(radBut_C.isChecked()){
                temp = cal.convertCelciusToFahrenheit(temp);
            }else if(radBut_F.isChecked()){
                temp = cal.convertFahrenheitToCelcius(temp);
            }else{
                Toast.makeText(this,"Select the radio button!!", Toast.LENGTH_SHORT).show();
                temp = 0.0f;
            }
            textView.setText(new Float(temp).toString());
        }
    }
}