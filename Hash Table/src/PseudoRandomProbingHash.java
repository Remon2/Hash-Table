import java.util.ArrayList;
import java.util.Collections;



public class PseudoRandomProbingHash<K,V> implements HashTable <K,V> {
	
	@SuppressWarnings("rawtypes")
	private NodeHash [] usedArray;
	private ArrayList <Integer> perm;
	public int arraysize;
	int counter;
	private int collisions;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PseudoRandomProbingHash(){
		usedArray=new NodeHash[10];
		arraysize=10;
		perm = new ArrayList();
		for(int i=0;i<arraysize;i++){
		perm.add(i);
		}
	     Collections.shuffle(perm);
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
			int count=0;
			while(count<arraysize){
				int currentplace=(index+perm.get(count))%arraysize;
				if(usedArray[currentplace] != null && usedArray[currentplace].getKey().equals(key)){
					return currentplace;
				}
				count++;
			}
		}
		return -1;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void put(K key, V value) {
		if ((double) ((double) counter / (double) (arraysize)) >= 0.75) {
			reHashing(arraysize * 2);
		}
		int index=Math.abs(key.hashCode())%arraysize;
		if(usedArray[index]==null){
			usedArray[index]=new NodeHash(key,value);
			counter++;
			return;
		} 
		else{
			collisions++;
			int found=searchElement(key);
			if(found==-1){
			int count =0;
			while(count<arraysize){
				int currentplace=(index+perm.get(count))%arraysize;
				if(usedArray[currentplace]==null){
					usedArray[currentplace]=new NodeHash(key,value);
					counter++;
					return;
				}
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
		ArrayList <Integer> perm_temp=new ArrayList();
		for(int i=0;i<newsize;i++){
			perm_temp.add(i);
			}
		     Collections.shuffle(perm_temp);
		     for(int i=0;i<arraysize;i++){
		    	 if(usedArray[i]!=null){
		     int index=(usedArray[i].getKey().hashCode()) %newsize;
				if(tempArray[index]==null){
					tempArray[index]=new NodeHash(usedArray[i].getKey(),usedArray[i].getValue());
				} 
				else{
					int count =0;
					while(count<newsize){
						int currentplace=(index+perm_temp.get(count))%newsize;
						if(tempArray[currentplace]==null){
							tempArray[currentplace]=new NodeHash(usedArray[i].getKey(),usedArray[i].getValue());
							break;
						}
						count++;
					}
				}
		    	 }
		     }
		     arraysize=newsize;
		     usedArray=tempArray;
		     perm=perm_temp;
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
		if(size()!=0){
			return false;
		}
		return true;
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