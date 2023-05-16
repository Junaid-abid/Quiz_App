package com.example.quiz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Objects;

public class Computer_science extends AppCompatActivity {
    TextView qes, count;

    String[] tf_ques, tf_ans;

    String ans;

    ImageButton b1, b2;

    int index, score;

    CheckBox c1, c2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_science);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        qes = findViewById(R.id.qes);
        count = findViewById(R.id.num);
        b1 = findViewById(R.id.imageButton);
        b2 = findViewById(R.id.imageButton2);
        c1 = findViewById(R.id.check1);
        c2 = findViewById(R.id.check2);
        index=0;

        tf_ques = getResources().getStringArray(R.array.COMPUTER_Science);
        tf_ans = getResources().getStringArray(R.array.correct);

        qes.setText(tf_ques[index]);


        b1.setEnabled(false);


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c2.setChecked(false);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1.setChecked(false);
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index < 9) {
                    b1.setEnabled(true);
                    if (c1.isChecked()) {
                        ans = "True";

                    }
                    if (c2.isChecked()) {
                        ans = "False";
                    }

                    if (Objects.equals(ans, tf_ans[index])) {
                        score++;
                        ans="";
                    }

                    c1.setChecked(false);
                    c2.setChecked(false);

                    index++;
                    qes.setText(tf_ques[index]);
                    count.setText(String.valueOf(index+1));

                }

                else {

                    qes.setText("Your Correct answers are: "+score+" From 10");
                    c1.setEnabled(false);
                    c2.setEnabled(false);

                    b2.setEnabled(false);
                }

            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<11) {
                    b2.setEnabled(true);
                }
                if(index>0){


                    c1.setEnabled(true);
                    c2.setEnabled(true);
                    index--;
                    qes.setText(tf_ques[index]);
                    c1.setChecked(false);
                    c2.setChecked(false);
                    count.setText(String.valueOf(index+1));

                }
                else b1.setEnabled(false);
            }
        });
    }
}