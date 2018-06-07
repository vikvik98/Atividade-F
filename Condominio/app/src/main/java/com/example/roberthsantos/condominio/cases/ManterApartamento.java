package com.example.roberthsantos.condominio.cases;

import android.widget.EditText;

import com.example.roberthsantos.condominio.model.Apartamento;
import com.example.roberthsantos.condominio.model.Proprietario;

import java.util.ArrayList;
import java.util.List;

public class  ManterApartamento extends ManterProprietario{

    private List<Apartamento> apartamentos = Apartamento.listAll(Apartamento.class);


    public ManterApartamento() {

    }

    public Apartamento cadastrarApartamento(int numeroAp, int qtdQuarto){

        Apartamento apartamento = new Apartamento();
        apartamento.setNumeroDoAp(numeroAp);
        apartamento.setQtdQuartos(qtdQuarto);

        for(int i = 0; i < apartamentos.size(); i++){
            if(apartamentos.get(i).getNumeroDoAp() == numeroAp){
                //tem que ter um TOAST aqui
                break;
            }else {
                apartamento.setNumeroDoAp(numeroAp);
                apartamento.setQtdQuartos(qtdQuarto);
                //apartamentos.add(apartamento);
                return apartamento;
            }
        }
        return apartamento;
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
        throw new IllegalArgumentException();
    }

    public int verificarQuantidadeTotalDeQuartos(){
        int quartos = 0;
        for(int i = 0; i < apartamentos.size(); i++){
            quartos += apartamentos.get(i).getQtdQuartos();
        }
        return quartos;
    }

    public List<Apartamento> verificarApartamentosOcupados(){
        List<Apartamento> apartamentosProprietarios = new ArrayList<>();
        for(int i = 0; i < apartamentos.size(); i++){
            if(apartamentos.get(i).getProprietario() != null){
                apartamentosProprietarios.add(apartamentos.get(i));
            }
        }
        return apartamentosProprietarios;
    }

    public Apartamento verificarApartamento(int numeroAp){
        for(int i = 0; i < apartamentos.size(); i++){
            if(apartamentos.get(i).getNumeroDoAp() == numeroAp){
                return apartamentos.get(i);
            }
        }
        return null;
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
