package br.dojo.robosExploradores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class TesteLeituraDeArquivo {

	@Test
	public void testeLeituraNumeroInstancias() throws IOException {
		LeitorMapas leitor = new LeitorMapas("Arquivos-Teste/mapaTeste1");
		assertEquals(1, leitor.getNumeroInstancias());
	}
	
	@Test
	public void testeLeituraNumeroInstancias2() throws IOException {
		LeitorMapas leitor = new LeitorMapas("Arquivos-Teste/mapaTeste2");
		assertEquals(2, leitor.getNumeroInstancias());
	}
	
	@Test
	public void testeLeituraMapa() throws IOException {
		LeitorMapas leitor = new LeitorMapas("Arquivos-Teste/mapaTeste1");
		assertEquals(1, leitor.getNumeroInstancias());
		
		assertTrue(leitor.hasNextExplorador());
		
		Explorador explorador = leitor.gerarExplorador();
		explorador.explorarMapas();
		
		String mapa = ".\n";
		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());
	}
	
	@Test
	public void testeLeituraMapaComDuasLinhas() throws IOException {
		LeitorMapas leitor = new LeitorMapas("Arquivos-Teste/mapaTeste2");
		assertEquals(2, leitor.getNumeroInstancias());
		
		assertTrue(leitor.hasNextExplorador());
		
		Explorador explorador = leitor.gerarExplorador();
		
		String mapa = "..\n"+
					  "..\n";
		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());
	}
	
	@Test
	public void testeLeituraMapaComDuasInstancias() throws IOException {
		
		LeitorMapas leitor = new LeitorMapas("Arquivos-Teste/mapaTeste3");
		assertEquals(2, leitor.getNumeroInstancias());
		
		assertTrue(leitor.hasNextExplorador());
		
		Explorador explorador1 = leitor.gerarExplorador();
		Explorador explorador2 = leitor.gerarExplorador();
		
		String mapa = ".\n";

		assertEquals(mapa, explorador1.getMapa1());
		assertEquals(mapa, explorador1.getMapa2());

		mapa = "..\n"+
			   "..\n";
			   
		assertEquals(mapa, explorador2.getMapa1());
		assertEquals(mapa, explorador2.getMapa2());


	}
	
	@Test
	public void testeLeituraMapaComTresInstancias() throws IOException {
		LeitorMapas leitor = new LeitorMapas("Arquivos-Teste/mapaTeste4");
		assertEquals(3, leitor.getNumeroInstancias());
		
		assertTrue(leitor.hasNextExplorador());
		
		Explorador explorador1 = leitor.gerarExplorador();
		Explorador explorador2 = leitor.gerarExplorador();
		Explorador explorador3 = leitor.gerarExplorador();
				
		String mapa = ".\n";

		assertEquals(mapa, explorador1.getMapa1());
		assertEquals(mapa, explorador1.getMapa2());
		
		mapa = "..\n"+
			   "..\n";
			   
		
		assertEquals(mapa, explorador2.getMapa1());
		assertEquals(mapa, explorador2.getMapa2());
		
		mapa = "...\n"+
			   "...\n"+
			   "...\n";
			   
		
		assertEquals(mapa, explorador3.getMapa1());
		assertEquals(mapa, explorador3.getMapa2());
	}
	
	@Test
	public void testeLeituraVertical() throws IOException {
		LeitorMapas leitor = new LeitorMapas("Arquivos-Teste/mapaTeste5");
		Explorador explorador = leitor.gerarExplorador();
		
		assertEquals(1, leitor.getNumeroInstancias());

		String mapa = ".\n"+
					  ".\n"+
					  ".\n";

		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());
	}
}











































