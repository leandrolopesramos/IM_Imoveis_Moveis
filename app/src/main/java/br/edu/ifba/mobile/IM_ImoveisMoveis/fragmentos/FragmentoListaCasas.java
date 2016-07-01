package br.edu.ifba.mobile.IM_ImoveisMoveis.fragmentos;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import br.edu.ifba.mobile.IM_ImoveisMoveis.bd.Casa;
import br.edu.ifba.mobile.IM_ImoveisMoveis.tarefas.ListagemCasas;
import br.edu.ifba.mobile.IM_ImoveisMoveis.tarefas.RemocaoCasa;
import br.edu.ifba.mobile.IM_ImoveisMoveis.R;

/**
 * Created by LEANDRO on 20/05/2016.
 */
public class FragmentoListaCasas extends Fragment {

    private static FragmentoListaCasas instancia = null;
    public static FragmentoListaCasas getInstancia(){
        if (instancia == null){
            instancia = new FragmentoListaCasas();
        }
        return instancia;
    }

    private View tela = null;
    private ListView lista = null;



    @Override
    public View onCreateView(LayoutInflater inflador,
                             ViewGroup vgrupo, Bundle bundle){
        tela = inflador.inflate(R.layout.fragmento_listagem_casa, vgrupo, false);

        preparar();

        return tela;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflador /*pega layout em xml e cria grafico de fato criar o menu*/ ){
        super.onCreateOptionsMenu(menu, inflador);

        inflador.inflate(R.menu.menu_imoveis, menu);
    }


    private void preparar(){
        lista = (ListView) tela.findViewById(R.id.listaCasas);

        //Adiciona a opção  de menu ao fragmento
        this.setHasOptionsMenu(true);
        //lista clicavel
        lista.setClickable(true);
        //Apenas uma escolha por vez
        lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

    }

    @TargetApi(Build.VERSION_CODES.M)
    public void atualizar(){
        ListagemCasas listagem = new ListagemCasas(this.getContext(), lista);
        listagem.execute();
    }

    public Casa getCasaSelecionada(){
        Casa casa = new Casa();

        int posicao = lista.getCheckedItemPosition(); //Seleciona a opcao slecionada

        if (posicao != ListView.INVALID_POSITION){
            casa = (Casa) lista.getItemAtPosition(posicao); //Converte a o objeto posição em casa
        }

        return casa;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        long id = item.getItemId();

        if (id != AdapterView.INVALID_ROW_ID){
            if (id == R.id.cadastro_remover){
                RemocaoCasa remocao = new RemocaoCasa(this.getContext(), this.getCasaSelecionada());
                remocao.execute();//sempre tem q chamar o execute do assinc task
                atualizar();
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
