package com.example.fragmentsample;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentD extends Fragment {
    TextView txt_sonuc;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        txt_sonuc = view.findViewById(R.id.txt_sonuc);

        return view;
    }

    public void sayilariTopla(int sayi1, int sayi2) {

        int toplam = sayi1 + sayi2;

        txt_sonuc.setText("Sonuc: " + toplam);

    }
}
