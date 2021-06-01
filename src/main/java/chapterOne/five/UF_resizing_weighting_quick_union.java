package chapterone.five;

/**
 * 
 * @author gxx
 *
 */

/*
 *------------------------------------------------------
 *	public class UF_resizing_weighting_quick_union
 *-------------------------------------------------
 *		UF()							
 *		void union(int p, int q)		在 p 和 q 之间添加一条连接
 *		int find(int p)					p (0 到 N-1)所在分量的标识符
 *		boolean connected(int p, int q)	如果 p 和 q 存在于同一个分量则返回true
 *		int count()						连通分量的数量
 *		int newSite()					
 *----------------------------------------------------------------
 *	默认调用时，p，q均存在
 */
public class UF_resizing_weighting_quick_union {
	
	private int[] id;
	private int[] sz;
	private int count;
	private int size;

	public UF_resizing_weighting_quick_union() {
		size = 0;
		count = 0;
		id = null;
		sz = null;
	}
	
	public int newSite() {
		if (id == null) {
			id = new int[1];
			sz = new int[1];
		}
		
		if (size == id.length) {
			resizeArray(size * 2);
		}
		
		int newSiteId = size;
		id[newSiteId] = newSiteId;
		sz[newSiteId] = 1;
		
		size++;
		count++;
		
		return newSiteId;
	}
	
	private void resizeArray(int newSize) {
		int[] newId = new int[newSize];
		int[] newSz = new int[newSize];
		
		for (int i = 0; i < size; i++) {
			newId[i] = id[i];
			newSz[i] = sz[i];
		}
		id = newId;
		sz = newSz;
	}
	
	public int count() {
		return count;
	}
	
	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
