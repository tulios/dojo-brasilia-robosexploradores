package br.dojo.robosExploradores;

import org.junit.Test;
import static org.junit.Assert.*;

public class TesteLeituraMapa {
	
	@Test
	public void verificaLeituraTamanhoMapa(){
		Explorador explorador = new Explorador();
		explorador.setLinha(4);
		explorador.setColuna(4);
		
		assertEquals(4, explorador.getLinha());
		assertEquals(4, explorador.getColuna());
	}
	
	@Test
	public void verificaDefinicaoMapas(){
		String mapa1 = ". . . .\n"+
					   ". . . .\n"+
					   ". . . F\n"+
					   ". . # R";
		
		String mapa2 = ". . . .\n"+
		   			   ". . . .\n"+
		   			   ". F B B\n"+
		   			   "# . . R";
		
		Explorador explorador = new Explorador();
		explorador.definirMapas(mapa1, mapa2);
		
		assertTrue(explorador.getMapa1().equals(mapa1));
		assertTrue(explorador.getMapa2().equals(mapa2));		
	}
	
	
	@Test
	public void explorarMapas(){
		String mapa1 = ". . . .\n"+
					   ". . . .\n"+
					   ". . . F\n"+
					   ". . # R";
		
		String mapa2 = ". . . .\n"+
		   			   ". . . .\n"+
		   			   ". F B B\n"+
		   			   "# . . R";
		
		Explorador explorador = new Explorador();
		explorador.definirMapas(mapa1, mapa2);		
		assertEquals(3, explorador.explorarMapas());				
	}

	
}
































