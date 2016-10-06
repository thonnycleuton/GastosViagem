package com.thonnycleuton.gastosemviagem.DAO;

import com.thonnycleuton.gastosemviagem.modelo.Gasto;
import com.thonnycleuton.gastosemviagem.modelo.Viagem;

import java.util.ArrayList;
import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by thonnycleuton on 04/10/16.
 */
public class DAO {

    private static List<Viagem> viagens = new ArrayList<>();
    private Realm realm;
    private static DAO INSTANCE;

    private DAO(Realm realm){
        this.realm = realm;
    }

    public static DAO getInstance(Realm realm){
        if (INSTANCE == null) {
            INSTANCE = new DAO(realm);
        }
        return INSTANCE;
    }

    public void saveViagem(final Viagem viagem){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(viagem);
            }
        });
    }

    public static void addViagem (Viagem viagem){
        viagens.add(viagem);
    }

    public void removeViagem(String id){
        final Viagem viagem = realm.where(Viagem.class).equalTo("id", id).findFirst();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                viagem.deleteFromRealm();
            }
        });
    }

    public Viagem getViagemById(String id){
        Viagem viagem = realm.where(Viagem.class).equalTo("id", id).findFirst();
        return viagem;
    }

    public Gasto getGastoById(String id){
        Gasto gasto= realm.where(Gasto.class).equalTo("id", id).findFirst();
        return gasto;
    }
    public RealmResults<Viagem> getViagemByDestino(String nome){
        return realm.where(Viagem.class).contains("destino", nome, Case.INSENSITIVE).findAll();
    }

    public RealmResults<Viagem> getViagemAll(){
        return realm.where(Viagem.class).findAll();
    }

}
