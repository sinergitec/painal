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

import com.sienrgitec.painal.MainActivity;
import com.sienrgitec.painal.R;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
                            final Painal service = ServiceGenerator.createService(Painal.class);
                            Map<String, String> data = new HashMap<>();
                            data.put("ipcEmail", usr);
                            data.put("ipcPersona","5");
                            final Call<Respuesta> call = service.recuperapw(data);

                            call.enqueue(new Callback<Respuesta>() {
                                @Override
                                public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {

                                    if(response.isSuccessful()) {
                                        Respuesta res = response.body();
                                        if (res.getResponse().getOplError().equals("true"))
                                            System.out.println("Error");
                                        else {
                                            if (res.getResponse().getTtCtUsuario() != null
                                                    && res.getResponse().getTtCtUsuario().getTtCtUsuario().size() > 0) {

                                                System.out.println("La constraseña es:" + res.getResponse().getTtCtUsuario().getTtCtUsuario().get(0).getcPassword());
                                            }
                                        }
                                    }else{
                                        System.out.println("Error en la respuesta");
                                    }
                                }

                                @Override
                                public void onFailure(Call<Respuesta> call, Throwable t) {
                                    Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            });




                        }
                    }
                });

        userRecupera = view.findViewById(R.id.correo);
        return builder.create();
    }

    private void setContentView(int recupera_pw) {
    }

}
