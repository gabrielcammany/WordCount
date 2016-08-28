package model.hashtable;

import java.math.BigInteger;
import java.util.ArrayList;

import model.Word;

public class HashTable {
	
	public static String hashfunction;

	private int tablesize;
	private HashEntry[] table;
	public static BigInteger collision;
	
	//create hashtable
	@SuppressWarnings("static-access")
	public HashTable(int tablesize, String hashfunction){
		this.tablesize = tablesize;
		table = new HashEntry[tablesize];
		collision = BigInteger.valueOf(0);
		this.hashfunction = hashfunction;
	}
	
	public void insert (String key, String value, String hashfunction){
		//declaracions
		HashEntry aux;
		Boolean trobat = Boolean.FALSE;
		//
		int hash = hash(key);
		aux = table[hash];
		//busquem un forat on posarse o la mateixa paraula.
		while ( aux!= null && !trobat){
			if (aux.getKey().equals(key)) trobat=Boolean.TRUE;
			else{
				collision = collision.add(BigInteger.valueOf(1));
				hash = rehash(hash);
				aux = table[hash];
			}
		}
		//si la trobem, incrementem el comptador
		if (trobat)	((Word) aux.getValue()).addCount();//aux.setValue(new Word(value));
		//si es null la crea
		else 		table[hash] = new HashEntry(key, new Word (value));
	}

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
	
	public ArrayList<Word> getTable() {
		ArrayList<Word> llista = new ArrayList<>();
		for(int i =0 ; i<tablesize; i++){
			if(table[i]!=null){
				llista.add((Word)table[i].getValue());
			}
		}
		return llista;
	}

	public BigInteger getCollisions() {
		return collision;
	}
}
