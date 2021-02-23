package com.example.fragmentsample;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FragmentE extends Fragment {

    Button hesapla;
    TextView sonuc;
    int sayi1 = 0, sayi2 = 0;

    SecondActivity.ogrenci ogr;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_e, container, false);

        hesapla = view.findViewById(R.id.hesapla);
        sonuc = view.findViewById(R.id.sonuc);


       /* Bundle bundle = getArguments();

        final int sayi1 = bundle.getInt("sayi1");
        final int sayi2 = bundle.getInt("sayi2");*/
        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonuc.setText("sonuc= " + (sayi1 + sayi2));
            }
        });

        return view;


    }

    public void sendData(int sayim1, int sayim2) {

        this.sayi1 = sayim1;
        this.sayi2 = sayim2;

    }

    public void sendOgreci(SecondActivity.ogrenci ogrenci) {

        this.ogr=ogrenci;


    }
}
