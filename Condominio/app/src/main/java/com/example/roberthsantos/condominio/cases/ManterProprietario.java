package com.example.roberthsantos.condominio.cases;

import com.example.roberthsantos.condominio.model.Proprietario;

import java.util.ArrayList;
import java.util.List;

public class ManterProprietario {
    private List<Proprietario> proprietarios;

    public ManterProprietario() {
        this.proprietarios = new ArrayList<>();
    }

    public boolean CadastrarProprietario(String nome, String telefone){
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
