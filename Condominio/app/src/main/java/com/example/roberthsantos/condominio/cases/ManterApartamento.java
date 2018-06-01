package com.example.roberthsantos.condominio.cases;

import android.widget.EditText;

import com.example.roberthsantos.condominio.model.Apartamento;
import com.example.roberthsantos.condominio.model.Proprietario;

import java.util.ArrayList;
import java.util.List;

public class ManterApartamento extends ManterProprietario{

    private List<Apartamento> apartamentos;


    public ManterApartamento() {
        this.apartamentos = new ArrayList<>();
    }

    public boolean cadastrarApartamento(EditText numeroAp, EditText qtdQuarto){
        Apartamento apartamento = new Apartamento();
        int numero = Integer.valueOf(numeroAp.getText().toString());
        int qtdQuartos = Integer.valueOf(qtdQuarto.getText().toString());
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

    public boolean associarProprietario(EditText numeroApt, EditText nomeProprietarios){
        Apartamento apartamento = new Apartamento();
        int numeroAp = Integer.valueOf(numeroApt.getText().toString());
        int nomeProprietario = Integer.valueOf(nomeProprietarios.getText().toString());
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
            }
        }

        return false;
    }

    public boolean verificarApartamentoExistente(int numeroDoAp){
        for(int i = 0; i < apartamentos.size(); i++){
            if(apartamentos.get(i).getNumeroDoAp() == numeroDoAp){
                return true;
            }
        }
        return false;
    }

    public int verificarQuantidadeTotalDeQuartos(){
        int quartos = 0;
        for(int i = 0; i < apartamentos.size(); i++){
            quartos += apartamentos.get(i).getQtdQuartos();
        }
        return quartos;
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
