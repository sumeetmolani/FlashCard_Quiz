package com.example.flashcardquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class playActivity extends AppCompatActivity {
    String[] question_list = {
            "1 Which of the following data structures is primarily used in the implementation of a LIFO (Last In, First Out) structure ? ",
            "2. What is the time complexity of binary search on a sorted array of n elements ?",
            "3. Which of the following sorting algorithms has the best average-case time complexity?"
            ,"4. In the context of databases, what does ACID stand for ? ",
            "5. What is the primary purpose of a DNS (Domain Name System)?",
            "Which of the following is a NoSQL database?"
    };
    String[] choose_list = { "Queue" , "Stack" ,"Linked List","Array"
            ,"O(n)","O(n log n)","O(log n)","O(1)",
            "Bubble Sort","Selection Sort", "Merge Sort","Insertion Sort",
            "Atomicity, Consistency, Isolation, Durability","Atomicity, Concurrency, Isolation, Durability","Atomicity, Consistency, Integrity, Durability",
            "Atomicity, Concurrency, Integrity, Durability"
            ,"To secure communication over a network"
            ," To translate domain names to IP addresses"
            ," To route data packets across the internet"
            ,"To encrypt internet traffic",
            " MySQL"," PostgreSQL"," MongoDB  ","Oracle"
    };
    String[] correct_list = {
            "Stack",
            "O(log n) ",
            "Merge Sort",
            "Atomicity, Consistency, Isolation, Durability",
            "To translate domain names to IP addresses",
            "MongoDB "
    };


    TextView cpt_question , text_question;
    Button btn_choose1 , btn_choose2 , btn_choose3 , btn_choose4 , btn_next;


    int currentQuestion =  0  ;
    int scorePlayer =  0  ;
    boolean isclickBtn = false;
    String valueChoose = "";
    Button btn_click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_play);
        cpt_question = findViewById(R.id.cpt_question);
        text_question = findViewById(R.id.text_question);

        btn_choose1 = findViewById(R.id.btn_choose1);
        btn_choose2 = findViewById(R.id.btn_choose2);
        btn_choose3 = findViewById(R.id.btn_choose3);
        btn_choose4 = findViewById(R.id.btn_choose4);
        btn_next = findViewById(R.id.btn_next);

        findViewById(R.id.image_back).setOnClickListener(
                a-> finish()
        );
        remplirData();
        btn_next.setOnClickListener(
                view -> {
                    if (isclickBtn){
                        isclickBtn = false;

                        if(!valueChoose.equals(correct_list[currentQuestion])){
                            Toast.makeText(playActivity.this , "Wrong",Toast.LENGTH_LONG).show();
                            btn_click.setBackgroundResource(R.drawable.background_btn_erreur);

                        }else {
                            Toast.makeText(playActivity.this , "correct",Toast.LENGTH_LONG).show();
                            btn_click.setBackgroundResource(R.drawable.background_btn_correct);

                            scorePlayer++;
                        }
                        new Handler().postDelayed(() -> {
                            if(currentQuestion!=question_list.length-1){
                                currentQuestion = currentQuestion + 1;
                                remplirData();
                                valueChoose = "";
                                btn_choose1.setBackgroundResource(R.drawable.background_btn_choose);
                                btn_choose2.setBackgroundResource(R.drawable.background_btn_choose);
                                btn_choose3.setBackgroundResource(R.drawable.background_btn_choose);
                                btn_choose4.setBackgroundResource(R.drawable.background_btn_choose);

                            }else {
                                Intent intent  = new Intent(playActivity.this , ResulteActivity.class);
                                intent.putExtra("RESLTE" , scorePlayer);
                                startActivity(intent);
                                finish();
                            }

                        },2000);

                    }else {
                        Toast.makeText(playActivity.this ,  "You have to choose one",Toast.LENGTH_LONG).show();
                    }
                }
        );


    }

    void remplirData(){
        cpt_question.setText((currentQuestion+1) + "/" + question_list.length);
        text_question.setText(question_list[currentQuestion]);
        btn_choose1.setText(choose_list[4 * currentQuestion]);
        btn_choose2.setText(choose_list[4 * currentQuestion+1]);
        btn_choose3.setText(choose_list[4 * currentQuestion+2]);
        btn_choose4.setText(choose_list[4 * currentQuestion+3]);
    }
    public void ClickChoose(View view) {
        btn_click = (Button)view;
        if (isclickBtn) {
            btn_choose1.setBackgroundResource(R.drawable.background_btn_choose);
            btn_choose2.setBackgroundResource(R.drawable.background_btn_choose);
            btn_choose3.setBackgroundResource(R.drawable.background_btn_choose);
            btn_choose4.setBackgroundResource(R.drawable.background_btn_choose);
        }
        chooseBtn();
    }
    void chooseBtn(){

        btn_click.setBackgroundResource(R.drawable.background_btn_choose_color);
        isclickBtn = true;
        valueChoose = btn_click.getText().toString();
    }
}