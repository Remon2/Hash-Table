

public class Test6 {
	
	
	public static void main(String[] args) {
		double startTime,endTime,elapsedTime,startTotal,endTotal,elapsedTotal;
		startTotal=System.currentTimeMillis();
		SeparateChainingHashTable<Integer, String> h = new SeparateChainingHashTable<>();
		System.out.println("Initial Size = "+h.arraysize);
		System.out.println("When Adding 100 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 100; i++) {
			h.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		
		System.out.println("Collision Number = "+h.getCollisions());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("Table Size = "+h.arraysize);
		System.out.println("Elements Number = "+h.size());
		System.out.println("_______________________________________________");
		h = new SeparateChainingHashTable<>();
		System.out.println("When Adding 1000 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 1000; i++) {
			h.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		System.out.println("Table Size = "+h.arraysize);
		System.out.println("Collision Number = "+h.getCollisions());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("Elements Number = "+h.size());
		System.out.println("_______________________________________________");
		h = new SeparateChainingHashTable<>();
		System.out.println("When Adding 10000 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 10000; i++) {
			h.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		System.out.println("Table Size = "+h.arraysize);
		//System.out.println("Load Factor = "+h.loadFactor);
		System.out.println("Collision Number = "+h.getCollisions());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("Elements Number = "+h.size());
		System.out.println("_______________________________________________");
		h = new SeparateChainingHashTable<>();
		System.out.println("When Adding 100000 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 100000; i++) {
			h.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		System.out.println("Table Size = "+h.arraysize);
		//System.out.println("Load Factor = "+h.loadFactor);
		System.out.println("Collision Number = "+h.getCollisions());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("Elements Number = "+h.size());
		System.out.println("************************************************");
		System.out.println("*******QuadraticProbingHash**************");
		QuadraticProbingHash<Integer, String> h1 = new QuadraticProbingHash<>();
		System.out.println("Initial Size = "+h1.arraysize);
		System.out.println("When Adding 100 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 100; i++) {
			h1.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		
		System.out.println("Collision Number = "+h1.getCollisions());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("Table Size = "+h1.arraysize);
		System.out.println("Elements Number = "+h1.size());
		System.out.println("_______________________________________________");
		h1 = new QuadraticProbingHash<>();
		System.out.println("When Adding 1000 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 1000; i++) {
			h1.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		System.out.println("Table Size = "+h1.arraysize);
		System.out.println("Collision Number = "+h1.getCollisions());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("Elements Number = "+h1.size());
		System.out.println("_______________________________________________");
		h1 = new QuadraticProbingHash<>();
		System.out.println("When Adding 10000 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 10000; i++) {
			h1.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		System.out.println("Table Size = "+h1.arraysize);
		//System.out.println("Load Factor = "+h.loadFactor);
		System.out.println("Collision Number = "+h1.getCollisions());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("Elements Number = "+h1.size());
		System.out.println("Memory Used = "+h1.size()/h1.arraysize);
		System.out.println("_______________________________________________");
		h1 = new QuadraticProbingHash<>();
		System.out.println("When Adding 100000 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 100000; i++) {
			h1.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		System.out.println("Table Size = "+h1.arraysize);
		System.out.println("Collision Number = "+h1.getCollisions());
		System.out.println("Elements Number = "+h1.size());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("*******PseudoRandomProbing**************");
		PseudoRandomProbingHash<Integer, String> h2 = new PseudoRandomProbingHash<>();
		System.out.println("Initial Size = "+h2.arraysize);
		System.out.println("When Adding 100 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 100; i++) {
			h2.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		
		System.out.println("Collision Number = "+h2.getCollisions());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("Table Size = "+h2.arraysize);
		System.out.println("Elements Number = "+h2.size());
		System.out.println("_______________________________________________");
		h2 = new PseudoRandomProbingHash<>();
		System.out.println("When Adding 1000 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 1000; i++) {
			h2.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		System.out.println("Table Size = "+h2.arraysize);
		System.out.println("Collision Number = "+h2.getCollisions());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("Elements Number = "+h2.size());
		System.out.println("_______________________________________________");
		h2 = new PseudoRandomProbingHash<>();
		System.out.println("When Adding 10000 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 10000; i++) {
			h2.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		System.out.println("Table Size = "+h2.arraysize);
		//System.out.println("Load Factor = "+h.loadFactor);
		System.out.println("Collision Number = "+h2.getCollisions());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("Elements Number = "+h2.size());
		System.out.println("_______________________________________________");
		h2 = new PseudoRandomProbingHash<>();
		System.out.println("When Adding 100000 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 100000; i++) {
			h2.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		System.out.println("Table Size = "+h2.arraysize);
		System.out.println("Collision Number = "+h2.getCollisions());
		System.out.println("Elements Number = "+h2.size());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("*******LinearProbing**************");
		LinearProbingHash<Integer, String> h3 = new LinearProbingHash<>();
		System.out.println("Initial Size = "+h3.arraysize);
		System.out.println("When Adding 100 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 100; i++) {
			h3.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		
		System.out.println("Collision Number = "+h3.getCollisions());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("Table Size = "+h3.arraysize);
		System.out.println("Elements Number = "+h3.size());
		System.out.println("_______________________________________________");
		h3 = new LinearProbingHash<>();
		System.out.println("When Adding 1000 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 1000; i++) {
			h3.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		System.out.println("Table Size = "+h3.arraysize);
		System.out.println("Collision Number = "+h3.getCollisions());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("Elements Number = "+h3.size());
		System.out.println("_______________________________________________");
		h3 = new LinearProbingHash<>();
		System.out.println("When Adding 10000 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 10000; i++) {
			h3.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		System.out.println("Table Size = "+h3.arraysize);
		//System.out.println("Load Factor = "+h.loadFactor);
		System.out.println("Collision Number = "+h3.getCollisions());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("Elements Number = "+h3.size());
		System.out.println("_______________________________________________");
		h3 = new LinearProbingHash<>();
		System.out.println("When Adding 100000 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 100000; i++) {
			h3.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		System.out.println("Table Size = "+h3.arraysize);
		System.out.println("Collision Number = "+h3.getCollisions());
		System.out.println("Elements Number = "+h3.size());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("*******DoubleHashing**************");
		DoubleHashing<Integer, String> h4 = new DoubleHashing<>();
		System.out.println("Initial Size = "+h4.arraysize);
		System.out.println("When Adding 100 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 100; i++) {
			h4.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		
		System.out.println("Collision Number = "+h4.getCollisions());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("Table Size = "+h4.arraysize);
		System.out.println("Elements Number = "+h4.size());
		System.out.println("_______________________________________________");
		h4 = new DoubleHashing<>();
		System.out.println("When Adding 1000 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 1000; i++) {
			h4.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		System.out.println("Table Size = "+h4.arraysize);
		System.out.println("Collision Number = "+h4.getCollisions());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("Elements Number = "+h4.size());
		System.out.println("_______________________________________________");
		h4 = new DoubleHashing<>();
		System.out.println("When Adding 10000 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 10000; i++) {
			h4.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		System.out.println("Table Size = "+h4.arraysize);
		System.out.println("Collision Number = "+h4.getCollisions());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("Elements Number = "+h4.size());
		System.out.println("_______________________________________________");
		h4 = new DoubleHashing<>();
		System.out.println("When Adding 100000 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 100000; i++) {
			h4.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		System.out.println("Table Size = "+h4.arraysize);
		System.out.println("Collision Number = "+h4.getCollisions());
		System.out.println("Elements Number = "+h4.size());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		
		System.out.println("*******BucketingHash**************");
		BucketingHashTable<Integer, String> h5 = new BucketingHashTable<>();
		System.out.println("Initial Size = "+h5.arraysize);
		System.out.println("When Adding 100 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 100; i++) {
			h5.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		
		System.out.println("Collision Number = "+h5.getCollisions());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("Table Size = "+h5.arraysize);
		System.out.println("Elements Number = "+h5.size());
		System.out.println("_______________________________________________");
		h5 = new BucketingHashTable<>();
		System.out.println("When Adding 1000 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 1000; i++) {
			h5.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		System.out.println("Table Size = "+h5.arraysize);
		System.out.println("Collision Number = "+h5.getCollisions());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("Elements Number = "+h5.size());
		System.out.println("_______________________________________________");
		h5 = new BucketingHashTable<>();
		System.out.println("When Adding 10000 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 10000; i++) {
			h5.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		System.out.println("Table Size = "+h5.arraysize);
		System.out.println("Collision Number = "+h5.getCollisions());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		System.out.println("Elements Number = "+h5.size());
		System.out.println("_______________________________________________");
		h5 = new BucketingHashTable<>();
		System.out.println("When Adding 100000 Elements in the Table :");
		startTime=System.currentTimeMillis();
		for (int i = 1; i <= 100000; i++) {
			h5.put(i, "");
		}
		endTime=System.currentTimeMillis();
		elapsedTime=endTime-startTime;
		System.out.println("Table Size = "+h5.arraysize);
		System.out.println("Collision Number = "+h5.getCollisions());
		System.out.println("Elements Number = "+h5.size());
		System.out.println("Time Taken = "+elapsedTime+" ms");
		
		
		endTotal=System.currentTimeMillis();
		elapsedTotal=endTotal-startTotal;
		System.out.println("_______________________________________________");
		System.out.println("Total time taken to run this test = "+elapsedTotal+" ms");
	}

}





