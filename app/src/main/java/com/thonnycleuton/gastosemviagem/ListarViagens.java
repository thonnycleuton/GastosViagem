package com.thonnycleuton.gastosemviagem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.thonnycleuton.gastosemviagem.DAO.DAO;
import com.thonnycleuton.gastosemviagem.adapters.ViagemAdapter;
import com.thonnycleuton.gastosemviagem.modelo.Viagem;

import java.util.List;

import io.realm.Realm;

public class ListarViagens extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listView;
    private List<Viagem> viagens;
    private ViagemAdapter viagemAdapter;
    private DAO dao;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_viagens);

        dao = DAO.getInstance(Realm.getDefaultInstance());
        realm = Realm.getDefaultInstance();

        listView = (ListView) findViewById(R.id.listar_viagens);
        viagens = dao.getViagemAll();
        listView.setAdapter(new ViagemAdapter(this, viagens));
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){

        Viagem viagem = (Viagem) adapterView.getAdapter().getItem(i);
        Intent intent = new Intent(this, ListarViagens.class);
        startActivity(intent);
    }
}
