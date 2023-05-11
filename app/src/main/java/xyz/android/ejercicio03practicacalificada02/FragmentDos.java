package xyz.android.ejercicio03practicacalificada02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.Period;

import xyz.android.ejercicio03practicacalificada02.model.Persona;

public class FragmentDos extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dos, container, false);

        // Obtener referencia del TextView
        TextView saludoText = view.findViewById(R.id.textSaludo);

        // Obtener el objeto Persona del argumento
        Bundle bundle = getArguments();
        if (bundle != null) {
            Persona persona = (Persona) bundle.getSerializable("persona");
            int anio = persona.getAnioNacimiento();

            String mssSaludo = String.format("Hola %s, tienes %s años", persona.getNombre(), calcularEdad(anio));
            saludoText.setText(mssSaludo);
            Toast.makeText(getActivity(), mssSaludo, Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    private static int calcularEdad(int yearNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(yearNacimiento, 1, 1);
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }
}