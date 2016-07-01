package br.edu.ifba.mobile.IM_ImoveisMoveis.fragmentos;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import br.edu.ifba.mobile.IM_ImoveisMoveis.bd.Casa;
import br.edu.ifba.mobile.IM_ImoveisMoveis.tarefas.GravacaoCasa;
import br.edu.ifba.mobile.IM_ImoveisMoveis.R;

/**
 * Created by LEANDRO on 13/05/2016.
 */
public class FragmentoCadastroCasa extends Fragment {

    private static FragmentoCadastroCasa instancia = null;
    
    public static FragmentoCadastroCasa getInstancia(){
        if(instancia == null){
            instancia = new FragmentoCadastroCasa();
        }
        return instancia;
    }

    private View tela = null;

    private EditText endCasa = null;
    private EditText bairro = null;
    private EditText complemento = null;
    private EditText valor = null;
    private EditText quarto = null;
    private EditText banheiro = null;
    private EditText sala = null;
    private EditText cozinha = null;
    private EditText garagem = null;
    private EditText iptu = null;
    private EditText agua = null;
    private EditText luz = null;
    private EditText obs = null;

    private Button botaoGravar = null;

    private Casa casa = null;

    @Override
    public View onCreateView(LayoutInflater inflador, ViewGroup vgroup, Bundle bundle){
        tela = inflador.inflate(R.layout.fragmento_cadastro_casa, vgroup, false);

        preparar();

        return tela;
    }

    private void preparar(){
        endCasa = (EditText) tela.findViewById(R.id.endCasa);
        bairro = (EditText) tela.findViewById(R.id.bairroCasa);
        complemento = (EditText) tela.findViewById(R.id.complementoCasa);
        valor = (EditText) tela.findViewById(R.id.valorCasa);
        quarto = (EditText) tela.findViewById(R.id.quartosCasa);
        banheiro = (EditText) tela.findViewById(R.id.banheirosCasa);
        sala = (EditText) tela.findViewById(R.id.salaCasa);
        cozinha = (EditText) tela.findViewById(R.id.cozinhaCasa);
        garagem = (EditText) tela.findViewById(R.id.garagem);
        iptu = (EditText) tela.findViewById(R.id.iptuCasa);
        agua = (EditText) tela.findViewById(R.id.aguaCasa);
        luz = (EditText) tela.findViewById(R.id.luzCasa);
        obs = (EditText) tela.findViewById(R.id.obsCasa);

        botaoGravar = (Button) tela.findViewById(R.id.botaoGravar);

        botaoGravar.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) { // assinc test
                        GravacaoCasa gravacao = new GravacaoCasa(getContexto(), getCasa());
                        gravacao.execute();
                    }
                }
        );
    }

    private Context getContexto(){
        return this.getContext();
    }

    private Casa getCasa(){
        casa.setEndereco(endCasa.getText().toString());
        casa.setBairro(bairro.getText().toString());
        casa.setComplemento(complemento.getText().toString());
        casa.setValor(Double.valueOf(valor.getText().toString()));
        casa.setQuarto(quarto.getText().toString());
        casa.setBanheiro(banheiro.getText().toString());
        casa.setSala(sala.getText().toString());
        casa.setCozinha(cozinha.getText().toString());
        casa.setGaragem(garagem.getText().toString());
        casa.setIptu(iptu.getText().toString());
        casa.setAgua(agua.getText().toString());
        casa.setLuz(luz.getText().toString());
        casa.setObs(obs.getText().toString());

        return casa;
    }

    public void exibirCasaSelecionada(){
        casa = FragmentoListaCasas.getInstancia().getCasaSelecionada(); //Pega a casa selecionada(instancia ja estara selecionada)

        if (casa.getCodigo() == -1){
            limparCampos();
        } else{
            carregarCampos();
        }
    }

    private void limparCampos(){
        endCasa.setText("");
        bairro.setText("Centro");
        complemento.setText("Casa");
        valor.setText("0.00");
        quarto.setText("1/4");
        banheiro.setText("0 Banheiros");
        sala.setText("0 Salas");
        cozinha.setText("0 Cozinhas");
        garagem.setText("0 Garagens");
        iptu.setText("S|N");
        agua.setText("S|N");
        luz.setText("S|N");
        obs.setText("Observações");
    }

    private void carregarCampos(){
        endCasa.setText(casa.getEndereco());
        bairro.setText(casa.getBairro());
        complemento.setText(casa.getComplemento());
        valor.setText(casa.getValor() + "");
        quarto.setText(casa.getQuarto());
        banheiro.setText(casa.getBanheiro());
        sala.setText(casa.getSala());
        cozinha.setText(casa.getCozinha());
        garagem.setText(casa.getGaragem());
        iptu.setText(casa.getIptu());
        agua.setText(casa.getAgua());
        luz.setText(casa.getLuz());
        obs.setText(casa.getObs());
    }
}
