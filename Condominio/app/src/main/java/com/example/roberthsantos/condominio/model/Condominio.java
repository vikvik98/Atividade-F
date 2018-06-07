package com.example.roberthsantos.condominio.model;

import com.orm.SugarRecord;

import java.util.Date;

public class Condominio extends SugarRecord{

    private String mesAno;
    private Date dataPagamento;
    private double valorPago;
    private double valorAPagar;
    private Apartamento apartamento;

    public Condominio() {

    }
}
