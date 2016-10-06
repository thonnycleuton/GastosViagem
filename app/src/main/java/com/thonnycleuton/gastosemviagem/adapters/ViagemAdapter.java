package com.thonnycleuton.gastosemviagem.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.thonnycleuton.gastosemviagem.R;
import com.thonnycleuton.gastosemviagem.modelo.Viagem;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by thonnycleuton on 04/10/16.
 */
public class ViagemAdapter extends BaseAdapter {

    private final Context context;
    private final List<Viagem> viagens ;

    public ViagemAdapter(Context context, List<Viagem> viagens) {
        this.context = context;
        this.viagens = viagens;
    }

    @Override
    public int getCount() {
        return viagens != null ? viagens.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return viagens.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Viagem viagem = viagens.get(i);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        view = LayoutInflater.from(context).inflate(R.layout.lista_viagem_item, viewGroup, false);

        TextView destino = (TextView) view.findViewById(R.id.txtNomeDestino);
        TextView data = (TextView) view.findViewById(R.id.txtItemData);
        TextView total = (TextView) view.findViewById(R.id.txtTotalGastos);
        ImageView icone = (ImageView) view.findViewById(R.id.viagemIcon);

        if (viagem.getTipoViagem().equals("lazer")){
            icone.setImageResource(R.drawable.lazer_small);
        }else {
            icone.setImageResource(R.drawable.work_small);
        }

        destino.setText(viagem.getDestino());
        data.setText(dateFormat.format(viagem.getData()));

        return view;
    }
}
