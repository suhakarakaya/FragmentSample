package com.example.fragmentsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

public class BaseActivity extends AppCompatActivity implements MyListener {

    FrameLayout container;
    TextView txt_sonuc;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        container = findViewById(R.id.container);
        txt_sonuc = findViewById(R.id.txt_sonuc);

        manager = getSupportFragmentManager();
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.container, fragmentA, "FragmentA");
        transaction.commit();
    }

    @Override
    public void sayilariTopla(int sayi1, int sayi2) {
        int sonuc = sayi1 + sayi2;
        txt_sonuc.setText("Sonuç: " + sonuc);
    }
}