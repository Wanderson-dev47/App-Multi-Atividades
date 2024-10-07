package dominando.android.multiapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dominando.android.multiapp.R;
import dominando.android.multiapp.listener.RecyclerItemClickListener;
import dominando.android.multiapp.adapter.AdapterOpcoes;
import dominando.android.multiapp.model.OpcaoEscolha;

public class MainActivity extends AppCompatActivity {

    private final List<OpcaoEscolha> opcaoEscolhaLista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Chamada da função que adiciona as opcoes
        criarButoes();

        // Configurando adapter opcões
        AdapterOpcoes adapter = new AdapterOpcoes(opcaoEscolhaLista);

        // Configuração do Recycler View da aplicação
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        // Criação do Click Listener do Recycler View para os botões de redirecionamento
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        OpcaoEscolha opcao = opcaoEscolhaLista.get(position);

                        if (opcao.getOpcao() == R.string.opcao1) {
                            startActivity(new Intent(MainActivity.this, FrasesDoDiaActivity.class));

                        } else if (opcao.getOpcao() == R.string.opcao2) {
                            startActivity(new Intent(MainActivity.this, JokenpoActivity.class));

                        } else if (opcao.getOpcao() == R.string.opcao3) {
                            startActivity(new Intent(MainActivity.this, AlcoolOuGasolinaActivity.class));

                        } else if (opcao.getOpcao() == R.string.opcao4) {
                            startActivity(new Intent(MainActivity.this, CalculadoraGorjetaActivity.class));

                        } else if (opcao.getOpcao() == R.string.opcao5) {
                            startActivity(new Intent(MainActivity.this, CardViewActivity.class));

                        } else if (opcao.getOpcao() == R.string.opcao6) {
                            startActivity(new Intent(MainActivity.this, CaraCoroaActivity.class));

                        }
                    }

                    // Para quando o usuário pressionar e segurar o botão exibir mensagem de seleção
                    @Override
                    public void onLongItemClick(View view, int position) {
                        OpcaoEscolha opcao = opcaoEscolhaLista.get(position);

                        if (opcao.getOpcao() == R.string.opcao1) {
                            Toast.makeText(MainActivity.this, "Frases do Dia", Toast.LENGTH_SHORT).show();

                        } else if (opcao.getOpcao() == R.string.opcao2) {
                            Toast.makeText(MainActivity.this, "Jokenpô", Toast.LENGTH_SHORT).show();

                        } else if (opcao.getOpcao() == R.string.opcao3) {
                            Toast.makeText(MainActivity.this, "Álcool ou Gasolina", Toast.LENGTH_SHORT).show();

                        } else if (opcao.getOpcao() == R.string.opcao4) {
                            Toast.makeText(MainActivity.this, "Calculadora de Gorjeta", Toast.LENGTH_SHORT).show();

                        } else if (opcao.getOpcao() == R.string.opcao5) {
                            Toast.makeText(MainActivity.this, "CardView", Toast.LENGTH_SHORT).show();

                        } else if (opcao.getOpcao() == R.string.opcao6) {
                            Toast.makeText(MainActivity.this, "Cara ou Coroa", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }
        ));

    }

    public void criarButoes() {

        opcaoEscolhaLista.add(new OpcaoEscolha(R.string.opcao1));
        opcaoEscolhaLista.add(new OpcaoEscolha(R.string.opcao2));
        opcaoEscolhaLista.add(new OpcaoEscolha(R.string.opcao3));
        opcaoEscolhaLista.add(new OpcaoEscolha(R.string.opcao4));
        opcaoEscolhaLista.add(new OpcaoEscolha(R.string.opcao5));
        opcaoEscolhaLista.add(new OpcaoEscolha(R.string.opcao6));

    }


}