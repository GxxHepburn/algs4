package chapterone.five;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF_quick_union {

	public static void main(String[] args) {
		int N = StdIn.readInt();
		UF_quick_union uf = new UF_quick_union(N);
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
	
	private int[] id;
	private int count;
	// K2 
	private int cnt;
	
	public UF_quick_union(int N) {
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
		//	K2
		cnt = 0;
		return find(p) == find(q);
	}
	
	public int find(int p) {
		// K2 
		cnt++;
		while (p != id[p]) {
			// K2 
			cnt++;
			p = id[p];
		}
		return p;
	}
	
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) {
			return;
		}
		// K2 
		cnt++;
		id[pRoot] = qRoot;
		// K2 
		for (int i : id) {
			StdOut.print(i + " ");
		}
		StdOut.println("cnt: " + cnt);
		count--;
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
