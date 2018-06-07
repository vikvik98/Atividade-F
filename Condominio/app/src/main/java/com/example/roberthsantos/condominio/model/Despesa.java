package com.example.roberthsantos.condominio.model;

import com.orm.SugarRecord;

import java.util.List;

public class Despesa extends SugarRecord{

    private String mesAno;
    private double valor;
    private List<ItemCondominio> itemCondominios;
    private TipoDespesa tipoDespesa;

    public Despesa() {
    }

    public String getMesAno() {
        return mesAno;
    }

    public void setMesAno(String mesAno) {
        this.mesAno = mesAno;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<ItemCondominio> getItemCondominios() {
        return itemCondominios;
    }

    public void setItemCondominios(List<ItemCondominio> itemCondominios) {
        this.itemCondominios = itemCondominios;
    }

    public TipoDespesa getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(TipoDespesa tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }
}
