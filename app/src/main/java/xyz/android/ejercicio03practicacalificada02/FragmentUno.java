package xyz.android.ejercicio03practicacalificada02;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;

import xyz.android.ejercicio03practicacalificada02.model.Persona;

public class FragmentUno extends Fragment {
    private TextView nombreEditText;
    private EditText anioNacimientoEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_uno, container, false);

        // Obtener referencias a los campos y botón
        nombreEditText = view.findViewById(R.id.editTextNombre);
        anioNacimientoEditText = view.findViewById(R.id.editTextAnioNacimiento);
        Button openFragmento2Btn = view.findViewById(R.id.btnOpenFragmentoDos);


        // Obtener referencias a los campos y botón
        openFragmento2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores de los campos
                String nombre = nombreEditText.getText().toString().trim();
                String anioNacimiento = anioNacimientoEditText.getText().toString().trim();

                // Validar los campos
                if (nombre.isEmpty()) {
                    Toast.makeText(getActivity(), "Ingrese un nombre", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (anioNacimiento.isEmpty()) {
                    Toast.makeText(getActivity(), "Ingrese el año de nacimiento", Toast.LENGTH_SHORT).show();
                    return;
                }

                int anio = Integer.parseInt(anioNacimiento);
                if (!esAnioNacimientoValido(anio)) {
                    Toast.makeText(getActivity(), "El año de nacimiento es inválido.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Crear objeto Persona
                Persona persona = new Persona(nombre, anio);

                // Pasar el objeto Persona al FragmentoDos
                FragmentDos fragmentDos = new FragmentDos();
                Bundle bundle = new Bundle();
                bundle.putSerializable("persona", persona);
                fragmentDos.setArguments(bundle);

                // Reemplazar el FragmentoUno por el FragmentoDos
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.contenedorFragment2, fragmentDos).commit();
            }
        });

        return view;
    }

    public static boolean esAnioNacimientoValido(int yearNacimiento) {
        int yearActual = LocalDate.now().getYear();

        // Verificar si el año de nacimiento está dentro de un rango específico
        return yearNacimiento >= 1900 && yearNacimiento <= yearActual;
    }
}