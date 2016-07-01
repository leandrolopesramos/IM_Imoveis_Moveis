package br.edu.ifba.mobile.IM_ImoveisMoveis.tarefas;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import br.edu.ifba.mobile.IM_ImoveisMoveis.bd.Apartamento;
import br.edu.ifba.mobile.IM_ImoveisMoveis.bd.FachadaBD;

/**
 * Created by LEANDRO on 27/05/2016.
 */
public class RemocaoApartamento extends AsyncTask<Void, Void, String>{

    private Context contexto = null;
    private Apartamento apartamento = null;

    public RemocaoApartamento(Context contexto, Apartamento apartamento){
        this.contexto = contexto;
        this.apartamento = apartamento;
    }

    @Override
    protected String doInBackground(Void... params) {
        String mensagem = "";

        if (apartamento.getCodigo() != -1){
           if (FachadaBD.getInstancia().removerApto(apartamento)==0){
               mensagem = "Problema em removerApto!";
           }else {
               mensagem = "Apartamento removido topeira!";
           }
        }else{
            mensagem = "Seleciona uma apartamento animal!";
        }

        return mensagem;
    }

    @Override
    protected void onPostExecute(String mensagem){
        Toast.makeText(contexto, mensagem, Toast.LENGTH_LONG).show();
    }

}
