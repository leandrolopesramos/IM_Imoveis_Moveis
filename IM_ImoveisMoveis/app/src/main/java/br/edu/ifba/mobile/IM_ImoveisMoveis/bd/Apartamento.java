package br.edu.ifba.mobile.IM_ImoveisMoveis.bd;

import java.text.DecimalFormat;

public class Apartamento {


	private long codigo= -1;
	private String endereco;
	private String bairro;
	private String complemento;
	private double valor;
	private double txCond;
	private String areaLazer;
	private String areaServico;
	private String quarto;
	private String banheiros;
	private String sala;
	private String cozinha;
	private String estacionamento;
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

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getTxCond() {
		return txCond;
	}

	public void setTxCond(double txCond) {
		this.txCond = txCond;
	}

	public String getAreaLazer() {
		return areaLazer;
	}

	public void setAreaLazer(String areaLazer) {
		this.areaLazer = areaLazer;
	}

	public String getAreaServico() {
		return areaServico;
	}

	public void setAreaServico(String areaServico) {
		this.areaServico = areaServico;
	}

	public String getQuarto() {
		return quarto;
	}

	public void setQuarto(String quarto) {
		this.quarto = quarto;
	}

	public String getBanheiros() {
		return banheiros;
	}

	public void setBanheiros(String banheiros) {
		this.banheiros = banheiros;
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

	public String getEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(String estacionamento) {
		this.estacionamento = estacionamento;
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

	@Override
	public String toString() {
		return bairro + " - R$" + new DecimalFormat("0.00").format(valor) + " + TX = R$" + new DecimalFormat("0.00").format(txCond) + " - " + quarto + " - " + banheiros ;

	}

}

