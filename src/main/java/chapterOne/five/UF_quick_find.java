package chapterone.five;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF_quick_find implements UF {

	private int[] id;
	private int count;
	
	private static int cnt;
	
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
//		for (int i : id) {
//			StdOut.print(i + " ");
//		}
//		StdOut.println("cnt: " + cnt);
		count--;
	}
	
	public static void main(String[] args) {
		int N = StdIn.readInt();
		UF_quick_find uf = new UF_quick_find(N);
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
	
	public static void initStdDraw() {
		StdDraw.setXscale(0, 3000);
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

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		UF_quick_find.cnt = cnt;
	}
	
	
}
