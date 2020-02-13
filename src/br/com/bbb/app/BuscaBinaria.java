package br.com.bbb.app;

import br.com.bbb.app.util.UtilitariosNumericos;

public class BuscaBinaria {

	private int comparacoes;
	
	public BuscaBinaria() {
		//
	}
	
	public int getComparacoes() {
		return comparacoes;
	}

	public void setComparacoes(int comparacoes) {
		this.comparacoes = comparacoes;
	}

	public int buscaBinaria(int[] listaItens, int indiceInicio, int indiceFim, int numeroProcurado) {
		setComparacoes(getComparacoes()+1);
		int i = (int)((indiceInicio + indiceFim) / 2);
		
		if(listaItens[i] == numeroProcurado) {
			System.out.println("Achou numero!!!");
			return i;
		}
		if(indiceInicio == indiceFim) {
			System.out.println("NÃO achou numero procurado => "+numeroProcurado);
			return -1;
		}		
		else if(listaItens[i] >= numeroProcurado ) {
			return buscaBinaria(listaItens, indiceInicio, i-1, numeroProcurado);
			
		} else if(listaItens[i] < numeroProcurado ) {
			return buscaBinaria(listaItens, i+1, indiceFim, numeroProcurado);
		}

		return -1;
	}
	
	public static void main(String[] args) {
		int numeroItens = 1_000_000;
		BuscaBinaria busca = new BuscaBinaria();
		int[] itens = UtilitariosNumericos.retornaListaInteiros(numeroItens);
		busca.buscaBinaria(itens, 0, itens.length, 543_689);
		System.out.println("Numero de comparacoes = "+busca.getComparacoes());
	}
}
