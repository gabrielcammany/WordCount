package estructura3;

import java.math.BigInteger;

import model.Word;
import model.binarytree.BinaryTree;
import model.hashtable.HashFunctionLibrary;

public class Hashtablewithbinarytree{


	public static String hashfunction;

	private int tablesize;
	private Tree[] table;
	public static BigInteger collision;
	
	//create hashtable
	public Hashtablewithbinarytree(int tablesize, String hashfunction){
		this.tablesize = tablesize;
		table = new Tree[tablesize];
		collision = BigInteger.valueOf(0);
		this.hashfunction = hashfunction;
		for (int i = 0; i<tablesize; i++){
			table[i] = new Tree();
		}
	}
	
	public void insert (String key, String value){
		//declaracions
		int hash = hash(key);
		Tree t = table[hash];
		BinaryTree tm = t.getTree();
		tm.trobaPosicio(tm.getArbrePrincipal(),value,BinaryTree.LEFT);
	}
/*
	public Word consulta (String key){
		Boolean trobat = Boolean.FALSE;
		HashEntry aux;
		int hash = hash(key);
		aux=table[hash];
		while ( aux!= null && !trobat){
			if (aux.getKey() == key) trobat=Boolean.TRUE;
			else{
				hash = rehash(hash);
				aux = table[hash];
			}
		}
		if (trobat)	return (Word) aux.getValue();
		return null;
	}
	*/
	
	public int hash(String str){
		switch(hashfunction){
		case "APHash":
			return (int) Math.abs(HashFunctionLibrary.APHash(str) % tablesize);
		case "BKDRHash":
			return (int) Math.abs(HashFunctionLibrary.BKDRHash(str) % tablesize);
		case "BPHash":
			return (int) Math.abs(HashFunctionLibrary.BPHash(str) % tablesize);
		case "DEKHash":
			return (int) Math.abs(HashFunctionLibrary.DEKHash(str) % tablesize);
		case "PJWHash":
			return (int) Math.abs(HashFunctionLibrary.PJWHash(str) % tablesize);
		case "DJBHash":
			return (int) Math.abs(HashFunctionLibrary.DJBHash(str) % tablesize);
		case "ELFHash":
			return (int) Math.abs(HashFunctionLibrary.ELFHash(str) % tablesize);
		case "FNVHash":
			return (int) Math.abs(HashFunctionLibrary.FNVHash(str) % tablesize);
		case "JSHash":
			return (int) Math.abs(HashFunctionLibrary.JSHash(str) % tablesize);
		case "RSHash":
			return (int) Math.abs(HashFunctionLibrary.RSHash(str) % tablesize);
		case "SDBMHash":
			return (int) Math.abs(HashFunctionLibrary.SDBMHash(str) % tablesize);
		case "MurMurhash32":
			return (int) Math.abs(HashFunctionLibrary.MurMurhash32(str) % tablesize);
		case "MurMurhash64":
			return (int) Math.abs(HashFunctionLibrary.MurMurhash64(str) % tablesize);
		case "asci":
			return new BigInteger(toAscii(str)).mod(new BigInteger(((Integer) tablesize).toString())).intValue();
		case "basic":
			return str.charAt(0);
		}
		return 0;
	}

	public int rehash(int hash){
		return (hash+1)%tablesize;
	}
	
	/* value to create the Hash code from he name entered, basically converting name to ASCII */
	public String toAscii(String s){
		StringBuilder sb = new StringBuilder();
		long asciiInt;
		// loop through all values in the string, including blanks
		for (int i = 0; i < s.length(); i++){
			//getting Ascii value of character and adding it to the string.
			char c = s.charAt(i);
			asciiInt = (int)c; 
			sb.append(asciiInt);
		}
		return String.valueOf(sb);
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
