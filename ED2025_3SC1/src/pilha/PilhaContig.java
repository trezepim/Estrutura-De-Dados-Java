package pilha;

import dados.Item;

public class PilhaContig {
	private Item [] info;
	private int topo;

	public PilhaContig(int qte){
		this.topo = 0;
		this.info = new Item [qte];
	}
	public Item getInfo(){
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

	//inserir um novo dado no topo da pilha.
	public boolean empilhar (Item elem){
		if (this.eCheia())
			return false; // evita overflow
		else {
			this.info[this.topo]= elem;
			this.topo++;
			return true;
		}
	}

	//remove o dado que está no topo da pilha (somente um dado).
	public Item desempilhar(){
		if (this.eVazia())
			return null; // evita underflow
		else{
			this.topo--;
			return this.info[this.topo];
		}
	}

	// Atividade 06 - questão 02
	public void remover10() {
		PilhaContig aux = new PilhaContig(this.topo);
		Item item;

		while(!this.eVazia()) {
			item = this.desempilhar();
			if(item.getChave() <= 10) {
				aux.empilhar(item);
			}
		}
		while(!aux.eVazia()) {
			this.empilhar(aux.desempilhar());
		}
	}

	// Atividade 06 - questão 03
	public int verificarIguais(PilhaContig pilha2) {
		if(this.topo != pilha2.topo) {
			return 0;
		}
		PilhaContig aux1 = new PilhaContig(this.topo);
		PilhaContig aux2 = new PilhaContig(this.topo);

		boolean igual = true;

		Item item1, item2;

		while(!this.eVazia() && igual) {
			item1 = this.desempilhar();
			item2 = pilha2.desempilhar();

			aux1.empilhar(item1);
			aux2.empilhar(item2);

			if(item1.getChave() != item2.getChave()) {
				igual = false;
			}
		}
		while(!aux1.eVazia()) {
			this.empilhar(aux1.desempilhar());
			pilha2.empilhar(aux2.desempilhar());
		}
		if(igual) {
			return 1;
		}
		return 0;
	}

	// estudo 01
	public void inverterPilha() {
		PilhaContig aux1 = new PilhaContig(this.topo);
		PilhaContig aux2 = new PilhaContig(this.topo);

		Item item;

		while(!this.eVazia()) {
			item = this.desempilhar();
			aux1.empilhar(item);
		}

		while(!aux1.eVazia()) {
			item = aux1.desempilhar();
			aux2.empilhar(item);
		}

		while(!aux2.eVazia()) {
			item = aux2.desempilhar();
			this.empilhar(item);
		}
	}

	// estudo 02
	public void removerPares() {
		PilhaContig aux = new PilhaContig(this.topo);

		Item item;

		while(!this.eVazia()) {
			item = this.desempilhar();

			if(item.getChave() % 2 != 0) {
				aux.empilhar(item);
			}
		}

		while(!aux.eVazia()) {
			item = aux.desempilhar();
			this.empilhar(item);
		}
	}

	// estudo 03
	public void ordenarPilha() {
		PilhaContig aux = new PilhaContig(this.topo);

		Item item;

		while(!this.eVazia()) {
			item = this.desempilhar();
			aux.empilhar(item);

			while(!aux.eVazia() && aux.getInfo().getChave() > item.getChave()) {
				this.empilhar(aux.desempilhar());
			}

			aux.empilhar(item);

			while (!aux.eVazia()) {
				this.empilhar(aux.desempilhar());
			}
		}
	}

	// estudo 03
	public int somarElementos() {
		PilhaContig aux = new PilhaContig(this.topo);

		int soma = 0;

		Item item;

		while(!this.eVazia()) {
			item = this.desempilhar();
			soma += item.getChave();
			aux.empilhar(item);
		}

		while(!aux.eVazia()) {
			item = aux.desempilhar();
			this.empilhar(item);
		}

		return soma;
	}

	// estudo 04
	public void removerMaiorElemento() {
		PilhaContig aux = new PilhaContig(this.topo);

		Item item;

		int maior = Integer.MIN_VALUE; // atribui o menor valor de inteiro

		while(!this.eVazia()) {
			item = this.desempilhar();
			aux.empilhar(item);

			if(item.getChave() > maior) {
				maior = item.getChave();
			}
		}

		while(!aux.eVazia()) {
			item = aux.desempilhar();

			if(item.getChave() != maior) {
				this.empilhar(item);
			}
		}
	}
}
