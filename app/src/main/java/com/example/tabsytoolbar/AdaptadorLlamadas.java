package com.example.tabsytoolbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AdaptadorLlamadas extends ArrayAdapter<Llamada> {

    private static final DateFormat df = new SimpleDateFormat("hh:mm");

    public AdaptadorLlamadas(@NonNull Context context, @NonNull Llamada[] objects) {
        super(context, R.layout.pestana_llamadas, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Llamada llamada = getItem(position);
        Contacto contacto = llamada.getContacto();
        ViewHolder holder;
        View item = convertView;
        if (item == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.pestana_llamadas, null);
            holder = new ViewHolder();
            holder.img = item.findViewById(R.id.ivImg);
            holder.nom = item.findViewById(R.id.tvNombre);
            holder.hora = item.findViewById(R.id.tvHora);
            item.setTag(holder);
        } else {
            holder = (ViewHolder) item.getTag();
        }

        ImageView img = holder.img;
        img.setImageResource(contacto.getImg());
        TextView nom = holder.nom;
        nom.setText(contacto.getNom());
        TextView hora = holder.hora;
        hora.setText(df.format(llamada.getHora()));

        return item;
    }

    private static class ViewHolder {
        ImageView img;
        TextView nom, hora;
    }
}
