import java.util.ArrayList;



public class BucketingHashTable<K,V> implements HashTable <K,V> {
	@SuppressWarnings("rawtypes")
	private NodeHash [] usedArray;
	@SuppressWarnings("rawtypes")
	private NodeHash [] overFlowArray;
	public int arraysize;
	private int elementInHash;
	private int bucketSize;
	private int overflowIndex; 
	private int collisions;
	
public BucketingHashTable(){
	usedArray=new NodeHash[10];
	arraysize=10;
	elementInHash=0;
	bucketSize=5;
	overFlowArray=new NodeHash[2*bucketSize];
	overflowIndex=0;
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
		int bucketNum=index/bucketSize;
		int indexNum=bucketNum*bucketSize;
		for(int i=0;i<bucketSize;i++){
			if(usedArray[indexNum]!=null&&usedArray[indexNum].getKey().equals(key)){
				return indexNum;
			}
			indexNum++;
		}
	}
	for(int i=0;i<overFlowArray.length;i++){
		if(overFlowArray[i]!=null&&overFlowArray[i].getKey().equals(key)){
		return i;
		}
	}	
	
	return -1;
}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void put(K key, V value) {
		int index= Math.abs(key.hashCode()) %arraysize;
		if ((double) ((double) size() / (double) (arraysize)) >= 0.75) {
			reHashing(arraysize * 2);
		}
		if(size()/arraysize>=0.75){
			reHashing(2*arraysize);
		}
		if(usedArray[index]==null){
			usedArray[index]=new NodeHash(key,value);
			elementInHash++;
			return;
		}
		else {
			collisions++;
			int found=searchElement(key);
			if(found==-1){
			int bucketNum=index/bucketSize;
			int indexNum=bucketNum*bucketSize;
			for(int i=0;i<bucketSize;i++){
				if(usedArray[indexNum]==null){
					usedArray[indexNum]=new NodeHash(key,value);
					elementInHash++;
					return;
				}
				indexNum++;
			}
			for(int i=0;i<overFlowArray.length;i++){
				if(overFlowArray[i]==null){
				overFlowArray[i]=new NodeHash(key,value);
				overflowIndex++;
				return;
				}
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
		elementInHash=0;
        overflowIndex=0;
		NodeHash [] tempArray=new NodeHash[newsize];
		for(int i=0;i<arraysize;i++){
			if(usedArray[i]!=null){
			int index=(usedArray[i].getKey().hashCode() %newsize);
			if(tempArray[index]==null){
				tempArray[index]=new NodeHash(usedArray[i].getKey(),usedArray[i].getValue());
				elementInHash++;
			}
			else {
				int bucketNum=index/bucketSize;
				int indexNum=bucketNum*bucketSize;
				for(int j=0;j<bucketSize;j++){
					if(tempArray[indexNum]==null){
						tempArray[indexNum]=new NodeHash(usedArray[i].getKey(),usedArray[i].getValue());
						elementInHash++;
						break;
					}
					indexNum++;
				}
			}
			}
		}
		for(int i=0;i<overFlowArray.length;i++){
			if(overFlowArray[i]!=null){
			int index=(overFlowArray[i].getKey().hashCode() %newsize);
			if(tempArray[index]==null){
				tempArray[index]=new NodeHash(overFlowArray[i].getKey(),overFlowArray[i].getValue());
				overFlowArray[i]=null;
				elementInHash++;
			}
			else {
				int bucketNum=index/bucketSize;
				int indexNum=bucketNum*bucketSize;
				for(int j=0;j<bucketSize;j++){
					if(tempArray[indexNum]==null){
						tempArray[indexNum]=new NodeHash(overFlowArray[i].getKey(),overFlowArray[i].getValue());
						overFlowArray[i]=null;
						elementInHash++;
						break;
					}
					indexNum++;
				}
			}
		}
		}
		for(int i=0;i<overFlowArray.length;i++){
			if(overFlowArray[i]!=null){
				overflowIndex++;
			}
		}	
		arraysize=newsize;
		usedArray=tempArray;
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public V get(K key) {
		int index=(key.hashCode() %arraysize);
		if(usedArray[index]!=null&&usedArray[index].getKey().equals(key)){
			return (V) usedArray[index].getValue();
		}
		else {
			int bucketNum=index/bucketSize;
			int indexNum=bucketNum*bucketSize;
			for(int i=0;i<bucketSize;i++){
				if(usedArray[indexNum]!=null&&usedArray[indexNum].getKey().equals(key)){
					return (V) usedArray[indexNum].getValue();
				}
				indexNum++;
			}
		}
				for(int i=0;i<overFlowArray.length;i++){
					if(overFlowArray[i]!=null&&overFlowArray[i].getKey().equals(key)){
					return (V) overFlowArray[i].getValue();
					}
				}
				return null;
	}

	@Override
	public void delete(K key) {
		int index=(key.hashCode() %arraysize);
		if(usedArray[index]!=null&&usedArray[index].getKey().equals(key)){
			usedArray[index]=null;
			elementInHash--;
			return ;
		}
		else {
			int bucketNum=index/bucketSize;
			int indexNum=bucketNum*bucketSize;
			for(int i=0;i<bucketSize;i++){
				if(usedArray[indexNum]!=null&&usedArray[indexNum].getKey().equals(key)){
					usedArray[indexNum]=null;
					elementInHash--;
					return ;
				}
				indexNum++;
			}
		}
				for(int i=0;i<overFlowArray.length;i++){
					if(overFlowArray[i]!=null&&overFlowArray[i].getKey().equals(key)){
						overFlowArray[i]=null;
						overflowIndex--;
					return ;
					}
				}
		
	}

	@Override
	public boolean contains(K key) {
		if(get(key)==null){
			return false;
		}
		return true;
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
		return elementInHash+overflowIndex ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<K> keys() {
		ArrayList<K> iterator = new ArrayList<K>();
		for(int i=0;i<usedArray.length;i++){
			if(usedArray[i]!=null){
				iterator.add((K) usedArray[i].getKey());
			}
		}
		for(int i=0;i<overFlowArray.length;i++){
			if(overFlowArray[i]!=null){
				iterator.add((K) overFlowArray[i].getKey());
			}
		}
		return iterator;
		
	}
}