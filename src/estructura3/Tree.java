package estructura3;

import model.binarytree.BinaryTree;

public class Tree {
	boolean inici;
	BinaryTree arbre;
	
	
	public Tree() {
		super();
		inici= Boolean.TRUE;
		arbre = new BinaryTree();
	}
	
	public boolean isInici() {
		return inici;
	}
	
	public void setInici(Boolean b) {
		this.inici = b;
	}
	
	public BinaryTree getTree(){
		return arbre;
	}
}
