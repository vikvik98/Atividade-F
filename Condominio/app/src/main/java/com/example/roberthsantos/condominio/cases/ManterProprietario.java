package com.example.roberthsantos.condominio.cases;

import com.example.roberthsantos.condominio.model.Proprietario;

import java.util.List;

public class ManterProprietario {
    private List<Proprietario> proprietarios = Proprietario.listAll(Proprietario.class);
    Proprietario proprietario = new Proprietario();

    public ManterProprietario() {
    }

    public Proprietario cadastrarProprietario(String nomeProprietario, String telefoneProprietario){
        String nome = nomeProprietario;
        String telefone = telefoneProprietario;
        proprietario.setNome(nomeProprietario);
        proprietario.setTelefone(telefoneProprietario);
        for(int i = 0; i < proprietarios.size(); i++){
            if(getProprietarios().get(i).getNome().equals(nome) && getProprietarios().get(i).getTelefone().equals(telefone)){
                break;
            }else {
                proprietario.setNome(nome);
                proprietario.setTelefone(telefone);
                return proprietario;
            }
        }
        return proprietario;

    }

    public List<Proprietario> getProprietarios() {
        return proprietarios;
    }

    public void setProprietarios(List<Proprietario> proprietarios) {
        this.proprietarios = proprietarios;
    }
}
