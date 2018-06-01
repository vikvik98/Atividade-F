package com.example.roberthsantos.condominio.cases;

import com.example.roberthsantos.condominio.model.Proprietario;

import java.util.ArrayList;
import java.util.List;

public class ManterProprietario {
    private List<Proprietario> proprietarios;

    public ManterProprietario() {
        this.proprietarios = new ArrayList<>();
    }

    public void CadastrarProprietario(String nome, String telefone){
        Proprietario proprietario = new Proprietario();
        proprietario.setNome(nome);
        proprietario.setTelefone(telefone);
        proprietarios.add(proprietario);
    }

    public List<Proprietario> getProprietarios() {
        return proprietarios;
    }

    public void setProprietarios(List<Proprietario> proprietarios) {
        this.proprietarios = proprietarios;
    }
}
