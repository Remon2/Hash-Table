import java.util.ArrayList;


public class LinearProbingHash<K,V> implements HashTable <K,V> {

	@SuppressWarnings({ "rawtypes"})
	private NodeHash [] usedArray;
	public int arraysize;
	private int step;
	private int counter;
	private int collisions;
	
	 public LinearProbingHash() {
		 counter=0;
			arraysize=10;
		usedArray=new NodeHash[arraysize];
		step=3;
		collisions=0;
	}
	 public int getCollisions(){
			return collisions;
		}
	 private int searchElement(K key) {
			int indexProb = Math.abs(key.hashCode()) % arraysize;
			if (usedArray[indexProb] != null && usedArray[indexProb].getKey().equals(key)) {
				return indexProb;
			} else {
				int index = (indexProb + step) % arraysize;
				while (index != indexProb) {
					if (usedArray[index] != null && usedArray[index].getKey().equals(key)) {
						return index;
					}
					index = (index + step) % arraysize;
				}
			}
			return -1;
		}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void put(K key, V value) {
		int index= Math.abs(key.hashCode()) %arraysize;
	if ((double) ((double) counter / (double) (arraysize)) >= 0.75) {
		rehashing(arraysize * 2);
	}
		if(usedArray[index]==null){
			usedArray[index]=new NodeHash(key,value);
			counter++;
			return;
		}
		
		else{
			collisions++;
			int found=searchElement(key);
			if(found==-1){
			int place=(index+step)%arraysize;
			while (usedArray[place] != null) {
				place= (place + step) % arraysize;
			}
			usedArray[place] = new NodeHash(key, value);
			counter++;
		}
		
		else{
			usedArray[found].setValue(value);
			return;
		}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void rehashing(int newSize) {
		NodeHash temp[] = new NodeHash[newSize];
		for (int i = 0; i < arraysize; i++) {
			if (usedArray[i] != null) {
				int getkey = Math.abs(usedArray[i].getKey().hashCode()) % newSize;
				if (temp[getkey] == null) {
					temp[getkey] = new NodeHash(usedArray[i].getKey(),
							usedArray[i].getValue());

				} else {
                 
					int index = (getkey + step) % newSize;
					while (temp[index] != null) {
						index = (index + step) % newSize;
					}
					temp[index] = new NodeHash(usedArray[i].getKey(),
							usedArray[i].getValue());

				}
			}
		}
		usedArray = temp;
		arraysize = newSize;
	}
	@SuppressWarnings("unchecked")
	@Override
	public V get(K key) {
		int index=searchElement(key);
		if(index!=-1){
			return (V) usedArray[index].getValue();
		}
		return null;
	}

	@Override
	public void delete(K key) {
		int index = searchElement(key);
		if (index != -1) {
			usedArray[index] = null;
			counter--;
		}	
	}

	@Override
	public boolean contains(K key) {
		int index=searchElement(key);
		if(index!=-1){
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		if(size()==0){
		return true;
		}
		return false;
	}

	@Override
	public int size() {
		return counter;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<K> keys() {
		ArrayList<K> iterator = new ArrayList<K>();
		for(int i=0;i<arraysize;i++){
			if(usedArray[i]!=null){
				iterator.add((K) usedArray[i].getKey());
			}
		}
		return iterator;
	}
}