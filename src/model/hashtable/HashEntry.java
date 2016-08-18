package model.hashtable;

public class HashEntry {
	private String key;
	private Object value;
	
	public HashEntry(String key) {
		super();
		this.key = key;
	}
	public HashEntry(String key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "HashEntry [key=" + key + ", value=" + value + "]";
	}	
	
}
