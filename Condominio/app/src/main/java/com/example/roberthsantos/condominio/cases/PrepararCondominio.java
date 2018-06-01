package com.example.roberthsantos.condominio.cases;

import android.widget.EditText;

import java.util.IllegalFormatException;

public class PrepararCondominio {

    public void verificaNomeDespesa(String nome){
        if (nome.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    public boolean verificarMesDespesa(EditText mesDespesa){
        if (mesDespesa.getText().toString().length() > 4 && mesDespesa.getText().toString().charAt(3) == '/'){
            return true;
        }
        throw new IllegalAccessError();
    }

    public void calcularCondominio(){

    }
}
