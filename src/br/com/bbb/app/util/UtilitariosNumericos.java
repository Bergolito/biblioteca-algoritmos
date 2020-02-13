package br.com.bbb.app.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class UtilitariosNumericos {

	private UtilitariosNumericos() {
		//
	}
	
	public static int[] retornaListaInteiros(int qtdItens) {
		int[] itens = new int[qtdItens];
		
		for (int i = 0; i < qtdItens; i++) {
			itens[i] = i;
		}
		
		return itens;
	}	
	
	public static int[] retornaListaInteirosAleatorios(int qtdItens, int fatorMultiplicados) {
		int[] retorno = null;
		List<Integer> itens = new ArrayList<>();
		
		Random rand = new Random();
		for (int i = 0; i < qtdItens; i++) {
			itens.add(rand.nextInt(qtdItens*fatorMultiplicados));
		}
		
		retorno = ordenaListaItens(itens);
		return retorno;
	}	
	
	public static int[] ordenaListaItens(List<Integer> listaDesordenada) {
		int[] arrayItens = new int[listaDesordenada.size()];
		Collections.sort(listaDesordenada);
		for (int i = 0; i < listaDesordenada.size(); i++) {
			arrayItens[i] = listaDesordenada.get(i);
		}
		return arrayItens;
	}
	
	public static boolean isNumber(String item) {
		try {
			Integer.parseInt(item);
			return true;
		} catch (Exception e) {
			// Não faz nada!	
		}
		return false;
	}


}
