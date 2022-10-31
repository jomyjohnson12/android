package com.example.sharedpreferences;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.widget.AppCompatButton;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    AppCompatButton b1,b2;
    String getUserName,getPassword,PrefValue;
    SharedPreferences mypreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mypreferences = getSharedPreferences("login", MODE_PRIVATE);
        e1 = (EditText) findViewById(R.id.name);
        e2 = (EditText) findViewById(R.id.pswd);
        b1 = (AppCompatButton) findViewById(R.id.signin);
        b2 = (AppCompatButton) findViewById(R.id.signout);
        PrefValue = mypreferences.getString("email", null);
        if (PrefValue != null) {
            Intent i = new Intent(getApplicationContext(), dashboard.class);
            startActivity(i);
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserName = e1.getText().toString();
                getPassword = e2.getText().toString();
                if (getUserName.equals("abc124@gmail.com") && getPassword.equals("12345")) {
                    SharedPreferences.Editor myedit = mypreferences.edit();
                    myedit.putString("email", getUserName);
                    myedit.commit();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_LONG).show();

                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor myedit = mypreferences.edit();
                myedit.clear();
                myedit.commit();
            }


        });
    }
}