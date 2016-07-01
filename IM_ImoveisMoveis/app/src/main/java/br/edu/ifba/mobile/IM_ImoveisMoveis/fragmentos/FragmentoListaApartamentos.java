package br.edu.ifba.mobile.IM_ImoveisMoveis.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import br.edu.ifba.mobile.IM_ImoveisMoveis.bd.Apartamento;
import br.edu.ifba.mobile.IM_ImoveisMoveis.R;
import br.edu.ifba.mobile.IM_ImoveisMoveis.tarefas.ListagemApartamentos;
import br.edu.ifba.mobile.IM_ImoveisMoveis.tarefas.RemocaoApartamento;

/**
 * Created by LEANDRO on 20/05/2016.
 */
public class FragmentoListaApartamentos extends Fragment {

    private static FragmentoListaApartamentos instancia = null;
    public static FragmentoListaApartamentos getInstancia(){
        if (instancia == null){
            instancia = new FragmentoListaApartamentos();
        }
        return instancia;
    }

    private View tela = null;
    private ListView lista = null;

    @Override
    public View onCreateView(LayoutInflater inflador,
                             ViewGroup vgrupo, Bundle bundle){
        tela = inflador.inflate(R.layout.fragmento_listagem_apartamento, vgrupo, false);

        preparar();

        return tela;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflador /*pega layout em xml e cria grafico de fato criar o menu*/ ){
        super.onCreateOptionsMenu(menu, inflador);

        inflador.inflate(R.menu.menu_imoveis, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        long id = item.getItemId();

        if (id != AdapterView.INVALID_ROW_ID){
            if (id == R.id.cadastro_remover){
                RemocaoApartamento remocao = new RemocaoApartamento(this.getContext(), this.getApartamentoSelecionado());
                remocao.execute();//sempre tem q chamar o execute do assinc task
                atualizar();
            }
        }

        return super.onOptionsItemSelected(item);
    }


    private void preparar(){
        lista = (ListView) tela.findViewById(R.id.listaApartamentos);

        //Adiciona a opção  de menu ao fragmento
        this.setHasOptionsMenu(true);
        //lista clicavel
        lista.setClickable(true);
        //Apenas uma escolha por vez
        lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

    }

    public void atualizar(){
        ListagemApartamentos listagem = new ListagemApartamentos(this.getContext(), lista);
        listagem.execute();
    }

    public Apartamento getApartamentoSelecionado(){
        Apartamento apartamento = new Apartamento();

        int posicao = lista.getCheckedItemPosition(); //Seleciona a opcao slecionada

        if (posicao != ListView.INVALID_POSITION){
            apartamento = (Apartamento) lista.getItemAtPosition(posicao); //Converte a o objeto posição em casa
        }

        return apartamento;
    }
}
