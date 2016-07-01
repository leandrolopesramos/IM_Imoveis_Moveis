package br.edu.ifba.mobile.IM_ImoveisMoveis.tarefas;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import br.edu.ifba.mobile.IM_ImoveisMoveis.bd.Casa;
import br.edu.ifba.mobile.IM_ImoveisMoveis.bd.FachadaBD;

/**
 * Created by LEANDRO on 27/05/2016.
 */
public class RemocaoCasa extends AsyncTask<Void, Void, String>{

    private Context contexto = null;
    private Casa casa = null;

    public RemocaoCasa(Context contexto, Casa casa){
        this.contexto = contexto;
        this.casa = casa;
    }

    @Override
    protected String doInBackground(Void... params) {
        String mensagem = "";

        if (casa.getCodigo() != -1){
           if (FachadaBD.getInstancia().removerCasa(casa)==0){
               mensagem = "Problema em remover o Apto!";
           }else {
               mensagem = "Casa Removida Ser Humaninho!";
           }
        }else{
            mensagem = "Seleciona uma casa Man, vá!";
        }

        return mensagem;
    }

    @Override
    protected void onPostExecute(String mensagem){
        Toast.makeText(contexto, mensagem, Toast.LENGTH_LONG).show();
    }

}
