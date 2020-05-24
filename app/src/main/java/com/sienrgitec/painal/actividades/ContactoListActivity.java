package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.recycler.ContactoAdapter;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.sienrgitec.painal.R.id.agregar;

public class ContactoListActivity extends AppCompatActivity {

    private ImageView btnAgregar;
    private RecyclerView recyclerContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_contacto);
        listContacto();
        btnAgregar = findViewById(agregar);
        btnAgregar.setOnClickListener(v -> agregarContacto());
    }

    private void agregarContacto() {
        Intent cont = new Intent(ContactoListActivity.this, ContactoActivity.class);
        startActivity(cont);
    }

    private void  listContacto() {

        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, String> data = new HashMap<>();
        data.put("ipiPersona", String.valueOf(CarritoSingleton.getInstance().getCliente().getiCliente()));
        data.put("ipcPersona", String.valueOf("cliente"));


        final Call<Respuesta> call = service.ctContacto(data);
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                Respuesta res = response.body();

                if (response.isSuccessful()) {
                    if (res.getResponse().getOplError().equals("true"))
                        Toast.makeText(ContactoListActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                    else {
                        recyclerContactos = findViewById(R.id.listContacto);
                        recyclerContactos.setLayoutManager(new LinearLayoutManager(ContactoListActivity.this));
                        ContactoAdapter fm = new ContactoAdapter(ContactoListActivity.this, null);
                        fm.setList(res.getResponse().getTt_ctContacto().getTtCtContacto_());
                        recyclerContactos.setAdapter(fm);
                    }
                } else {
                    Toast.makeText(ContactoListActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                Toast.makeText(ContactoListActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
