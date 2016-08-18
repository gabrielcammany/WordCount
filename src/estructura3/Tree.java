package estructura3;

import model.binarytree.TreeManager;

public class Tree {
	boolean inici;
	TreeManager arbre;
	
	
	public Tree() {
		super();
		inici= Boolean.TRUE;
		arbre = new TreeManager();
	}
	
	public boolean isInici() {
		return inici;
	}
	
	public void setInici(Boolean b) {
		this.inici = b;
	}
	
	public TreeManager getTree(){
		return arbre;
	}
}
