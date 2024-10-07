package dominando.android.multiapp.activity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import dominando.android.multiapp.R;

public class CalculadoraGorjetaActivity extends AppCompatActivity {

    private TextInputEditText entradaGorjeta;
    private TextView textPorcentagem, textGorjeta, textTotal;

    private double procentagemGorjeta = 0;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadoragorjeta);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Para matar a execução de vez
        Button buttonVoltar = findViewById(R.id.buttonVoltar);
        buttonVoltar.setOnClickListener(view -> finish());

        entradaGorjeta = findViewById(R.id.entradaGorjeta);
        textGorjeta = findViewById(R.id.textGorjeta);
        textTotal = findViewById(R.id.textTotal);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        SeekBar seekBarGojeta = findViewById(R.id.seekBarGorjeta);

        // Listener do SeekBar para atualizar porcentagem
        seekBarGojeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                procentagemGorjeta = progress;

                // Função da class Math que arredonda para valor inteiro e exibe porcentagem em tempo real
                textPorcentagem.setText(Math.round(procentagemGorjeta) + " %");

                calcularValor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Essa verificação garante que o Alert Dialog apareca somente uma vez após alteração no seekBar(na ausencia de dados)
                verificarEExibirDialog();

            }
        });

    }


    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void calcularValor() {

        // Recuperação do dado fornecido pelo usuário
        String valorEntrada = Objects.requireNonNull(entradaGorjeta.getText()).toString();

        if (valorEntrada.isEmpty()) {
            // Para que seja focado automaticamente no campo de entrada
            entradaGorjeta.requestFocus();

            // Para fins de debug, um log para saber se a condição foi satisfeita
            Log.d("Calculadora Gorjeta", "O campo de entrada está vázio!");
        } else {

            // Aqui é feito a conversão para double do valor de entrada
            double valorDouble = Double.parseDouble(valorEntrada);

            // Calculo da Gorjeta
            double gorjeta = valorDouble * (procentagemGorjeta / 100);
            double total = gorjeta + valorDouble;

            // Exibição dos valores gorjeta e total na tela
            textGorjeta.setText("R$ " + String.format("%.2f", gorjeta));
            textTotal.setText("R$ " + String.format("%.2f", total));

        }

    }

    public void abrirDialog() {
        /*
        /* 4 Etapas para criar um AlertDialog
        /* 1 - Instanciar AlertDialog
        /* 2 - Configurar titulo e mensagem
        /* 3 - Configurar ações
        /* 4 - Criar e exibir AlertDialog
        */
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Houve um problema :(")
                .setMessage("Para que seja possível prosseguir com o cálculo é preciso informar um valor antes!")
                .setIcon(android.R.drawable.ic_menu_info_details)
                .setPositiveButton("Certo!", (dialog1, which) -> {})
                .create()
                .show();
    }

    @SuppressLint("SetTextI18n")
    public void verificarEExibirDialog() {
        // Para verificar se está vázio o campo de entrada
        String valorEntrada = Objects.requireNonNull(entradaGorjeta.getText()).toString();

        if (valorEntrada.isEmpty()) {
            abrirDialog();

            //Zera quaisquer valores que tiver sido exibido anteriormente
            textGorjeta.setText("R$ 0,00");
            textTotal.setText("R$ 0,00");
        }
    }

}