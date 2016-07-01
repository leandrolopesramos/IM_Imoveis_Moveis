package br.edu.ifba.mobile.IM_ImoveisMoveis.tarefas;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.edu.ifba.mobile.IM_ImoveisMoveis.bd.Casa;
import br.edu.ifba.mobile.IM_ImoveisMoveis.bd.FachadaBD;

/**
 * Created by LEANDRO on 27/05/2016.
 */
    public class ListagemCasas extends AsyncTask<Void, Void, List<Casa>>{

    private Context contexto = null;
    private ListView listaCasas = null;

    public ListagemCasas(Context contexto, ListView listaCasas){
        this.contexto = contexto;
        this.listaCasas = listaCasas;
    }

    @Override
    protected List<Casa> doInBackground(Void... params) {
        List<Casa> casas = FachadaBD.getInstancia().listarCasas();

        return casas;
    }

    @Override
    protected void onPostExecute(List<Casa> casas){
        if(casas.isEmpty()){
        Toast.makeText(contexto, "Lista Vazia Meu Rei, cadastre uma casa vá!", Toast.LENGTH_LONG).show();
        }

        else{
            ArrayAdapter<Casa> adaptador = new ArrayAdapter<Casa>(contexto, android.R.layout.simple_list_item_single_choice, casas);
            listaCasas.setAdapter(adaptador);
        }

}
}
