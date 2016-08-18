package model.binarytree;

import model.Word;

public class Leaf extends BinaryTree{

	public Leaf(Word paraula){
		super.setParaula(paraula);
		super.setRight(null);
		super.setLeft(null);
	}
}