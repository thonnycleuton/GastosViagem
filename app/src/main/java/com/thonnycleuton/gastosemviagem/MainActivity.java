package com.thonnycleuton.gastosemviagem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void novaViagemView(View view) {
        Intent intent = new Intent(this, NovaViagem.class);
        startActivity(intent);
    }

    public void novoGastoView(View view) {
        Intent intent = new Intent(this, NovoGasto.class);
        startActivity(intent);
    }

    public void minhasViagens(View view) {
        Intent intent = new Intent(this, ListarViagens.class);
        startActivity(intent);
    }
}
