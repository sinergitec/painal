package com.sienrgitec.painal.actividades;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.sienrgitec.painal.R;


public class RecuperaPassword extends AppCompatDialogFragment {

    private EditText userRecupera;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.recupera_pw, null);

        builder.setView(view)
                .setTitle("Recupera Contraseña")
                .setPositiveButton("Buscar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String usr = userRecupera.getText().toString();

                        System.out.println("usuario" + usr);

                        if (usr.isEmpty()) {
                            Toast.makeText(getActivity(), "El correo es requerido", Toast.LENGTH_LONG).show();
                            userRecupera.setError("Correo requerido");
                            userRecupera.requestFocus();

                        } else {

                            Toast.makeText(getActivity(), "La contraseña es:", Toast.LENGTH_LONG).show();
                        }
                    }
                });

        userRecupera = view.findViewById(R.id.correo);
        return builder.create();
    }

    private void setContentView(int recupera_pw) {
    }

}
