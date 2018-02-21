package com.example.zulkuf.android_101_2;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView firstCount,secondCount,result,score;
    ImageView operator;
    EditText et;
    ImageButton calculate;
    public int count;
    public int error;
    Random rnd;
    public int first,second;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText)findViewById(R.id.editText);
        operator = (ImageView)findViewById(R.id.operator1);
        firstCount = (TextView)findViewById(R.id.first);
        secondCount = (TextView)findViewById(R.id.second);
        result = (TextView)findViewById(R.id.result);
        calculate = (ImageButton)findViewById(R.id.imageButton);
        score = (TextView)findViewById(R.id.textView2);


         first = sayiUret();
         second = sayiUret();

        firstCount.setText(Integer.toString(first));
        secondCount.setText(Integer.toString(second));
        count = 0;
        error = 0;
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int value = Integer.parseInt(et.getText().toString());
                operator.setImageDrawable(getDrawable(R.drawable.plus));

                int res = first + second;
                result.setText(Integer.toString(res));


                if (res == value){
                    count++;
                    Toast.makeText(MainActivity.this, "Doğru", Toast.LENGTH_SHORT).show();
                    score.setText(Integer.toString(count));
                }else{
                   error++;
                   if (error == 3){
                       Toast.makeText(MainActivity.this, "Kaybettin Skor: "+String.valueOf(count), Toast.LENGTH_SHORT).show();
                   }else{
                       Toast.makeText(MainActivity.this, "Hatalı Sonuç", Toast.LENGTH_SHORT).show();
                    }
                }

                result.setText("");
                first = sayiUret();
                second = sayiUret();
                et.setText("");
                firstCount.setText(Integer.toString(first));
                secondCount.setText(Integer.toString(second));
            }
        });



    }

    public int sayiUret(){
       rnd = new Random();
       int val = rnd.nextInt(10);
       return val;
    }

}
