package chapterone.five;


public class UF_path_compression_quick_union {

	private int[] id;
	private int count;
	
	public UF_path_compression_quick_union(int N) {
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
		return p;
	}
	
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) {
			return;
		}
		id[pRoot] = qRoot;
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
