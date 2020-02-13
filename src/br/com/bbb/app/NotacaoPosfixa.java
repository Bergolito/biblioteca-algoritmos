package br.com.bbb.app;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import br.com.bbb.app.util.UtilitariosCaracteres;
import br.com.bbb.app.util.UtilitariosNumericos;

public class NotacaoPosfixa {

	private String[] expressao;
	
	public NotacaoPosfixa(String[] exp) {
		this.expressao = exp;
	}
	
	public String[] getExpressao() {
		return expressao;
	}


	public void setExpressao(String[] expressao) {
		this.expressao = expressao;
	}

	/**
	 * Recebe uma expressão infixa e retorna uma string com a expressão posfixa
	 * @param expr
	 * @return
	 */
	// TODO Reduzir de 20 para 15
	public List<String> notacaoInfixa2Posfixa(String expr[]) {
		List<String> saida = new ArrayList<>();
		Deque<String> pilha = new LinkedList<>();
		String item = "";
		String topoPilha = null;
		String desempilha = null;
		
		for (int i = 0; i < expr.length; i++) {
			item = expr[i];

			if(UtilitariosNumericos.isNumber(item) || UtilitariosCaracteres.isLetter(item)) {
				saida.add(item);
				
			} else {
				
				if(pilha.isEmpty()) {
					pilha.push(item);
				} else {
					
					// verifica prioridade
					topoPilha = pilha.peek();
					
					if(prioridadeOperadores(item, topoPilha)) {
						pilha.push(item);
					} else {
						
						
						while(!pilha.isEmpty()) {
							desempilha = pilha.pop();
							saida.add(desempilha);
						}
						pilha.push(item);
					}
				}
			}
		}
		//
		while(!pilha.isEmpty()) {
			desempilha = pilha.pop();
			saida.add(desempilha);
		}
		
		return saida;
	}
	
	public String imprimeInfixa2Posfixa(List<String> lista) {
		StringBuilder saida = new StringBuilder();
		lista.forEach(item->saida.append(" |"+item+"| "));
		return saida.toString();
	}

	private static boolean prioridadeOperadores(String c, String t) {
		int pc = -1;
		int pt = -1;

		if (c.equals("^") )
			pc = 4;
		else if (c.equals("*") || c.equals("/"))
			pc = 2;
		else if (c.equals("+") || c.equals("-"))
			pc = 1;
		else if (c.equals("("))
			pc = 4;

		if (t.equals("^"))
			pt = 3;
		else if (t.equals("*") || t.equals("/"))
			pt = 2;
		else if (t.equals("+") || t.equals("-"))
			pt = 1;
		else if (t.equals("("))
			pt = 0;

		return (pc > pt);
	}
	
	public static void main(String[] args) {
		  String exp1[] = {"-5","-","2","*","3","+","14","/","-7"};
		  String exp2[] = {"a","-","b","*","c"};
		  String exp3[] = {"(","a","-","b",")","*","c"};
		  String exp4[] = {"a","*","b","+","c","*","d","^","e","/","f","-","g","*","h"};
		  
		  NotacaoPosfixa posfixa1 = new NotacaoPosfixa(exp1);
		  NotacaoPosfixa posfixa2 = new NotacaoPosfixa(exp2);
		  NotacaoPosfixa posfixa3 = new NotacaoPosfixa(exp3);
		  NotacaoPosfixa posfixa4 = new NotacaoPosfixa(exp4);
		  System.out.println("Saída expr1 = "+posfixa1.imprimeInfixa2Posfixa(posfixa1.notacaoInfixa2Posfixa(posfixa1.getExpressao())));
		  System.out.println("Saída expr2 = "+posfixa2.imprimeInfixa2Posfixa(posfixa2.notacaoInfixa2Posfixa(posfixa2.getExpressao())));		 
		  System.out.println("Saída expr3 = "+posfixa3.imprimeInfixa2Posfixa(posfixa3.notacaoInfixa2Posfixa(posfixa3.getExpressao())));		 
		  System.out.println("Saída expr4 = "+posfixa4.imprimeInfixa2Posfixa(posfixa4.notacaoInfixa2Posfixa(posfixa4.getExpressao())));		 
	}
	
}
