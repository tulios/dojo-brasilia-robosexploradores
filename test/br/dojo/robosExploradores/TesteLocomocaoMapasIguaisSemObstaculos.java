package br.dojo.robosExploradores;

import java.io.IOException;

import org.junit.Test;
import static org.junit.Assert.*;

public class TesteLocomocaoMapasIguaisSemObstaculos {
	
	@Test
	public void andarMapa_RF() throws IOException{
		String mapa = "R F";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(1, resultado);
	}

	@Test
	public void andarMapa_RoF() throws IOException{
		String mapa = "R . F";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(2, resultado);
	}

	@Test
	public void andarMapa_RooF() throws IOException{
		String mapa = "R . . F";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(3, resultado);
	}
	
	@Test
	public void andarMapa_RoooooF() throws IOException{
		String mapa = "R . . . . . F";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(6, resultado);
	}

	@Test
	public void andarMapa_oRF() throws IOException{
		String mapa = ". R F";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(1, resultado);
	}

	@Test
	public void andarMapa_oFR() throws IOException{
		String mapa = ". F R";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(1, resultado);
	}
	
	@Test
	public void andarMapa_oFoR() throws IOException{
		String mapa = ". F . R";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(2, resultado);
	}
	
	@Test
	public void andarMapa_R_F() throws IOException{
		String mapa = 	"R\n" +
						"F";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(1, resultado);
	}
	
	@Test
	public void andarMapa_R_o_F() throws IOException{
		String mapa = 	"R\n" +
						".\n"   +
						"F";
		
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(2, resultado);
	}
	
	@Test
	public void andarMapa_R_o_o_F() throws IOException{
		String mapa = 	"R\n" +
						".\n" +
						".\n" +
						"F";
		
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(3, resultado);
	}
	
	@Test
	public void andarMapa_R_o_F_o() throws IOException{
		String mapa = 	"R\n" +
						".\n" +
						"F\n" +
						".";
		
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(2, resultado);
	}
	
	@Test
	public void andarMapa_F_o_R_o() throws IOException{
		String mapa = 	"F\n" +
						".\n" +
						"R\n" +
						".";
		
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(2, resultado);
	}
	
	@Test
	public void andarMapa_F_o_o_o_R_o_o() throws IOException{
		String mapa = 	"F\n" +
						".\n" +
						".\n" +
						".\n" +
						"R\n" +
						".\n" +
						".";
		
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(4, resultado);
	}
	
	@Test
	public void andarMapa_oF_Ro() throws IOException{
		String mapa = 	". F\n" +
						"R .";
		
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(2, resultado);
	}
	
	@Test
	public void andarMapaComplexo() throws IOException{
		String mapa = 	". . . . .\n" +
						". F . . .\n" +
						". . . . .\n" +
						". . . . R";
		
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(5, resultado);
	}

	@Test
	public void andarMapaComplexo2() throws IOException{
		String mapa = 	". . . . .\n" +
						". F . . .\n" +
						". . R . .\n" +
						". . . . .";
		
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(2, resultado);
	}
	
	@Test
	public void andarMapaComplexo3() throws IOException{
		String mapa = 	". . . . .\n" +
						". R . . .\n" +
						". . . . .\n" +
						"F . . . .";
		
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(3, resultado);
	}
	
}































































