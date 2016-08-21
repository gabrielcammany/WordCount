package model.binarytree;

import java.util.ArrayList;

import model.Word;
import model.binarytree.Node;

public class BinaryTree{
	public final static int LEFT = 1;
	public final static int RIGHT = -1;
	public final static int MIDDLE = 0;
	private int level = 0;
    private Node principal = null;
	private ArrayList<Word> list;
	
	
	public Node getArbrePrincipal() {
		return principal;
	}

	public int getNivells() {
		return level;
	}

	public ArrayList<Word> printaInOrder(){
		list = new ArrayList<Word>();
		return printaInOrder(principal);
	}
	
	private ArrayList<Word> printaInOrder(Node arbre) {
		if (arbre.getLeft() != null) printaInOrder(arbre.getLeft());
		else list.add(arbre.getParaula());
		if (arbre.getRight() != null && arbre.getLeft() != null) list.add(arbre.getParaula());
		if (arbre.getRight() != null) 	printaInOrder(arbre.getRight());
		else if (arbre.getRight() != null || arbre.getLeft() != null) list.add(arbre.getParaula());
		return list;
	}

	public void trobaPosicio(Node tree, String nodeParaula, int nivell) {
		
		if (principal == null) {
			principal = new Node(new Word(nodeParaula));
            return;
        }
		switch (tree.quinCami(nodeParaula)) {
		case LEFT:
			if (tree.getLeft() != null) {
				if (tree.getLeft().quinCami(nodeParaula) == MIDDLE) {
					tree.getLeft().getParaula().addCount();
				} else if (tree.getLeft().quinCami(nodeParaula) < MIDDLE) {
					nivell++;
					trobaPosicio(tree.getLeft(), nodeParaula, nivell);
				} else {
					nivell++;
					trobaPosicio(tree.getLeft(), nodeParaula, nivell);
				}
			} else {
				if (nivell >= level)
					this.level = nivell;
				tree.setLeft(new Node(new Word(nodeParaula)));
			}
			break;
		case RIGHT:
			if (tree.getRight() != null) {
				if (tree.getRight().quinCami(nodeParaula) == MIDDLE) {
					tree.getRight().getParaula().addCount();
				} else if (tree.getRight().quinCami(nodeParaula) < MIDDLE) {
					nivell++;
					trobaPosicio(tree.getRight(), nodeParaula, nivell);
				} else {
					nivell++;
					trobaPosicio(tree.getRight(), nodeParaula, nivell);
				}
			} else {
				if (nivell > level)
					this.level = nivell;
				tree.setRight(new Node(new Word(nodeParaula)));
			}
			break;
		case MIDDLE:
			tree.getParaula().addCount();
		}
	}
}
