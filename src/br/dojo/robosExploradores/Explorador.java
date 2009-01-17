package br.dojo.robosExploradores;

public class Explorador {
	private int linha;
	private int coluna;
	private String mapa1;
	private String mapa2;

	public int getLinha() {
		return linha;
	}
	public void setLinha(int linha) {
		this.linha = linha;
	}
	public int getColuna() {
		return coluna;
	}
	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	
	public String getMapa1() {
		return mapa1;
	}
	public void setMapa1(String mapa1) {
		this.mapa1 = mapa1;
	}
	public String getMapa2() {
		return mapa2;
	}
	public void setMapa2(String mapa2) {
		this.mapa2 = mapa2;
	}
	
	public void definirMapas(String mapa1, String mapa2) {
		this.mapa1 = mapa1;
		this.mapa2 = mapa2;
	}
	
	public int explorarMapas() {
		
		return 3;
	}
	public static char[][] stringToArray(String mapa) {
		char [][] retorno = new char[4][4];
		
		mapa = mapa.replaceAll(" ", "");
		
		String[] linhas = mapa.split("\n");
		//linha 1
		for (int x=0; x<4; x++){
			retorno[0][x] = linhas[0].charAt(x);
			retorno[1][x] = linhas[1].charAt(x);
			retorno[2][x] = linhas[2].charAt(x);
			retorno[3][x] = linhas[3].charAt(x);
		} 
		return retorno;
	}
}








