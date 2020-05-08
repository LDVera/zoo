package com.dv22.zoo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Detalle extends Fragment {
    /**
     * El argumento que representa el ID del elemento selecionado en la lista y que a este fragmento le llega para cargar el contenido apropiado
     */
    public static final String ARG_ID_ENTRADA_SELECIONADA = "item_id";

    /**
     * El contenido que cargaremos en este fragmento
     */
    private Lista_contenido.Lista_entrada mItem;

    public Fragment_Detalle() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ID_ENTRADA_SELECIONADA)) {
            //Cargamos el contenido de la entrada con cierto ID seleccionado en la lista. Se recomiendo usar un Loader para cargar el contenido
            mItem = Lista_contenido.ENTRADAS_LISTA_HASHMAP.get(getArguments().getString(ARG_ID_ENTRADA_SELECIONADA));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_fragment_detalle, container, false);
        // Inflate the layout for this fragment

        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.textView_superior)).setText(mItem.textoEncima);
            ((TextView) rootView.findViewById(R.id.textView_inferior)).setText(mItem.textoDebajo);
            ((ImageView) rootView.findViewById(R.id.imageView_imagen)).setImageResource(mItem.idImagen);
        }

        return rootView;


    }
}
