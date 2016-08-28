package estructura3;

import model.avltree.ArbreAVL;

public class Tree {
	boolean inici;
	ArbreAVL arbre;
	
	
	public Tree() {
		super();
		inici= Boolean.TRUE;
		arbre = new ArbreAVL();
	}
	
	public boolean isInici() {
		return inici;
	}
	
	public void setInici(Boolean b) {
		this.inici = b;
	}
	
	public ArbreAVL getTree(){
		return arbre;
	}
}
