package br.dojo.robosExploradores;

import org.junit.Test;
import static org.junit.Assert.*;

public class TesteLocomocaoDosRobos {
	
	@Test
	public void andarMapa_RF(){
		String mapa = "R F";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(1, resultado);
	}

	@Test
	public void andarMapa_RoF(){
		String mapa = "R . F";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(2, resultado);
	}

	@Test
	public void andarMapa_RooF(){
		String mapa = "R . . F";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(3, resultado);
	}
	
	@Test
	public void andarMapa_RoooooF(){
		String mapa = "R . . . . . F";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(6, resultado);
	}

	@Test
	public void andarMapa_oRF(){
		String mapa = ". R F";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(1, resultado);
	}

	@Test
	public void andarMapa_oFR(){
		String mapa = ". F R";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(1, resultado);
	}
	
	@Test
	public void andarMapa_oFoR(){
		String mapa = ". F . R";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(2, resultado);
	}
	
	@Test
	public void andarMapa_R_F(){
		String mapa = 	"R\n" +
						"F";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(1, resultado);
	}
	
	@Test
	public void andarMapa_R_o_F(){
		String mapa = 	"R\n" +
						".\n"   +
						"F";
		
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(2, resultado);
	}
	
}































































