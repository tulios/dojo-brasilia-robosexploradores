package br.dojo.robosExploradores;

import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;

public class TesteLeituraDeArquivo {

	@Test
	public void testeLeituraNumeroInstancias() throws IOException {
		Explorador explorador = new Explorador();
				
		assertTrue(explorador.lerArquivo("Arquivos-Teste/mapaTeste1"));
		assertEquals(1, explorador.getNumeroInstancias());
	}
	
	@Test
	public void testeLeituraNumeroInstancias2() throws IOException {
		Explorador explorador = new Explorador();
				
		assertTrue(explorador.lerArquivo("Arquivos-Teste/mapaTeste2"));
		assertEquals(2, explorador.getNumeroInstancias());
	}
	
	@Test
	public void testeLeituraMapa() throws IOException {
		Explorador explorador = new Explorador();
				
		assertTrue(explorador.lerArquivo("Arquivos-Teste/mapaTeste1"));
		assertEquals(1, explorador.getNumeroInstancias());
		explorador.explorarMapas();
		
		String mapa = ".\n";
		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());
	}
	
	@Test
	public void testeLeituraMapaComDuasLinhas() throws IOException {
		Explorador explorador = new Explorador();
				
		assertTrue(explorador.lerArquivo("Arquivos-Teste/mapaTeste2"));
		assertEquals(2, explorador.getNumeroInstancias());
		explorador.explorarMapas();
		
		String mapa = "..\n"+
					  "..\n";
		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());
	}
	
	@Test
	public void testeLeituraMapaComDuasInstancias() throws IOException {
		Explorador explorador = new Explorador();
				
		assertTrue(explorador.lerArquivo("Arquivos-Teste/mapaTeste3"));
		assertEquals(2, explorador.getNumeroInstancias());

		explorador.explorarMapas();
		
		String mapa = ".\n";

		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());
		
		explorador.explorarMapas();
		mapa = "..\n"+
			   "..\n";
			   
		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());


	}
	
	@Test
	public void testeLeituraMapaComTresInstancias() throws IOException {
		Explorador explorador = new Explorador();
				
		assertTrue(explorador.lerArquivo("Arquivos-Teste/mapaTeste4"));
		assertEquals(3, explorador.getNumeroInstancias());

		explorador.explorarMapas();
		
		String mapa = ".\n";

		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());
		
		explorador.explorarMapas();
		mapa = "..\n"+
			   "..\n";
			   
		
		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());
		
		explorador.explorarMapas();
		mapa = "...\n"+
			   "...\n"+
			   "...\n";
			   
		
		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());
	}
	
	@Test
	public void testeLeituraMapaComNextInvalido() throws IOException {
		Explorador explorador = new Explorador();
				
		assertTrue(explorador.lerArquivo("Arquivos-Teste/mapaTeste1"));
		assertEquals(1, explorador.getNumeroInstancias());

		explorador.explorarMapas();
		
		String mapa = ".\n";

		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());
	}
	
	@Test
	public void testeLeituraVertical() throws IOException {
		Explorador explorador = new Explorador();
				
		assertTrue(explorador.lerArquivo("Arquivos-Teste/mapaTeste5"));
		assertEquals(1, explorador.getNumeroInstancias());

		explorador.explorarMapas();
		
		String mapa = ".\n"+
					  ".\n"+
					  ".\n";

		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());
	}
}











































