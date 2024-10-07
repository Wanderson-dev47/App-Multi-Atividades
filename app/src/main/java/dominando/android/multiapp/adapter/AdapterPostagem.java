package dominando.android.multiapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dominando.android.multiapp.R;
import dominando.android.multiapp.model.Postagem;

public class AdapterPostagem extends RecyclerView.Adapter<AdapterPostagem.MyViewHolder> {


    List<Postagem> postagensLista;

    // Construtor que recebe e atualiza a lista
    public AdapterPostagem(List<Postagem> lista) {
        this.postagensLista = lista;
    }

    // Criação do ViewHolder, inflando layout
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View postagemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_postagem, parent, false);

        return new MyViewHolder(postagemView);
    }

    // Método que atualiza o ViewHolder
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Postagem cardPostagem = postagensLista.get(position);
        holder.nome.setText(cardPostagem.getNome());
        holder.postagem.setText(cardPostagem.getPostagem());
        holder.imagem.setImageResource(cardPostagem.getImagem());

    }

    // Método que retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return postagensLista.size();
    }

    // Classe que cria o ViewHolder
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nome;
        TextView postagem;
        ImageView imagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.textNome);
            postagem = itemView.findViewById(R.id.textPostagem);
            imagem = itemView.findViewById(R.id.imagePostagem);
        }
    }
}
