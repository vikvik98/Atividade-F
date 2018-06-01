package com.example.roberthsantos.condominio.cases;

import com.example.roberthsantos.condominio.model.Apartamento;
import com.example.roberthsantos.condominio.model.Proprietario;

import java.util.ArrayList;
import java.util.List;

public class ManterApartamento extends ManterProprietario{

    private List<Apartamento> apartamentos;

    public ManterApartamento() {
        this.apartamentos = new ArrayList<>();
    }

    public boolean CadastrarApartamento(int numero, int qtdQuartos){
        Apartamento apartamento = new Apartamento();
        for(int i = 0; i < apartamentos.size(); i++){
            if(apartamentos.get(i).getNumeroDoAp() == numero){
                return false;
            }else {
                apartamento.setNumeroDoAp(numero);
                apartamento.setQtdQuartos(qtdQuartos);
                apartamentos.add(apartamento);
                return true;
            }
        }
        return true;
    }

    public boolean AssociarProprietario(int numeroAp, String nomeProprietario){
        Apartamento apartamento = new Apartamento();
        for(int i = 0; i < apartamentos.size(); i++){
            if(apartamentos.get(i).getNumeroDoAp() == numeroAp){
                apartamento = apartamentos.get(i);
            }else{
                return false;
            }
        }

        for(int i = 0; i < getProprietarios().size(); i++){
            if(getProprietarios().get(i).getNome().equals(nomeProprietario)){
                apartamento.setProprietario(getProprietarios().get(i));
                getProprietarios().get(i).getApartamentos().add(apartamento);
                return true;
            }else {
                return false;
            }
        }

        return true;
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
