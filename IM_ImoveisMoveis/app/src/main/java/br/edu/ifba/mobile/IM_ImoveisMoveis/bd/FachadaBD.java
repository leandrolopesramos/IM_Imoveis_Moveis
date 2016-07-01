package br.edu.ifba.mobile.IM_ImoveisMoveis.bd;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FachadaBD extends SQLiteOpenHelper {

	private static FachadaBD instancia = null;

	public static FachadaBD criarInstancia(Context context){
		if(instancia == null){
			instancia = new FachadaBD(context);
		}

		return instancia;

	}

	public static FachadaBD getInstancia(){
		return instancia;
	}

	private static String NOME_BANCO = "ImoveisMoveis";
	private static int VERSAO_BANCO = 1;

	public FachadaBD(Context context) {
		super(context, NOME_BANCO, null, VERSAO_BANCO);
	}

	private static String COMANDO_CRIACAO_TABELA_CASA =
			"CREATE TABLE CASA (CODIGO INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ "END TEXT, BAIRRO TEXT, COMPLEMENTO TEXT, VALOR REAL, QUARTO TEXT, BANHEIRO TEXT,"
			+ "SALA TEXT, COZINHA TEXT, GARAGEM TEXT, IPTU TEXT, AGUA TEXT, LUZ TEXT, OBS TEXT)";

	private static String COMANDO_CRIACAO_TABELA_APARTAMENTO = "CREATE TABLE APARTAMENTO(CODIGO INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ "END TEXT, BAIRRO TEXT, COMPLEMENTO TEXT, VALOR REAL, TXCOND REAL, AREALAZER TEXT, AREASERVICO TEXT, QUARTO TEXT, BANHEIRO TEXT,"
			+ "SALA TEXT, COZINHA TEXT, ESTACIONAMENTO TEXT, IPTU TEXT, AGUA TEXT, LUZ TEXT, OBS TEXT)";


	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(COMANDO_CRIACAO_TABELA_CASA);
		db.execSQL(COMANDO_CRIACAO_TABELA_APARTAMENTO);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int versaoNova) {

	}

	// metodos de criacao de um CRUD utilizando o SQLite
	
	public long inserirCasa(Casa casa) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues valores = new ContentValues();

		valores.put("END", casa.getEndereco());
		valores.put("BAIRRO", casa.getBairro());
		valores.put("COMPLEMENTO", casa.getComplemento());
		valores.put("VALOR", casa.getValor());
		valores.put("QUARTO", casa.getQuarto());
		valores.put("BANHEIRO", casa.getBanheiro());
		valores.put("SALA", casa.getSala());
		valores.put("COZINHA", casa.getCozinha());
		valores.put("GARAGEM", casa.getGaragem());
		valores.put("IPTU", casa.getIptu());
		valores.put("AGUA", casa.getAgua());
		valores.put("LUZ", casa.getLuz());
		valores.put("OBS", casa.getObs());

		long codigo = db.insert("CASA", null, valores); //retorna o ID da insercao.

		return codigo;
	}

	public long atualizarCasa(Casa casa) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues valores = new ContentValues();

		valores.put("END", casa.getEndereco());
		valores.put("BAIRRO", casa.getBairro());
		valores.put("COMPLEMENTO", casa.getComplemento());
		valores.put("VALOR", casa.getValor());
		valores.put("QUARTO", casa.getQuarto());
		valores.put("BANHEIRO", casa.getBanheiro());
		valores.put("SALA", casa.getSala());
		valores.put("COZINHA", casa.getCozinha());
		valores.put("GARAGEM", casa.getGaragem());
		valores.put("IPTU", casa.getIptu());
		valores.put("AGUA", casa.getAgua());
		valores.put("LUZ", casa.getLuz());
		valores.put("OBS", casa.getObs());

		long codigo = db.update("CASA", valores, "CODIGO = " + casa.getCodigo(), null);

		return codigo;
	}

	public int removerCasa(Casa casa) {

		SQLiteDatabase db = this.getWritableDatabase();

		return db.delete("CASA", "CODIGO = " + casa.getCodigo(), null);
	}

	public List<Casa> listarCasas() {
		List<Casa> casas = new ArrayList<Casa>();
		SQLiteDatabase db = this.getReadableDatabase();

		String selecao = "SELECT END, BAIRRO , COMPLEMENTO , VALOR , QUARTO , BANHEIRO, " +
				"SALA , COZINHA , GARAGEM , IPTU , AGUA , LUZ , OBS FROM CASA";

		Cursor cursor = db.rawQuery(selecao, null);

		if(cursor != null){
			boolean temProximo = cursor.moveToFirst();
			while (temProximo){
				Casa casa = new Casa();

				casa.setEndereco(cursor.getString(cursor.getColumnIndex("END")));
				casa.setBairro(cursor.getString(cursor.getColumnIndex("BAIRRO")));
				casa.setComplemento(cursor.getString(cursor.getColumnIndex("COMPLEMENTO")));
				casa.setValor(cursor.getFloat(cursor.getColumnIndex("VALOR")));
				casa.setQuarto(cursor.getString(cursor.getColumnIndex("QUARTO")));
				casa.setBanheiro(cursor.getString(cursor.getColumnIndex("BANHEIRO")));
				casa.setSala(cursor.getString(cursor.getColumnIndex("SALA")));
				casa.setCozinha(cursor.getString(cursor.getColumnIndex("COZINHA")));
				casa.setGaragem(cursor.getString(cursor.getColumnIndex("GARAGEM")));
				casa.setIptu(cursor.getString(cursor.getColumnIndex("IPTU")));
				casa.setAgua(cursor.getString(cursor.getColumnIndex("AGUA")));
				casa.setLuz(cursor.getString(cursor.getColumnIndex("LUZ")));
				casa.setObs(cursor.getString(cursor.getColumnIndex("OBS")));

				casas.add(casa);

				temProximo = cursor.moveToNext();
			}
		}

		return casas;

	}


	public long inserirApto(Apartamento apartamento) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues valores = new ContentValues();

		valores.put("END", apartamento.getEndereco());
		valores.put("BAIRRO", apartamento.getBairro());
		valores.put("COMPLEMENTO", apartamento.getComplemento());
		valores.put("VALOR", apartamento.getValor());
		valores.put("TXCOND", apartamento.getTxCond());
		valores.put("AREALAZER", apartamento.getAreaLazer());
		valores.put("AREASERVICO", apartamento.getAreaServico());
		valores.put("QUARTO", apartamento.getQuarto());
		valores.put("BANHEIRO", apartamento.getBanheiros());
		valores.put("SALA", apartamento.getSala());
		valores.put("COZINHA", apartamento.getCozinha());
		valores.put("ESTACIONAMENTO", apartamento.getEstacionamento());
		valores.put("IPTU", apartamento.getIptu());
		valores.put("AGUA", apartamento.getAgua());
		valores.put("LUZ", apartamento.getLuz());
		valores.put("OBS", apartamento.getObs());

		long codigo = db.insert("APARTAMENTO", null, valores); //retorna o ID da insercao.

		return codigo;
	}

	public long atualizarApto(Apartamento apartamento) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues valores = new ContentValues();

		valores.put("END", apartamento.getEndereco());
		valores.put("BAIRRO", apartamento.getBairro());
		valores.put("COMPLEMENTO", apartamento.getComplemento());
		valores.put("VALOR", apartamento.getValor());
		valores.put("TXCOND", apartamento.getTxCond());
		valores.put("AREALAZER", apartamento.getAreaLazer());
		valores.put("AREASERVICO", apartamento.getAreaServico());
		valores.put("QUARTO", apartamento.getQuarto());
		valores.put("BANHEIRO", apartamento.getBanheiros());
		valores.put("SALA", apartamento.getSala());
		valores.put("COZINHA", apartamento.getCozinha());
		valores.put("ESTACIONAMENTO", apartamento.getEstacionamento());
		valores.put("IPTU", apartamento.getIptu());
		valores.put("AGUA", apartamento.getAgua());
		valores.put("LUZ", apartamento.getLuz());
		valores.put("OBS", apartamento.getObs());

		long codigo = db.update("APARTAMENTO", valores, "CODIGO = " + apartamento.getCodigo(), null);

		return codigo;
	}

	public int removerApto(Apartamento apartamento){

		SQLiteDatabase db = this.getWritableDatabase();

		return db.delete("APARTAMENTO", "CODIGO = " + apartamento.getCodigo(), null);
	}

	public List<Apartamento> listarApartamentos() {
		List<Apartamento> apartamentos = new ArrayList<Apartamento>();
		SQLiteDatabase db = this.getReadableDatabase();

		String selecao = "SELECT END, BAIRRO , COMPLEMENTO , VALOR , TXCOND , AREALAZER , AREASERVICO , QUARTO , BANHEIRO," +
				" SALA , COZINHA , ESTACIONAMENTO , IPTU , AGUA , LUZ , OBS FROM APARTAMENTO";

		Cursor cursor = db.rawQuery(selecao, null);

		if(cursor != null){
			boolean temProximo = cursor.moveToFirst();
			while (temProximo){
				Apartamento apartamento = new Apartamento();

				apartamento.setEndereco(cursor.getString(cursor.getColumnIndex("END")));
				apartamento.setBairro(cursor.getString(cursor.getColumnIndex("BAIRRO")));
				apartamento.setComplemento(cursor.getString(cursor.getColumnIndex("COMPLEMENTO")));
				apartamento.setValor(cursor.getFloat(cursor.getColumnIndex("VALOR")));
				apartamento.setTxCond(cursor.getFloat(cursor.getColumnIndex("TXCOND")));
				apartamento.setAreaLazer(cursor.getString(cursor.getColumnIndex("AREALAZER")));
				apartamento.setAreaServico(cursor.getString(cursor.getColumnIndex("AREASERVICO")));
				apartamento.setQuarto(cursor.getString(cursor.getColumnIndex("QUARTO")));
				apartamento.setBanheiros(cursor.getString(cursor.getColumnIndex("BANHEIRO")));
				apartamento.setSala(cursor.getString(cursor.getColumnIndex("SALA")));
				apartamento.setCozinha(cursor.getString(cursor.getColumnIndex("COZINHA")));
				apartamento.setEstacionamento(cursor.getString(cursor.getColumnIndex("ESTACIONAMENTO")));
				apartamento.setIptu(cursor.getString(cursor.getColumnIndex("IPTU")));
				apartamento.setAgua(cursor.getString(cursor.getColumnIndex("AGUA")));
				apartamento.setLuz(cursor.getString(cursor.getColumnIndex("LUZ")));
				apartamento.setObs(cursor.getString(cursor.getColumnIndex("OBS")));

				apartamentos.add(apartamento);

				temProximo = cursor.moveToNext();
			}
		}

		return apartamentos;
	}
	
}