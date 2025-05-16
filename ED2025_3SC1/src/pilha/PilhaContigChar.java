package pilha;

import dados.*;

public class PilhaContigChar {
	private ItemChar [] info;
	private int topo;

	public PilhaContigChar(int qte){
		this.topo = 0;
		this.info = new ItemChar [qte];
	}
	public ItemChar getInfo(){
		return this.info[this.topo-1];
	}
	public int getTopo(){
		return this.topo;
	}
	public boolean eVazia(){
		return (this.topo == 0);
	}
	public boolean eCheia(){
		return (this.topo == this.info.length);
	}
	// insere um novo dado no topo da pilha.
	public boolean empilhar (ItemChar elem){
		if (this.eCheia())
			return false; // evita overflow
		else {this.info[this.topo]= elem;
		this.topo++;
		return true;
		}
	}

	// remove o dado que está no topo da pilha (somente um dado).
	public ItemChar desempilhar(){
		if (this.eVazia())
			return null; // evita underflow
		else{
			this.topo--;
			return this.info[this.topo];
		}
	}

	// Atividade 06 - questão 01
	public String inverterPalavra(String palavra) {
		String resposta = "";

		for(int i = 0; i < palavra.length(); i++) {
			this.empilhar(new ItemChar(palavra.charAt(i)));
		}

		while(!this.eVazia()) {
			resposta += this.desempilhar().getChave();
		}

		return resposta;
	}

	// Atividade 06 - questão 15
	public boolean verificarInverso(String x, String y) {
		if(x.length() != y.length()) {
			return false;
		}

		PilhaContigChar aux = new PilhaContigChar(y.length());
		ItemChar item1, item2;
		for(int i = 0; i < x.length(); i++) {
			this.empilhar(new ItemChar(x.charAt(i)));
		}
		for(int i = x.length()-1; i >= 0; i++) {
			aux.empilhar(new ItemChar(y.charAt(i)));
		}
		while(!this.eVazia()) {
			item1 = this.desempilhar();
			item2 = aux.desempilhar();
			if(item1.getChave() != item2.getChave()) {
				return false;
			}
		}
		return true;
	}
}
