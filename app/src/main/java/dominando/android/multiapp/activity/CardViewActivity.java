package dominando.android.multiapp.activity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dominando.android.multiapp.R;
import dominando.android.multiapp.adapter.AdapterPostagem;
import dominando.android.multiapp.model.Postagem;

public class CardViewActivity extends AppCompatActivity {

    private final List<Postagem> postagensLista = new ArrayList<>();

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Para matar a tela de uma vez e voltar para a anterior
        Button buttonVoltar = findViewById(R.id.buttonVoltar);
        buttonVoltar.setOnClickListener(view -> finish());

        // Chamada do elemento recycler view
        RecyclerView recyclerPost = findViewById(R.id.recyclerPost);

        // Configuração do Adapter
        this.adicionarPostagens();
        AdapterPostagem adapterPostagem = new AdapterPostagem(postagensLista);

        // Configuração do Recycler View do CardView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerPost.setLayoutManager(layoutManager);
        recyclerPost.setAdapter(adapterPostagem);
        recyclerPost.setHasFixedSize(true);

    }

    public void adicionarPostagens() {
        postagensLista.add(new Postagem("Wanderson Brito", "#TBT Viagem Legal", R.drawable.imagem1));
        postagensLista.add(new Postagem("Hotel JM", "Viaje, aproveite nossos descontos!", R.drawable.imagem2));
        postagensLista.add(new Postagem("Maria Luiza", "#Paris!!", R.drawable.imagem3));
        postagensLista.add(new Postagem("Marcos Paulo", "Que fofo linda!", R.drawable.imagem4));
        postagensLista.add(new Postagem("Roronoa Zoro", "Sem treino, sem ganho!", R.drawable.imagem5));
    }
}