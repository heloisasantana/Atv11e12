package com.example.atv11;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class FragmentTime extends Fragment {

    private EditText editNome, editCidade;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time, container, false);

        editNome = view.findViewById(R.id.editNome);
        editCidade = view.findViewById(R.id.editCidade);
        Button buttonCadastrar = view.findViewById(R.id.buttonCadastrar);

        buttonCadastrar.setOnClickListener(v -> {
            String nome = editNome.getText().toString();
            String cidade = editCidade.getText().toString();

            // Implementação da inserção do Time no banco de dados

            Toast.makeText(view.getContext(), "Time cadastrado: " + nome, Toast.LENGTH_LONG).show();
        });

        return view;
    }
}
