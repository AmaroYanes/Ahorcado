package dad.javafx.ahorcado.controller;

import javafx.collections.ObservableList;

public class AhorcadoFunciones {
	
	public static String cogerPalabra(ObservableList<String> palabras) {
		int indice = (int)(Math.random()*palabras.size());
		return palabras.get(indice);
	}
	public static String generarOculta(String palabra) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < palabra.length();i++) {
			sb.append("_");
		}
		return sb.toString();
	}
	public static String cambiarString(String palabra,String oculta,char caracter) {
		StringBuilder novo = new StringBuilder();
		novo.append(oculta);
		for(int i = 0;i < palabra.length();i++) {
			if(palabra.charAt(i)==caracter)novo.setCharAt(i, caracter);
		}
		return novo.toString();
	}
}
