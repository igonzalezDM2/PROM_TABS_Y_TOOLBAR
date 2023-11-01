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

public class AdaptadorChats extends ArrayAdapter<Chat> {

    private static final DateFormat df = new SimpleDateFormat("hh:mm");

    public AdaptadorChats(@NonNull Context context, @NonNull Chat[] objects) {
        super(context, R.layout.pestana_chats, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Chat chat = getItem(position);
        Contacto contacto = chat.getContacto();
        ViewHolder holder;
        View item = convertView;
        if (item == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.pestana_chats, null);
            holder = new ViewHolder();
            holder.img = item.findViewById(R.id.ivImg);
            holder.nom = item.findViewById(R.id.tvNombre);
            holder.mensaje = item.findViewById(R.id.tvMensaje);
            holder.hora = item.findViewById(R.id.tvHora);
            item.setTag(holder);
        } else {
            holder = (ViewHolder) item.getTag();
        }

        ImageView img = holder.img;
        img.setImageResource(contacto.getImg());
        TextView nom = holder.nom;
        nom.setText(contacto.getNom());
        TextView mensaje = holder.mensaje;
        mensaje.setText(chat.getUltMensaje());
        TextView hora = holder.hora;
        hora.setText(df.format(chat.getHora()));

        return item;
    }

    private static class ViewHolder {
        ImageView img;
        TextView nom, mensaje, hora;
    }
}
