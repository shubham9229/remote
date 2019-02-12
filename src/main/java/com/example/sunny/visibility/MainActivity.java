package com.example.sunny.visibility;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    View go,button1,button2,button3,button4,playAgain;
    TextView timer,textView,marks,result;
    Button b1,b2,b3,b4;
    String option;
    Boolean continueGame;
    int rightOption,wrongOption;



    public void start(View view)
    {
        go=findViewById(R.id.go);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        playAgain=findViewById(R.id.playAgain);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        go.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        timer.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
        marks.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
        gameStart();
    }



    public void gameStart()
    {
        timerSet();
        continueGame=true;
        rightOption=wrongOption=0;
        marks.setText(rightOption+"/"+wrongOption);
        result.setText("");
         game();
            }



            public void game()
            {
                if(continueGame){
                final int random1 = new Random().nextInt(21);
                final int random2 = new Random().nextInt(21);
                textView.setText(random1+"+"+random2);
                int sum=random1+random2;
                option = Integer.toString(new Random().nextInt(4)+1);
                    Log.i("answer",option);
                if(option.equals(b1.getTag()))
                    b1.setText(Integer.toString(sum));
                else
                    b1.setText(Integer.toString(new Random().nextInt(41)));
                if(option.equals(b2.getTag()))
                    b2.setText(Integer.toString(sum));
                else
                    b2.setText(Integer.toString(new Random().nextInt(41)));
                if(option.equals(b3.getTag()))
                    b3.setText(Integer.toString(sum));
                else
                    b3.setText(Integer.toString(new Random().nextInt(41)));
                if(option.equals(b4.getTag()))
                    b4.setText(Integer.toString(sum));
                else
                    b4.setText(Integer.toString(new Random().nextInt(41)));
            }}



            public void right(View view)
            {

                if(continueGame){
                if(option.equals(view.getTag())){
                    result.setText("CORRECT!!");
                    rightOption++;
                     }
                else {
                    result.setText("WRONG!!");
                    wrongOption++;
                }
                marks.setText(rightOption+"/"+wrongOption);
                game();
            }}




    public void timerSet()
    {
        new CountDownTimer(30000,1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(((millisUntilFinished+1000)/1000)+"s");
            }

            @Override
            public void onFinish() {
                timer.setText("0:00");
                continueGame=false;
                result.setText("Your Score "+rightOption+" / "+wrongOption);
                playAgain.setVisibility(View.VISIBLE);
            }
        }.start();
        }


        public void again(View view)
        {
            gameStart();
            playAgain.setVisibility(View.INVISIBLE);
        }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer=(TextView)findViewById(R.id.timer);
        textView=(TextView)findViewById(R.id.textView);
        marks=(TextView)findViewById(R.id.marks);
        result=(TextView)findViewById(R.id.result);
    }
}
