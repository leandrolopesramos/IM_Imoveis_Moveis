package br.edu.ifba.mobile.IM_ImoveisMoveis.bd;

import java.text.DecimalFormat;

/**
 * Created by LEANDRO on 28/06/2016.
 */
public class Casa {
    private long codigo= -1;
    private String endereco;
    private String bairro;
    private String complemento;
    private double valor;
    private String quarto;
    private String banheiro;
    private String sala;
    private String cozinha;
    private String garagem;
    private String iptu;
    private String agua;
    private String luz;
    private String obs;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getQuarto() {
        return quarto;
    }

    public void setQuarto(String quarto) {
        this.quarto = quarto;
    }

    public String getBanheiro() {
        return banheiro;
    }

    public void setBanheiro(String banheiro) {
        this.banheiro = banheiro;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getCozinha() {
        return cozinha;
    }

    public void setCozinha(String cozinha) {
        this.cozinha = cozinha;
    }

    public String getGaragem() {
        return garagem;
    }

    public void setGaragem(String garagem) {
        this.garagem = garagem;
    }

    public String getIptu() {
        return iptu;
    }

    public void setIptu(String iptu) {
        this.iptu = iptu;
    }

    public String getAgua() {
        return agua;
    }

    public void setAgua(String agua) {
        this.agua = agua;
    }

    public String getLuz() {
        return luz;
    }

    public void setLuz(String luz) {
        this.luz = luz;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return bairro + " - R$" + new DecimalFormat("0.00").format(valor) + " - " + quarto + "" + banheiro;

    }

}
