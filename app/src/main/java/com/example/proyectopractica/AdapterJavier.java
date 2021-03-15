package com.example.proyectopractica;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class AdapterJavier extends ArrayAdapter<Persona> {



    public AdapterJavier(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public AdapterJavier(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public AdapterJavier(@NonNull Context context, int resource, @NonNull Persona[] objects) {
        super(context, resource, objects);
    }

    public AdapterJavier(@NonNull Context context, int resource, int textViewResourceId, @NonNull Persona[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public AdapterJavier(@NonNull Context context, int resource, @NonNull List<Persona> objects) {
        super(context, resource, objects);
    }

    public AdapterJavier(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Persona> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
