package simplesmente;

import dados.Item;

public class ListaSimples {
	private No prim;
	private No ult;
	private int quantNos;
	//construtor da classe
	public ListaSimples(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}
	public int getQuantNos(){
		return this.quantNos;
	}
	public No getPrim(){
		return this.prim;
	}
	public No getUlt(){
		return this.ult;
	}
	public void setQuantNos(int novoValor){
		this.quantNos = novoValor;
	}
	public void setPrim(No novoNo){
		this.prim = novoNo;
	}
	public void setUlt(No novoNo){
		this.ult = novoNo;
	}
	public boolean eVazia (){
		return (this.prim == null);
	}
	//insere um novo nó no final da lista ou se a lista estiver vazia, insere o primeiro nó na lista
	public void inserirUltimo (Item elem){
		No novoNo = new No (elem);
		if (this.eVazia()){
			this.prim = novoNo;
		} else {
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}

	public void inserirPrimeiro(Item elem) {
		No novoNo = new No(elem);
		if (this.eVazia()) {
			this.prim = novoNo;
			this.ult = novoNo;
		} else {
			novoNo.setProx(this.prim);
			this.prim = novoNo;
		}
		this.quantNos++;
	}

	//retorna o endereço do nó que está contendo o valor a ser procurado.
	public No pesquisarNo (int chave){
		No atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave)){
			atual = atual.getProx();
		}
		return atual;

	}
	public boolean removerNo(int x){
		if (this.eVazia()){
			return false;
		}else{
			if (this.prim.getInfo().getChave()==x){
				if (this.prim.getProx()==null){  //se for único nó da lista
					this.ult = null;
				}
				//remover o primeiro nó da lista
				this.prim = this.prim.getProx();
			}else{
				No atual = this.prim;
				while ((atual.getProx()!=null)&&
						(atual.getProx().getInfo().getChave()!=x)){
					atual = atual.getProx();
				}
				if (atual.getProx()==null){ //não achou o valor na lista
					return false;
				}else{
					if (atual.getProx()==this.ult){  //se for o último nó
						atual.setProx(null);
						this.ult = atual;
					}else{ //remove o nó no meio da lista
						atual.setProx(atual.getProx().getProx());
					}
				}
			}
			this.quantNos--;
			return true;
		}
	}
	// Atividade 02 - questão 07
	public int calcularSoma() {
		int soma = 0;
		No atual = this.prim;
		while(atual != null) {
			soma += atual.getInfo().getChave();
			atual = atual.getProx();
		}
		return soma;
	}

	// Atividade 02 - questão 08
	public double calcularMedia() {
		double soma = 0;
		No atual = this.prim;
		while(atual != null) {
			soma += atual.getInfo().getChave();
			atual = atual.getProx();
		}
		return soma / this.quantNos;
	}

	// Atividade 02 - questão 09
	public String mostrarPares() {
		String resposta = " ";
		No atual = this.prim;
		while(atual != null) {
			if(atual.getInfo().getChave() % 2 == 0) {
				resposta += atual.getInfo().getChave() + " ";
			}
			atual = atual.getProx();
		}
		return resposta;
	}

	// Atividade 02 - questão 10
	public boolean verificarIdenticas(ListaSimples lista2) {
		if (this.quantNos != lista2.getQuantNos()) {
			return false;
		}else {
			No atual = this.prim;
			No atual2 = lista2.getPrim();

			while (atual != null) {
				if (atual.getInfo().getChave() != atual2.getInfo().getChave()) {
					return false;
				}
				atual = atual.getProx();
				atual2 = atual2.getProx();
			}
			return true;
		}
	}

	//Atividade 02 - questão 11
	public boolean alterarNo(int x) {
		No achou = this.pesquisarNo(x);
		if (achou == null) {
			return false;
		}else {
			achou.getInfo().setChave(50);
			return true;
		}
	}

	// Atividade 02 - questão 12
	public int contarNos(int x) {
		if (this.eVazia()) {
			this.inserirUltimo(new Item(x));
			return 1;
		}else {
			No atual = this.prim;
			int cont = 0;
			while (atual != null) {
				if (atual.getInfo().getChave() == x) {
					cont++;
				}
				atual = atual.getProx();
			}
			if(cont == 0) {
				this.inserirUltimo(null);
				return 1;
			}else {
				return cont;
			}
		}
	}

	// Questão 05 Simulado
	public void listaPares(ListaSimples lista2) {
		No atual = this.prim;

		while(atual != null) {
			if(atual.getInfo().getChave() % 2 == 0) {
				lista2.inserirUltimo(new Item(atual.getInfo().getChave()));
				lista2.quantNos++;
			}
			atual = atual.getProx();
		}
	}

	// Questão 06 Simulado
	public void mediaLista() {
		No atual = this.prim;
		
		int soma = 0;
		int cont = 0;
		
		while (atual != null) {
			if (atual.getInfo().getChave() > 1000) {
				soma += atual.getInfo().getChave();
				cont++;
			}
			atual = atual.getProx();
		}
		this.inserirUltimo(new Item(soma/cont));
		this.quantNos++;
	}

	//mostra todo o conteúdo da lista
	public String toString(){
		String msg = "";
		No atual = this.prim;
		while (atual != null){
			msg += atual.getInfo().getChave()+"\n";
			atual = atual.getProx();
		}
		return msg;
	}
}
