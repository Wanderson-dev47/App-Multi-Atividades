package dominando.android.multiapp.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import dominando.android.multiapp.R;

public class JokenpoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokenpo);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        // Para matar a tela de uma vez e voltar para a anterior
        Button buttonVoltar = findViewById(R.id.buttonVoltar);
        buttonVoltar.setOnClickListener(view -> finish());

        // Criação e instancia dos botões e chamada das funções que resgata o clique do usuário
        ImageView imagePedra = findViewById(R.id.imagePedra);
        selecionarPedra(imagePedra);

        ImageView imagePapel = findViewById(R.id.imagePapel);
        selecionarPapel(imagePapel);

        ImageView imageTesoura = findViewById(R.id.imageTesoura);
        selecionarTesoura(imageTesoura);

    }


    public void selecionarPedra(View cliqueUsuario) {

        cliqueUsuario.setOnClickListener(v -> {
            animarClique(cliqueUsuario);
            this.opcaoSelecionar("Pedra");
        });
    }

    public void selecionarPapel(View cliqueUsuario) {

        cliqueUsuario.setOnClickListener(v -> {
            animarClique(cliqueUsuario);
            this.opcaoSelecionar("Papel");
        });
    }

    public void selecionarTesoura(View cliqueUsuario) {

        cliqueUsuario.setOnClickListener(v -> {
            animarClique(cliqueUsuario);
            this.opcaoSelecionar("Tesoura");
        });
    }


    @SuppressLint("SetTextI18n")
    public void opcaoSelecionar(String opcaoUsuario) {

        ImageView imagemResultado = findViewById(R.id.imagePadrao);
        TextView textResultadoApp = findViewById(R.id.textAppResultado);
        TextView textResultadoUser = findViewById(R.id.textResultadoUser);
        TextView feedbackResultado = findViewById(R.id.feedbackJokenpo);

        // Opções aleatórias do App
        int aleatorio = (int) (Math.random() * 3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String opcaoApp = opcoes[aleatorio];


        // Para o usuário enxergar de maneira visual a opção do App em tempo real
        switch (opcaoApp) {
            case "Pedra":
                imagemResultado.animate().rotationY(90f).setDuration(100).withEndAction(() -> {
                    imagemResultado.setImageResource(R.drawable.pedra);
                    imagemResultado.animate().rotationY(0f).setDuration(100).start();
                });
                break;

            case "Papel":
                imagemResultado.animate().rotationY(90f).setDuration(100).withEndAction(() -> {
                    imagemResultado.setImageResource(R.drawable.papel);
                    imagemResultado.animate().rotationY(0f).setDuration(100).start();
                });
                break;

            case "Tesoura":
                imagemResultado.animate().rotationX(90f).setDuration(100).withEndAction(() -> {
                    imagemResultado.setImageResource(R.drawable.tesoura);
                    imagemResultado.animate().rotationX(0f).setDuration(100).start();
                });
                break;
        }

        // Feedback das opções do usuário e do App para mostrar na tela
        if (
                opcaoUsuario.equals("Pedra") && opcaoApp.equals("Tesoura") ||
                        opcaoUsuario.equals("Papel") && opcaoApp.equals("Pedra") ||
                        opcaoUsuario.equals("Tesoura") && opcaoApp.equals("Papel")
        ) {
            textResultadoApp.setText("Aplicativo escolheu: " + opcaoApp);
            textResultadoUser.setText("Você escolheu: " + opcaoUsuario);
            animarFeedbackZoomIn(feedbackResultado, "Você venceu!");

        } else if (
                opcaoApp.equals("Pedra") && opcaoUsuario.equals("Tesoura") ||
                        opcaoApp.equals("Papel") && opcaoUsuario.equals("Pedra") ||
                        opcaoApp.equals("Tesoura") && opcaoUsuario.equals("Papel")
        ) {
            textResultadoApp.setText("Aplicativo escolheu: " + opcaoApp);
            textResultadoUser.setText("Você escolheu: " + opcaoUsuario);
            animarFeedbackZoomIn(feedbackResultado, "Você perdeu!");

        } else {
            textResultadoApp.setText("Aplicativo escolheu: " + opcaoApp);
            textResultadoUser.setText("Você escolheu: " + opcaoUsuario);
            animarFeedbackZoomIn(feedbackResultado, "Empate!");
        }

        // Para verificar no logcat
        String tag = "Item clicado -> ";
        System.out.println(tag + "App escolheu: " + opcaoApp);
        System.out.println(tag + "Usuário escolheu: " + opcaoUsuario);

    }

    private void animarClique(View view) {
        // Cria animação de escala (aumento e diminuição do tamanho) com scaleUp para aumentar e scaleDown para diminuir
        ObjectAnimator scaleXUp = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.2f);
        ObjectAnimator scaleYUp = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.2f);
        ObjectAnimator scaleXDown = ObjectAnimator.ofFloat(view, "scaleX", 1.2f, 1f);
        ObjectAnimator scaleYDown = ObjectAnimator.ofFloat(view, "scaleY", 1.2f, 1f);

        // Definição de duração das animações
        scaleXUp.setDuration(100);
        scaleYUp.setDuration(100);
        scaleXDown.setDuration(100);
        scaleYDown.setDuration(100);

        // Uso do AnimatorSet para combinar as animações em sequência (aumento e depois diminuição)
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleXUp).with(scaleYUp); // Animando aumento ao mesmo tempo
        animatorSet.play(scaleXDown).with(scaleYDown).after(scaleXUp); // Havendo diminuição depois do aumento

        animatorSet.start();
    }

    public void animarFeedbackZoomIn(final TextView feedbackResultado, String feedback) {
        feedbackResultado.setText(feedback);

        // Inicialmente com tamanho reduzido
        feedbackResultado.setScaleX(0.3f);
        feedbackResultado.setScaleY(0.3f);

        // Tamanho normal
        feedbackResultado.animate()
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(300)
                .setListener(null);
    }

}