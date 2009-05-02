package br.dojo.robosExploradores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class TesteIntegracao {
	
	@Test
	public void mapaSimples() throws IOException{
		LeitorMapas leitor = new LeitorMapas("Arquivos-Teste/mapaIntegracao1");
		Explorador e = leitor.gerarExplorador();
		
		int resultado = e.explorarMapas();
		assertEquals(1, resultado);
		
	}
	
	@Test
	public void arquivoComDuasInstancias() throws IOException{
		LeitorMapas leitor = new LeitorMapas("Arquivos-Teste/mapaIntegracao2");
		
		assertTrue(leitor.hasNextExplorador());
		Explorador e = leitor.gerarExplorador();
		int resultado = e.explorarMapas();
		assertEquals(1, resultado);
		
		assertTrue(leitor.hasNextExplorador());
		Explorador e2 = leitor.gerarExplorador();
		
		resultado = e2.explorarMapas();
		assertEquals(2, resultado);
	}
	
	@Test
	public void arquivoSaida() throws IOException{
		LeitorMapas leitor = new LeitorMapas("Arquivos-Teste/mapaIntegracao2");
		
		assertTrue(leitor.hasNextExplorador());
		Explorador e = leitor.gerarExplorador();
		int resultado = e.explorarMapas();
		assertEquals(1, resultado);
				
		assertTrue(leitor.hasNextExplorador());
		Explorador e2 = leitor.gerarExplorador();
		
		resultado = e2.explorarMapas();
		assertEquals(2, resultado);
		
	}
	
	@Test
	public void testaEntradaSaidaMapaComTresInstancias() throws IOException{
		LeitorMapas leitor = new LeitorMapas("Arquivos-Teste/mapaIntegracao3");

		assertTrue(leitor.hasNextExplorador());
		Explorador e = leitor.gerarExplorador();
		int resultado = e.explorarMapas();
		assertEquals(1, resultado);
		
		assertTrue(leitor.hasNextExplorador());
		e = leitor.gerarExplorador();
		resultado = e.explorarMapas();
		assertEquals(2, resultado);
		
		assertTrue(leitor.hasNextExplorador());
		e = leitor.gerarExplorador();
		resultado = e.explorarMapas();
		assertEquals(2, resultado);

	}
}
