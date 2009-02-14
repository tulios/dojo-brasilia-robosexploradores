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
	
	public char[][] andar(char[][] arrayMapa1, Contador contador) {
		
		if (naoPodeAndar(arrayMapa1) && arrayMapa1 == null) {
			return null;
		}
		
		int distancia = calculaDistancia(arrayMapa1);
		if(distancia == 1){
			contador.valor++;
			return arrayMapa1;
		}
		
		contador.valor++;
		
		//Se o robo estiver abaixo do final
		if (linhaRobo-linhaFinal > 0) {
			if (podeSubir(arrayMapa1)){
				arrayMapa1 = andar(subir(arrayMapa1), contador);

			}else{
				if (podeAndarEsquerda(arrayMapa1) ){
					arrayMapa1 = andar(andarEsquerda(arrayMapa1), contador);

				}else if (podeAndarDireita(arrayMapa1)){
					arrayMapa1 = andar(andarDireita(arrayMapa1), contador);

				}else if (podeDescer(arrayMapa1)){
					arrayMapa1 = andar(descer(arrayMapa1), contador);
				}
			}
		} else {
			//Se o robo estiver a direita do final
			if (colunaRobo-colunaFinal > 0) {
				if(podeAndarEsquerda(arrayMapa1)){
					arrayMapa1 = andar(andarEsquerda(arrayMapa1), contador);
					
				}else {
					if(podeSubir(arrayMapa1)){
						arrayMapa1 = andar(subir(arrayMapa1), contador);
					}else{
						if(podeDescer(arrayMapa1)){
							arrayMapa1 = andar(descer(arrayMapa1), contador);
						}	
					}
				}
			} else {//se o robo estiver a esquerda do final
				
				//robo acima do final
				if (linhaRobo-linhaFinal < 0 && podeDescer(arrayMapa1)){
					arrayMapa1 = andar(descer(arrayMapa1), contador);
				
				}else if (podeAndarDireita(arrayMapa1)){
					arrayMapa1 = andar(andarDireita(arrayMapa1), contador);
				
				}else if (podeSubir(arrayMapa1)){
					arrayMapa1 = andar(subir(arrayMapa1), contador);
					
				}else if (podeDescer(arrayMapa1)){
					arrayMapa1 = andar(descer(arrayMapa1), contador);
				} else {
					arrayMapa1 = null;
				}
			}
		}
			
		return arrayMapa1;
		
	}
	private boolean naoPodeAndar(char[][] arrayMapa1) {
		return !podeAndarDireita(arrayMapa1) && !podeAndarEsquerda(arrayMapa1) &&
				!podeDescer(arrayMapa1) && !podeSubir(arrayMapa1);
	}
	private char[][] descer(char[][] arrayMapa1) {
		char[][] arrayMapa = arrayMapa1.clone();
		arrayMapa[linhaRobo][colunaRobo] = '*';
		arrayMapa[linhaRobo+1][colunaRobo] = 'R';
		return arrayMapa;
	}
	private char[][] andarDireita(char[][] arrayMapa1) {
		char[][] arrayMapa = arrayMapa1.clone();
		arrayMapa[linhaRobo][colunaRobo] = '*';
		arrayMapa[linhaRobo][colunaRobo+1] = 'R';
		return arrayMapa;
	}
	private char[][] andarEsquerda(char[][] arrayMapa1) {
		char[][] arrayMapa = arrayMapa1.clone();
		arrayMapa[linhaRobo][colunaRobo] = '*';
		arrayMapa[linhaRobo][colunaRobo-1] = 'R';
		return arrayMapa;
	}
	private char[][] subir(char[][] arrayMapa1) {
		char[][] arrayMapa = arrayMapa1.clone();
		arrayMapa[linhaRobo][colunaRobo] = '*';
		arrayMapa[linhaRobo-1][colunaRobo] = 'R';
		return arrayMapa;
	}
	private boolean podeAndarDireita(char[][] arrayMapa1) {
		return (colunaRobo+1) < arrayMapa1[0].length && arrayMapa1[linhaRobo][colunaRobo+1] == '.';
	}
	private boolean podeAndarEsquerda(char[][] arrayMapa1) {
		return (colunaRobo-1) >= 0 && arrayMapa1[linhaRobo][colunaRobo-1] == '.';
	}
	private boolean podeSubir(char[][] arrayMapa1) {
		return (linhaRobo - 1) >= 0 && arrayMapa1[linhaRobo-1][colunaRobo] == '.';
	}
	private boolean podeDescer(char[][] arrayMapa1) {
		return (linhaRobo + 1) < arrayMapa1.length && arrayMapa1[linhaRobo+1][colunaRobo] == '.';
	}
	
	public int explorarMapas() {
		
		int distancia = calculaDistancia(arrayMapa1);
		
		if (mapa1.contains("#")){			
			if(distancia == 1){
				return 1;
			}
			
			//nao posso andar
			Contador obj = new Contador();
			if (andar(arrayMapa1, obj) == null) {
				//pego mapa original, quebro em varios
				return -1;
			}
			
			return obj.valor;
			
		}
		return distancia;
	}
	
	private int calculaDistancia(char[][] arrayMapa1) {
		localizarRoboEFinal(arrayMapa1);
		return Math.abs(colunaFinal - colunaRobo)+Math.abs(linhaFinal-linhaRobo);
	}
	private void localizarRoboEFinal(char[][] arrayMapa1) {
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








