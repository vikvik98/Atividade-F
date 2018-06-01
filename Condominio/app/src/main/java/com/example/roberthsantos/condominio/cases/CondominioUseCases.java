package com.example.roberthsantos.condominio.cases;

import android.widget.EditText;

import com.example.roberthsantos.condominio.model.Apartamento;
import com.example.roberthsantos.condominio.model.Proprietario;


public class CondominioUseCases {

    public Apartamento adicionarApartamento(EditText numero, EditText quantQuartos, EditText proprietario, EditText telefone){

        Apartamento apartamento1 = new Apartamento();
        Proprietario proprietario1 = new Proprietario();

        int numeroApt = Integer.valueOf(numero.getText().toString());
        int quantQuarto = Integer.valueOf(quantQuartos.getText().toString());

        proprietario1.setNome(proprietario.getText().toString());
        proprietario1.setTelefone(telefone.getText().toString());

        apartamento1.setNumeroDoAp(numeroApt);
        apartamento1.setQtdQuartos(quantQuarto);
        //apartamento1.getProprietario().setTarget(proprietario1);
        return apartamento1;
    }

    //public void verificarApartamento(Box<Apartamento> apartamentoBox, int numeroApartamento){
    //    List<Apartamento> apartamentos = apartamentoBox
    //           .query()
    //           .equal(Apartamento_.numero,numeroApartamento)
    //            .build()
    //           .find();

    //   if (apartamentos.size() > 0){
    //       throw new IllegalArgumentException();
    //    }
    //}

    //TODO : perguntar ao prof se as verificações dos dados recebidos, como a verificação se há ou nao
    //TODO : proprietario ou se ja existe um apt com o msm numero ficam nos casos de uso ou na propria Activity!?

//    public void verificaProprietario(CheckBox checkOcupado){
//        if (checkOcupado.isChecked()){
//            if ()
//        }
//    }




}
