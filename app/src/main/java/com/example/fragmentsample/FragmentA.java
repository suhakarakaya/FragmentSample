package com.example.fragmentsample;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {


    EditText edt_sayi1, edt_sayi2;
    Button btn_gonder;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_a, container, false);

        btn_gonder = view.findViewById(R.id.btn_gonder);
        edt_sayi1 = view.findViewById(R.id.edt_sayi1);
        edt_sayi2 = view.findViewById(R.id.edt_sayi2);

        btn_gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendData();

            }
        });


        return view;    }


    public void sendData() {

        MyListener listener = (MyListener) getActivity();
        listener.sayilariTopla(Integer.parseInt(edt_sayi1.getText().toString()), Integer.parseInt(edt_sayi2.getText().toString()));

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
