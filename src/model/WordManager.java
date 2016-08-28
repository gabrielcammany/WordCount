package model;

import java.util.ArrayList;
import java.util.List;

import model.avltree.ArbreAVL;
import model.binarytree.BinaryTree;
import model.hashandtree.HashtablewithAVLTree;
import model.hashtable.HashTable;
import tools.Time;

public class WordManager {
	
	private List<String> words;
	private ArrayList<Word> llista;
	private String extra;
	private Time tiempo;
	
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
		tiempo.setTemps_iniciOrdenacio();
		tiempo = new Time();
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
		tiempo.setTemps_final();
		tiempo.setTemps_finalOrdenacio();
	}
	
	public void countWithBinaryTree(){
		BinaryTree binaryTree = new BinaryTree();
		tiempo = new Time();
		for(String paraula : words){
			binaryTree.trobaPosicio(binaryTree.getArbrePrincipal(), paraula,BinaryTree.LEFT);
		}
		tiempo.setTemps_final();
		tiempo.setTemps_iniciOrdenacio();
		llista = binaryTree.printaInOrder();
		tiempo.setTemps_finalOrdenacio();
		extra = "Binary Tree with " + binaryTree.getNivells() + " levels";
	}
	
	public void countWithAVLTree(){
		ArbreAVL avl = new ArbreAVL();
		tiempo = new Time();
		for(String paraula : words){
			avl.insertar(new Word(paraula));
		}
		tiempo.setTemps_final();
		tiempo.setTemps_iniciOrdenacio();
		llista = avl.printaInOrder();
		tiempo.setTemps_finalOrdenacio();
		extra = "Binary Tree with " + avl.getLevel() + " levels";
	}
	
	public void countWithHashTable(String hashfunction){
		tiempo = new Time();
		HashTable hash = new HashTable(words.size(), hashfunction);
		for(String paraula : words){
			hash.insert(paraula, paraula, hashfunction);
		}
		tiempo.setTemps_final();
		tiempo.setTemps_iniciOrdenacio();
		llista = hash.getTable();
		tiempo.setTemps_finalOrdenacio();
		extra = "Static Hash Table ("+ HashTable.hashfunction +") with " + words.size() + " size\n"+"Collision: " + hash.getCollisions();
	}
	public String getExtra() {
		return extra;
	}

	public List<Word> getList() {
		return llista;
	}
	public int listNumber() {
		if (llista!=null) return llista.size();
		else return 0;
	}

	public void countWithHashTableplusTree(String hashfunction) {
		HashtablewithAVLTree hash = new HashtablewithAVLTree(24, hashfunction);
		tiempo = new Time();
		for(String paraula : words){
			hash.insert(paraula);
		}
		tiempo.setTemps_final();
		tiempo.setTemps_iniciOrdenacio();
		llista = hash.getTable();
		tiempo.setTemps_finalOrdenacio();
		extra = "Static Hash Table ("+ HashTable.hashfunction +") with " + words.size() + " size\n"+"Collision: " + hash.getCollisions();
		
	}

	public Time getTiempo() {
		return tiempo;
	}

	public void setTiempo(Time tiempo) {
		this.tiempo = tiempo;
	}	
}
