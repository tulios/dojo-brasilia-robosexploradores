package br.dojo.robosExploradores;

import java.io.File;

import org.junit.Test;
import static org.junit.Assert.*;

public class TesteMain {

	@Test
	public void testeExecucaoMetodoMain(){
		String[] args = new String[]{"Arquivos-Teste/mapaTeste1"};
		Main.main(args);
		
		File saida = new File("resultadoExploracao");
		assertTrue(saida.exists());
	}

}