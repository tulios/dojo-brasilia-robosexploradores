package br.dojo.robosExploradores;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			if (args != null && args.length > 0){
				
				FileWriter fw = new FileWriter("resultadoExploracao", true);
				
				
				LeitorMapas leitor = new LeitorMapas(args[0]);
				while(leitor.hasNextExplorador()) {
					Explorador e = leitor.gerarExplorador();
					int passosDados = e.explorarMapas();
					fw.append(String.valueOf(passosDados)+"\n");
				}
				
				fw.flush();
				fw.close();
						
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
