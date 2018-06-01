package com.example.roberthsantos.condominio.model;

import com.orm.SugarRecord;

import java.util.List;

public class Proprietario extends SugarRecord {

    private String nome;
    private String telefone;
    private List<Apartamento> apartamentos;

    public Proprietario() {

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }
}
