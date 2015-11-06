import java.util.ArrayList;



public class DoubleHashing<K,V> implements HashTable <K,V> {
	@SuppressWarnings("rawtypes")
	private NodeHash [] usedArray;
	public  int arraysize;
	int counter;
	private int collisions;
	public DoubleHashing(){
		usedArray=new NodeHash[16];
		arraysize=16;
		counter=0;
		collisions=0;
	}
	public int getCollisions(){
		return collisions;
	}
	private int searchElement(K key) {
		int index= Math.abs(key.hashCode()) % arraysize;
		if (usedArray[index] != null && usedArray[index].getKey().equals(key)) {
			return index;
		} else {
			int hash_function=1+(((key.hashCode()/arraysize)%(arraysize/2))*2);
			int count=0;
			while(count<arraysize){
				int properplace=(hash_function+index)%arraysize;
				if(usedArray[properplace]!=null&&usedArray[properplace].getKey().equals(key)){
					return properplace;
				}
				index=properplace;
				count++;
			}
		}
		return -1;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void put(K key, V value) {
		if ((double) ((double) counter / (double) (arraysize)) >= 0.75) {
			reHashing(2*arraysize);
		}
		int index=Math.abs(key.hashCode()) % arraysize;
		if(usedArray[index]==null){
			usedArray[index]=new NodeHash(key,value);
			counter++;
			return;
		} 
		else{
			collisions++;
			int found=searchElement(key);
			if(found==-1){
			int hash_function=1+(((key.hashCode()/arraysize)%(arraysize/2))*2);
			int count=0;
			while(count<arraysize){
				int properplace=(hash_function+index)%arraysize;
				if(usedArray[properplace]==null){
					usedArray[properplace]=new NodeHash(key,value);
					counter++;
					return;
				}
				index=properplace;
				count++;
			}
		}
		
		else{
			usedArray[found].setValue(value);
			return;
		}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void reHashing(int newsize) {
		
		NodeHash [] tempArray=new NodeHash[newsize];
		for(int i=0;i<arraysize;i++){
			if(usedArray[i]!=null){
			 int index=(usedArray[i].getKey().hashCode()) %newsize;
			 if(tempArray[index]==null){
					tempArray[index]=new NodeHash(usedArray[i].getKey(),usedArray[i].getValue());
				}
		else{
			int hash_function=1+(((usedArray[i].getKey().hashCode()/newsize)%(newsize/2))*2);
			int count=0;
			while(count<newsize){
				int properplace=(hash_function+index)%newsize;
				if(tempArray[properplace]==null){
					tempArray[properplace]=new NodeHash(usedArray[i].getKey(),usedArray[i].getValue());
					break;
				}
				index=properplace;
				count++;
			}
		}
		}
		}
		arraysize=newsize;
		usedArray=tempArray;
		
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