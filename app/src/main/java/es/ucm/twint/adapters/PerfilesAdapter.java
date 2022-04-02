package es.ucm.twint.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import es.ucm.mocks.Perfil;
import es.ucm.twint.R;

public class PerfilesAdapter extends BaseAdapter {
    LayoutInflater inflater;
    Context context;
    ArrayList<Perfil> perfiles;

    public PerfilesAdapter(Context context, ArrayList<Perfil> perfiles) {
        this.context = context;
        this.perfiles = perfiles;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return perfiles.size();
    }

    @Override
    public Object getItem(int i) {
        return perfiles.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = inflater.inflate(R.layout.perfil, viewGroup, false);
        Perfil perfil = (Perfil) getItem(i);

        TextView tv = (TextView) rowView.findViewById(R.id.tv_nombre_perfil);
        ImageView iv = (ImageView) rowView.findViewById(R.id.iv_perfil);
        Button bt = (Button) rowView.findViewById(R.id.bt_like_perfil);

        tv.setText(perfil.getNombre());
        Picasso.get().load(perfil.getImagen()).into(iv);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Oh! Te ha gustado este perfil, eh?", Snackbar.LENGTH_LONG).show();
            }
        });

        return rowView;
    }
}
