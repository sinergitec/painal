package com.sienrgitec.painal.actividades;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;

import com.sienrgitec.painal.R;


public class RecuperaPassword extends AppCompatDialogFragment {

    private TextView userRecupera;
    private FragmentManager supportFragmentManager;
    private String valor = "";

    public RecuperaPassword() {
    }
    public RecuperaPassword(String valor) {

        this.valor = valor;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_recupera_pw, null);

        userRecupera = view.findViewById(R.id.contrasena);
        userRecupera.setText(valor);

        builder.setView(view)
                .setTitle(Html.fromHtml("<font color='#FF0000'>Aviso</font>"))
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        userRecupera = view.findViewById(R.id.correo);
        return builder.create();
    }

    private void setContentView(int recupera_pw) {
    }

}
