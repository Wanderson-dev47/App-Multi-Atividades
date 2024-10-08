package dominando.android.multiapp.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import dominando.android.multiapp.R;

public class InfoFragment extends Fragment {

    public InfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_info, container, false);

        ImageView btnFechar = view.findViewById(R.id.btnFechar);
        btnFechar.setOnClickListener(view1 -> fecharInfo());

        // Adiciona o callback para o botão de voltar, com a animação e remove o fragment
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                fecharInfo();
            }
        });

        // Para acessar o link do meu LinkedIn
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView linkedinLink = view.findViewById(R.id.tvLinkedIn);
        linkedinLink.setOnClickListener(view1 -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/wanderson-dev47/"));
            startActivity(intent);
        });

        // Inflate the layout for this fragment
        return view;
    }

    private void fecharInfo() {
        getParentFragmentManager().beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .remove(this)
                .commit();
    }

}