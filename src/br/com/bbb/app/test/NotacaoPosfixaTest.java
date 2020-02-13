package br.com.bbb.app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.bbb.app.NotacaoPosfixa;

class NotacaoPosfixaTest {

	@Test
	void test01() {
		String exp1[] = {"-5","-","2","*","3","+","14","/","-7"};
		String exp1Saida[] = {"-5","2","3","*","-","14","-7","/","+"};
		
		NotacaoPosfixa posfixa1 = new NotacaoPosfixa(exp1);
		List<String> listaResultaExp1 = posfixa1.notacaoInfixa2Posfixa(posfixa1.getExpressao());
		assertTrue(posfixa1.notacaoInfixa2Posfixa(posfixa1.getExpressao()).size() == 9);
		for (int i = 0; i < listaResultaExp1.size(); i++) {
			assertEquals(exp1Saida[i], posfixa1.notacaoInfixa2Posfixa(posfixa1.getExpressao()).get(i));
		}

	}

	@Test
	void test02() {
		String exp2[] = {"a","-","b","*","c"};
		String exp2Saida[] = {"a","b","c","*","-"};
		
		NotacaoPosfixa posfixa2 = new NotacaoPosfixa(exp2);
		List<String> listaResultaExp2 = posfixa2.notacaoInfixa2Posfixa(posfixa2.getExpressao());
		assertTrue(posfixa2.notacaoInfixa2Posfixa(posfixa2.getExpressao()).size() == 5);
		for (int i = 0; i < listaResultaExp2.size(); i++) {
			assertEquals(exp2Saida[i], posfixa2.notacaoInfixa2Posfixa(posfixa2.getExpressao()).get(i));
		}
		
	}

	@Test
	void test03() {
		String exp3[] = {"(","a","-","b",")","*","c"};
		String exp3Saida[] = {"a","b","-","(","c","*",")"};

		NotacaoPosfixa posfixa3 = new NotacaoPosfixa(exp3);
		List<String> listaResultaExp3 = posfixa3.notacaoInfixa2Posfixa(posfixa3.getExpressao());
		assertTrue(posfixa3.notacaoInfixa2Posfixa(posfixa3.getExpressao()).size() == 7);
		for (int i = 0; i < listaResultaExp3.size(); i++) {
			assertEquals(exp3Saida[i], posfixa3.notacaoInfixa2Posfixa(posfixa3.getExpressao()).get(i));
		}
		
	}

	@Test
	void test04() {
		String exp4[] = {"a","*","b","+","c","*","d","^","e","/","f","-","g","*","h"};
		String exp4Saida[] = {"a","b","*","c","d","e","^","*","+","f","/","g","h","*","-"};

		NotacaoPosfixa posfixa4 = new NotacaoPosfixa(exp4);
		List<String> listaResultaExp4 = posfixa4.notacaoInfixa2Posfixa(posfixa4.getExpressao());
		assertTrue(posfixa4.notacaoInfixa2Posfixa(posfixa4.getExpressao()).size() == 15);
		for (int i = 0; i < listaResultaExp4.size(); i++) {
			assertEquals(exp4Saida[i], posfixa4.notacaoInfixa2Posfixa(posfixa4.getExpressao()).get(i));
		}
		
	}

		
}
