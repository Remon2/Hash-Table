import java.util.ArrayList;
import java.util.LinkedList;


public class SeparateChainingHashTable<K, V> implements HashTable<K, V> {
	public int arraysize;
	private int counter = 0;
	private int collisions;
	@SuppressWarnings("rawtypes")
	private LinkedList<NodeHash>[] separateChainingArray;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SeparateChainingHashTable() {
		arraysize = 10;
		separateChainingArray = new LinkedList[arraysize];
		for (int i = 0; i < arraysize; i++) {
			separateChainingArray[i] = new LinkedList<NodeHash>();
		}
		collisions=0;
	}
	public int getCollisions(){
		return collisions;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void put(K key, V value) {
		if ((double) ((double) size()/ (double) (arraysize)) >= 3) {
			reHashing(2*arraysize);
		}
		int index = Math.abs(key.hashCode()) % arraysize;
		for (int i = 0; i < separateChainingArray[index].size(); i++) {
			if (separateChainingArray[index].get(i).getKey().equals(key)) {	
				separateChainingArray[index].get(i).setValue(value);
				return;
			}
		}
		if(separateChainingArray[index].size()>0){
			collisions++;
		}
		separateChainingArray[index].add(new NodeHash(key, value));
		counter++;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void reHashing(int newsize) {
		 LinkedList<NodeHash>[] tempArray=new LinkedList[newsize];
		 for (int i = 0; i < newsize; i++) {
			 tempArray[i] = new LinkedList<NodeHash>();
			}
		for(int i=0;i<arraysize;i++){
			for(int j=0;j<separateChainingArray[i].size();j++){
				int index = (separateChainingArray[i].get(j).getKey().hashCode()) % newsize;
				tempArray[index].add(new NodeHash(separateChainingArray[i].get(j).getKey()
						, separateChainingArray[i].get(j).getValue()));
			}
		}
		arraysize=newsize;
		separateChainingArray=tempArray;

	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(K key) {
		int index = Math.abs(key.hashCode()) % arraysize;
		for (int i = 0; i < separateChainingArray[index].size(); i++) {
			if ((separateChainingArray[index].get(i).getKey()).equals(key)) {
				return (V) separateChainingArray[index].get(i).getValue();
			}
		}
		return null;
	}

	@Override
	public void delete(K key) {
		if(contains(key)){
		int index = Math.abs(key.hashCode()) % arraysize;
		for (int i = 0; i < separateChainingArray[index].size(); i++) {
			if ((separateChainingArray[index].get(i).getKey()).equals(key)) {
				separateChainingArray[index].remove(i);
				counter--;
				return;
			}
		}
		}
	}

	@Override
	public boolean contains(K key) {
		int index = Math.abs(key.hashCode())% arraysize;
		for (int i = 0; i < separateChainingArray[index].size(); i++) {
			if ((separateChainingArray[index].get(i).getKey()).equals(key)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		return counter;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<K> keys() {
		ArrayList<K> iterator = new ArrayList<K>();
		for (int i = 0; i < arraysize; i++) {
			for (int j = 0; j < separateChainingArray[i].size(); j++) {
				iterator.add((K) separateChainingArray[i].get(j).getKey());
			}
		}
		return iterator;
	}
}