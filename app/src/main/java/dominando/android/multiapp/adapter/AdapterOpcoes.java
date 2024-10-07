package dominando.android.multiapp.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dominando.android.multiapp.R;
import dominando.android.multiapp.model.OpcaoEscolha;

public class AdapterOpcoes extends RecyclerView.Adapter<AdapterOpcoes.MyViewHolder> {

    private final List<OpcaoEscolha> opcaoEscolhaLista;

    public AdapterOpcoes(List<OpcaoEscolha> lista) {
        this.opcaoEscolhaLista = lista;
    }

    // Inflando o layout de opções para serem exibidas em lista
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View opc = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.opcoes_lista, parent, false);

        return new MyViewHolder(opc);
    }

    // Para atualizar a lista com os dados
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        OpcaoEscolha opcaoEscolha = opcaoEscolhaLista.get(position);

        holder.opcao.setText(opcaoEscolha.getOpcao());
    }

    // Para exibir a quantidade completa de opções
    @Override
    public int getItemCount() {
        return opcaoEscolhaLista.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        Button opcao;

        @SuppressLint("WrongViewCast")
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            opcao = itemView.findViewById(R.id.buttonOpcoes);
        }
    }

}
