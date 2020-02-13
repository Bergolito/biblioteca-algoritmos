package br.com.bbb.app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.bbb.app.BuscaBinaria;
import br.com.bbb.app.util.UtilitariosNumericos;

class BuscaBinariaTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		int numeroItens = 256;
		BuscaBinaria busca = new BuscaBinaria();
		int[] itens = UtilitariosNumericos.retornaListaInteiros(numeroItens);
		busca.buscaBinaria(itens, 0, itens.length, 115);
		assertEquals(6, busca.getComparacoes());
	}

}
