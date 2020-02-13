package br.com.bbb.app.util;

public class UtilitariosCaracteres {

	private UtilitariosCaracteres() {
		//
	}
	
	public static boolean isLetter(String item) {
		return Character.isLetter(item.charAt(0));
	}
	

}
