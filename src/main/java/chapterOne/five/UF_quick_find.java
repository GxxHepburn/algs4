package chapterone.five;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF_quick_find {

	private int[] id;
	private int count;
	
	public UF_quick_find(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	public int count() {
		return count;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	public int find(int p) {
		return id[p];
	}
	
	public void union(int p, int q) {
		// K1 
		int cnt = 0;
		
		int pID = find(p);
		// K1 
		cnt++;
		
		int qID = find(q);
		// K1 
		cnt++;
		
		if (pID == qID) {
			return;
		}
		
		for (int i = 0; i < id.length; i++) {
			// K1 
			cnt++;
			if (id[i] == pID) {
				// K1 
				cnt++;
				id[i] = qID;
			}
		}
		// K1 
		for (int i : id) {
			StdOut.print(i + " ");
		}
		StdOut.println("cnt: " + cnt);
		count--;
	}
	
	public static void main(String[] args) {
		int N = StdIn.readInt();
		UF_quick_find uf = new UF_quick_find(N);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) {
				continue;
			}
			uf.union(p, q);
		}
		StdOut.println(uf.count);
	}

	public int[] getId() {
		return id;
	}

	public void setId(int[] id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}