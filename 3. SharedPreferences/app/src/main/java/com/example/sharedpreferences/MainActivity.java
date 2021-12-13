package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name, email;
    SharedPreferences sp;
    String a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("MyPref", MODE_PRIVATE);
        name = (EditText) findViewById(R.id.txt1);
        email = (EditText) findViewById(R.id.txt2);

        if(sp.contains("Name"))
            name.setText(sp.getString("Name",""));
        if(sp.contains("Email"))
            email.setText(sp.getString("Email", ""));
    }
    public void nextActivity(View view) {
        a = name.getText().toString();
        b = email.getText().toString();

        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Name", a);
        editor.putString("Email", b);
        editor.apply();
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
