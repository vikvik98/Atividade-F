package com.example.roberthsantos.condominio.controllers;

import android.widget.EditText;

import com.example.roberthsantos.condominio.cases.ManterApartamento;
import com.example.roberthsantos.condominio.model.Apartamento;

public class ApartamentoController {

    public Apartamento cadastrarApartamento(EditText numeroAp, EditText qtdQuarto){
        int numero = Integer.parseInt(numeroAp.getText().toString());
        int quantQuartos = Integer.parseInt(qtdQuarto.getText().toString());

        ManterApartamento manterApartamento = new ManterApartamento();
        return manterApartamento.cadastrarApartamento(numero,quantQuartos);
    }
}
