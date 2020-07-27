package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.recycler.HistoricoDetAdapter;
import com.sienrgitec.painal.pojo.entity.TtOpPedidoDet;
import com.sienrgitec.painal.pojo.entity.TtOpPedidoDet_;

import java.util.List;


public class HistoDetPedido extends AppCompatActivity {

    private RecyclerView recyclerHistoricoDet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_detalle_pedido);

        Intent i = getIntent();
        List<TtOpPedidoDet> detalle = (List<TtOpPedidoDet>) i.getSerializableExtra("objMostrarDetalle");

        recyclerHistoricoDet = findViewById(R.id.rvDetallePedido);
        recyclerHistoricoDet.setLayoutManager(new LinearLayoutManager(HistoDetPedido.this));
        HistoricoDetAdapter det = new HistoricoDetAdapter(HistoDetPedido.this, null,  null);
        det.setList(detalle);
        recyclerHistoricoDet.setAdapter(det);

    }
}
