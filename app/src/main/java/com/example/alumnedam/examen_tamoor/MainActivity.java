package com.example.alumnedam.examen_tamoor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public int numPreguntas;


    public int getNumPreguntas() {

        return numPreguntas;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button next = (Button) findViewById(R.id.bt_Next);
        next.setOnClickListener(this);

        Button salir = (Button) findViewById(R.id.bt_salir);
        salir.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        if (view.getId() == R.id.bt_Next) {
            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
            RadioGroup radioGroupPregunta = (RadioGroup) findViewById(R.id.radioGroupPreguntas);

            Intent intent = new Intent (this, MostrarPreguntas.class);
            intent.putExtra("numPreguntas", getNumPreguntas());

            switch (radioGroupPregunta.getCheckedRadioButtonId()) {
                case R.id.radioButton5:
                    numPreguntas = 5;
                    intent.putExtra("numPreguntas", getNumPreguntas());
                    break;
                case R.id.radioButton10:
                    numPreguntas = 10;
                    intent.putExtra("numPreguntas", getNumPreguntas());
                    break;
                case R.id.radioButton20:
                    numPreguntas = 20;
                    intent.putExtra("numPreguntas", getNumPreguntas());
                    break;

                default:
                    Toast.makeText(this, "Tienes que selecionar una opcion", Toast.LENGTH_SHORT).show();
            }

/*
            switch (radioGroup.getCheckedRadioButtonId()){
                case R.id.radioButtonSuma:
                    numCartes = 4;
                    intent.putExtra("numCartes", getNumCartes());
                    break;
                case R.id.radioButtonResta:
                    numCartes = 8;
                    intent.putExtra("numCartes", getNumCartes());
                    break;
                case R.id.radioButtonMultiplicacio:
                    numCartes = 16;
                    intent.putExtra("numCartes", getNumCartes());
                    break;
                case R.id.radioButtonDivisio:
                    numCartes = 8;
                    intent.putExtra("numCartes", getNumCartes());
                    break;
                case R.id.radioButtonGeneral:
                    numCartes = 8;
                    intent.putExtra("numCartes", getNumCartes());
                    break;

                default:
                    Toast.makeText(this, "Tienes que selecionar una opcion", Toast.LENGTH_SHORT).show();


            }
           */


            startActivity(intent);
            //si el usuario desea salir se juega, picando al buton de salir podra salir.
        }else if (view.getId() == R.id.bt_salir){
            finish();
        }





    }
}
