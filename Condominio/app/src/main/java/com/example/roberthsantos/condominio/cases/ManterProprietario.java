package com.example.roberthsantos.condominio.cases;

import android.widget.EditText;
import android.widget.Toast;

import com.example.roberthsantos.condominio.model.Proprietario;

import java.util.ArrayList;
import java.util.List;

public class ManterProprietario {
    private List<Proprietario> proprietarios;

    public ManterProprietario() {
        this.proprietarios = new ArrayList<>();
    }

    public boolean cadastrarProprietario(EditText nomeProprietario, EditText telefoneProprietario){
        String nome = nomeProprietario.getText().toString();
        String telefone = telefoneProprietario.getText().toString();
        for(int i = 0; i < proprietarios.size(); i++){
            if(getProprietarios().get(i).getNome().equals(nome) && getProprietarios().get(i).getTelefone().equals(telefone)){
                return false;
            }else {
                Proprietario proprietario = new Proprietario();
                proprietario.setNome(nome);
                proprietario.setTelefone(telefone);
                proprietarios.add(proprietario);
                return true;
            }
        }
        return true;

    }

    public List<Proprietario> getProprietarios() {
        return proprietarios;
    }

    public void setProprietarios(List<Proprietario> proprietarios) {
        this.proprietarios = proprietarios;
    }
}
