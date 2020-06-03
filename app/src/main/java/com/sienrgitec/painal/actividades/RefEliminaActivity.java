package com.sienrgitec.painal.actividades;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.Loading;
import com.sienrgitec.painal.fragmentos.HomeFragment;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RefEliminaActivity  extends AppCompatDialogFragment {

    private TextView clienteBorrar;
    private Integer cliente = 0;
    private Integer referido = 0;
    private Context context = getActivity();

    public RefEliminaActivity(){
    }

    public RefEliminaActivity(Integer iCliente, Integer ipiReferido){

        this.cliente = iCliente;
        this.referido = ipiReferido;
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

                        eliminar(cliente,referido);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent inicio = new Intent(getContext(), HomeFragment.class);
                        getContext().startActivity(inicio);
                    }
                });
        return builder.create();
    }

    private void eliminar(Integer cliente, Integer referido) {

        final Loading loading = new Loading(getActivity());
        loading.iniciaDialogo("alert");


        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, Integer> data = new HashMap<>();
        data.put("ipiCliente", cliente);
        data.put("ipiReferido", referido);
        final Call<Respuesta> call = service.opClienteReferidosDelete(data);

        call.enqueue(new Callback<Respuesta>() {

            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                loading.detenDialogo("alert");
                Respuesta res = response.body();
                System.out.println(getActivity());
                if (response.isSuccessful()) {
                    if (res.getResponse().getOplError().equals("true")){
                        Toast.makeText(getContext(), res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                    }else{

                    }
                } else {
                    Toast.makeText(getContext(), res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                loading.detenDialogo("alert");
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
