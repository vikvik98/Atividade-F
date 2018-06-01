package com.example.roberthsantos.condominio.model;

import com.orm.SugarRecord;

public class Apartamento extends SugarRecord {

    private int numeroDoAp;
    private int qtdQuartos;
    private boolean ocupado;
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

    public int getNumeroDoAp() {
        return numeroDoAp;
    }

    public int getQtdQuartos() {
        return qtdQuartos;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public EnumTipoOcupacao getOpDoEnum() {
        return opDoEnum;
    }

    public void setOpDoEnum(EnumTipoOcupacao opDoEnum) {
        this.opDoEnum = opDoEnum;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
}
