package com.sienrgitec.painal.actividades;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.JsonToken;
import android.util.Log;
import android.view.View;
import android.webkit.JsResult;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;

import java.io.BufferedReader;
import java.io.IOException;

import io.conekta.conektasdk.Card;
import io.conekta.conektasdk.Conekta;
import io.conekta.conektasdk.Token;

public class DatosTC extends AppCompatActivity  {

    private Activity activity = this;


    private EditText etNombreT, etTarjeta, etMesT, etYearT, etSeg;
    private Button btnAceptarT, btnCancelarT;

    public DatosTC() throws JSONException {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datostc);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width *.9),(int)(height*.4));

        etNombreT = (EditText) findViewById(R.id.etNombreT);
        etTarjeta = (EditText) findViewById(R.id.etetTarjeta);
        etMesT = (EditText) findViewById(R.id.etMesT);
        etYearT = (EditText) findViewById(R.id.etYear);
        etSeg = (EditText) findViewById(R.id.etSeg);

        btnCancelarT = (Button) findViewById(R.id.btnCancT);
        btnAceptarT = (Button) findViewById(R.id.btnAceptaT);


        btnAceptarT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ValidaCampos();

            }
        });


    }


    public void ValidaCampos() {
        btnAceptarT.setEnabled(false);
        if (etNombreT.getText().toString().isEmpty()) {
            AlertDialog.Builder myBuild = new AlertDialog.Builder(DatosTC.this);
            myBuild.setMessage("No se capturo el nombre");
            myBuild.setTitle(Html.fromHtml("<font color ='#FF0000'> ERROR </font>"));
            myBuild.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    btnAceptarT.setEnabled(true);

                }
            });
            AlertDialog dialog = myBuild.create();
            dialog.show();
            return;
        }

        if (etTarjeta.getText().toString().isEmpty()) {
            AlertDialog.Builder myBuild = new AlertDialog.Builder(DatosTC.this);
            myBuild.setMessage("No se capturo el nombre");
            myBuild.setTitle(Html.fromHtml("<font color ='#FF0000'> ERROR </font>"));
            myBuild.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    btnAceptarT.setEnabled(true);

                }
            });
            AlertDialog dialog = myBuild.create();
            dialog.show();
            return;
        }

        if (etMesT.getText().toString().isEmpty()) {
            AlertDialog.Builder myBuild = new AlertDialog.Builder(DatosTC.this);
            myBuild.setMessage("No se capturo el mes de vencimiento");
            myBuild.setTitle(Html.fromHtml("<font color ='#FF0000'> ERROR </font>"));
            myBuild.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    btnAceptarT.setEnabled(true);

                }
            });
            AlertDialog dialog = myBuild.create();
            dialog.show();
            return;
        }

        if (etYearT.getText().toString().isEmpty()) {
            AlertDialog.Builder myBuild = new AlertDialog.Builder(DatosTC.this);
            myBuild.setMessage("No se capturo el año de vencimiento");
            myBuild.setTitle(Html.fromHtml("<font color ='#FF0000'> ERROR </font>"));
            myBuild.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    btnAceptarT.setEnabled(true);

                }
            });
            AlertDialog dialog = myBuild.create();
            dialog.show();
            return;
        }

        if (etSeg.getText().toString().isEmpty()) {
            AlertDialog.Builder myBuild = new AlertDialog.Builder(DatosTC.this);
            myBuild.setMessage("No se capturo elnombre de seguridad");
            myBuild.setTitle(Html.fromHtml("<font color ='#FF0000'> ERROR </font>"));
            myBuild.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    btnAceptarT.setEnabled(true);

                }
            });
            AlertDialog dialog = myBuild.create();
            dialog.show();
            return;
        }

        Conekta.setPublicKey("key_eYvWV7gSDkNYXsmr"); //key_DJhK36dtEd73q5s54tYaP8w
        Conekta.setApiVersion("0.3.0"); //Set api version (optional)
        Conekta.collectDevice(activity); //Collect device

        //Card card = new Card("Josue Camara", "4242424242424242", "332", "11", "2021");

        Card card = new Card(etNombreT.getText().toString(),
                etTarjeta.getText().toString(),
                etSeg.getText().toString(),
                etMesT.getText().toString(),
                etYearT.getText().toString());


        Token token = new Token(activity);


        token.onCreateTokenListener(new Token.CreateToken() {
            @Override
            public void onCreateTokenReady(JSONObject data) {

                Log.e("antes de try ", "data" + data);
                try {
                    etNombreT.setText("Token id: " + data.getString("id"));

                } catch (Exception error) {
                    AlertDialog.Builder myBuild = new AlertDialog.Builder(DatosTC.this);
                    myBuild.setMessage("Error: " + data);
                    myBuild.setTitle(Html.fromHtml("<font color ='#FF0000'> ERROR </font>"));
                    myBuild.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            btnAceptarT.setEnabled(true);

                        }
                    });
                    AlertDialog dialog = myBuild.create();
                    dialog.show();
                    return;
                }
            }
        });
        token.create(card);//Create token

    }









}
