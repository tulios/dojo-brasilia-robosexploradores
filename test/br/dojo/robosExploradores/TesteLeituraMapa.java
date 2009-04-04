package br.dojo.robosExploradores;

import org.junit.Test;
import static org.junit.Assert.*;

public class TesteLeituraMapa {
	
	@Test
	public void mapaDeStringParaArray(){
		String mapa =  ". . . .\n"+
		   			   ". . . .\n"+
		   			   ". F B B\n"+
		   			   "# . . R";
		
		char[][] array = stringToArray(mapa);
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
		
		char[][] array = stringToArray(mapa);
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
		
		char[][] array = stringToArray(mapa);
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

	private static char[][] stringToArray(String mapa) {
		mapa = mapa.replaceAll(" ", "");
		String[] linhas = mapa.split("\n");

		char [][] retorno = new char[linhas.length][linhas[0].length()];


		for (int x=0; x<linhas.length; x++){
			for (int y = 0; y < linhas[0].length(); y++){
				retorno[x][y] = linhas[x].charAt(y);
			}									
		} 
		return retorno;
	}
}
































