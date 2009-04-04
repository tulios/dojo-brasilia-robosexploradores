package br.dojo.robosExploradores;

import java.io.IOException;

import org.junit.Test;
import static org.junit.Assert.*;

public class TesteLocomocaoMapasIguaisComObstaculos {

	@Test
	public void andarMapa_oF_oX_oR() throws IOException{
		String mapa = 	". F \n" +
		". # \n" +
		". R \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(4, resultado);
	}

	@Test
	public void andarMapa_oF_oX_Ro() throws IOException{
		String mapa = 	". F \n" +
		". # \n" +
		"R . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(3, resultado);
	}


	@Test
	public void andarMapa_RF_oX_oo() throws IOException{
		String mapa = 	"R F \n" +
		". # \n" +
		". . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(1, resultado);
	}

	@Test
	public void andarMapa_oF_RX_oo() throws IOException{
		String mapa = 	". F \n" +
		"R # \n" +
		". . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(2, resultado);
	}

	@Test
	public void andarMapa_oF_Xo_Ro() throws IOException{
		String mapa = 	"F . \n" +
		"# . \n" +
		"R . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(4, resultado);
	}

	@Test
	public void andarMapa_oFo_oXo_oRo() throws IOException{
		String mapa = 	". F . \n" +
		". # . \n" +
		". R . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(4, resultado);
	}

	@Test
	public void andarMapa_oFo_oXo_ooR() throws IOException{
		String mapa = 	". F . \n" +
		". # . \n" +
		". . R \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(3, resultado);
	}

	@Test
	public void andarMapa_oFo_oXX_ooR() throws IOException{
		String mapa = 	". F . \n" +
		". # # \n" +
		". . R \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(5, resultado);
	}

	@Test
	public void andarMapa_oFo_XXo_Roo() throws IOException{
		String mapa = 	". F . \n" +
		"# # . \n" +
		"R . . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(5, resultado);
	}

	@Test
	public void andarMapa_oFX_oXo_oRo() throws IOException{
		String mapa = 	". F # \n" +
		". # . \n" +
		". R . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(4, resultado);
	}

	@Test
	public void andarMapa_XFo_RXo_ooo() throws IOException{
		String mapa = 	"# F . \n" +
		"R # . \n" +
		". . . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(6 , resultado);
	}

	@Test
	public void andarMapa_oFX_oXR_ooo() throws IOException{
		String mapa = 	". F # \n" +
		". # R \n" +
		". . . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(6 , resultado);
	}


	@Test
	public void andarMapa_oXo_RoF() throws IOException{
		String mapa = 	". # . \n" +
		"R . F \n" ;

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(2 , resultado);
	}

	@Test
	public void andarMapa_oXo_FoR() throws IOException{
		String mapa = 	". # . \n" +
		"F . R \n" ;

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(2 , resultado);
	}

	@Test
	public void andarMapa_ooo_FXR() throws IOException{
		String mapa = 	". . . \n" +
		"F # R \n" ;

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}
	@Test
	public void andarMapa_FXR_ooo() throws IOException{
		String mapa = 	"F # R \n"+
		". . . \n" ;

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}

	@Test
	public void andarMapa_RXF_ooo() throws IOException{
		String mapa = 	"R # F \n"+
					    ". . . \n" ;

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}

