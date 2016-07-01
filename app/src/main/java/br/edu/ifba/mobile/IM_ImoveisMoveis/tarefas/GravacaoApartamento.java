package br.edu.ifba.mobile.IM_ImoveisMoveis.tarefas;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import br.edu.ifba.mobile.IM_ImoveisMoveis.bd.Apartamento;
import br.edu.ifba.mobile.IM_ImoveisMoveis.bd.FachadaBD;

/**
 * Created by LEANDRO on 27/05/2016.
 */
public class GravacaoApartamento extends AsyncTask<Void, Void, String>{

    private Context contexto = null;
    private Apartamento apartamento= null;

    public GravacaoApartamento(Context contexto, Apartamento apartamento){
        this.contexto = contexto;
        this.apartamento = apartamento;
    }

    @Override
    protected String doInBackground(Void... params) {
        String mensagem = "";

        long codigo = -1;
        if (apartamento.getCodigo() == -1){
            codigo = FachadaBD.getInstancia().inserirApto(apartamento);
        }else{
            codigo = FachadaBD.getInstancia().atualizarApto(apartamento);
        }

        if(codigo > 0){
            mensagem = "Dados Gravados com sucesso!";
        }
        else{
            mensagem = "Erro de Inserção!";
        }

        return mensagem;
    }

    @Override
    protected void onPostExecute(String mensagem){
        Toast.makeText(contexto, mensagem, Toast.LENGTH_LONG).show();
    }

}
