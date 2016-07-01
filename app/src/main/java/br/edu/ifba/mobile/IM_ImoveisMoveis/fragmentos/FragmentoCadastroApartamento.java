package br.edu.ifba.mobile.IM_ImoveisMoveis.fragmentos;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import br.edu.ifba.mobile.IM_ImoveisMoveis.bd.Apartamento;
import br.edu.ifba.mobile.IM_ImoveisMoveis.tarefas.GravacaoApartamento;
import br.edu.ifba.mobile.IM_ImoveisMoveis.R;

/**
 * Created by LEANDRO on 13/05/2016.
 */
public class FragmentoCadastroApartamento extends Fragment {

    private static FragmentoCadastroApartamento instancia = null;
    public static FragmentoCadastroApartamento getInstancia(){
        if(instancia == null){
            instancia = new FragmentoCadastroApartamento();
        }
        return instancia;
    }

    private View tela = null;

    private EditText endApto = null;
    private EditText bairro = null;
    private EditText complemento = null;
    private EditText valor = null;
    private EditText txCond = null;
    private EditText areaLazer = null;
    private EditText areaServico = null;
    private EditText quarto = null;
    private EditText banheiro = null;
    private EditText sala = null;
    private EditText cozinha = null;
    private EditText estacionamento = null;
    private EditText iptu = null;
    private EditText agua = null;
    private EditText luz = null;
    private EditText obs = null;

    private Button botaoGravar = null;

    private Apartamento apartamento = null;

    @Override
    public View onCreateView(LayoutInflater inflador, ViewGroup vgroup, Bundle bundle){
        tela = inflador.inflate(R.layout.fragmento_cadastro_apartamento, vgroup, false);

        preparar();

        return tela;
    }

    private void preparar(){

        endApto = (EditText) tela.findViewById(R.id.endApto);
        bairro = (EditText) tela.findViewById(R.id.bairroApto);
        complemento = (EditText) tela.findViewById(R.id.complementoApto);
        valor = (EditText) tela.findViewById(R.id.valorApto);
        txCond = (EditText) tela.findViewById(R.id.txCond);
        areaLazer = (EditText) tela.findViewById(R.id.areaLazer);
        areaServico = (EditText) tela.findViewById(R.id.areaServicoApto);
        quarto = (EditText) tela.findViewById(R.id.quartosApto);
        banheiro = (EditText) tela.findViewById(R.id.banheirosApto);
        sala = (EditText) tela.findViewById(R.id.salasApto);
        cozinha = (EditText) tela.findViewById(R.id.cozinhaApto);
        estacionamento = (EditText) tela.findViewById(R.id.estacionamentoApto);
        iptu = (EditText) tela.findViewById(R.id.iptuApto);
        agua = (EditText) tela.findViewById(R.id.aguaApto);
        luz = (EditText) tela.findViewById(R.id.luzApto);
        obs = (EditText) tela.findViewById(R.id.obsApto);

        botaoGravar = (Button) tela.findViewById(R.id.botaoGravar);

        botaoGravar.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) { // assinc test
                        GravacaoApartamento gravacao = new GravacaoApartamento(getContexto(), getApartamento());
                        gravacao.execute();
                    }
                }
        );
    }

    @TargetApi(Build.VERSION_CODES.M)
    private Context getContexto(){
        return this.getContext();
    }

    private Apartamento getApartamento(){
        apartamento.setEndereco(endApto.getText().toString());
        apartamento.setBairro(bairro.getText().toString());
        apartamento.setComplemento(complemento.getText().toString());
        apartamento.setValor(Double.valueOf(valor.getText().toString()));
        apartamento.setTxCond(Double.valueOf(txCond.getText().toString()));
        apartamento.setAreaLazer(areaLazer.getText().toString());
        apartamento.setAreaServico(areaServico.getText().toString());
        apartamento.setQuarto (quarto.getText().toString());
        apartamento.setBanheiros(banheiro.getText().toString());
        apartamento.setSala (sala.getText().toString());
        apartamento.setCozinha(cozinha.getText().toString());
        apartamento.setEstacionamento (estacionamento.getText().toString());
        apartamento.setIptu(iptu.getText().toString());
        apartamento.setAgua(agua.getText().toString());
        apartamento.setLuz(luz.getText().toString());
        apartamento.setObs(obs.getText().toString());


        return apartamento;
    }

    public void exibirApartamentoSelecionado(){
        apartamento = FragmentoListaApartamentos.getInstancia().getApartamentoSelecionado(); //Pega a casa selecionada(instancia ja estara selecionada)

        if (apartamento.getCodigo() == -1){
            limparCampos();
        } else{
            carregarCampos();
        }
    }

    private void limparCampos(){
        endApto.setText("");
        bairro.setText("Candeias");
        complemento.setText("Predio X");
        valor.setText("0.00");
        txCond.setText("0.00");
        areaLazer.setText("Pisc|Acad");
        areaServico.setText("Tem ou Não");
        quarto.setText("1/4");
        banheiro.setText("0 Banheiro");
        sala.setText("0 Salas");
        cozinha.setText("0 Cozinha");
        estacionamento.setText("Tem ou Não");
        iptu.setText("S|N");
        agua.setText("S|N");
        luz.setText("S|N");
        obs.setText("Observações");
    }

    private void carregarCampos(){
        endApto.setText(apartamento.getEndereco());
        bairro.setText(apartamento.getBairro());
        complemento.setText(apartamento.getComplemento());
        valor.setText(apartamento.getValor() + "");
        txCond.setText(apartamento.getTxCond() + "");
        areaLazer.setText(apartamento.getAreaLazer());
        areaServico.setText(apartamento.getAreaServico());
        quarto.setText(apartamento.getQuarto() );
        banheiro.setText(apartamento.getBanheiros());
        sala.setText(apartamento.getSala());
        cozinha.setText(apartamento.getCozinha());
        estacionamento.setText(apartamento.getEstacionamento());
        iptu.setText(apartamento.getIptu());
        agua.setText(apartamento.getAgua());
        luz.setText(apartamento.getLuz());
        obs.setText(apartamento.getObs());
    }


}
