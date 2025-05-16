package duplamente;

import dados.Item;

public class ListaDupla {
	private NoDupla prim;
	private NoDupla ult;
	private int quantNos;

	public ListaDupla() {
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}

	public int getQuantNos() {
		return this.quantNos;
	}

	public NoDupla getPrim() {
		return this.prim;
	}

	public NoDupla getUlt() {
		return this.ult;
	}

	public void setQuantNos(int valorNovo) {
		this.quantNos = valorNovo;
	}

	public void setPrim(NoDupla novoNo) {
		this.prim = novoNo;
	}

	public void setUlt(NoDupla novoNo) {
		this.ult = novoNo;
	}

	public boolean eVazia() {
		return (this.prim == null);
	}

	// insere um novo nó no final da lista ou se a lista estiver vazia, insere
	// o primeiro nó na lista
	public void inserirUltimo(Item elem) {
		NoDupla novoNo = new NoDupla(elem);
		if (this.eVazia())
			this.prim = novoNo;
		else {
			novoNo.setAnt(this.ult);
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}

	// retorna o endereço do nó que está contendo o valor a ser procurado.
	public NoDupla pesquisarNo(int chave) {
		NoDupla atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave))
			atual = atual.getProx();
		return atual;
	}

	// remove um determinado nó em qualquer posição na lista.
	public boolean removerNo(int chave) {
		NoDupla atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave)) {
			atual = atual.getProx();
		}
		if (atual == null)
			return false;
		else {
			if (atual == this.prim) {
				this.prim = prim.getProx();
				if (this.prim == null) // se a lista tem somente um nó
					this.ult = null;
				else
					this.prim.setAnt(null);
			} else if (atual == this.ult) {
				this.ult = this.ult.getAnt();
				this.ult.setProx(null);
			} else {
				atual.getProx().setAnt(atual.getAnt());
				atual.getAnt().setProx(atual.getProx());
			}
		}
		this.quantNos--;
		return true;
	}

	// Atividade 05 - questão 01
	public void concatenarListas(ListaDupla lista2) {
		this.ult.setProx(lista2.prim);
		lista2.prim.setAnt(this.ult);
		this.ult = lista2.ult;
		lista2.prim = null;
		lista2.ult = null;
		this.quantNos += lista2.quantNos;
		lista2.quantNos = 0;
	}

	// Atividade 05 - questão 02
	public ListaDupla partirLista() {
		ListaDupla lista2 = new ListaDupla();
		NoDupla atual = this.prim;

		for(int i = 1; i < this.quantNos/2; i++) {
			atual = atual.getProx();
		}

		lista2.prim = atual.getProx();
		lista2.ult = this.ult;
		this.ult = atual;
		this.ult.setProx(null);
		lista2.prim.setAnt(null);

		lista2.quantNos = this.quantNos - this.quantNos/2;
		this.quantNos = this.quantNos/2;

		return lista2;
	}

	// Atividade 05 - questão 03
	public int procurarMaior() {
		if(this.eVazia()) {
			return -1;
		}
		int maior = 0;
		NoDupla atual = this.prim;

		while(atual != null) {
			if(atual.getInfo().getChave() > maior) {
				maior = atual.getInfo().getChave();
			}
			atual = atual.getProx();
		}
		return maior;
	}

	// Atividade 05 - questão 04
	public String removerZero() {
		if(this.eVazia()) {
			return "Lista vazia";
		}
		NoDupla atual = this.prim;
		while(atual != null) {
			if(atual.getInfo().getChave() == 0) {
				this.quantNos--;
				if(atual == this.prim) {
					this.prim = this.prim.getProx();
					if(this.prim == null) {
						this.ult = null;
					}else {
						this.prim.setAnt(null);
					}
				}else {
					if(atual == this.ult) {
						this.ult = this.ult.getAnt();
						this.ult.setProx(null);
					}else {
						atual.getProx().setAnt(atual.getAnt());
						atual.getAnt().setProx(atual.getProx());
					}
				}
			}
			atual = atual.getProx();
		}
		return "Removeu todos os zeros";
	}

	// Atividade 05 - questão 05
	public String removerZeros() {
		NoDupla atual = this.prim;
		boolean removeu = false;

		while(atual != null) {
			if(atual.getInfo().getChave() == 0) {
				this.quantNos--;
				removeu = true;

				if(atual == this.prim) {
					this.prim = this.prim.getProx();
				}else {
					if(atual == this.ult) {
						this.ult = this.ult.getAnt();
						this.ult.setProx(null);
					}else {
						atual.getProx().setAnt(atual.getAnt());
						atual.getAnt().setProx(atual.getProx());
					}
				}
			}
			atual = atual.getProx();
		}
		if(removeu) {
			return "";
		}
		return "Nenhum valor 0 foi encontrado";
	}

	// estudo 01
	public void removerPares() {
		if(!this.eVazia()) {
			NoDupla atual = this.prim;

			while(atual != null) {
				if(atual.getInfo().getChave() % 2 == 0) {
					this.quantNos--;

					if(atual == this.prim) {
						this.prim = this.prim.getProx();

						if(this.prim == null) {
							this.ult = null;
						}else {
							this.prim.setAnt(null);
						}
					}else {
						if(atual == this.ult) {
							this.ult = this.ult.getAnt();
							this.ult.setProx(null);
						}else {
							atual.getProx().setAnt(atual.getAnt());
							atual.getAnt().setProx(atual.getProx());
						}
					}
				}
				atual = atual.getProx();
			}
		}
	}

	// estudo 02
	public void inserirOrdenado(Item elem) {
		NoDupla novoNo = new NoDupla(elem);

		NoDupla atual = this.prim;

		if(novoNo.getInfo().getChave() < this.prim.getInfo().getChave()) { // inserir primeiro
			novoNo.setProx(this.prim);
			this.prim.setAnt(novoNo);
			this.prim = novoNo;
		}else {
			boolean inseriu = false;
			
			while(atual.getProx() != null) {
				if(atual.getProx().getInfo().getChave() > novoNo.getInfo().getChave()) { // inserir no meio
					novoNo.setProx(atual.getProx());
					novoNo.setAnt(atual);

					atual.getProx().setAnt(novoNo);
					atual.setProx(novoNo);
					
					inseriu = true;
					
					return;
				}
				atual = atual.getProx();
			}
			if(!inseriu) { // inserir por último
				novoNo.setAnt(this.ult);
				this.ult.setProx(novoNo);

				this.ult = novoNo;
			}
		}
	}

	public String toString() {
		String msg = "";
		NoDupla atual = this.prim;
		while (atual != null) {
			msg += atual.getInfo().getChave() + "\n";
			atual = atual.getProx();
		}
		return msg;
	}
}
