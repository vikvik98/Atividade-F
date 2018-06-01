package com.example.roberthsantos.condominio.model;

import com.orm.SugarRecord;

public class Apartamento extends SugarRecord {

    private int numeroDoAp;
    private int qtdQuartos;
    private Proprietario proprietario;
    private EnumTipoOcupacao opDoEnum;


    public Apartamento() {

    }


    public void setNumeroDoAp(int numero) {
        this.numeroDoAp = numero;
    }

    public void setQtdQuartos(int qtdQuartos) {
        this.qtdQuartos = qtdQuartos;
    }


    public int getNumeroDoApp() {
        return numeroDoAp;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
}
