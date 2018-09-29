package org.dev4u.hv.guia3_ejemplo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorMensaje extends ArrayAdapter<Mensaje> {

    public AdaptadorMensaje(@NonNull Context context, @NonNull List<Mensaje> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Obteniendo el dato
        Mensaje mensaje = getItem(position);

        //TODO inicializando el layout correspondiente al item (Contacto)
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mensaje, parent, false);
        }
        TextView lblFecha = convertView.findViewById(R.id.lblFecha);
        TextView lblContenido = convertView.findViewById(R.id.lblContenido);

        // mostrar los datos
        lblFecha.setText(mensaje.Fecha);
        lblContenido.setText(mensaje.Contenido);

        // Return la convertView ya con los datos
        return convertView;
    }
}
