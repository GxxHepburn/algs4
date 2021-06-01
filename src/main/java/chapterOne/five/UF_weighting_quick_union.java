package chapterone.five;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF_weighting_quick_union {
	
	private int[] id;
	private int[] sz;
	private int count;
	// K3
	private int cnt;

	public static void main(String[] args) {
		int N = StdIn.readInt();
		UF_weighting_quick_union uf = new UF_weighting_quick_union(N);
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
	
	public UF_weighting_quick_union(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			sz[i] = 1;
		}
	}
	
	public int count() {
		return count;
	}
	
	public boolean connected(int p, int q) {
		//	K3
		cnt = 0;
		return find(p) == find(q);
	}
	
	public int find(int p) {
		//	K3
		cnt++;
		while (p != id[p]) {
			//	K3
			cnt++;
			p = id[p];
		}
		return p;
	}
	
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j) {
			return;
		}
		//	K3
		cnt++;
		cnt++;
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
			//	K3
			cnt++;
			cnt++;
			cnt++;
		} else {
			id[j] = i;
			sz[i] += sz[j];
			//	K3
			cnt++;
			cnt++;
			cnt++;
		} 
		// K3
//		for (int t : id) {
//			StdOut.print(t + " ");
//		}
		// K4
//		StdOut.print(" | sz: ");
//		for (int t : sz) {
//			StdOut.print(t + " ");
//		}
//		StdOut.println("cnt: " + cnt);
		count--;
	}

	public int[] getId() {
		return id;
	}

	public void setId(int[] id) {
		this.id = id;
	}

	public int[] getSz() {
		return sz;
	}

	public void setSz(int[] sz) {
		this.sz = sz;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
