package com.example.roberthsantos.condominio.cases;

import com.example.roberthsantos.condominio.model.Apartamento;
import com.example.roberthsantos.condominio.model.Proprietario;

import java.util.ArrayList;
import java.util.List;

public class ManterApartamento {

    private List<Apartamento> apartamentos;

    public ManterApartamento() {
        this.apartamentos = new ArrayList<>();
    }

    public void CadastrarApartamento(int numero, int qtdQuartos){
        //TODO: Tratamento para saber se tem proprietario ou nao
        Apartamento apartamento = new Apartamento();
        apartamento.setNumeroDoAp(numero);
        apartamento.setQtdQuartos(qtdQuartos);
        apartamentos.add(apartamento);
    }

    public void AssociarProprietario(int numeroAp, String nomeProprietario){
        Apartamento apartamento = new Apartamento();
        for(int i = 0; i < apartamentos.size(); i++){
            if(apartamentos.get(i).getNumeroDoApp() == numeroAp){
                apartamento = apartamentos.get(i);
            }
        }


    }



    public List<Apartamento> getApartamentos() {
        return apartamentos;
    }

    public void setApartamentos(List<Apartamento> apartamentos) {
        this.apartamentos = apartamentos;
    }

}
