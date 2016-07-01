package br.edu.ifba.mobile.IM_ImoveisMoveis.fragmentos;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.edu.ifba.mobile.IM_ImoveisMoveis.R;

/**
 * Created by LEANDRO on 13/05/2016.
 */
public class FragmentoTelaInicial extends Fragment {

    private static FragmentoTelaInicial instancia = null;

    public static FragmentoTelaInicial getInstancia(){
        if(instancia == null){
            instancia = new FragmentoTelaInicial();
        }
        return instancia;
    }

    private View tela = null;

    @Override
    public View onCreateView(LayoutInflater inflador, ViewGroup vgrupo,Bundle bundle){
        tela = inflador.inflate(R.layout.fragmento_tela_inicial, vgrupo, false);
        return tela;
    }

}
