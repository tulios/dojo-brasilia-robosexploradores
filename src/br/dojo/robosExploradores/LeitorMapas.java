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
		String mapa1 = "";
		String mapa2 = "";
		Explorador e = new Explorador();
		
	
		String[] partes = linhasDoArquivo.get(index++).split(" ");

		int linha = Integer.parseInt(partes[0]);
		
		for (int i = 0; i < linha; i++) {
			mapa1 += linhasDoArquivo.get(index++)+"\n";
		}
		for (int i = 0; i < linha; i++) {
			mapa2 += linhasDoArquivo.get(index++)+"\n";
		}
		
		e.definirMapas(mapa1, mapa2);
	
		
		return e;
	}

	public int getNumeroInstancias() {
		return numeroInstancias;
	}

}
