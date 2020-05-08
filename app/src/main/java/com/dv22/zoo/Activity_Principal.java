package com.dv22.zoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.content.Intent;

public class Activity_Principal extends FragmentActivity {

    private boolean dosFragmentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_principal_dospaneles);

        //Se comprueba que exista el framelayout framelayout_contenedor_entrada. Si existe estaremos usando activity_dospaneles.xml, sino estaremos usando activity_listado.xml
        if (findViewById(R.id.framelayout_contenedor_detalle) != null) {
            // Entra aqu� solo en dise�os para pantallas grandes (es decir, si usamos res/values-large o res/values-sw600dp). Estaremos usando activity_dospaneles.xml
            dosFragmentos = true;
        }
    }


    public void onEntradaSelecionada(String id) {
        if (dosFragmentos) {
            // Si estamos en pantallas grandes, se mostrar� el detalle seleccionado en esta misma actividad remplazando el fragmento del detalle por el nuevo
            Bundle arguments = new Bundle();
            arguments.putString(Fragment_Detalle.ARG_ID_ENTRADA_SELECIONADA, id);
            Fragment_Detalle fragment = new Fragment_Detalle();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_contenedor_detalle, fragment).commit();

        } else {
            // En pantallas peque�as, iniciaremos una nueva actividad con el contenido del elemento seleccionado de la lista
            Intent detailIntent = new Intent(this, Activity_Detalle.class);
            detailIntent.putExtra(Fragment_Detalle.ARG_ID_ENTRADA_SELECIONADA, id);
            startActivity(detailIntent);
        }
    }
}
