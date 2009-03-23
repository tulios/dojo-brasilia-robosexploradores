package br.dojo.robosExploradores;

import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;

public class TesteLeituraDeArquivo {

	@Test
	public void testeLeituraNumeroInstancias() throws IOException {
		Explorador explorador = new Explorador();
				
		assertTrue(explorador.lerArquivo("mapaTeste1"));
		assertEquals(1, explorador.getNumeroInstancias());
	}
	
	@Test
	public void testeLeituraNumeroInstancias2() throws IOException {
		Explorador explorador = new Explorador();
				
		assertTrue(explorador.lerArquivo("mapaTeste2"));
		assertEquals(2, explorador.getNumeroInstancias());
	}
	
	@Test
	public void testeLeituraTamanhoMapa() throws IOException {
		Explorador explorador = new Explorador();
				
		assertTrue(explorador.lerArquivo("mapaTeste1"));
		assertEquals(1, explorador.getNumeroInstancias());
		explorador.next();
		assertEquals(1, explorador.getLinha());
		assertEquals(1, explorador.getColuna());
	}
	
	@Test
	public void testeLeituraTamanhoMapa2() throws IOException {
		Explorador explorador = new Explorador();
				
		assertTrue(explorador.lerArquivo("mapaTeste2"));
		assertEquals(2, explorador.getNumeroInstancias());
		explorador.next();
		assertEquals(2, explorador.getLinha());
		assertEquals(2, explorador.getColuna());
	}
	
	@Test
	public void testeLeituraMapa() throws IOException {
		Explorador explorador = new Explorador();
				
		assertTrue(explorador.lerArquivo("mapaTeste1"));
		assertEquals(1, explorador.getNumeroInstancias());
		explorador.next();
		assertEquals(1, explorador.getLinha());
		assertEquals(1, explorador.getColuna());
		
		String mapa = ".\n";
		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());
	}
	
	@Test
	public void testeLeituraMapaComDuasLinhas() throws IOException {
		Explorador explorador = new Explorador();
				
		assertTrue(explorador.lerArquivo("mapaTeste2"));
		assertEquals(2, explorador.getNumeroInstancias());
		explorador.next();
		assertEquals(2, explorador.getLinha());
		assertEquals(2, explorador.getColuna());
		
		String mapa = "..\n"+
					  "..\n";
		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());
	}
	
	@Test
	public void testeLeituraMapaComDuasInstancias() throws IOException {
		Explorador explorador = new Explorador();
				
		assertTrue(explorador.lerArquivo("mapaTeste3"));
		assertEquals(2, explorador.getNumeroInstancias());

		explorador.next();
		
		String mapa = ".\n";

		assertEquals(1, explorador.getLinha());
		assertEquals(1, explorador.getColuna());

		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());
		
		explorador.next();
		mapa = "..\n"+
			   "..\n";
			   
		
		assertEquals(2, explorador.getLinha());
		assertEquals(2, explorador.getColuna());

		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());


	}
	
	@Test
	public void testeLeituraMapaComTresInstancias() throws IOException {
		Explorador explorador = new Explorador();
				
		assertTrue(explorador.lerArquivo("mapaTeste4"));
		assertEquals(3, explorador.getNumeroInstancias());

		explorador.next();
		
		String mapa = ".\n";

		assertEquals(1, explorador.getLinha());
		assertEquals(1, explorador.getColuna());

		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());
		
		explorador.next();
		mapa = "..\n"+
			   "..\n";
			   
		
		assertEquals(2, explorador.getLinha());
		assertEquals(2, explorador.getColuna());

		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());
		
		explorador.next();
		mapa = "...\n"+
			   "...\n"+
			   "...\n";
			   
		
		assertEquals(3, explorador.getLinha());
		assertEquals(3, explorador.getColuna());

		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());
	}
	
	@Test
	public void testeLeituraMapaComNextInvalido() throws IOException {
		Explorador explorador = new Explorador();
				
		assertTrue(explorador.lerArquivo("mapaTeste1"));
		assertEquals(1, explorador.getNumeroInstancias());

		explorador.next();
		
		String mapa = ".\n";

		assertEquals(1, explorador.getLinha());
		assertEquals(1, explorador.getColuna());

		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());
		
		assertTrue(explorador.next() == false);
	}
	
	@Test
	public void testeLeituraVertical() throws IOException {
		Explorador explorador = new Explorador();
				
		assertTrue(explorador.lerArquivo("mapaTeste5"));
		assertEquals(1, explorador.getNumeroInstancias());

		explorador.next();
		
		String mapa = ".\n"+
					  ".\n"+
					  ".\n";

		assertEquals(3, explorador.getLinha());
		assertEquals(1, explorador.getColuna());

		assertEquals(mapa, explorador.getMapa1());
		assertEquals(mapa, explorador.getMapa2());
		
		assertTrue(explorador.next() == false);
	}
}











































