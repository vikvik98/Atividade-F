package com.example.roberthsantos.condominio.app;
import com.example.roberthsantos.condominio.R;
import com.example.roberthsantos.condominio.cases.ManterApartamento;
import com.example.roberthsantos.condominio.cases.PrepararCondominio;
import com.example.roberthsantos.condominio.model.Despesa;
import com.example.roberthsantos.condominio.model.TipoDespesa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddDespesasActivity extends AppCompatActivity {

    private EditText nomeDespesa;
    private EditText mesDespesa;
    private EditText valorDespesa;
    private EditText apartamentoDespesa;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_despesas);

        setupViews();
    }

    private void setupViews() {
        nomeDespesa = findViewById(R.id.add_nome_despesa);
        mesDespesa = findViewById(R.id.add_mes_despesa);
        valorDespesa = findViewById(R.id.add_valor_despesa);
        apartamentoDespesa = findViewById(R.id.numero_apt_despesa);
        radioGroup = findViewById(R.id.group_ratificado);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.verdadeiro){
                    apartamentoDespesa.setVisibility(View.GONE);
                    apartamentoDespesa.setText("");

                }else{
                    apartamentoDespesa.setVisibility(View.VISIBLE);
                    apartamentoDespesa.setText("");
                }
            }
        });
    }




    public void inserirDespesa(View view) {

        // TODO: vamos ter a criação de um tipoDespesa e depois passar para despesa
        // TODO: e no final com item condominio, onde temos que ter
        TipoDespesa tipoDespesa = new TipoDespesa();
        //TODO : fazer verificação se ta vazio ou n, pra ver se pode



        try{
            ManterApartamento manterApartamento = new ManterApartamento();
            PrepararCondominio preparo = new PrepararCondominio();

            preparo.verificaNomeDespesa(nomeDespesa.getText().toString());
            tipoDespesa.setNome(nomeDespesa.getText().toString());

            if (radioGroup.getCheckedRadioButtonId() == R.id.verdadeiro){
                tipoDespesa.setValorRateado(true);
            }else{
                tipoDespesa.setValorRateado(false);

                manterApartamento.verificarApartamentoExistente(Integer.parseInt(apartamentoDespesa.getText().toString()));
            }

            preparo.verificarMesDespesa(mesDespesa);

            Despesa despesa = new Despesa();
            despesa.setMesAno(mesDespesa.getText().toString());
            despesa.setTipoDespesa(tipoDespesa);
            despesa.setValor(Integer.parseInt(valorDespesa.getText().toString()));

            Toast.makeText(this, "Despesa cadastrada com sucesso!", Toast.LENGTH_SHORT).show();
            finish();

        }catch (IllegalArgumentException e){
            Toast.makeText(this, "Valores invalidos!", Toast.LENGTH_SHORT).show();
        }catch (IllegalAccessError e){
            Toast.makeText(this, "Mês não aceitavel", Toast.LENGTH_SHORT).show();
        }
    }


}
