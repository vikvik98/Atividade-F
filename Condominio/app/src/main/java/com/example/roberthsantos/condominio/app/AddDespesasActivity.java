package com.example.roberthsantos.condominio.app;
import com.example.roberthsantos.condominio.R;
import com.example.roberthsantos.condominio.model.TipoDespesa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddDespesasActivity extends AppCompatActivity {

    private EditText nomeDespesa;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_despesas);
        setupViews();
    }

    private void setupViews() {
        nomeDespesa = findViewById(R.id.add_nome_despesa);
        radioGroup = findViewById(R.id.group_ratificado);

    }


    public void inserirDespesa(View view) {
        TipoDespesa tipoDespesa = new TipoDespesa();
        //TODO : fazer verificação se ta vazio ou n, pra ver se pode negoçar

        try{
            verificaNomeDespesa(nomeDespesa.getText().toString());

            tipoDespesa.setNome(nomeDespesa.getText().toString());

            if (radioGroup.getCheckedRadioButtonId() == R.id.verdadeiro){
                tipoDespesa.setValorRateado(true);
            }else{
                tipoDespesa.setValorRateado(false);
            }

            Toast.makeText(this, "Despesa cadastrada com sucesso!", Toast.LENGTH_SHORT).show();
            finish();

        }catch (IllegalArgumentException e){
            Toast.makeText(this, "Digite um nome valido!", Toast.LENGTH_SHORT).show();
        }
    }

    private void verificaNomeDespesa(String nome){
        if (nome.isEmpty()){
            throw new IllegalArgumentException();
        }
    }
}
