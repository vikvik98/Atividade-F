package com.example.roberthsantos.condominio.model;

public enum EnumTipoOcupacao {

    PROPRIETARIO(1),
    INQUILINO(2),
    VAZIO(3);

    private final int opOcupacao;

    EnumTipoOcupacao(int opOcupacao){
        this.opOcupacao = opOcupacao;
    }

    public int getOpOcupacao(){
        return opOcupacao;
    }


}
