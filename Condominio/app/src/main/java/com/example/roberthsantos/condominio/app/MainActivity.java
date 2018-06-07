package com.example.roberthsantos.condominio.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.roberthsantos.condominio.R;
import com.example.roberthsantos.condominio.adapters.ListaApartamentosAdapter;
import com.example.roberthsantos.condominio.model.Apartamento;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Apartamento apartamento;
    private CardView cardApartamento;
    private RecyclerView rvApartamentos;
    private List<Apartamento> apartamentosList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvApartamentos = (RecyclerView) findViewById(R.id.rvApartamentos);

        List<Apartamento> apartamentos = Apartamento.listAll(Apartamento.class);

        ListaApartamentosAdapter adapter = new ListaApartamentosAdapter(this, apartamentos);
        rvApartamentos.setAdapter(adapter);

        rvApartamentos.setLayoutManager(new LinearLayoutManager(this));
        setupViews();

    }

    private void setupViews() {
        cardApartamento = findViewById(R.id.card_apt);
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

    @Override
    protected void onResume() {

        RecyclerView rvApartamentos = (RecyclerView) findViewById(R.id.rvApartamentos);

        List<Apartamento> apartamentos = Apartamento.listAll(Apartamento.class);

        ListaApartamentosAdapter adapter = new ListaApartamentosAdapter(this, apartamentos);
        rvApartamentos.setAdapter(adapter);

        rvApartamentos.setLayoutManager(new LinearLayoutManager(this));

        super.onResume();
    }

    public void novoApartamento(View view) {
        startActivity(new Intent(this, AddApartamentoActivity.class));
    }
}
