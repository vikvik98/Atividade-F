package com.example.roberthsantos.condominio.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.roberthsantos.condominio.R;
import com.example.roberthsantos.condominio.model.Apartamento;

import java.util.List;

public class ListaApartamentosAdapter extends RecyclerView.Adapter<ListaApartamentosAdapter.ViewHolder> {

    private final Context context;
    private final List<Apartamento> apartamentos;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cardview_apartamento,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Apartamento apartamento = this.apartamentos.get(position);
        try {
            holder.tvPropietario.setText(apartamento.getProprietario().getNome());
        }catch (NullPointerException e){
            holder.tvPropietario.setText("Apartamento vazio.");
        }
        holder.tvNumeroApartamento.setText("" + apartamento.getNumeroDoAp());

    }

    @Override
    public int getItemCount() {
        return apartamentos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        protected TextView tvPropietario;
        protected TextView tvNumeroApartamento;

        public ViewHolder(View itemView){
            super(itemView);

            tvPropietario = (TextView) itemView.findViewById(R.id.nome_proprietario);
            tvNumeroApartamento = (TextView) itemView.findViewById(R.id.numero_apt);
        }
    }
    public ListaApartamentosAdapter(Context context, List<Apartamento> apartamentos){

        this.context = context;
        this.apartamentos = apartamentos;
    }

}
