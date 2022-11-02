package com.example.sumofnum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sumofnum.R;

public class MainActivity extends AppCompatActivity
{
    private EditText value1,value2;
    private Button Sum;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }
    public void addListenerOnButton() {
        value1 = (EditText) findViewById(R.id.entry1);
        value2 = (EditText) findViewById(R.id.entry2);
        Sum = (Button) findViewById(R.id.button);
        Sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edittext1 = value1.getText().toString();
                String edittext2 = value2.getText().toString();
                int a = Integer.parseInt(edittext1);
                int b = Integer.parseInt(edittext2);
                int sum = a + b;
                Toast.makeText(getApplicationContext(), String.valueOf(sum),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}