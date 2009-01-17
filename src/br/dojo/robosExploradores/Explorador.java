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
		mapa = mapa.replaceAll(" ", "");
		String[] linhas = mapa.split("\n");
		
		char [][] retorno = new char[linhas.length][linhas.length];
		
		
		for (int x=0; x<linhas.length; x++){
			for (int y = 0; y < linhas[0].length(); y++){
				retorno[y][x] = linhas[y].charAt(x);
			}									
		} 
		return retorno;
	}
}








