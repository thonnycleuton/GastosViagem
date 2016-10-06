package com.thonnycleuton.gastosemviagem;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.thonnycleuton.gastosemviagem.DAO.DAO;
import com.thonnycleuton.gastosemviagem.modelo.Viagem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import io.realm.Realm;

public class NovaViagem extends AppCompatActivity {

    public final static String ADDED_NEW_TRIP = NovaViagem.class.getPackage().getName() + ".ADDED_NEW_TRIP";

    private String tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_viagem);
    }

    public void onRadioButtonClicked(View view) {
        tipo = view.getId() == R.id.radio_tipo_lazer ? "lazer":"negocios";
    }

    public void showDatePickerDialog(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void salvarViagem(View view) {
        EditText destino = (EditText) findViewById(R.id.txtDestino);
        TextView data = (TextView) findViewById(R.id.txtDataViagem);

        Viagem viagem = new Viagem();
        viagem.setDestino(destino.getText().toString());
        viagem.setTipoViagem(tipo);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            viagem.setData(dateFormat.parse(data.getText().toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        DAO.getInstance(Realm.getDefaultInstance()).saveViagem(viagem);
        //TODO: Decidir se volta pra pagina inicial ou se gera um popup apenas e um backbutton

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(ADDED_NEW_TRIP, "Nova Viagem adicionada com successo");
        startActivity(intent);
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {


        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {

            final Calendar c = Calendar.getInstance();
            c.set(year, month, day);
            TextView txtDatePicker = (TextView) getActivity().findViewById(R.id.txtDataViagem);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            txtDatePicker.setText(dateFormat.format(c.getTime()));

        }
    }
}
