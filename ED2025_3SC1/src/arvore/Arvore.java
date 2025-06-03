package arvore;

import dados.Item;

public class Arvore {
	private NoArv raiz;
	private int quantNos; //opcional

	public Arvore(){
		this.quantNos=0;
		this.raiz = null;
	}
	public boolean eVazia (){
		return (this.raiz == null);
	}
	public NoArv getRaiz(){
		return this.raiz;
	}
	public int getQuantNos() {
		return this.quantNos;
	}

	//inserir um novo nó na arvore. Sempre insere em um atributo que seja igual a null
	public boolean inserir (Item elem){
		if (pesquisar (elem.getChave())){
			return false;
		}else{
			this.raiz = inserir (elem, this.raiz);
			this.quantNos++;
			return true;
		}
	}

	public NoArv inserir (Item elem, NoArv no){
		if (no == null){
			NoArv novo = new NoArv(elem);
			return novo;
		}else {
			if (elem.getChave() < no.getInfo().getChave()){
				no.setEsq(inserir(elem, no.getEsq()));
				return no;
			}else{
				no.setDir(inserir(elem, no.getDir()));
				return no;
			}
		}
	}

	//Pesquisa se um determinado valor está na árvore
	public boolean pesquisar (int chave){
		if (pesquisar (chave, this.raiz)!= null){
			return true;
		}else{
			return false;
		}

	}
	private NoArv pesquisar (int chave, NoArv no){
		if (no != null){
			if (chave < no.getInfo().getChave()){
				no = pesquisar (chave, no.getEsq());
			}else{
				if (chave > no.getInfo().getChave()){
					no = pesquisar (chave, no.getDir());
				}
			}
		}
		return no;
	}

	//remove um determinado nó procurando pela chave. O nó pode estar em qualquer
	//posição na árvore
	public boolean remover (int chave){
		if (pesquisar (chave, this.raiz) != null){
			this.raiz = remover (chave, this.raiz);
			this.quantNos--;
			return true;
		}
		else {
			return false;
		}
	}
	public NoArv remover (int chave, NoArv arv){
		if (chave < arv.getInfo().getChave()){
			arv.setEsq(remover (chave, arv.getEsq()));
		}else{
			if (chave > arv.getInfo().getChave()){
				arv.setDir(remover (chave, arv.getDir()));
			}else{
				if (arv.getDir()== null){
					return arv.getEsq();
				}else{
					if (arv.getEsq() == null){
						return arv.getDir();
					}else{
						arv.setEsq(Arrumar (arv, arv.getEsq()));
					}
				}
			}
		}
		return arv;
	}

	private NoArv Arrumar (NoArv arv, NoArv maior){
		if (maior.getDir() != null){
			maior.setDir(Arrumar (arv, maior.getDir()));
		}
		else{
			arv.setInfo(maior.getInfo());
			maior = maior.getEsq();
		}
		return maior;
	}

	//caminhamento central
	public Item [] CamCentral (){
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos];
		return (FazCamCentral (this.raiz, vet, n));
	}
	private Item [] FazCamCentral (NoArv arv, Item [] vet, int []n){
		if (arv != null) {
			vet = FazCamCentral (arv.getEsq(),vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamCentral (arv.getDir(),vet,n);
		}
		return vet;
	}

	//caminhamento pré-fixado
	public Item [] CamPreFixado (){
		int []n = new int[1];
		n[0] = 0;
		Item [] vet = new Item[this.quantNos];
		return (FazCamPreFixado (this.raiz, vet, n));
	}
	private Item [] FazCamPreFixado (NoArv arv, Item [] vet, int []n){
		if (arv != null) {
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamPreFixado (arv.getEsq(), vet,n);
			vet = FazCamPreFixado (arv.getDir(), vet,n);
		}
		return vet;
	}

	//caminhamento pós-fixado
	public Item [] CamPosFixado (){
		int []n= new int[1];
		n[0] = 0;
		Item [] vet = new Item[this.quantNos];
		return (FazCamPosFixado (this.raiz, vet, n));
	}
	private Item [] FazCamPosFixado (NoArv arv, Item[] vet, int []n){
		if (arv != null) {
			vet = FazCamPosFixado (arv.getEsq(), vet,n);
			vet = FazCamPosFixado (arv.getDir(), vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
		}
		return vet;
	}

	/*
	a)	Mostrar os nós folhas

	b)	Mostrar a soma de todos os números

	c)	Mostrar a soma somente dos números pares

	d)	Mostrar somente os números pares
	 */

	public void mostrarFolhas() {
		Item[] vet = new Item[this.quantNos];
		int[] n = new int[1];
		n[0] = 0;

		fazMostrarFolhas(raiz, vet, n);

		for (int i = 0; i < vet.length; i++) {
			System.out.println(vet[i]);
		}
	}

	private Item[] fazMostrarFolhas(NoArv arv, Item[] vet, int []n) {
		if (arv != null) {
			vet = fazMostrarFolhas(arv.getEsq(), vet, n);

			if(arv.getEsq() == null && arv.getDir() == null) {
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}

			vet = fazMostrarFolhas(arv.getDir(), vet, n);

		}
		return vet;
	}

	public void mostrarSoma() {
		Item[] vet = new Item[this.quantNos];
		int[] n = new int[1];
		n[0] = 0;

		int soma = 0;

		fazMostrarSoma(raiz, vet, n);

		for (int i = 0; i < vet.length; i++) {
			soma += vet[i].getChave();
		}

		System.out.println("Soma: " + soma);
	}

	private Item[] fazMostrarSoma(NoArv arv, Item []vet, int []n) {
		if(arv != null) {
			vet = fazMostrarSoma(arv.getEsq(), vet, n);

			if(arv != null) {
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}

			vet = fazMostrarSoma(arv.getDir(), vet, n);

		}
		return vet;
	}

	public void mostrarSomaPares() {
		Item[] vet = new Item[this.quantNos];
		int[] n = new int[1];
		n[0] = 0;

		int soma = 0;

		fazMostrarSomaPares(raiz, vet, n);

		for (int i = 0; i < vet.length; i++) {
			soma += vet[i].getChave();
		}

		System.out.println("Soma dos números pares: " + soma);
	}

	private Item[] fazMostrarSomaPares(NoArv arv, Item []vet, int []n) {
		if(arv != null) {
			vet = fazMostrarSomaPares(arv.getEsq(), vet, n);

			if(arv.getInfo().getChave() % 2 == 0) {
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}

			vet = fazMostrarSomaPares(arv.getDir(), vet, n);

		}
		return vet;
	}

	public void mostrarPares() {
		Item[] vet = new Item[this.quantNos];
		int[] n = new int[1];
		n[0] = 0;

		fazMostrarPares(raiz, vet, n);

		for (int i = 0; i < vet.length; i++) {
			System.out.println(vet[i]);
		}
	}

	private Item[] fazMostrarPares(NoArv arv, Item []vet, int []n) {
		if(arv != null) {
			vet = fazMostrarPares(arv.getEsq(), vet, n);

			if(arv.getInfo().getChave() % 2 == 0) {
				vet[n[0]] = arv.getInfo();
				n[0]++;
			}

			vet = fazMostrarPares(arv.getDir(), vet, n);

		}
		return vet;
	}
}