package duplamente;

import java.util.Scanner;

import dados.Item;

public class MenuPrincipalDupla {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		ListaDupla lista = new ListaDupla();
		
		lista.inserirUltimo(new Item(2));
		lista.inserirUltimo(new Item(4));
		lista.inserirUltimo(new Item(6));
		lista.inserirUltimo(new Item(8));
		lista.inserirUltimo(new Item(9));
		
		lista.inserirOrdenado(new Item(10));
		
		System.out.println(lista.toString());
		
	}
}