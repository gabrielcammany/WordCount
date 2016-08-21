package model.binarytree;

import model.Word;

public class Node{

	private Word paraula;
	private Node dret;
	private Node esquerra;
	
	public Node(Word paraula){
		this.dret = null;
		this.esquerra = null;
		this.paraula = paraula;
	}
	public String getText() {
		return paraula.getName();
	}	

	public int quinCami(String paraula){
		int valor = this.paraula.getName().compareTo(paraula);
		if(valor == 0){
			return 0;
		}else if(valor<0){
			return -1;
		}else{
			return 1;
		}
	}

	public Word getParaula() {
		return paraula;
	}

	public void setParaula(Word paraula) {
		this.paraula = paraula;
	}

	public Node getRight() {
		return dret;
	}

	public void setRight(Node dret) {
		this.dret = dret;
	}

	public Node getLeft() {
		return esquerra;
	}
	
	public void setLeft(Node esquerra) {
		this.esquerra = esquerra;
	}
	
}