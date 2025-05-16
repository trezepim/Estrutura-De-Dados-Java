package simplesmente;

import dados.Item;

public class No {
	 private Item info; // a declaração do tipo Item está no capitulo 1
	 private No prox;
	 
	 public No (Item elem){ // a variável elem contém os dados armazenados
	  this.info = elem;
	  this.prox = null; // esta linha é opcional, pois o prox é automaticamente
	                    // definido como null
	 }
	 public Item getInfo (){
	  return this.info;
	 }
	 public void setInfo(Item elem){
	  this.info = elem;
	 }
	 public No getProx(){
	  return this.prox;
	 }
	 public void setProx(No novoNo){
	  this.prox = novoNo;
	 }
}
