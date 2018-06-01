package com.example.roberthsantos.condominio.model;

import com.orm.SugarRecord;

import java.util.List;

public class Despesas extends SugarRecord{

    private String mesAno;
    private double valor;
    private List<ItemCondominio> itemCondominios;
    private TipoDespesa tipoDespesa;

    public Despesas() {
    }
}
