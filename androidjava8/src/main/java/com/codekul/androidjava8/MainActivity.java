package com.codekul.androidjava8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.function.Predicate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnOkay).setOnClickListener( v -> {
            myData((data1,data2) -> data1 == data2 ? 20 : 100, 100, 50 );

            /*myData(new IIData() {
                @Override
                public Integer test(Integer data1, Integer data2) {
                    return null;
                }
            },100,2);*/
        });

        findViewById(R.id.btnOkay).setOnClickListener(this::myClick);
    }

    private void myClick(View v){
        if(v.getId() == R.id.btnOkay)
            myData((data1,data2) -> data1 > data2 ? 1 : 0 ,10,20);
    }

    @FunctionalInterface
    private interface IIData {
        Integer test(Integer data1, Integer data2);
    }

    public void myData(IIData data, Integer num1, Integer num2){
        setText(String.valueOf(data.test(num1,num2)));
    }

    private void setText(String text){
        ((TextView)findViewById(R.id.textData)).setText(text);
    }
}
