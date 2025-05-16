package simplesmente;

import dados.Item;

public class TestarLista {

	public static void main(String[] args) {
		ListaSimples lista1 = new ListaSimples();
		
		lista1.inserirUltimo(new Item(1));
		lista1.inserirUltimo(new Item(2));
		lista1.inserirUltimo(new Item(3));
		lista1.inserirUltimo(new Item(4));
		lista1.inserirUltimo(new Item(5));
		
		System.out.println(lista1.toString());
		}
}
