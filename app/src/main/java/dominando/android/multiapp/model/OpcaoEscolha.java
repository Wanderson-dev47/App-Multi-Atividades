package dominando.android.multiapp.model;

import android.widget.Button;

public class OpcaoEscolha {
    private int opcao;

    public OpcaoEscolha() {
    }

    public OpcaoEscolha(int opcao) {
        this.opcao = opcao;
    }

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

}
