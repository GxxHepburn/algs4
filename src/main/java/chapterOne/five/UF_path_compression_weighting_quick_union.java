package chapterone.five;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF_path_compression_weighting_quick_union implements UF {

	private int[] id;
	private int[] sz;
	private int count;
	
	private int cnt;

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
		cnt = 0;
		return find(p) == find(q);
	}
	
	public int find(int p) {
		int q = p;
		cnt++;
		while (p != id[p]) {
			cnt++;
			p = id[p];
		}
		int root = p;
		int temp;
		cnt++;
		while (q != id[q]) {
			cnt++;
			temp = id[q];
			cnt++;
			id[q] = root;
			q = temp;
		}
		return root;
	}
	
	public void union(int p, int q) {
		cnt = 0;
		int i = find(p);
		int j = find(q);
		if (i == j) {
			return;
		}
		cnt++;
		cnt++;
		if (sz[i] < sz[j]) {
			cnt++;
			id[i] = j;
			cnt++;
			cnt++;
			sz[j] += sz[i];
		} else {
			cnt++;
			id[j] = i;
			cnt++;
			cnt++;
			sz[i] += sz[j];
		} 
//		StdOut.println(getCnt());
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
