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
	@Test
	public void andarMapa_FXR_ooo(){
		String mapa = 	"F # R \n"+
		". . . \n" ;

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}

	@Test
	public void andarMapa_RXF_ooo(){
		String mapa = 	"R # F \n"+
					    ". . . \n" ;

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}

	@Test
	public void andarMapa_ooo_RXF(){
		String mapa = 	". . . \n"+
		"R # F \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}

	@Test
	public void andarMapa_RXF_oXo_ooo(){
		String mapa = 	"R # F \n"+
		". # . \n"+
		". . . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(6 , resultado);
	}

	@Test
	public void andarMapa_FXR_oXo_ooo(){
		String mapa = 	"F # R \n"+
		". # . \n"+
		". . . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(6 , resultado);
	}

	@Test
	public void andarMapa_RXXF_ooXo_XoXo_Xooo(){
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
	public void andarMapa_RoX_XoX_ooF(){
		String mapa = 	"R . # \n"+
		"# . # \n"+
		". . F \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}

	@Test
	public void andarMapa_RoX_XoX_Foo(){
		String mapa = 	"R . # \n"+
		"# . # \n"+
		"F . . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}

	@Test
	public void andarMapa_RoX_Xoo_Foo(){
		String mapa = 	"R . # \n"+
		". . . \n"+
		"F . . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(2 , resultado);
	}

	@Test
	public void andarMapa_RoF_ooo_xoo(){
		String mapa = 	"R . F \n"+
		". . . \n"+
		"# . . \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(2 , resultado);
	}

	@Test
	public void andarMapaParaBecoSemSaida1(){
		String mapa = 	"R # . \n"+
		". # # \n"+
		". # F \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(-1 , resultado);
	}

	@Test
	public void andarMapaParaBecoSemSaida2(){
		String mapa = 	"R . . \n"+
		". # . \n"+
		". # F \n";

		Explorador e = new Explorador();
		e.definirMapas(mapa, mapa);

		int resultado = e.explorarMapas();
		assertEquals(4 , resultado);
	}

	@Test
	public void andarMapasDoisCaminhosPossiveis(){
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
	public void andarMapasDoisCaminhosPossiveis2(){
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
	public void andarMapasDoisCaminhosPossiveis3(){
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
	public void andarMapasComQuatroPossibilidades(){
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
	public void andarMapasComQuatroPossibilidades2(){
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
	public void andarMapasComQuatroPossibilidades3(){
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
	public void andarMapasComQuatroPossibilidades4(){
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
	public void andarMapasComQuatroPossibilidades5(){
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
	public void andarMapasComQuatroPossibilidades6(){
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
	public void andarMapasComDoisCaminhosPossiveisEDoisImpossiveis(){
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
	public void andarMapasComUmCaminhoLongo(){
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
	public void andarMapasComUmCaminhoLongoInvertido(){
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
	public void andarMapasComUmCaminhoLongoAlterado(){
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
	public void andarMapasComVariosCaminhos(){
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
	public void andarMapasSemCaminhosPOssiveis(){
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
	public void andarMapasComBuracos(){
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
































