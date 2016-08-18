package model;

import java.util.Arrays;
import java.util.List;

public class Word implements Comparable<Word>{
	private String name;
	private int count;
	
	public Word(String name){
		this.name = name;
		count=1; //si creem vol dir que l'hem trobat un cop
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void addCount() {
		this.count++;
	}

	@Override
	public String toString() {
		return "Word [name=" + name + ", count=" + count + "]";
	}

	public List<String> toList() {
		return Arrays.asList(name, ""+count);
	}

	@Override
	public int compareTo(Word arg0) {
		if (this.count>arg0.count) return -1;
		else if (this.count<arg0.count) return 1;
		return 0;
	}
	
	
}
