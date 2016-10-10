package com.codekul.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runFragTxn(R.id.frameContainer,ImageFragment.getInstance(R.drawable.captain));
        runFragTxn(R.id.frameBottom, BottomFragment.getInstance());
    }

    private void runFragTxn(){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction txn = manager.beginTransaction();
        //txn.replace(R.id.frameContainer, new MyFragment());
        txn.replace(R.id.frameContainer, MyFragment.getInstance("This is codekul"));

        txn.commit();
    }

    public void runFragTxn(int container, Fragment fragment) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction txn = manager.beginTransaction();
        txn.replace(container, fragment);
        txn.commit();
    }
}
