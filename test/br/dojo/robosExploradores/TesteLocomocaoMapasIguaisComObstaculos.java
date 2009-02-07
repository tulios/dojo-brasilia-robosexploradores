package br.dojo.robosExploradores;

import org.junit.Test;
import static org.junit.Assert.*;

public class TesteLocomocaoMapasIguaisComObstaculos {
	
	@Test
	public void andarMapa_oF_oX_oR(){
		String mapa = 	". F \n" +
						". # \n" +
						". R \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(4, resultado);
	}

	@Test
	public void andarMapa_oF_oX_Ro(){
		String mapa = 	". F \n" +
						". # \n" +
						"R . \n";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(3, resultado);
	}
	
	
	@Test
	public void andarMapa_RF_oX_oo(){
		String mapa = 	"R F \n" +
						". # \n" +
						". . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(1, resultado);
	}
	
	@Test
	public void andarMapa_oF_RX_oo(){
		String mapa = 	". F \n" +
						"R # \n" +
						". . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(2, resultado);
	}
	
	@Test
	public void andarMapa_oF_Xo_Ro(){
		String mapa = 	"F . \n" +
						"# . \n" +
						"R . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(4, resultado);
	}
	
	@Test
	public void andarMapa_oFo_oXo_oRo(){
		String mapa = 	". F . \n" +
						". # . \n" +
						". R . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(4, resultado);
	}
	
	@Test
	public void andarMapa_oFo_oXo_ooR(){
		String mapa = 	". F . \n" +
						". # . \n" +
						". . R \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(3, resultado);
	}
	
	@Test
	public void andarMapa_oFo_oXX_ooR(){
		String mapa = 	". F . \n" +
						". # # \n" +
						". . R \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(5, resultado);
	}
	
	@Test
	public void andarMapa_oFo_XXo_Roo(){
		String mapa = 	". F . \n" +
						"# # . \n" +
						"R . . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(5, resultado);
	}
	
	@Test
	public void andarMapa_oFX_oXo_oRo(){
		String mapa = 	". F # \n" +
						". # . \n" +
						". R . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(4, resultado);
	}
	
	@Test
	public void andarMapa_XFo_RXo_ooo(){
		String mapa = 	"# F . \n" +
						"R # . \n" +
						". . . \n";
						
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(6 , resultado);
	}
	
	@Test
	public void andarMapa_oFX_oXR_ooo(){
		String mapa = 	". F # \n" +
						". # R \n" +
						". . . \n";
						
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(6 , resultado);
	}
	
	
	@Test
	public void andarMapa_oXo_RoF(){
		String mapa = 	". # . \n" +
						"R . F \n" ;
						
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(2 , resultado);
	}
	
	@Test
	public void andarMapa_oXo_FoR(){
		String mapa = 	". # . \n" +
						"F . R \n" ;
						
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(2 , resultado);
	}

	@Test
	public void andarMapa_ooo_FXR(){
		String mapa = 	". . . \n" +
						"F # R \n" ;
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}
	
}
































