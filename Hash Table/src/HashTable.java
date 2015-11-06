
public interface HashTable <K,V> {
	
	public void put(K key, V value);
	public V get(K key);
	public void delete(K key);
	public boolean contains(K key);
	public boolean isEmpty();
	public int size();
	Iterable<K> keys();
	public int getCollisions();

	

}
