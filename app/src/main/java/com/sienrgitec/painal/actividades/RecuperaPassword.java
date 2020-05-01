package com.sienrgitec.painal.actividades;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.sienrgitec.painal.MainActivity;
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
                        Toast.makeText(getActivity(), "La contraseña es:", Toast.LENGTH_LONG).show();

                    }
                });

        userRecupera = view.findViewById(R.id.correo);
        return builder.create();
    }
}
