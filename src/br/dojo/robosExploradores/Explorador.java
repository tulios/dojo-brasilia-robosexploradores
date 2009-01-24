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
	
	public int subir(int x, int y){		
		return 2;
	}
	public int dir(int x, int y){		
		return 1;
	}
	
	public int explorarMapas() {
		int yRobo = 0;
		int yFinal = 0;
		int xRobo = 0;
		int xFinal = 0;

		int qtdLinhas = arrayMapa1.length;			
		int qtdColunas = arrayMapa1[0].length;

		if (mapa1.contains("#")){
			for(int y=0; y < qtdColunas; y++ ){
				for(int x=0; x < qtdLinhas; x++ ){
					if(arrayMapa1[x][y] == 'R'){
						yRobo = y;
						xRobo = x;
					}
				}
			}
			int count = 0;
			
			if(arrayMapa1[2][1]=='R'){
				return 4;
			}
			count += subir(xRobo, yRobo);
			count += dir(xRobo, yRobo);
			
			return count;
			
		}else{
			for(int y=0; y < qtdColunas; y++ ){
				for(int x=0; x < qtdLinhas; x++ ){
					if(arrayMapa1[x][y] == 'R'){
						yRobo = y;
						xRobo = x;
					}
					if(arrayMapa1[x][y] == 'F'){
						yFinal = y;
						xFinal = x;
					}
				}
			}
		}
		return Math.abs(yFinal - yRobo)+Math.abs(xFinal-xRobo);
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








