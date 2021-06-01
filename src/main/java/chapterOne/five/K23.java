package chapterone.five;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class K23 {

	public static void main(String[] args) {
		int N = 2048;
		int T = 1;
		int size = 10;
		
		K23 k23 = new K23();
		List<List<Collection>> lists = k23.generator(N, size);
		
		for (int i = 0; i < size; i++) {
			List<Collection> list = lists.get(i);
			
			UF_quick_find uf_quick_find = new UF_quick_find(N);
			UF_quick_union uf_quick_union = new UF_quick_union(N);
			double t_f = 0d;
			double t_u = 0d;
			
			Stopwatch t1 = new Stopwatch();
			for (int j = 0; j < T; j++) {
				int left = uf_quick_find.count();
				int index = 0;
				while (left > 1) {
					int p = list.get(index).p;
					int q = list.get(index).q;
					index++;
					if (uf_quick_find.connected(p, q)) {
						continue;
					}
					uf_quick_find.union(p, q);
					left = uf_quick_find.count();
				}
			}
			t_f = t1.elapsedTime() / 5d;
			
			
			Stopwatch t2 = new Stopwatch();
			for (int j = 0; j < T; j++) {
				int left = uf_quick_union.count();
				int index = 0;
				while (left > 1) {
					int p = list.get(index).p;
					int q = list.get(index).q;
					index++;
					if (uf_quick_union.connected(p, q)) {
						continue;
					}
					uf_quick_union.union(p, q);
					left = uf_quick_union.count();
				}
			}
			t_u = t2.elapsedTime() / 5d;
			StdOut.println("N: " + "quick_find / quick_union: " + t_f / t_u);
			N += N;
		}
	}
	
	public class Collection {
		int p;
		int q;
		
		public Collection(int p, int q) {
			this.p = p;
			this.q = q;
		}
	}
	
	private List<List<Collection>> generator(int start, int size) {
		List<List<Collection>> lists = new ArrayList<List<Collection>>();
		
		for (int i = 0; i < size; i++) {
			List<Collection> list = new ArrayList<Collection>();
			UF_weighting_quick_union uf = new UF_weighting_quick_union(start);
			int left = uf.count();
			while (left > 1) {
				int p = StdRandom.uniform(start);
				int q = StdRandom.uniform(start);
				Collection collection = new Collection(p, q);
				list.add(collection);
				if (uf.connected(p, q)) {
					continue;
				}
				uf.union(p, q);
				left = uf.count();
			}
			lists.add(list);
			start += start;
		}
		return lists;
	}
}
