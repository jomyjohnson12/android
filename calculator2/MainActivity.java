package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    AppCompatButton b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText) findViewById(R.id.fno);
        ed2=(EditText) findViewById(R.id.sno);
        ed3=(EditText) findViewById(R.id.res);
        b1=(AppCompatButton) findViewById(R.id.add);
        b2=(AppCompatButton) findViewById(R.id.sub);
        b3=(AppCompatButton) findViewById(R.id.mul);
        b4=(AppCompatButton) findViewById(R.id.div);
        b5=(AppCompatButton) findViewById(R.id.clear);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if(ed1.getText().length()>0 && (ed2.getText().length()>0))
             {
                 double first=Double.parseDouble(ed1.getText().toString());
                 double second=Double.parseDouble(ed2.getText().toString());
                 double result=first+second;
                 ed3.setText(Double.toString(result));
             }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().length()>0 && (ed2.getText().length()>0))
                {
                    double first=Double.parseDouble(ed1.getText().toString());
                    double second=Double.parseDouble(ed2.getText().toString());
                    double result=first-second;
                    ed3.setText(Double.toString(result));
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().length()>0 && (ed2.getText().length()>0))
                {
                    double first=Double.parseDouble(ed1.getText().toString());
                    double second=Double.parseDouble(ed2.getText().toString());
                    double result=first*second;
                    ed3.setText(Double.toString(result));
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().length()>0 && (ed2.getText().length()>0))
                {
                    double first=Double.parseDouble(ed1.getText().toString());
                    double second=Double.parseDouble(ed2.getText().toString());
                    double result=first/second;
                    ed3.setText(Double.toString(result));
                }
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
            }
        });

    }
}