package com.example.checktestsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText e1,e2;
Button b;
DBhandler dd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dd=new DBhandler(this);
        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);
        b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1,s2;
                s1= e1.getText().toString();
                s2=e2.getText().toString();
                long id= dd.insertData(s1,s2);
                if(id>0) {

                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getApplicationContext(),"Failure",Toast.LENGTH_SHORT).show();

            }
        });


}

}
