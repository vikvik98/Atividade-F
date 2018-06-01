package com.example.roberthsantos.condominio.app;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.roberthsantos.condominio.R;
import com.example.roberthsantos.condominio.cases.CondominioUseCases;
import com.example.roberthsantos.condominio.cases.ManterApartamento;
import com.example.roberthsantos.condominio.cases.ManterProprietario;
import com.example.roberthsantos.condominio.model.Apartamento;
import com.example.roberthsantos.condominio.model.Proprietario;

import java.util.List;


public class AddApartamentoActivity extends AppCompatActivity {

    private EditText editTelefone;
    private AutoCompleteTextView acProprietario;
    private EditText editQuantQuartos;
    private EditText editNumeroApt;
    private LinearLayout linearLayout;
    private CheckBox checkOcupado;
    private Proprietario proprietario;
    private boolean validarOcupacao;
    private  Apartamento apartamento = new Apartamento();
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
        acProprietario = findViewById(R.id.nome_proprietario_add);
        editQuantQuartos = findViewById(R.id.quant_quartos_add);
        checkOcupado = findViewById(R.id.check_ocupado);
        linearLayout = findViewById(R.id.layout_telefone_add);
        acProprietario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                proprietario = (Proprietario) parent.getItemAtPosition(position);
            }
        });
    }

    public void clickCheckOcupado(View view) {

        //TODO: temos que fazer aparecer a lista de proprietarios.
        if (checkOcupado.isChecked()){
            acProprietario.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.VISIBLE);
            validarOcupacao = true;
        }else{
            acProprietario.setVisibility(View.GONE);
            linearLayout.setVisibility(View.GONE);
            acProprietario.setText("");
            editTelefone.setText("");
            validarOcupacao = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        carregarProprietarios();
    }

    private void carregarProprietarios() {
        List<Proprietario> proprietarios =Proprietario.listAll(Proprietario.class);

        ArrayAdapter<Proprietario> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,proprietarios);
        acProprietario.setAdapter(adapter);
    }

    public void addApartamento(View view) {
        ManterApartamento useCaseAddApartamento = new ManterApartamento();

        try{

            apartamento = useCaseAddApartamento.cadastrarApartamento(editNumeroApt,editQuantQuartos);
            //apartamento.save();


            if (validarOcupacao == true){
                try {
                    proprietario.getNome();
                }catch (NullPointerException e){
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);

                    final View viewDialog = getLayoutInflater().inflate(R.layout.cadastro_proprietario,null);

                    builder.setView(viewDialog)
                            .setTitle("Cadastro de Proprietario")
                            .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    EditText edProprietario = (EditText)viewDialog.findViewById(R.id.ed_cadastro_proprietario_nome);
                                    EditText edTelefone = (EditText) viewDialog.findViewById(R.id.ed_cadastro_proprietario_telefone);

                                    String nomeProprietario = edProprietario.getText().toString();
                                    String telefoneProprietario = edTelefone.getText().toString();
                                    ManterProprietario useCaseAddProprietario = new ManterProprietario();

                                    proprietario = useCaseAddProprietario.cadastrarProprietario(nomeProprietario,telefoneProprietario);

                                    proprietario.save();
                                    apartamento.setProprietario(proprietario);
                                    apartamento.save();

                                    Toast.makeText(AddApartamentoActivity.this,"Salvo",Toast.LENGTH_LONG).show();
                                    finish();
                                }
                            })
                            .setNegativeButton("Cancelar",null)
                            .show();
                }
            }else {

                apartamento.setProprietario(proprietario);
                apartamento.save();
                Toast.makeText(AddApartamentoActivity.this,"Salvo",Toast.LENGTH_LONG).show();
                finish();
                // proprietario.save();
            }

            // useCaseAddApartamento.verificarApartamento(apartamentoBox,Integer.valueOf(editNumeroApt.getText().toString()));
            //apartamentoBox.put(useCaseAddApartamento.adicionarApartamento(editNumeroApt,editQuantQuartos,editProprietario,editTelefone));
            //finish();
        }catch (IllegalArgumentException e){
            Toast.makeText(this, "Numero de apartamento já existente", Toast.LENGTH_SHORT).show();
        }
    }

    public Proprietario coletarDadosProprietario(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final View viewDialog = getLayoutInflater().inflate(R.layout.cadastro_proprietario,null);

        builder.setView(viewDialog)
                .setTitle("Cadastro de Proprietario")
                .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        EditText edProprietario = (EditText)viewDialog.findViewById(R.id.ed_cadastro_proprietario_nome);
                        EditText edTelefone = (EditText) viewDialog.findViewById(R.id.ed_cadastro_proprietario_telefone);

                        ManterProprietario useCaseAddProprietario = new ManterProprietario();

                        //proprietario = useCaseAddProprietario.cadastrarProprietario(edProprietario,edTelefone);

                    }
                })
                .setNegativeButton("Cancelar",null)
                .show();
        return proprietario;
    }


}
