package com.example.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences sp;
    EditText username, password;
    Button bttn;

    String a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("Mypref", MODE_PRIVATE);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        bttn = (Button) findViewById(R.id.bttn);

        bttn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor editor = sp.edit();

        a = username.getText().toString();
        b = password.getText().toString();

        editor.putString("Username", a);
        editor.putString("Password", b);
        editor.apply();

        Toast.makeText(this, "Registration successful", Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, SecondActivity.class));
    }
}
