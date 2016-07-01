package br.edu.ifba.mobile.IM_ImoveisMoveis.tarefas;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import br.edu.ifba.mobile.IM_ImoveisMoveis.bd.Casa;
import br.edu.ifba.mobile.IM_ImoveisMoveis.bd.FachadaBD;

/**
 * Created by LEANDRO on 27/05/2016.
 */
public class GravacaoCasa extends AsyncTask<Void, Void, String>{

    private Context contexto = null;
    private Casa casa = null;

    public GravacaoCasa(Context contexto, Casa casa){
        this.contexto = contexto;
        this.casa = casa;
    }

    @Override
    protected String doInBackground(Void... params) {
        String mensagem = "";

        long codigo = -1;
        if (casa.getCodigo() == -1){
            codigo = FachadaBD.getInstancia().inserirCasa(casa);
        }else{
            codigo = FachadaBD.getInstancia().atualizarCasa(casa);
        }

        if(codigo > 0){
            mensagem = "Dados Gravados Ser Humaninho!";
        }
        else{
            mensagem = "Erro de Inserção Ser Humaninho!";
        }

        return mensagem;
    }

    @Override
    protected void onPostExecute(String mensagem){
        Toast.makeText(contexto, mensagem, Toast.LENGTH_LONG).show();
    }

}
