package com.thonnycleuton.gastosemviagem.modelo;

import java.util.Date;
import java.util.UUID;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by thonnycleuton on 04/10/16.
 */
public class Viagem extends RealmObject {

    @PrimaryKey
    private String id;
    private String destino;
    private String tipoViagem;
    private Date data;
    private RealmList<Gasto> gastos;

    public Viagem() {
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTipoViagem() {
        return tipoViagem;
    }

    public void setTipoViagem(String tipoViagem) {
        this.tipoViagem = tipoViagem;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public RealmList<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(RealmList<Gasto> gastos) {
        this.gastos = gastos;
    }


}
