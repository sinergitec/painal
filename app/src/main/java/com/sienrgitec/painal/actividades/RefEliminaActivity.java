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

import com.sienrgitec.painal.MainActivity;
import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.Loading;
import com.sienrgitec.painal.componente.recycler.ReferidosAdapter;

public class RefEliminaActivity  extends AppCompatDialogFragment {

    private TextView clienteBorrar;
    private Integer cliente = 0;

    public RefEliminaActivity(){
    }

    public RefEliminaActivity(Integer iCliente){
        this.cliente = iCliente;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_eliminar, null);

        builder.setView(view)
                .setTitle(Html.fromHtml("<font color='#FF0000'>Aviso</font>"))
                .setCancelable(false)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final Loading loading = new Loading(getActivity());
                        loading.iniciaDialogo("alert");

                        Intent inicio = new Intent(getActivity(), MainActivity.class);
                        inicio.putExtra("cliente", cliente);
                        startActivity(inicio);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        return builder.create();
    }

    private void setContentView(int recupera_pw) {
    }
}
