package dominando.android.multiapp.activity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import dominando.android.multiapp.R;

public class CaraCoroaTwoActivity extends AppCompatActivity {

    private TextView nomeJogadorUm, nomeJogadorDois, pontuacaoJogUm, pontuacaoJogDois;
    private Button btnGirarMoeda;
    private ProgressBar progressCaraCoroa;
    private int contaProgresso = 0, pontoJogadorUm = 0, pontoJogadorDois = 0;

    private ImageView moedaResultado;

    @SuppressLint("SourceLockedOrientationActivity")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caracoroatwo);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Para matar a execução da aplicação de vez
        Button btnVoltar = findViewById(R.id.buttonVoltar);
        btnVoltar.setOnClickListener(v -> finish());

        // Instanciando os elementos da tela
        progressCaraCoroa = findViewById(R.id.progressCaraCoroa);
        moedaResultado = findViewById(R.id.moedaPadraoResult);
        nomeJogadorUm = findViewById(R.id.nomeJogadorUm);
        nomeJogadorDois = findViewById(R.id.nomeJogadorDois);
        pontuacaoJogUm = findViewById(R.id.pontuacaoUm);
        pontuacaoJogDois = findViewById(R.id.pontuacaoDois);

        // Recebendo os dados da tela anterior
        Bundle dados = getIntent().getExtras();
        assert dados != null;
        String nomeJogadorUm = dados.getString("nomeJogadorUm");
        String nomeJogadorDois = dados.getString("nomeJogadorDois");

        // Passando os dados para os elementos da tela
        this.nomeJogadorUm.setText(nomeJogadorUm);
        this.nomeJogadorDois.setText(nomeJogadorDois);

        btnGirarMoeda = findViewById(R.id.btnGirarMoeda);
        btnGirarMoeda.setOnClickListener(this::girarMoeda);

    }

    // Método para girar a moeda e passar os pontos para os jogadores, também com o progress bar e com animações
    public void girarMoeda(View view) {

        // Torna o button invisivel e o progress bar visivel
        progressCaraCoroa.setVisibility(View.VISIBLE);

        contaProgresso++;
        progressCaraCoroa.setProgress(contaProgresso);

        // Animação de rotação da moeda durante o processo do progress bar
        if (contaProgresso >= 0 && contaProgresso <= 6) {

            float grauRotacao = (360f / 6) * contaProgresso; // Dividindo 360 graus ao longo de 6 etapas
            moedaResultado.animate().setDuration(400).rotationY(grauRotacao);
            moedaResultado.setImageResource(R.drawable.moeda_padrao);
        }


        if (contaProgresso == 7) {
            // Chance de 50% de vencer
            int numeroAleatorio = (int) (Math.random() * 2);

            // Após o fim da animação, executa as mudanças de imagens e atualiza pontos
            moedaResultado.animate().setDuration(400).rotationY(360f).withEndAction(() -> {

                switch (numeroAleatorio) {

                    case 0: // Cara
                        moedaResultado.setImageResource(R.drawable.moeda_cara);
                        pontoJogadorUm++;
                        pontuacaoJogUm.setText(String.valueOf(pontoJogadorUm));

                        Toast.makeText(this, nomeJogadorUm.getText().toString() + " venceu!", Toast.LENGTH_SHORT).show();
                        break;

                    case 1: // Coroa
                        moedaResultado.setImageResource(R.drawable.moeda_coroa);
                        pontoJogadorDois++;
                        pontuacaoJogDois.setText(String.valueOf(pontoJogadorDois));

                        Toast.makeText(this, nomeJogadorDois.getText().toString() + " venceu!", Toast.LENGTH_SHORT).show();
                        break;
                }

                // Zera contador e torna invisivel o progress bar e button
                contaProgresso = 0;
                progressCaraCoroa.setVisibility(View.INVISIBLE);
                btnGirarMoeda.postDelayed(() -> btnGirarMoeda.setVisibility(View.INVISIBLE), 1);

            });

            btnGirarMoeda.postDelayed(() -> btnGirarMoeda.setVisibility(View.VISIBLE), 2000);
        }

    }

}