package com.example.atv11;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class FragmentJogador extends Fragment {

    private EditText editNome, editIdade, editIdTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jogador, container, false);

        editNome = view.findViewById(R.id.editNome);
        editIdade = view.findViewById(R.id.editIdade);
        editIdTime = view.findViewById(R.id.editIdTime);
        Button buttonCadastrar = view.findViewById(R.id.buttonCadastrar);

        buttonCadastrar.setOnClickListener(v -> {
            String nome = editNome.getText().toString();
            int idade = Integer.parseInt(editIdade.getText().toString());
            int idTime = Integer.parseInt(editIdTime.getText().toString());

            // Implementação da inserção do Jogador no banco de dados

            Toast.makeText(view.getContext(), "Jogador cadastrado: " + nome, Toast.LENGTH_LONG).show();
        });

        return view;
    }
}
