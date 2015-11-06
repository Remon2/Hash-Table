
public class Test4 {
	
	public static boolean testChaining() {
		boolean ok = true;
		SeparateChainingHashTable<Integer, String> ht1 = new SeparateChainingHashTable<>();
		System.out.println("When insert 10000 elements  ");
		for (int i=0;i<10000;i++) {
			String s = String.valueOf(i*100);
			ht1.put(i*10, s);
		}
		System.out.println(ht1.getCollisions() + " collisions occurred in test 1.");
		System.out.println("The size of the hashtable is " + ht1.size());
		System.out.println("The memory used"+ht1.arraysize);
		for (int i=0;i<1000;i++) {
			String s = String.valueOf(i*100);
			if (!ht1.get(i*10).equals(s)) {
				ok = false;
			}
		}
		System.out.println("When insert 100000 elements  ");
		SeparateChainingHashTable<Integer, String> ht2 = new SeparateChainingHashTable<>();
		for (int i=0;i<100000;i++) {
			String s = String.valueOf('A' + i);
			ht2.put(i, s);
		}
		System.out.println(ht2.getCollisions() + " collisions occurred in test 2.");
		System.out.println("The size of the hashtable is " + ht2.size());
		System.out.println("The memory Used is  "+ht2.arraysize);
		for (int i=0;i<26;i++) {
			String s = String.valueOf('A' + i);
			if (!ht2.get(i).equals(s)) {
				ok = false;
			}
		}
		return ok;
	}
	
	public static boolean testBucketing() {
		boolean ok = true;
		BucketingHashTable<Integer, String> ht1 = new BucketingHashTable<>();
		System.out.println("When insert 10000 elements  ");
		for (int i=0;i<10000;i++) {
			String s = String.valueOf(i*100);
			ht1.put(i*10, s);
		}
		System.out.println(ht1.getCollisions() + " collisions occurred in test 1.");
		System.out.println("The size of the hashtable is " + ht1.size());
		System.out.println("The memory Used is  "+ht1.arraysize);
		for (int i=0;i<10;i++) {
			String s = String.valueOf(i*100);
			if (!ht1.get(i*10).equals(s)) {
				ok = false;
			}
		}
		System.out.println("When insert 100000 elements  ");
		BucketingHashTable<Integer, String> ht2 = new BucketingHashTable<>();
 		for (int i=0;i<100000;i++) {
			String s = String.valueOf('A' + i);
			ht2.put(i, s);
		}
		ht2.delete(10);
		System.out.println(ht2.getCollisions() + " collisions occurred in test 2.");
		System.out.println("The size of the hashtable is " + ht2.size());
		System.out.println("The memory Used is  "+ht2.arraysize);
		for (int i=0;i<26;i++) {
			String s = String.valueOf('A' + i);
			if (!ht2.contains(i) && i != 10)
				ok = false;
			if (i != 10) {
				if (!ht2.get(i).equals(s)) {
					ok = false;
				}
			}
		}
		return ok;
	}
	
	public static boolean testLinear() {
		boolean ok = true;
		System.out.println("When insert 10000 elements  ");
		LinearProbingHash<Integer, String> ht1 = new LinearProbingHash<>();
		for (int i=0;i<10000;i++) {
			String s = String.valueOf(i*100);
			ht1.put(i*10, s);
		}
		System.out.println(ht1.getCollisions() + " collisions occurred in test 1.");
		System.out.println("The size of the hashtable is " + ht1.size());
		System.out.println("The memory Used is  "+ht1.arraysize);
		for (int i=0;i<10;i++) {
			String s = String.valueOf(i*100);
			if (!ht1.get(i*10).equals(s)) {
				ok = false;
			}
		}
		System.out.println("When insert 100000 elements  ");
		LinearProbingHash<Integer, String> ht2 = new LinearProbingHash<>();
 		for (int i=0;i<100000;i++) {
			String s = String.valueOf('A' + i);
			ht2.put(i, s);
		}
		ht2.delete(10);
		System.out.println(ht2.getCollisions() + " collisions occurred in test 2.");
		System.out.println("The size of the hashtable is " + ht2.size());
		System.out.println("The memory Used is  "+ht2.arraysize);
		for (int i=0;i<26;i++) {
			String s = String.valueOf('A' + i);
			if (!ht2.contains(i) && i != 10)
				ok = false;
			if (i != 10) {
				if (!ht2.get(i).equals(s)) {
					ok = false;
				}
			}
		}
		return ok;
	}
	
