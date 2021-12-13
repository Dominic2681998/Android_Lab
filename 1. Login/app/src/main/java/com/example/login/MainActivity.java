package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String user = "anlin", pass = "123";
    TextView username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void verify(View view) {
        if(view.getId() == R.id.bttn) {
            username = (TextView) findViewById(R.id.username);
            password = (TextView) findViewById(R.id.password);
            String a = username.getText().toString();
            String b = password.getText().toString();
            if(a.equals((user)) && b.equals(pass))
                Toast.makeText(this, "Login successful.", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "Login unsuccessful.", Toast.LENGTH_LONG).show();
        }
    }
}