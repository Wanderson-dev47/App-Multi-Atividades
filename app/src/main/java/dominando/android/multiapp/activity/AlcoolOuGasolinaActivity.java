package dominando.android.multiapp.activity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import dominando.android.multiapp.R;

public class AlcoolOuGasolinaActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textoResultado;
    private ProgressBar progressBar;
    private Button buttonCalcular;

    @SuppressLint({"SourceLockedOrientationActivity", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcoolougasolina);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Para matar a tela de uma vez e voltar para a anterior
        Button buttonVoltar = findViewById(R.id.buttonVoltar);
        buttonVoltar.setOnClickListener(view -> finish());

        editPrecoAlcool = findViewById(R.id.entradaAlcool);
        editPrecoGasolina = findViewById(R.id.entradaGas);
        textoResultado = findViewById(R.id.textGasOuAl);
        progressBar = findViewById(R.id.progressBar);
        buttonCalcular = findViewById(R.id.buttonCalcular);

        buttonCalcular.setOnClickListener(this::calcularPrecos);
    }

    @SuppressLint("SetTextI18n")
    public void calcularPrecos(View view) {

        // Variáveis que guardará os dados fornecidos pelo usuário
        String precoAlcool = Objects.requireNonNull(editPrecoAlcool.getText()).toString();
        String precoGas = Objects.requireNonNull(editPrecoGasolina.getText()).toString();

        // Aqui nem precisa de comentários... (ou precisa?)
        Boolean autorizarProgressao = validarCampos(precoAlcool, precoGas);

        if (autorizarProgressao) {

            // Exibição do progressBar e ocultação do botão
            buttonCalcular.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);

            new Handler(Looper.getMainLooper()).postDelayed(() -> {

                // Será preciso converter os valores para double
                Double valorAlcool = Double.parseDouble(precoAlcool);
                Double valorGas = Double.parseDouble(precoGas);

                /* Se (valorAlcool / valorGasolina) >=(maior ou igual) 0.7 é melhor utilizar gasolina
                 * senão é melhor utilizar álcool
                 */

                double resultCalculo = valorAlcool / valorGas;

                if (resultCalculo >= 0.7) {
                    textoResultado.setText("Melhor utilizar Gasolina!");

                } else {
                    textoResultado.setText("Melhor utilizar Alcool!");
                }

                // Esconder progressBar após o calculo e exibir botão
                progressBar.setVisibility(View.GONE);
                buttonCalcular.setVisibility(View.VISIBLE);
            }, 700);

        } else {
            // Se a validação não for true, então...
            Toast.makeText(this, "Preencha os dados primeiro!", Toast.LENGTH_SHORT).show();
        }

    }

    // Método para validação dos campos
    public Boolean validarCampos(String pAlcool, String pGasolina) {

        boolean autorizacao = true;

        if (pAlcool == null || pAlcool.isEmpty()) {
            autorizacao = false;
        } else if (pGasolina == null || pGasolina.isEmpty()) {
            autorizacao = false;
        }

        return autorizacao;

    }

}