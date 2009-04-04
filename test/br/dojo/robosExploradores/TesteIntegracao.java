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
		e.lerArquivo("Arquivos-Teste/mapaIntegracao1");
		
		e.next();
		int resultado = e.explorarMapas();
		assertEquals(1, resultado);
		
	}
	
	@Test
	public void arquivoComDuasInstancias() throws IOException{
		Explorador e = new Explorador();
		e.lerArquivo("Arquivos-Teste/mapaIntegracao2");
		
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
		e.lerArquivo("Arquivos-Teste/mapaIntegracao2");
		
		e.next();
		int resultado = e.explorarMapas();
		assertEquals(1, resultado);
		
		e.next();
		
		resultado = e.explorarMapas();
		assertEquals(2, resultado);
		
		FileReader fr = new FileReader("resultadoExploracao");
		BufferedReader br = new BufferedReader(fr);
		
		assertEquals("1", br.readLine());
		assertEquals("2", br.readLine());
		
		fr.close();
		br.close();
	}
	
	@Test
	public void testaEntradaSaidaMapaComTresInstancias() throws IOException{
		Explorador e = new Explorador();
		e.lerArquivo("Arquivos-Teste/mapaIntegracao3");
		
		e.next();
		int resultado = e.explorarMapas();
		assertEquals(1, resultado);
		
		e.next();
		resultado = e.explorarMapas();
		assertEquals(2, resultado);
		
		e.next();
		resultado = e.explorarMapas();
		assertEquals(2, resultado);
		
		FileReader fr = new FileReader("resultadoExploracao");
		BufferedReader br = new BufferedReader(fr);
		
		assertEquals("1", br.readLine());
		assertEquals("2", br.readLine());
		assertEquals("2", br.readLine());
		
		fr.close();
		br.close();
	}
}
