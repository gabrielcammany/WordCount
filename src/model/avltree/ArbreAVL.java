package model.avltree;

import java.util.ArrayList;

import model.Word;

public class ArbreAVL {

    private Node arrel = null;
	private int level = 0;
	private ArrayList<Word> list;
    
    public void trobaPosicio(Node node, Word paraula, int nivell) {
        if (getArrel() == null) {
            setArrel(new Node(paraula, null));
            return;
        }

        int aux = paraula.getName().compareTo(node.getParaula().getName());
        if (0 > aux){
        	
        	
            if (node.esquerra != null) {
            	nivell++;
            	trobaPosicio(node.esquerra, paraula,nivell);
            } else {
        		if (nivell >= level)
        			this.level = nivell;
                node.esquerra = new Node(paraula, node);
            }

            if (altura(node.esquerra) - altura(node.dreta) == 2) {
                if (0 > paraula.getName().compareTo(node.esquerra.getParaula().getName())) {
                    rotarDreta(node);
                } else {
                	rotacioLR(node);
                }
            }
        } else if (0 < aux) {
            if (node.dreta != null) {
            	nivell++;
            	trobaPosicio(node.dreta, paraula,nivell);
            } else {
        		if (nivell >= level)
        			this.level = nivell;
                node.dreta = new Node(paraula, node);
            }

            if (altura(node.dreta) - altura(node.esquerra) == 2) {
                if (0 < paraula.getName().compareTo(node.dreta.getParaula().getName())){
                    rotarEsquerra(node);
                }else {
                    rotacioRL(node);
                }
            }
        }else{	node.getParaula().addCount(); }

        actualitzaAltura(node);
    }


    public void insertar(Word data) {
    	trobaPosicio(getArrel(), data,0);
    }

    public int altura(Node node) {
        return node == null ? -1 : node.altura;
    }

    
    private void rotarDreta(Node arbre) {
        Node arrel = arbre.parent;
        Node fillEsquerra = arbre.esquerra;
        
        arbre.setFillEsquerra(fillEsquerra.dreta);
        fillEsquerra.setFillDret(arbre);
        if (arrel == null) {
            this.setArrel(fillEsquerra);
            fillEsquerra.parent = null;
            return;
        }

        if (arrel.esquerra == arbre) {
        	arrel.setFillEsquerra(fillEsquerra);
        } else {
        	arrel.setFillDret(fillEsquerra);
        }

        actualitzaAltura(arbre);
        actualitzaAltura(fillEsquerra);
    }

    private void rotarEsquerra(Node arbre) {
        Node arrel = arbre.parent;
        Node fillDret = arbre.dreta;
        arbre.setFillDret(fillDret.esquerra);
        fillDret.setFillEsquerra(arbre);
        
        if (arrel == null) {
            this.setArrel(fillDret);
            fillDret.parent = null;
            return;
        }

        if (arrel.esquerra == arbre) {
        	arrel.setFillEsquerra(fillDret);
        } else {
        	arrel.setFillDret(fillDret);
        }

        actualitzaAltura(arbre);
        actualitzaAltura(fillDret);
    }

    public void actualitzaAltura(Node node) {
        node.altura = Math.max(altura(node.esquerra), altura(node.dreta)) + 1;
    }

    public void rotacioLR(Node node) {
        rotarEsquerra(node.esquerra);
        rotarDreta(node);
    }

    public void rotacioRL(Node node) {
        rotarDreta(node.dreta);
        rotarEsquerra(node);
    }

    public ArrayList<Word> printaInOrder(){
    	list = new ArrayList<Word>();
    	printaInOrder(getArrel());
    	return list;
    }

    private void printaInOrder(Node node) {
    	if(node.esquerra != null){
			printaInOrder(node.esquerra);
		}else{
			list.add(node.getParaula());
		}
		if(node.dreta != null && node.esquerra !=null){
			list.add(node.getParaula());
		}
		if(node.dreta != null){
			printaInOrder(node.dreta);
		}else if(node.dreta != null || node.esquerra !=null){
			list.add(node.getParaula());
		}
    }
    
    public void printaPreOrder(){
    	printaPreOrder(getArrel());
    }
    
    private void printaPreOrder(Node arbre) {
		System.out.print(arbre.getParaula() + ", ");
		if(arbre.esquerra != null){
			printaPreOrder(arbre.esquerra);
		}
		if(arbre.dreta != null){
			printaPreOrder(arbre.dreta);
		}
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public Node getArrel() {
		return arrel;
	}


	public void setArrel(Node arrel) {
		this.arrel = arrel;
	}
    


}
