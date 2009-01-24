package br.dojo.robosExploradores;

public class Explorador {
	private int linha;
	private int coluna;
	private String mapa1;
	private String mapa2;
	private char[][] arrayMapa1;
	private char[][] arrayMapa2;
	
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
		
		this.arrayMapa1 = stringToArray(mapa1);
		this.arrayMapa2 = stringToArray(mapa2);
		
	}
	
	public int explorarMapas() {
		int r = 0;
		int f = 0;
		int r2 = 0;
		int f2 = 0;
		
		int qtdLinhas = arrayMapa1.length;			
		int qtdColunas = arrayMapa1[0].length;
		
		
		
		for(int i=0; i < qtdColunas; i++ ){
			if(arrayMapa1[0][i] == 'R')
				r = i;
			if(arrayMapa1[0][i] == 'F')
				f = i;
		}
		
		for(int i=0; i < qtdLinhas; i++ ){
			if(arrayMapa1[i][0] == 'R')
				r2 = i;
			if(arrayMapa1[i][0] == 'F')
				f2 = i;
		}
		
		if(f-r == 0) {
			return Math.abs(f2-r2);
		}
		
		return Math.abs(f - r);
	}
	
	public static char[][] stringToArray(String mapa) {
		mapa = mapa.replaceAll(" ", "");
		String[] linhas = mapa.split("\n");
		
		char [][] retorno = new char[linhas.length][linhas[0].length()];
		
		
		for (int x=0; x<linhas.length; x++){
			for (int y = 0; y < linhas[0].length(); y++){
				retorno[x][y] = linhas[x].charAt(y);
			}									
		} 
		return retorno;
	}
}