	public static boolean testQuadratic() {
		boolean ok = true;
		QuadraticProbingHash<Integer, String> ht1 = new QuadraticProbingHash<>();
		System.out.println("When insert 10000 elements  ");
		for (int i=0;i<10000;i++) {
			String s = String.valueOf(i*100);
			ht1.put(i*10, s);
		}
		System.out.println(ht1.getCollisions() + " collisions occurred in test 1.");
		System.out.println("The size of the hashtable is " + ht1.size());
		System.out.println("The memory Used is  "+ht1.arraysize);
		for (int i=0;i<10;i++) {
			String s = String.valueOf(i*100);
			if (!ht1.get(i*10).equals(s)) {
				ok = false;
			}
		}
		System.out.println("When insert 100000 elements  ");
		QuadraticProbingHash<Integer, String> ht2 = new QuadraticProbingHash<>();
 		for (int i=0;i<100000;i++) {
			String s = String.valueOf('A' + i);
			ht2.put(i, s);
		}
		ht2.delete(10);
		System.out.println(ht2.getCollisions() + " collisions occurred in test 2.");
		System.out.println("The size of the hashtable is " + ht2.size());
		System.out.println("The memory Used is  "+ht2.arraysize);
		for (int i=0;i<26;i++) {
			String s = String.valueOf('A' + i);
			if (!ht2.contains(i) && i != 10)
				ok = false;
			if (i != 10) {
				if (!ht2.get(i).equals(s)) {
					ok = false;
				}
			}
		}
		return ok;
	}

	public static boolean testRandom() {
		boolean ok = true;
		System.out.println("When insert 10000 elements  ");
		PseudoRandomProbingHash<Integer, String> ht1 = new PseudoRandomProbingHash<>();
		for (int i=0;i<10000;i++) {
			String s = String.valueOf(i*100);
			ht1.put(i*10, s);
		}
		System.out.println(ht1.getCollisions() + " collisions occurred in test 1.");
		System.out.println("The size of the hashtable is " + ht1.size());
		System.out.println("The memory Used is  "+ht1.arraysize);
		for (int i=0;i<10;i++) {
			String s = String.valueOf(i*100);
			if (!ht1.get(i*10).equals(s)) {
				ok = false;
			}
		}
		System.out.println("When insert 100000 elements  ");
		PseudoRandomProbingHash<Integer, String> ht2 = new PseudoRandomProbingHash<>();
 		for (int i=0;i<100000;i++) {
			String s = String.valueOf('A' + i);
			ht2.put(i, s);
		}
		ht2.delete(10);
		System.out.println(ht2.getCollisions() + " collisions occurred in test 2.");
		System.out.println("The size of the hashtable is " + ht2.size());
		System.out.println("The memory Used is  "+ht2.arraysize);
		for (int i=0;i<26;i++) {
			String s = String.valueOf('A' + i);
			if (!ht2.contains(i) && i != 10)
				ok = false;
			if (i != 10) {
				if (!ht2.get(i).equals(s)) {
					ok = false;
				}
			}
		}
		return ok;
	}
	
	public static boolean testDouble() {
		boolean ok = true;
		DoubleHashing<Integer, String> ht1 = new DoubleHashing<>();
		System.out.println("When insert 10000 elements  ");
		for (int i=0;i<10000;i++) {
			String s = String.valueOf(i*100);
			ht1.put(i*10, s);
		}
		System.out.println(ht1.getCollisions() + " collisions occurred in test 1.");
		System.out.println("The size of the hashtable is " + ht1.size());
		System.out.println("The memory Used is  "+ht1.arraysize);
		for (int i=0;i<10;i++) {
			String s = String.valueOf(i*100);
			if (!ht1.get(i*10).equals(s)) {
				ok = false;
			}
		}
		System.out.println("When insert 100000 elements  ");
		DoubleHashing<Integer, String> ht2 = new DoubleHashing<>();
 		for (int i=0;i<100000;i++) {
			String s = String.valueOf('A' + i);
			ht2.put(i, s);
		}
		ht2.delete(10);
		System.out.println(ht2.getCollisions() + " collisions occurred in test 2.");
		System.out.println("The size of the hashtable is " + ht2.size());
		System.out.println("The memory Used is  "+ht2.arraysize);
		for (int i=0;i<26;i++) {
			String s = String.valueOf('A' + i);
			if (!ht2.contains(i) && i != 10)
				ok = false;
			if (i != 10) {
				if (!ht2.get(i).equals(s)) {
					ok = false;
				}
			}
		}
		return ok;
	}
	
	public static void main(String[] args) {
		double startTotal,endTotal,elapsedTotal;
		startTotal=System.currentTimeMillis();
		
		System.out.println("________Testing Separate chaining________");
		if (testChaining())
			System.out.println("*****************************************");
		else
			System.err.println("Test failed!");
		System.out.println();
		System.out.println("_________Testing bucketing____________");
		if (testBucketing())
			System.out.println("*****************************************");
		else
			System.err.println("Test failed!");
		System.out.println();
		System.out.println("______Testing linear probing________");
		if (testLinear())
			System.out.println("*****************************************");
		else
			System.err.println("Test failed!");
		System.out.println();
		System.out.println("______Testing quadratic probing________");
		if (testQuadratic())
			System.out.println("*****************************************");
		else
			System.err.println("Test failed!");
		System.out.println();
		System.out.println("_______Testing psuedo-random probing_______");
		if (testRandom())
			System.out.println("*****************************************");
		else
			System.err.println("Test failed!");
		System.out.println();
		System.out.println("_________Testing double hashing_________");
		if (testDouble())
			System.out.println("*****************************************");
		else
			System.err.println("Test failed!");
		
		
		endTotal=System.currentTimeMillis();
		elapsedTotal=endTotal-startTotal;
		System.out.println("_______________________________________________");
		System.out.println("Total time taken to run this test = "+elapsedTotal+" ms");
	}

}
