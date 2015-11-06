
public class NodeHash<K,V> {
     private K key;
     private V value;
	public NodeHash(){
		
	}
	public NodeHash(K k,V v){
		key=k;
		value=v;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	

}
