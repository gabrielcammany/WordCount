package model.avltree;

import model.Word;

public class Node {
	 Node esquerra, dreta;
     Node parent;
     int vegades = 0;
     private Word paraula;
     int altura = 0;
     

     public Node(Word data, Node parent) {
         this.setParaula(data);
         this.parent = parent;
     }

     void setFillEsquerra(Node fill) {
         if (fill != null) {
             fill.parent = this;
         }

         this.esquerra = fill;
     }

     void setFillDret(Node child) {
         if (child != null) {
             child.parent = this;
         }

         this.dreta = child;
     }

	public Word getParaula() {
		return paraula;
	}

	public void setParaula(Word paraula) {
		this.paraula = paraula;
	}
}
