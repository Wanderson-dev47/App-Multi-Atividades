package dominando.android.multiapp.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import dominando.android.multiapp.R;

public class CaraCoroaActivity extends AppCompatActivity {

    private EditText inputJogadorUm, inputJogadorDois;
    private Button btnJogar;

    @SuppressLint({"SourceLockedOrientationActivity", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_caracoroa);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Para matar a execução da aplicação de vez
        Button btnVoltar = findViewById(R.id.buttonVoltar);
        btnVoltar.setOnClickListener(v -> finish());

        inputJogadorUm = findViewById(R.id.inputJogadorUm);
        inputJogadorDois = findViewById(R.id.inputJogadorDois);

        btnJogar = findViewById(R.id.btnJogar);
        btnJogar.setOnClickListener(v -> iniciarJogo());

    }

    public void iniciarJogo() {

        // Convertendo para String e passando em seguida para validar com o método validarEntrada
        String jogadorUm = inputJogadorUm.getText().toString();
        String jogadorDois = inputJogadorDois.getText().toString();

        boolean validar = this.validarEntrada(jogadorUm, jogadorDois);

        if (validar) {

            // Passando os dados para a próxima tela
            Intent intent = new Intent(CaraCoroaActivity.this, CaraCoroaTwoActivity.class);
            intent.putExtra("nomeJogadorUm", jogadorUm);
            intent.putExtra("nomeJogadorDois", jogadorDois);

            // Faz a limpeza dos campos para não deixar armazenado, quando o usuário voltar
            inputJogadorDois.setText("");
            inputJogadorUm.setText("");

            // Instanciando image view e passando a imagem de confirmação
            ImageView imgConfirma = new ImageView(getApplicationContext());
            imgConfirma.setImageResource(R.drawable.confirm_svg);

            // Para mostrar a mensagem de confirmação
            Toast toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(imgConfirma);
            toast.show();

            btnJogar.postDelayed(() -> startActivity(intent), 1000);
        }

    }

    // Para tratar a ausência de dados nos dois campos de entrada
    public Boolean validarEntrada(String nomeUm, String nomeDois) {
        boolean validacao = false;

        if (nomeUm.isEmpty()) {
            inputJogadorUm.setError("Preencha esse campo!");

        } else if (nomeDois.isEmpty()) {
            inputJogadorDois.setError("Preencha esse campo!");

        } else {
            validacao = true;
        }


        return validacao;

    }

}