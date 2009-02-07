package br.dojo.robosExploradores;

public class Explorador {
	private int linha;
	private int coluna;
	private String mapa1;
	private String mapa2;
	private char[][] arrayMapa1;
	private char[][] arrayMapa2;
	
	private int linhaRobo;
	private int colunaRobo;
	
	private int colunaFinal;
	private int linhaFinal;

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
	
	public void andar() {
		
		//Se o robo estiver abaixo do final
		if (linhaRobo-linhaFinal > 0) {
			if (podeSubir()){
				subir();

			}else{
				if (podeAndarEsquerda() ){
					andarEsquerda();

				}else if (podeAndarDireita()){
					andarDireita();

				}else if (podeDescer()){
					descer();
				}
			}
		} else {
			//Se o robo estiver a direita do final
			if (colunaRobo-colunaFinal > 0) {
				if(podeAndarEsquerda()){
					andarEsquerda();
				}else {
					if(podeSubir()){
						subir();						
					}else{
						descer();
					}
				}
			} else {
				if (podeAndarDireita())
					andarDireita();
				else{
					if (podeDescer())
						descer();
					else{
						subir();
					}
						
				}
			}
		}
		
	}
	private void descer() {
		arrayMapa1[linhaRobo][colunaRobo] = '*';
		arrayMapa1[linhaRobo+1][colunaRobo] = 'R';
	}
	private void andarDireita() {
		arrayMapa1[linhaRobo][colunaRobo] = '*';
		arrayMapa1[linhaRobo][colunaRobo+1] = 'R';
	}
	private void andarEsquerda() {
		arrayMapa1[linhaRobo][colunaRobo] = '*';
		arrayMapa1[linhaRobo][colunaRobo-1] = 'R';
	}
	private void subir() {
		arrayMapa1[linhaRobo][colunaRobo] = '*';
		arrayMapa1[linhaRobo-1][colunaRobo] = 'R';
	}
	private boolean podeAndarDireita() {
		return (colunaRobo+1) < arrayMapa1[0].length && arrayMapa1[linhaRobo][colunaRobo+1] == '.';
	}
	private boolean podeAndarEsquerda() {
		return (colunaRobo-1) >= 0 && arrayMapa1[linhaRobo][colunaRobo-1] == '.';
	}
	private boolean podeSubir() {
		return (linhaRobo - 1) >= 0 && arrayMapa1[linhaRobo-1][colunaRobo] == '.';
	}
	private boolean podeDescer() {
		return (linhaRobo + 1) < arrayMapa1.length && arrayMapa1[linhaRobo+1][colunaRobo] == '.';
	}
	
	public int explorarMapas() {
		
		int distancia = calculaDistancia();
		
		if (mapa1.contains("#")){			
			if(distancia == 1){
				return 1;
			}		
			
			andar();
			
			return explorarMapas()+1;
			
		}
		return distancia;
	}
	
	private int calculaDistancia() {
		localizarRoboEFinal();
		return Math.abs(colunaFinal - colunaRobo)+Math.abs(linhaFinal-linhaRobo);
	}
	private void localizarRoboEFinal() {
		int qtdLinhas = arrayMapa1.length;			
		int qtdColunas = arrayMapa1[0].length;
		
		for(int y=0; y < qtdColunas; y++ ){
			for(int x=0; x < qtdLinhas; x++ ){
				if(arrayMapa1[x][y] == 'R'){
					colunaRobo = y;
					linhaRobo = x;
				}
				if(arrayMapa1[x][y] == 'F'){
					colunaFinal = y;
					linhaFinal = x;
				}
			}
		}
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








