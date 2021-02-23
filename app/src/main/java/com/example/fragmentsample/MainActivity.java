package com.example.fragmentsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        manager.addOnBackStackChangedListener(this);


    }

    //ilgili layouta fragmente ekliyor
    public void addFragmentA(View view) {
        FragmentA fragmentA = new FragmentA();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentA, "FragmentA");

        transaction.addToBackStack("addA");
        transaction.commit();
    }

    public void removeFragmentA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("FragmentA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.remove(fragmentA);
            transaction.addToBackStack("removeB");
            transaction.commit();
        }

    }

    //tanımladığımız layoutta fragment eklemye yarıyor
    public void addFragmentB(View view) {

        FragmentB fragmentB = new FragmentB();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentB, "FragmentB");
        transaction.addToBackStack("addB");
        transaction.commit();
    }

    //tanımladığımız layoutta fragment çıkarmaya yarıyor
    public void removoFragmentB(View view) {


        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("FragmentB");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentB != null) {
            transaction.remove(fragmentB);
            transaction.addToBackStack("removeA");
            transaction.commit();
        }

    }


    public void replaceByFragmentB(View view) {

        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentB, "FragmentB");
        transaction.addToBackStack("replaceB");
        transaction.commit();
    }

    //ilgili layoutaa a olsun olmasaın a ile değiştir
    public void replaceByFragmentA(View view) {

        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentA, "FragmentA");
        transaction.addToBackStack("replaceA");
        transaction.commit();


    }

    //kaybolan layout göstermiş oluruz
    public void attachFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("FragmentA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.attach(fragmentA);
            transaction.addToBackStack("attachA");
            transaction.commit();

        }

    }

    //fragment varlığını sürdürür yalnız kullandığı layout yok olur. yani kullanıcı göremez ama varlığı main activitye bağlıdır
    public void detachFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("FragmentA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.detach(fragmentA);
            transaction.addToBackStack("detachA");
            transaction.commit();

        }

    }

    public void showfragmentA(View view) {


        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("FragmentA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {

            transaction.show(fragmentA);
            transaction.addToBackStack("showA");
            transaction.commit();
        }

    }

    //fragmenti saklamak aslında hiç bir lifecycle metodu çalışmaz
    public void hideFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("FragmentA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {

            transaction.hide(fragmentA);
            transaction.addToBackStack("hideA");
            transaction.commit();
        }

    }

    //yığının en üstüne eklenen eleman çıkarılacak
    public void backButton(View view) {

        manager.popBackStack();

    }

    //belirli bir fragmentin ekleme işleminin geri alınması
    public void popAddInclusive(View view) {

        manager.popBackStack("addA", FragmentManager.POP_BACK_STACK_INCLUSIVE);

    }

    //belirli bir framentin üstündekileri çıkartma
    public void popaddB(View view) {

        manager.popBackStack("addA", 0);

    }

    @Override
    public void onBackStackChanged() {
        //backstackle ulaşılan eleman sayısını veriyor
        int elemanSayisi = manager.getBackStackEntryCount();
        //stack içindeki olay isimlerini saklıyoruz
        StringBuilder mesaj = new StringBuilder("");

        for (int i = elemanSayisi - 1; i >= 0; i--) {
            mesaj.append("Index ").append(i).append(":");
            mesaj.append(manager.getBackStackEntryAt(i).getName());
            mesaj.append("\n");

        }

        Log.d("Suha", mesaj.toString() + "\n");
    }
}