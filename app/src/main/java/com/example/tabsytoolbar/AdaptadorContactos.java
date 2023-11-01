package com.example.tabsytoolbar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdaptadorContactos extends ArrayAdapter<Contacto> {
    public AdaptadorContactos(@NonNull Context context, @NonNull Contacto[] objects) {
        super(context, R.layout.pestana_contactos, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Contacto contacto = getItem(position);
        ViewHolder holder;

        View item = convertView;
        if (item == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.pestana_contactos, null);
            holder = new ViewHolder();
            holder.img = item.findViewById(R.id.ivImg);
            holder.nom = item.findViewById(R.id.tvNombre);
            holder.tlf = item.findViewById(R.id.tvTlf);
            holder.btnLlamar = item.findViewById(R.id.btnLlamar);
            item.setTag(holder);
        } else {
            holder = (ViewHolder) item.getTag();
        }

        ImageView img = holder.img;
        img.setImageResource(contacto.getImg());
        TextView nom = holder.nom;
        nom.setText(contacto.getNom());
        TextView tlf = holder.tlf;
        tlf.setText(contacto.getTlf());
        return item;
    }

    private static class ViewHolder {
        ImageView img;
        TextView nom, tlf;
        ImageButton btnLlamar;
    }
}
