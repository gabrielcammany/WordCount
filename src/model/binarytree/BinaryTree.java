package model.binarytree;

import model.Word;

public class BinaryTree{
	private Word paraula;
	private Leaf dret;
	private Leaf esquerra;
	
	public BinaryTree(){
		this.dret = null;
		this.esquerra = null;
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

	public Leaf getRight() {
		return dret;
	}

	public void setRight(Leaf dret) {
		this.dret = dret;
	}

	public Leaf getLeft() {
		return esquerra;
	}
	
	public void setLeft(Leaf esquerra) {
		this.esquerra = esquerra;
	}
	
	public String getText() {
		return paraula.getName();
	}	

}
