package pilha;

import dados.Item;

public class MenuPrincipal {

	public static void main(String[] args) {
		PilhaContig pilha = new PilhaContig(5);

		pilha.empilhar(new Item(1));
		pilha.empilhar(new Item(2));
		pilha.empilhar(new Item(3));
		pilha.empilhar(new Item(4));
		pilha.empilhar(new Item(5));

		pilha.inverterPilha();

		System.out.println(pilha.getInfo().getChave());
	}
}