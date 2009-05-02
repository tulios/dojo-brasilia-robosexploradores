package br.dojo.robosExploradores;

public class Explorador {

	private String mapa1;
	private String mapa2;

	private Contador resultFinal = new Contador(51);

	private int linhaRobo;
	private int colunaRobo;

	private int colunaFinal;
	private int linhaFinal;

	public String getMapa1() {
		return mapa1;
	}
	public String getMapa2() {
		return mapa2;
	}

	public Explorador (String mapa1, String mapa2) {
		this.mapa1 = mapa1;
		this.mapa2 = mapa2;
	}
	
	
	public int explorarMapas() {
		
		char[][] arrayMapa1 = stringToArray(mapa1);
		int distancia = calculaDistancia(arrayMapa1);

		if(distancia == 1){
			return 1;
		}

		Contador obj = new Contador();
		if (andar(arrayMapa1, obj) == null) {
			//caso nao haja caminhos possiveis
			return -1;
		}

		if(resultFinal.valor>50) {
			return -1;
		}
		
		return resultFinal.valor;
	}
	
	private char[][] andar(char[][] arrayMapa1, Contador contador) {

		int distancia = calculaDistancia(arrayMapa1);
		if(distancia == 1){
			contador.valor++;
			if (contador.valor < resultFinal.valor){
				resultFinal.valor = contador.valor;
			}
			return arrayMapa1;
		}

		if ((arrayMapa1 == null) || (naoPodeAndar(arrayMapa1))) {
			return null;
		}

		char[][] esquerda = null;
		if(podeAndarEsquerda(arrayMapa1)){
			esquerda = andarUmPassoEsquerda(arrayMapa1); 
		}

		char[][] direita = null;
		if(podeAndarDireita(arrayMapa1)){
			direita = andarUmPassoDireita(arrayMapa1);
		}

		char[][] baixo = null;
		if(podeDescer(arrayMapa1)){
			baixo = andarUmPassoAbaixo(arrayMapa1);
		}

		char[][] cima = null;
		if(podeSubir(arrayMapa1)){
			cima = andarUmPassoAcima(arrayMapa1);
		}

		Contador cEsquerda = new Contador(contador.valor);
		Contador cDireita = new Contador(contador.valor);
		Contador cBaixo = new Contador(contador.valor);
		Contador cCima = new Contador(contador.valor);

		if (esquerda != null){
			cEsquerda.valor++;
			andar(esquerda, cEsquerda);
		}	
		if (direita != null){
			cDireita.valor++;
			andar(direita, cDireita);
		}	
		if (baixo != null){
			cBaixo.valor++;
			andar(baixo, cBaixo);
		}	
		if (cima != null){
			cCima.valor++;
			andar(cima, cCima);
		}

		return arrayMapa1;

	}
	
	private char[][] andarUmPassoAbaixo(char[][] arrayMapa1) {
		char[][] arrayMapa = cloneArray(arrayMapa1);
		arrayMapa[linhaRobo][colunaRobo] = '*';
		arrayMapa[linhaRobo+1][colunaRobo] = 'R';
		return arrayMapa;
	}
	
	private char[][] andarUmPassoDireita(char[][] arrayMapa1) {
		char[][] arrayMapa = cloneArray(arrayMapa1);
		arrayMapa[linhaRobo][colunaRobo] = '*';
		arrayMapa[linhaRobo][colunaRobo+1] = 'R';
		return arrayMapa;
	}
	
	private char[][] andarUmPassoEsquerda(char[][] arrayMapa1) {
		char[][] arrayMapa = cloneArray(arrayMapa1);
		arrayMapa[linhaRobo][colunaRobo] = '*';
		arrayMapa[linhaRobo][colunaRobo-1] = 'R';
		return arrayMapa;
	}
	
	private char[][] andarUmPassoAcima(char[][] arrayMapa1) {
		char[][] arrayMapa = cloneArray(arrayMapa1);
		arrayMapa[linhaRobo][colunaRobo] = '*';
		arrayMapa[linhaRobo-1][colunaRobo] = 'R';
		return arrayMapa;
	}

	private char[][] cloneArray(char[][] array){
		char[][] retorno = new char[array.length][array[0].length];
		for (int x=0; x<array.length; x++){
			for (int y=0; y<array[x].length; y++){
				retorno[x][y] = array[x][y];
			}
		}
		return retorno;
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
	
	private boolean naoPodeAndar(char[][] arrayMapa1) {
		return !podeAndarDireita(arrayMapa1) && !podeAndarEsquerda(arrayMapa1) &&
		!podeDescer(arrayMapa1) && !podeSubir(arrayMapa1);
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

	private char[][] stringToArray(String mapa) {
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








