package chapterone.five;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF_path_compression_weighting_quick_union {

	private int[] id;
	private int[] sz;
	private int count;

	public static void main(String[] args) {
		int N = StdIn.readInt();
		UF_path_compression_weighting_quick_union uf = new UF_path_compression_weighting_quick_union(N);
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
	
	public UF_path_compression_weighting_quick_union(int N) {
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
		return find(p) == find(q);
	}
	
	public int find(int p) {
		int q = p;
		while (p != id[p]) {
			p = id[p];
		}
		int root = p;
		int temp;
		while (q != id[q]) {
			temp = id[q];
			id[q] = root;
			q = temp;
		}
		return root;
	}
	
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j) {
			return;
		}
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		} 
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
}
