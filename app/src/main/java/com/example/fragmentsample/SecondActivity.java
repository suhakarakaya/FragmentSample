package com.example.fragmentsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

public class SecondActivity extends AppCompatActivity {

    EditText sayi1, sayi2;
    Button fragmenteGonder;
    FragmentManager manager;
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        sayi1 = findViewById(R.id.edt_birinciSayi);
        sayi2 = findViewById(R.id.edt_ikinciSayi);
        container = findViewById(R.id.container);
        fragmenteGonder = findViewById(R.id.btnFragmentGonder);
        manager = getSupportFragmentManager();

    }

    public void calistir(View view) {

        FragmentE fragmentE = new FragmentE();

        /*Bundle bundle =new Bundle();
        bundle.putInt("sayi1",Integer.parseInt(sayi1.getText().toString()));
        bundle.putInt("sayi2",Integer.valueOf(sayi2.getText().toString()));

        fragmentA.setArguments(bundle);
*/
        fragmentE.sendData(Integer.parseInt(sayi1.getText().toString()), Integer.parseInt(sayi2.getText().toString()));

        fragmentE.sendOgreci(new ogrenci());

        FragmentTransaction transaction = manager.beginTransaction();


        transaction.add(R.id.container, fragmentE, "FragmentE");


        transaction.commit();
    }

    class ogrenci {
        int ogrNo;
        String ad;

    }
}