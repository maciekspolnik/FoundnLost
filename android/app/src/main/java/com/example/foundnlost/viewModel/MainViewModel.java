package com.example.foundnlost.viewModel;

import androidx.lifecycle.ViewModel;

import com.example.foundnlost.data.database.DatabaseHelper;
import com.example.foundnlost.data.network.model.Advert;

import java.util.ArrayList;
import java.util.Date;

public class MainViewModel extends ViewModel {
    private final DatabaseHelper databaseHelper;

    public MainViewModel(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public ArrayList<Advert> getLostAdverts(){
        ArrayList<Advert> list = new ArrayList<>();
        list.add(new Advert(1L, "LOST", "Skrzynka", "Zgubiono zieloną skrzynke, na znalazcę czeka nagroda", new Date(), "Tutaj"));
        list.add(new Advert(1L, "LOST", "Skrzynka", "Zgubiono zieloną skrzynke, na znalazcę czeka nagroda", new Date(), "Tutaj"));
        return list;
    }

    public ArrayList<Advert> getFoundAdverts(){
        ArrayList<Advert> list = new ArrayList<>();
        list.add(new Advert(1L, "FOUND", "Breloczek", "Znaleziono breloczek do kluczy, przy kontakcie proszę o podanie jego wyglądu w celu weryfikacji", new Date(), "Tutaj"));
        list.add(new Advert(1L, "FOUND", "Breloczek", "Znaleziono breloczek do kluczy, przy kontakcie proszę o podanie jego wyglądu w celu weryfikacji", new Date(), "Tutaj"));
        return list;
    }



}