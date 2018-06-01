package com.example.roberthsantos.condominio.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.roberthsantos.condominio.R;
import com.example.roberthsantos.condominio.model.Apartamento;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Apartamento apartamento;
    private CardView cardApartamento;
    private RecyclerView rvApartamentos;
    //private ApartamentoAdapter adapter;
    private List<Apartamento> apartamentosList;
    //private Box<Apartamento> apartamentoBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();

    }

    private void setupViews() {
        cardApartamento = findViewById(R.id.card_apt);
        //rvApartamentos = findViewById(R.id.rvApartamentos);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.manu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         switch (item.getItemId()){
            case R.id.item_despesa:
                startActivity(new Intent(this, AddDespesasActivity.class));
                return true;
         }
         return true;
    }

    private void reloadData(List<Apartamento> data) {

        final List<Apartamento> apartamentos = data;
        //TODO: tem que fazer adapter com o SUGAR
        //adapter = new ApartamentoAdapter(this, apartamentos, apartamentoBox);
        //rvApartamentos.setAdapter(adapter);
        rvApartamentos.setLayoutManager(new LinearLayoutManager(this));
        rvApartamentos.setHasFixedSize(true);

    }


    public void novoApartamento(View view) {
        startActivity(new Intent(this, AddApartamentoActivity.class));
    }
}
