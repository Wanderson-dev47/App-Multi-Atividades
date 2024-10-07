package dominando.android.multiapp.activity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import dominando.android.multiapp.R;

public class FrasesDoDiaActivity extends AppCompatActivity {

    String[] frasesDoDia = {
            "Acredite em si mesmo e você será imparável.",
            "Cada dia é uma nova oportunidade para brilhar.",
            "Se você pode sonhar, pode realizar.",
            "A persistência leva ao sucesso.",
            "A jornada mais longa começa com um único passo.",
            "Sua determinação é sua maior força.",
            "O sucesso é a soma de pequenos esforços repetidos dia após dia.",
            "Encare cada desafio como uma chance de crescimento.",
            "Grandes coisas nunca vêm da zona de conforto.",
            "Mude seus pensamentos e você mudará seu mundo.",
            "A adversidade revela o verdadeiro campeão que há em você.",
            "Você é mais forte do que imagina.",
            "O que você faz hoje pode melhorar todos os amanhãs.",
            "Acredite no poder dos seus sonhos e siga em frente.",
            "Você não pode mudar o vento, mas pode ajustar as velas do barco.",
            "A coragem não é a ausência do medo, mas a capacidade de avançar apesar dele.",
            "O sucesso é um reflexo do esforço que você coloca em seus objetivos.",
            "Não espere por oportunidades, crie-as.",
            "Cada dificuldade é uma chance de crescimento.",
            "A felicidade não é o destino, é o caminho.",
            "Viva o presente, prepare-se para o futuro e aprenda com o passado.",
            "A melhor maneira de prever o futuro é criá-lo.",
            "Nada é impossível para quem tem coragem de tentar.",
            "A sua atitude determina sua altitude.",
            "Transforme suas feridas em sabedoria.",
            "A ação é a chave fundamental para todo sucesso.",
            "Nunca é tarde demais para ser aquilo que você sempre quis ser.",
            "Acredite que você pode e você já está no meio do caminho.",
            "Tenha fé no processo, cada etapa é uma vitória.",
            "Você não precisa ver toda a escada, apenas dê o primeiro passo.",
            "Quando você faz o melhor que pode, você nunca se arrepende.",
            "O sucesso é a capacidade de ir de fracasso em fracasso sem perder o entusiasmo.",
            "O melhor ainda está por vir, continue avançando.",
            "Acredite que coisas boas estão por vir.",
            "Toda conquista começa com a decisão de tentar.",
            "Seja a mudança que você quer ver no mundo.",
            "O sucesso é uma jornada, não um destino.",
            "O que você faz hoje pode transformar seu amanhã.",
            "Cada momento é uma chance para recomeçar.",
            "Desafios são oportunidades disfarçadas.",
            "Você é o autor da sua própria história.",
            "O futuro pertence àqueles que acreditam na beleza de seus sonhos.",
            "Acredite que você é capaz de muito mais do que imagina.",
            "Pequenas atitudes positivas somam grandes resultados.",
            "A paciência é a chave para o sucesso.",
            "Não desista, a vitória pode estar mais próxima do que você pensa.",
            "Seja grato pelo que tem, enquanto trabalha pelo que deseja.",
            "O único limite para o seu sucesso é a sua mente.",
            "Não há elevador para o sucesso, você precisa subir os degraus.",
            "Acredite no poder do agora.",
            "Seja forte o suficiente para seguir em frente, mesmo quando ninguém acredita.",
            "O fracasso é apenas uma oportunidade de recomeçar com mais experiência.",
            "O esforço de hoje é a vitória de amanhã."
    };


    @SuppressLint({"MissingInflatedId", "SourceLockedOrientationActivity"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frasesdodia);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Para resgatar onde será exibido a nova mensagem
        TextView textResultado = findViewById(R.id.resultadoFrase);

        // Para matar a tela de uma vez e voltar para a anterior
        Button buttonVoltar = findViewById(R.id.buttonVoltar);
        buttonVoltar.setOnClickListener(view -> finish());

        // Ouvinte para geração de novas frases, exibidas aleatoriamente
        Button buttonGerar = findViewById(R.id.buttonGerar);
        buttonGerar.setOnClickListener(view -> {

            int fraseAleatoria = (int) (Math.random() * frasesDoDia.length);
            textResultado.setText(frasesDoDia[fraseAleatoria]);
        });
    }
}