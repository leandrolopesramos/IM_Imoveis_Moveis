package br.edu.ifba.mobile.IM_ImoveisMoveis.tarefas;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.edu.ifba.mobile.IM_ImoveisMoveis.bd.Apartamento;
import br.edu.ifba.mobile.IM_ImoveisMoveis.bd.FachadaBD;

/**
 * Created by LEANDRO on 27/05/2016.
 */
    public class ListagemApartamentos extends AsyncTask<Void, Void, List<Apartamento>>{

    private Context contexto = null;
    private ListView listaApartamentos = null;

    public ListagemApartamentos(Context contexto, ListView listaApartamentos){
        this.contexto = contexto;
        this.listaApartamentos = listaApartamentos;
    }

    @Override
    protected List<Apartamento> doInBackground(Void... params) {
        List<Apartamento> apartamentos = FachadaBD.getInstancia().listarApartamentos();

        return apartamentos;
    }

    @Override
    protected void onPostExecute(List<Apartamento> apartamentos){
        if(apartamentos.isEmpty()){
        Toast.makeText(contexto, "Lista Vazia. Cadastre um Apartamento!", Toast.LENGTH_LONG).show();
        }

        else{
            ArrayAdapter<Apartamento> adaptador = new ArrayAdapter<Apartamento>(contexto, android.R.layout.simple_list_item_single_choice, apartamentos);
            listaApartamentos.setAdapter(adaptador);
        }

}
}
