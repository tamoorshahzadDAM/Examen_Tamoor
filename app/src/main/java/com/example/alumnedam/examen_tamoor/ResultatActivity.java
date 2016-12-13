package com.example.alumnedam.examen_tamoor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by ALUMNEDAM on 13/12/2016.
 */

public class ResultatActivity extends AppCompatActivity implements View.OnClickListener {

    public int opcion;


    public int getOpcion() {

        return opcion;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_preguntas);

        Button confirmar = (Button) findViewById(R.id.bt_Confirmar);
        confirmar.setOnClickListener(this);

        Button salir = (Button) findViewById(R.id.bt_salir);
        salir.setOnClickListener(this);

        //Recibo el valor numero de cartes desde otro intent
        Intent intent = getIntent();
        int num = intent.getIntExtra("numPreguntas", 0);



        Intent btn = getIntent();
        int dificultad = btn.getIntExtra("mostrar_preguntas", 60000);




    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.bt_Next) {
            RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);

            Intent intent = new Intent (this, MostrarPreguntas.class);
            intent.putExtra("opcion", getOpcion());

            switch (radioGroup1.getCheckedRadioButtonId()) {
                case R.id.radioButtonOpcion1:
                    opcion = 1;
                    intent.putExtra("numPreguntas", getOpcion());
                    break;
                case R.id.radioButtonOpcion2:
                    opcion = 2;
                    intent.putExtra("numPreguntas", getOpcion());
                    break;
                case R.id.radioButtonOpcion3:
                    opcion = 3;
                    intent.putExtra("numPreguntas", getOpcion());
                    break;

                case R.id.radioButtonOpcion4:
                    opcion = 4;
                    intent.putExtra("numPreguntas", getOpcion());
                    break;


                default:
                    Toast.makeText(this, "Tienes que selecionar una opcion", Toast.LENGTH_SHORT).show();
            }



            startActivity(intent);
            //si el usuario desea salir se juega, picando al buton de salir podra salir.
        }else if (view.getId() == R.id.bt_salir){
            finish();
        }

    }
}
