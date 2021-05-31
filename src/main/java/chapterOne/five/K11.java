package chapterone.five;

/**
 * 每次union需要多访问N次id数组进行判断，
 * 同时还需要对两个分量的触点个数的sz赋新值,也会增加数组的访问，性能将会降低。
 * @author gxx
 *
 */
public class K11 {
	
	private int[] id;
	private int count;
	private int[] sz;
	
	public K11(int N) {
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
		return id[p];
	}
	
	public void union(int p, int q) {
		
		int pID = find(p);
		int qID = find(q);
		
		if (pID == qID) {
			return;
		}
		
		int totalSize = sz[p] + sz[q];
		int oldID;
		int newID;
		
		if (sz[p] < sz[q]) {
			oldID = pID;
			newID = qID;
		} else {
			oldID = qID;
			newID = pID;
		}
		
		for (int i = 0; i < id.length; i++) {
			if (id[i] == oldID) {
				id[i] = newID;
			}
			if (id[i] == newID) {
				sz[i] = totalSize;
			}
		}
		count--;
	}
}
