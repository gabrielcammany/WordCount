package estructura3;

import java.math.BigInteger;

import model.Word;

public class HashtablewithAVLTree{


	public static String hashfunction;

	private int tablesize;
	private Tree[] table;
	public static BigInteger collision;
	
	//create hashtable
	public HashtablewithAVLTree(){
		this.tablesize = 24;
		table = new Tree[tablesize];
		collision = BigInteger.valueOf(0);
		for (int i = 0; i<tablesize; i++){
			table[i] = new Tree();
		}
	}
	
	public void insert (String keyAndValue){
		table[hash(keyAndValue)].getTree().insertar(new Word(keyAndValue));
	}
	
	public int hash(String str){
		return (str.charAt(0)%tablesize)-1;
	}
	
	/*
	public ArrayList<Word> getTable() {
		ArrayList<Word> llista = new ArrayList<>();
		for(int i =0 ; i<tablesize; i++){
			if(table[i]!=null){
				llista.add((Word)table[i].getValue());
			}
		}
		return llista;
	}*/

	public BigInteger getCollisions() {
		return collision;
	}
}
