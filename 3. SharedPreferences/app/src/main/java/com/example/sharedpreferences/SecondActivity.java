package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    SharedPreferences sp;
    TextView name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        sp = getSharedPreferences("MyPref", MODE_PRIVATE);
        name = (TextView) findViewById(R.id.txt1);
        email = (TextView) findViewById(R.id.txt2);

        if(sp.contains("Name"))
            name.setText(sp.getString("Name",""));
        if(sp.contains("Email"))
            email.setText(sp.getString("Email", ""));
    }
    public void prevActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
