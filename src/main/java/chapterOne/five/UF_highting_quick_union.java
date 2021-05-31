package chapterone.five;


public class UF_highting_quick_union {

	private int[] id;
	private int[] height;
	private int count;
	
	private int maxHeight = 0;
	
	public UF_highting_quick_union(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
		height = new int[N];
	}
	
	public int count() {
		return count;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	public int find(int p) {
		while (p != id[p]) {
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
		if (height[i] < height[j]) {
			id[i] = j;
		} else if (height[j] < height[i]) {
			id[j] = i;
		} else {
			id[j] = i;
			height[i]++;
			maxHeight = Math.max(height[i], maxHeight);
		}
		count--;
	}

	public int[] getId() {
		return id;
	}

	public void setId(int[] id) {
		this.id = id;
	}

	public int[] getHeight() {
		return height;
	}

	public void setHeight(int[] height) {
		this.height = height;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}
}
