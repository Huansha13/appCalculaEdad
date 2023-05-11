package xyz.android.ejercicio03practicacalificada02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import xyz.android.ejercicio03practicacalificada02.model.Persona;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentUno fragmento1 = new FragmentUno();
        FragmentDos fragmento2 = new FragmentDos();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragment1, fragmento1).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragment2, fragmento2).commit();

    }
}