package org.dev4u.hv.guia3_ejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

public class MensajeActivity extends AppCompatActivity {

    //Declaracion de variables
    ArrayList<Mensaje> Mensaje;
    private AdaptadorMensaje adaptadorMensaje;
    private EditText txtEntrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        //Inicializacion de variables
        Mensaje = new ArrayList<>();
        txtEntrada = findViewById(R.id.txtEntrada);

        //Inicializando el adaptador
        adaptadorMensaje = new AdaptadorMensaje(this,  Mensaje);

        //Inicializando el listView
        ListView listView = (ListView) findViewById(R.id.lstMensaje);

        //seteando el adaptador al listview
        listView.setAdapter(adaptadorMensaje);


    }
    public void onClickBtnEnviar(View v){
        Date FechaHoraActual = new Date();
        SimpleDateFormat FormatoFecha = new SimpleDateFormat("EEE., d MMM. yyyy, hh:mm", new Locale("es_ES"));
        String Fecha = FormatoFecha.format(FechaHoraActual);
        Mensaje mensaje = new Mensaje(Fecha, txtEntrada.getText().toString());
        Mensaje.add(mensaje);
        adaptadorMensaje.notifyDataSetChanged();
    }
}
