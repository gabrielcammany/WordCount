package model.binarytree;

import java.util.ArrayList;

import model.Word;

public class TreeManager {
	public final static int LEFT = 1;
	public final static int RIGHT = -1;
	public final static int MIDDLE = 0;
	private int level;
	private BinaryTree principal;
	private ArrayList<Word> list;

	public TreeManager() {
		level = 1;
		principal = new BinaryTree();
		list = new ArrayList<>();
	}

	public BinaryTree getArbrePrincipal() {
		return principal;
	}

	public int getNivells() {
		return level;
	}

	public ArrayList<Word> printaInOrder(BinaryTree arbre) {
		if (arbre.getLeft() != null) printaInOrder(arbre.getLeft());
		else list.add(arbre.getParaula());
		if (arbre.getRight() != null && arbre.getLeft() != null) list.add(arbre.getParaula());
		if (arbre.getRight() != null) 	printaInOrder(arbre.getRight());
		else if (arbre.getRight() != null || arbre.getLeft() != null) list.add(arbre.getParaula());
		return list;
	}

	public void trobaPosicio(BinaryTree tree, int i, String nodeParaula, int nivell) {
		switch (i) {
		case LEFT:
			if (tree.getLeft() != null) {
				if (tree.getLeft().quinCami(nodeParaula) == MIDDLE) {
					tree.getLeft().getParaula().addCount();
				} else if (tree.getLeft().quinCami(nodeParaula) < MIDDLE) {
					nivell++;
					trobaPosicio(tree.getLeft(), RIGHT, nodeParaula, nivell);
				} else {
					nivell++;
					trobaPosicio(tree.getLeft(), LEFT, nodeParaula, nivell);
				}
			} else {
				if (nivell >= level)
					this.level = nivell;
				tree.setLeft(new Leaf(new Word(nodeParaula)));
			}
			break;
		case RIGHT:
			if (tree.getRight() != null) {
				if (tree.getRight().quinCami(nodeParaula) == MIDDLE) {
					tree.getRight().getParaula().addCount();
				} else if (tree.getRight().quinCami(nodeParaula) < MIDDLE) {
					nivell++;
					trobaPosicio(tree.getRight(), RIGHT, nodeParaula, nivell);
				} else {
					nivell++;
					trobaPosicio(tree.getRight(), LEFT, nodeParaula, nivell);
				}
			} else {
				if (nivell > level)
					this.level = nivell;
				tree.setRight(new Leaf(new Word(nodeParaula)));
			}
			break;
		case MIDDLE:
			tree.getParaula().addCount();
		}
	}
}