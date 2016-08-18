package model;

import java.util.ArrayList;
import java.util.List;

import estructura3.Hashtablewithbinarytree;
import model.binarytree.TreeManager;
import model.hashtable.HashTable;

public class WordManager {
	
	private List<String> words;
	private ArrayList<Word> llista;
	private String extra;
	
	public WordManager(){
		llista = new ArrayList<>();
		words = null;
	}
	
	public void setWords(List<String> words) {
		if(words!=null){
			this.words=words;
		}
	}
	
	public int wordNumber(){
		if (words!=null) return words.size();
		else return 0;
	}
	public void count(){
		llista.removeAll(llista);
		for(String paraula : words){
			boolean trobat = Boolean.FALSE;
			for(Word w : llista){
				if(w.getName().equals(paraula)){
					w.addCount();
					trobat=Boolean.TRUE;
				}
			}
			if(!trobat) llista.add(new Word(paraula));
		}
	}
	
	public void countWithBinaryTree(){
		llista.removeAll(llista);
		TreeManager binaryTree = new TreeManager();
		boolean inici = true;
		for(String paraula : words){
			 if(!inici){ 
				 binaryTree.trobaPosicio(binaryTree.getArbrePrincipal(),binaryTree.getArbrePrincipal().quinCami(paraula), paraula,TreeManager.LEFT);
				}
			 else if(inici){
				 binaryTree.getArbrePrincipal().setParaula(new Word(paraula));
				 inici = Boolean.FALSE;
			 }
		}
		llista = binaryTree.printaInOrder(binaryTree.getArbrePrincipal());
		extra = "Binary Tree with " + binaryTree.getNivells() + " levels";
	}
	
	public void countWithHashTable(String hashfunction){
		HashTable hash = new HashTable(words.size(), hashfunction);
		llista.removeAll(llista);
		for(String paraula : words){
			hash.insert(paraula, paraula, hashfunction);
		}
		llista = hash.getTable();
		extra = "Static Hash Table ("+ HashTable.hashfunction +") with " + words.size() + " size\n"+"Collision: " + hash.getCollisions();
	}
	public String getExtra() {
		return extra;
	}

	public ArrayList<Word> getList() {
		return llista;
	}
	public int listNumber() {
		if (llista!=null) return llista.size();
		else return 0;
	}

	public void countWithHashTableplusTree(String hashfunction) {
		Hashtablewithbinarytree hash = new Hashtablewithbinarytree(words.size(), hashfunction);
		llista.removeAll(llista);
		for(String paraula : words){
			hash.insert(paraula, paraula);
		}
		//llista = hash.getTable();
		extra = "Static Hash Table ("+ HashTable.hashfunction +") with " + words.size() + " size\n"+"Collision: " + hash.getCollisions();
		
	}	
}
