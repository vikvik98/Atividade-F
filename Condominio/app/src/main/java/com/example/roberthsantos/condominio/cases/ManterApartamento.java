package com.example.roberthsantos.condominio.cases;

import com.example.roberthsantos.condominio.model.Apartamento;
import com.example.roberthsantos.condominio.model.EnumTipoOcupacao;
import com.example.roberthsantos.condominio.model.Proprietario;

import java.util.ArrayList;
import java.util.List;

public class ManterApartamento extends ManterProprietario{

    private List<Apartamento> apartamentos;

    public ManterApartamento() {
        this.apartamentos = new ArrayList<>();
    }

    public boolean CadastrarApartamento(int numero, int qtdQuartos, EnumTipoOcupacao opDoEnum){
        Apartamento apartamento = new Apartamento();
        for(int i = 0; i < apartamentos.size(); i++){
            if(apartamentos.get(i).getNumeroDoAp() == numero){
                return false;
            }else {
                apartamento.setNumeroDoAp(numero);
                apartamento.setQtdQuartos(qtdQuartos);
                apartamento.setOpDoEnum(opDoEnum);
                apartamentos.add(apartamento);
                return true;
            }
        }
        return true;
    }

    public void AssociarProprietario(int numeroAp, String nomeProprietario){
        Apartamento apartamento = new Apartamento();
        for(int i = 0; i < apartamentos.size(); i++){
            if(apartamentos.get(i).getNumeroDoAp() == numeroAp){
                apartamento = apartamentos.get(i);
            }
        }

        for(int i = 0; i < getProprietarios().size(); i++){
            if(getProprietarios().get(i).getNome().equals(nomeProprietario)){
                getProprietarios().get(i).getApartamentos().add(apartamento);
            }
        }


    }

    @Override
    public List<Proprietario> getProprietarios() {
        return super.getProprietarios();
    }

    public List<Apartamento> getApartamentos() {
        return apartamentos;
    }

    public void setApartamentos(List<Apartamento> apartamentos) {
        this.apartamentos = apartamentos;
    }

}
