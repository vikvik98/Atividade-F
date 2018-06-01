package com.example.roberthsantos.condominio.model;

import com.orm.SugarRecord;

import java.util.List;

public class TipoDespesa extends SugarRecord {

    private String nome;
    private boolean valorRateado;
    private List<Despesas> despesas;

}
