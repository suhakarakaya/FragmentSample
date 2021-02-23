package com.example.fragmentsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class ThirdActivity extends AppCompatActivity implements MyListener {

    FrameLayout container1, container2;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        container1 = findViewById(R.id.container1);
        container2 = findViewById(R.id.container2);

        manager = getSupportFragmentManager();

        FragmentC fragmentC = new FragmentC();
        FragmentD fragmentD = new FragmentD();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container1, fragmentC, "FragmentC");
        transaction.add(R.id.container2, fragmentD, "FragmentD");

        transaction.commit();


    }

    @Override
    public void sayilariTopla(int sayi1, int sayi2) {

        manager = getSupportFragmentManager();

        FragmentD fragmentD = (FragmentD) manager.findFragmentByTag("FragmentD");

        fragmentD.sayilariTopla(sayi1,sayi2);

    }
}