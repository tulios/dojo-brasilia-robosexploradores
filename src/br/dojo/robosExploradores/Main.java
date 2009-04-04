package br.dojo.robosExploradores;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			if (args != null && args.length > 0){
				Explorador e = new Explorador();
				e.lerArquivo(args[0]);
				
				for (int x=0; x<e.getNumeroInstancias(); x++){
					e.explorarMapas();
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
