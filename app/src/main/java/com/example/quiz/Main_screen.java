package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main_screen extends AppCompatActivity {
TextView t1;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Intent i=new Intent(Main_screen.this,Name_button_screen.class);
        t1=findViewById(R.id.editTextTextPersonName);
        b1=findViewById(R.id.button6);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=t1.getText().toString();
                i.putExtra("title",s);
                startActivity(i);
                finish();
            }
        });
    }
}