package com.sienrgitec.painal.actividades;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
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

import com.sienrgitec.painal.MainActivity;
import com.sienrgitec.painal.R;


public class RecuperaPassword extends AppCompatDialogFragment {

    private TextView userRecupera;
    private FragmentManager supportFragmentManager;
    private String valor = "";
    private String usuario = "";

    public RecuperaPassword() {
    }
    public RecuperaPassword(String valor,String usuario) {

        this.valor = valor;
        this.usuario = usuario;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_recupera_pw, null);

        userRecupera = view.findViewById(R.id.contrasena);
        userRecupera.setText("La contraseña es: " + valor);

        final String usuario = this.usuario;
        final String password = this.valor;

        builder.setView(view)
                .setTitle(Html.fromHtml("<font color='#FF0000'>Aviso</font>"))
                .setIcon(R.drawable.ic_lock)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent inicio = new Intent(getActivity(), MainActivity.class);
                        inicio.putExtra("usuario", usuario);
                        inicio.putExtra("password", valor);
                        startActivity(inicio);
                    }
                });

        userRecupera = view.findViewById(R.id.correo);
        return builder.create();
    }

    private void setContentView(int recupera_pw) {
    }

}
