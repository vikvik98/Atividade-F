package com.example.roberthsantos.condominio.model;

import com.orm.SugarRecord;

import java.util.List;

public class TipoDespesa extends SugarRecord {

    private String nome;
    private boolean valorRateado;
    private List<Despesas> despesas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isValorRateado() {
        return valorRateado;
    }

    public void setValorRateado(boolean valorRateado) {
        this.valorRateado = valorRateado;
    }
}
