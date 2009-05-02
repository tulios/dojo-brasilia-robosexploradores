package br.dojo.robosExploradores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorMapas {

	private int numeroInstancias;
	private List<String> linhasDoArquivo = new ArrayList<String>();
	private int index;
	
	
	public LeitorMapas(String pathArquivo) {
		try {
			lerArquivo(pathArquivo);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void lerArquivo(String arquivo) throws IOException {
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		
		numeroInstancias = Integer.parseInt(br.readLine());

		String s = null;
		while((s = br.readLine()) != null) {
			linhasDoArquivo.add(s);
		}
		
		fr.close();
		br.close();
		
	}
	
	
	public boolean hasNextExplorador() {
		return index < linhasDoArquivo.size();
	}

	public Explorador gerarExplorador() {
		
	
		String[] partes = linhasDoArquivo.get(index++).split(" ");

		int linha = Integer.parseInt(partes[0]);
		
		String mapa1 = "";
		for (int i = 0; i < linha; i++) {
			mapa1 += linhasDoArquivo.get(index++)+"\n";
		}
		String mapa2 = "";
		for (int i = 0; i < linha; i++) {
			mapa2 += linhasDoArquivo.get(index++)+"\n";
		}	
		
		return new Explorador(mapa1, mapa2);
	}

	public int getNumeroInstancias() {
		return numeroInstancias;
	}

}
