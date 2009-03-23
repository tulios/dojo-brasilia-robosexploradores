package br.dojo.robosExploradores;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Explorador {
	private int linha;
	private int coluna;
	private String mapa1;
	private String mapa2;
	private char[][] arrayMapa1;
	private char[][] arrayMapa2;

	private int numeroInstancias;

	private Contador resultFinal = new Contador(51);

	private int linhaRobo;
	private int colunaRobo;

	private int colunaFinal;
	private int linhaFinal;

	private List<String> instancias;
	private int index;

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

		int multiplos = 0;
		if(podeAndarEsquerda(arrayMapa1))
			multiplos++;
		if(podeAndarDireita(arrayMapa1))
			multiplos++;
		if(podeDescer(arrayMapa1))
			multiplos++;
		if(podeSubir(arrayMapa1))
			multiplos++;

		if (multiplos > 1){
			char[][] esquerda = null;
			if(podeAndarEsquerda(arrayMapa1)){
				esquerda = andarEsquerda(arrayMapa1); 
			}

			char[][] direita = null;
			if(podeAndarDireita(arrayMapa1)){
				direita = andarDireita(arrayMapa1);
			}

			char[][] baixo = null;
			if(podeDescer(arrayMapa1)){
				baixo = descer(arrayMapa1);
			}

			char[][] cima = null;
			if(podeSubir(arrayMapa1)){
				cima = subir(arrayMapa1);
			}

			Contador cEsqueda = new Contador(contador.valor);
			Contador cDireita = new Contador(contador.valor);
			Contador cBaixo = new Contador(contador.valor);
			Contador cCima = new Contador(contador.valor);

			if (esquerda != null){
				cEsqueda.valor++;
				esquerda = andar(esquerda, cEsqueda);
			}	
			if (direita != null){
				cDireita.valor++;
				direita = andar(direita, cDireita);
			}	
			if (baixo != null){
				cBaixo.valor++;
				baixo = andar(baixo, cBaixo);
			}	
			if (cima != null){
				cCima.valor++;
				cima = andar(cima, cCima);
			}

		}else{
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

					}else if(podeSubir(arrayMapa1)){
						arrayMapa1 = andar(subir(arrayMapa1), contador);
					}else if(podeDescer(arrayMapa1)){
						arrayMapa1 = andar(descer(arrayMapa1), contador);
					}else if(podeAndarDireita(arrayMapa1)) {
						arrayMapa1 = andar(andarDireita(arrayMapa1), contador);
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

					}else if (podeAndarEsquerda(arrayMapa1)){
						arrayMapa1 = andar(andarEsquerda(arrayMapa1), contador);

					}else {
						arrayMapa1 = null;
					}
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
		char[][] arrayMapa = novoArray(arrayMapa1);
		arrayMapa[linhaRobo][colunaRobo] = '*';
		arrayMapa[linhaRobo+1][colunaRobo] = 'R';
		return arrayMapa;
	}
	private char[][] andarDireita(char[][] arrayMapa1) {
		char[][] arrayMapa = novoArray(arrayMapa1);
		arrayMapa[linhaRobo][colunaRobo] = '*';
		arrayMapa[linhaRobo][colunaRobo+1] = 'R';
		return arrayMapa;
	}
	private char[][] andarEsquerda(char[][] arrayMapa1) {
		char[][] arrayMapa = novoArray(arrayMapa1);
		arrayMapa[linhaRobo][colunaRobo] = '*';
		arrayMapa[linhaRobo][colunaRobo-1] = 'R';
		return arrayMapa;
	}
	private char[][] subir(char[][] arrayMapa1) {
		char[][] arrayMapa = novoArray(arrayMapa1);
		arrayMapa[linhaRobo][colunaRobo] = '*';
		arrayMapa[linhaRobo-1][colunaRobo] = 'R';
		return arrayMapa;
	}

	private char[][] novoArray(char[][] array){
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

	public int explorarMapas() {

		int distancia = calculaDistancia(arrayMapa1);

		if (mapa1.contains("#")){			
			if(distancia == 1){
				return 1;
			}

			Contador obj = new Contador();
			if (andar(arrayMapa1, obj) == null) {
				//caso nao haja caminhos possiveis
				return -1;
			}

			if(resultFinal.valor>50)
				return -1;
			else
				return resultFinal.valor;

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

	public boolean lerArquivo(String arquivo) throws IOException {
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);

		numeroInstancias = Integer.parseInt(br.readLine());

		instancias = new ArrayList<String>();
		String s = null;
		while((s = br.readLine()) != null) {
			instancias.add(s);
		}
		return true;
	}

	public int getNumeroInstancias() {
		return numeroInstancias;
	}

	public boolean next() throws IOException {
		if (index < instancias.size()){
			String[] partes = instancias.get(index++).split(" ");

			linha = Integer.parseInt(partes[0]);
			coluna = Integer.parseInt(partes[1]);
			mapa1="";
			mapa2="";
			
			for (int i = 0; i < linha; i++) {
				mapa1 += instancias.get(index++)+"\n";
			}
			for (int i = 0; i < linha; i++) {
				mapa2 += instancias.get(index++)+"\n";
			}
			
			definirMapas(mapa1, mapa2);
			FileWriter fw = new FileWriter("resutadoExploracao");
			int resultado = explorarMapas();
			fw.write(String.valueOf(resultado));
			fw.close();
			
			
			return true;
		}
		return false;
	}
}








