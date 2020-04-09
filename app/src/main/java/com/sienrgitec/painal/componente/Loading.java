package com.sienrgitec.painal.componente;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import com.sienrgitec.painal.R;

public class Loading {

    private Activity activity;
    private ProgressBar progressBar;
    private AlertDialog alertDialog;

    public Loading(Activity activity){
        this.activity = activity;
    }

    public void iniciaDialogo(String tipo){
        switch (tipo){
            case "alert":
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                LayoutInflater inflater = activity.getLayoutInflater();
                builder.setView(inflater.inflate(R.layout.loading, null));
                builder.setCancelable(false);

                alertDialog = builder.create();
                alertDialog.show();
                break;
            default:
                progressBar = new ProgressBar(activity);
                progressBar.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void detenDialogo(String tipo){
        switch (tipo){
            case "alert":
                alertDialog.dismiss();
                break;
            default:
                progressBar = new ProgressBar(activity);
                progressBar.setVisibility(View.GONE);
                break;
        }
    }

}
