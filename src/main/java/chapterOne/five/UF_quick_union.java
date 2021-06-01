package chapterone.five;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF_quick_union {

	public static void main(String[] args) {
		int N = StdIn.readInt();
		UF_quick_union uf = new UF_quick_union(N);
		int totalcost = 0;
		int i = 0;
		initStdDraw();
		while (!StdIn.isEmpty()) {
			cnt = 0;
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) {
				totalcost += cnt;
				i++;
				plot(i, cnt, totalcost);
				continue;
			}
			uf.union(p, q);
			totalcost += cnt;
			i++;
			plot(i, cnt, totalcost);
		}
		StdOut.println(uf.count);
	}
	
	private int[] id;
	private int count;
	// K2 
	private static int cnt;
	
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
	
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		UF_quick_union.cnt = cnt;
	}

	public static void initStdDraw() {
		StdDraw.setXscale(0, 900);
		StdDraw.setYscale(0, 1300);
		StdDraw.setPenRadius(0.002);
		StdDraw.textLeft(1, 625, "625");
	}
	
	public static void plot(int i, int cost, int totalcost) {
		double avg = (totalcost * 1.0) / i;
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.point(i, cost);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.point(i, avg);
	}
}
