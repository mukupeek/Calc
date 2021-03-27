package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private double arg1;
    private double arg2;
    private boolean check;
    private boolean check1;
    private double action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch switch1 = findViewById(R.id.switch1);
        Button button = findViewById(R.id.button);
        CheckBox checkBox  = findViewById(R.id.checkBox);
        ToggleButton toggleButton =findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(this);
        button.setOnClickListener(view ->{
            EditText input1 = findViewById(R.id.input1);
            EditText input2 = findViewById(R.id.input2);


            check1 = Boolean.valueOf(switch1.isChecked());
            if(!check1) {
                action = arg1 * arg2;
            }
            else action = arg1 / arg2;
                arg1 = Integer.valueOf(input1.getText().toString());
                arg2 = Integer.valueOf(input2.getText().toString());

                check = Boolean.valueOf(checkBox.isChecked());
                TextView result = findViewById(R.id.result);
                if (!check) {
                    result.setText(String.valueOf((int) action));
                }else result.setText(String.valueOf(action));

        });
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked)
        setContentView(R.layout.activity_2);
        else setContentView(R.layout.activity_main); //возвращение не доработано
    }
}
