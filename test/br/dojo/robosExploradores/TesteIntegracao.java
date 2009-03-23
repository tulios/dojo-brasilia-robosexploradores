package br.dojo.robosExploradores;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class TesteIntegracao {
	
	@Test
	public void mapaSimples() throws IOException{
		Explorador e = new Explorador();
		e.lerArquivo("mapaIntegracao1");
		
		e.next();
		int resultado = e.explorarMapas();
		assertEquals(1, resultado);
		
	}
	
	@Test
	public void arquivoComDuasInstancias() throws IOException{
		Explorador e = new Explorador();
		e.lerArquivo("mapaIntegracao2");
		
		e.next();
		int resultado = e.explorarMapas();
		assertEquals(1, resultado);
		
		e.next();
		resultado = e.explorarMapas();
		assertEquals(2, resultado);
		
		
	}
	
	@Test
	public void arquivoSaida() throws IOException{
		Explorador e = new Explorador();
		e.lerArquivo("mapaIntegracao2");
		
		e.next();
		int resultado = e.explorarMapas();
		assertEquals(1, resultado);
		
		e.next();
		resultado = e.explorarMapas();
		FileReader fr = new FileReader("resutadoExploracao");
		BufferedReader br = new BufferedReader(fr);
		assertEquals("2", br.readLine());
	}
}
