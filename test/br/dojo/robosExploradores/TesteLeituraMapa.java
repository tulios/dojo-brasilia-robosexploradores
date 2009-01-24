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
	public void mapaDeStringParaArray(){
		String mapa =  ". . . .\n"+
		   			   ". . . .\n"+
		   			   ". F B B\n"+
		   			   "# . . R";
		
		char[][] array = Explorador.stringToArray(mapa);
		assertEquals(4, array.length);
		assertEquals(4, array[0].length);
		
		mapa = mapa.replaceAll(" ", "");
		
		for (int i = 0; i < 4; i++) {
			assertEquals(mapa.charAt(i), array[0][i]);
			assertEquals(mapa.charAt(5+i), array[1][i]);
			assertEquals(mapa.charAt(10+i), array[2][i]);
			assertEquals(mapa.charAt(15+i), array[3][i]);

		}
	}
	
	@Test
	public void mapaMaiorDeStringParaArray(){
		String mapa =  ". . . . .\n"+
		   			   ". . . . .\n"+
		   			   ". F B B B\n"+
		   			   "# . . R #\n"+
		   			   ". # # # #";
		
		char[][] array = Explorador.stringToArray(mapa);
		assertEquals(5, array.length);
		assertEquals(5, array[0].length);
		
		mapa = mapa.replaceAll(" ", "");
		
		for (int i = 0; i < 5; i++) {
			assertEquals(mapa.charAt(i), array[0][i]);
			assertEquals(mapa.charAt(6+i), array[1][i]);
			assertEquals(mapa.charAt(12+i), array[2][i]);
			assertEquals(mapa.charAt(18+i), array[3][i]);
			assertEquals(mapa.charAt(24+i), array[4][i]);

		}
	}
	
	@Test
	public void verificaMapaRetangularDeStringParaArray(){
		String mapa =  ". . . . .\n"+
		   			   ". . . . .\n"+
		   			   ". F B B B\n"+
		   			   "# . . R #\n"+
		   			   "# . . . #\n"+
		   			   ". # # # #";
		
		char[][] array = Explorador.stringToArray(mapa);
		assertEquals(6, array.length);
		assertEquals(5, array[5].length);
		
		mapa = mapa.replaceAll(" ", "");
		
		for (int i = 0; i < 5; i++) {
			assertEquals(mapa.charAt(i), array[0][i]);
			assertEquals(mapa.charAt(6+i), array[1][i]);
			assertEquals(mapa.charAt(12+i), array[2][i]);
			assertEquals(mapa.charAt(18+i), array[3][i]);
			assertEquals(mapa.charAt(24+i), array[4][i]);
			assertEquals(mapa.charAt(30+i), array[5][i]);

		}
		
	}
	/*
	@Test
	public void explorarMapas1(){
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
	*/
	
	/*
	@Test
	public void explorarMapas2(){
		String mapa1 = ". B F B\n"+
					   ". . . #\n"+
					   ". # B B\n"+
					   ". . . R";
		
		String mapa2 = "# # # #\n"+
		   			   ". B B F\n"+
		   			   ". . . .\n"+
		   			   "# R . .";
		
		Explorador explorador = new Explorador();
		explorador.definirMapas(mapa1, mapa2);		
		assertEquals(12, explorador.explorarMapas());
	}
	*/
}
