	@Test
	public void andarMapa_ooo_RXF() throws IOException{
		String mapa = 	". . . \n"+
		"R # F \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}

	@Test
	public void andarMapa_RXF_oXo_ooo() throws IOException{
		String mapa = 	"R # F \n"+
		". # . \n"+
		". . . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(6 , resultado);
	}

	@Test
	public void andarMapa_FXR_oXo_ooo() throws IOException{
		String mapa = 	"F # R \n"+
		". # . \n"+
		". . . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(6 , resultado);
	}

	@Test
	public void andarMapa_RXXF_ooXo_XoXo_Xooo() throws IOException{
		String mapa = 	"R # # F \n"+
		". . # . \n"+
		"# . # . \n"+
		"# . . . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(9 , resultado);
	}

	@Test
	public void andarMapa_RoX_XoX_ooF() throws IOException{
		String mapa = 	"R . # \n"+
		"# . # \n"+
		". . F \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}

	@Test
	public void andarMapa_RoX_XoX_Foo() throws IOException{
		String mapa = 	"R . # \n"+
		"# . # \n"+
		"F . . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}

	@Test
	public void andarMapa_RoX_Xoo_Foo() throws IOException{
		String mapa = 	"R . # \n"+
		". . . \n"+
		"F . . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(2 , resultado);
	}

	@Test
	public void andarMapa_RoF_ooo_xoo() throws IOException{
		String mapa = 	"R . F \n"+
		". . . \n"+
		"# . . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(2 , resultado);
	}

	@Test
	public void andarMapaParaBecoSemSaida1() throws IOException{
		String mapa = 	"R # . \n"+
		". # # \n"+
		". # F \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(-1 , resultado);
	}

	@Test
	public void andarMapaParaBecoSemSaida2() throws IOException{
		String mapa = 	"R . . \n"+
		". # . \n"+
		". # F \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}

	@Test
	public void andarMapasDoisCaminhosPossiveis() throws IOException{
		String mapa = 	". F . .\n"+
						". # # .\n"+
						". # # .\n"+
						". R . .\n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(5 , resultado);
	}

	@Test
	public void andarMapasDoisCaminhosPossiveis2() throws IOException{
		String mapa = 	". . F .\n"+
						". # # .\n"+
						". # # .\n"+
						". . R .\n";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(5 , resultado);
	}

	@Test
	public void andarMapasDoisCaminhosPossiveis3() throws IOException{
		String mapa = 	". F . \n"+
						". # .\n"+
						". # . \n"+
						"R . . \n";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}

	@Test
	public void andarMapasComQuatroPossibilidades() throws IOException{
		String mapa = 	"F . . . .\n"+
						". # . # .\n"+
						". . R . .\n"+
						". # . # .\n"+
						". . . . .\n";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}

	@Test
	public void andarMapasComQuatroPossibilidades2() throws IOException{
		String mapa = 	". . . . F\n"+
						". # . # .\n"+
						". . R . .\n"+
						". # . # .\n"+
						". . . . .\n";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}
	

	@Test
	public void andarMapasComQuatroPossibilidades3() throws IOException{
		String mapa = 	". . . . .\n"+
						". # . # .\n"+
						". . R . .\n"+
						". # . # .\n"+
						". . . . F\n";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}

	@Test
	public void andarMapasComQuatroPossibilidades4() throws IOException{
		String mapa = 	". . . . .\n"+
						". # . # .\n"+
						". . R . .\n"+
						". # . # .\n"+
						"F . . . .\n";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}
	
	@Test
	public void andarMapasComQuatroPossibilidades5() throws IOException{
		String mapa = 	". . . . .\n"+
						". # . # .\n"+
						". . R . .\n"+
						". # . # .\n"+
						". . . . F\n";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}
	
	@Test
	public void andarMapasComQuatroPossibilidades6() throws IOException{
		String mapa = 	". F # . . .\n"+
						". . . . # .\n"+
						". # . . . .\n"+
						". . # R . .\n"+
						". . . . . .\n";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(5 , resultado);
	}
	
	@Test
	public void andarMapasComDoisCaminhosPossiveisEDoisImpossiveis() throws IOException{
		String mapa = 	". . . # .\n"+
						". # . # .\n"+
						". . R . .\n"+
						". # . # #\n"+
						". . . . F\n";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}

	@Test
	public void andarMapasComUmCaminhoLongo() throws IOException{
		String mapa = 	". . . . .\n"+
						". . # . .\n"+
						". # . # .\n"+
						". # R . .\n"+
						". . # # #\n"+
						". . . . F\n";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(18 , resultado);
	}
	
	@Test
	public void andarMapasComUmCaminhoLongoInvertido() throws IOException{
		String mapa = 	". . . . .\n"+
						". . # . .\n"+
						". # . # .\n"+
						". . R # .\n"+
						"# # # . .\n"+
						"F . . . .\n";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(18 , resultado);
	}
	
	@Test
	public void andarMapasComUmCaminhoLongoAlterado() throws IOException{
		String mapa = 	". . . . .\n"+
						". . # . .\n"+
						". # . # .\n"+
						". . F # .\n"+
						"# # # . .\n"+
						"R . . . .\n";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(18 , resultado);
	}
	
	@Test
	public void andarMapasComVariosCaminhos() throws IOException{
		String mapa = 	". . . . .\n"+
						". . # . .\n"+
						". # . # .\n"+
						". # F . .\n"+
						". # # # #\n"+
						"R . . . .\n";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(14 , resultado);
	}
	
	@Test
	public void andarMapasSemCaminhosPOssiveis() throws IOException{
		String mapa = 	". . . . .\n"+
						". . # . .\n"+
						". # . # .\n"+
						". # F # .\n"+
						". # # # .\n"+
						"R . . . .\n";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(-1 , resultado);
	}
	
	@Test
	public void andarMapasComBuracos() throws IOException{
		String mapa = 	". B F B\n"+
						". . . #\n"+
						". # B B\n"+
						". . . R\n";
		
		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);
		
		int resultado = e.explorarMapas();
		assertEquals(8 , resultado);
	}
	
	
}
































