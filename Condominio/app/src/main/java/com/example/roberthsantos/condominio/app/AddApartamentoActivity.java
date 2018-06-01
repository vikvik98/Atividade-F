package com.example.roberthsantos.condominio.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.roberthsantos.condominio.R;


public class AddApartamentoActivity extends AppCompatActivity {
    private EditText editTelefone;
    private EditText editProprietario;
    private EditText editQuantQuartos;
    private EditText editNumeroApt;
    private LinearLayout linearLayout;
    private CheckBox checkOcupado;
    //private Box<Apartamento> apartamentoBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_apartamento);

        //apartamentoBox = ((App)getApplication()).getBoxStore().boxFor(Apartamento.class);

        setupViews();

    }

    private void setupViews() {
        editNumeroApt = findViewById(R.id.numero_apt_add);
        editTelefone = findViewById(R.id.telefone_add);
        editProprietario = findViewById(R.id.nome_proprietario_add);
        editQuantQuartos = findViewById(R.id.quant_quartos_add);
        checkOcupado = findViewById(R.id.check_ocupado);
        linearLayout = findViewById(R.id.layout_telefone_add);
    }

    public void clickCheckOcupado(View view) {

        //TODO: temos que fazer aparecer a lista de proprietarios.
        if (checkOcupado.isChecked()){
            editProprietario.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.VISIBLE);
        }else{
            editProprietario.setVisibility(View.GONE);
            linearLayout.setVisibility(View.GONE);
            editProprietario.setText("");
            editTelefone.setText("");
        }
    }

    public void addApartamento(View view) {
        //CondominioUseCases useCaseAddApartamento = new CondominioUseCases();

        try{
            // useCaseAddApartamento.verificarApartamento(apartamentoBox,Integer.valueOf(editNumeroApt.getText().toString()));
            //apartamentoBox.put(useCaseAddApartamento.adicionarApartamento(editNumeroApt,editQuantQuartos,editProprietario,editTelefone));
            finish();
        }catch (IllegalArgumentException e){
            Toast.makeText(this, "Numero de apartamento já existente", Toast.LENGTH_SHORT).show();
        }
    }


}
