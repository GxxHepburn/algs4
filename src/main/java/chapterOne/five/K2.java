package chapterone.five;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class K2 {

	public static void main(String[] args) {
		int N = StdIn.readInt();
		UF_quick_union uf = new UF_quick_union(N);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) {
				continue;
			}
			uf.union(p, q);
		}
		StdOut.println(uf.getCount());
	}
	
	/*
	 * 森林
	 * 初始	0	1	2	3	4	5	6	7	8	9
	 * 
	 * 9 0	0	1	2	3	4	5	6	7	8
	 * 		|
	 * 		9
	 * 
	 * 3 4	0	1	2		4	5	6	7	8
	 * 		|				|
	 * 		9				3
	 * 
	 * 5 8	0 	1	2		4		6	7	8
	 * 		|				|				|
	 * 		9				3				5
	 * 
	 * 7 2	0	1	2		4		6		8
	 * 		|		|		|				|
	 * 		9		7		3				5
	 * 
	 * 2 1	0	1			4		6		8
	 * 		|	|			|				|
	 * 		9	2			3				5
	 * 			|
	 * 			7
	 * 
	 * 5 7	0	1---		4		6
	 * 		|	|	|		|		
	 * 		9	2	8		3
	 * 			|	|
	 * 			7	5
	 * 
	 * 0 3		1---		4---	6
	 * 			|	|		|	|
	 * 			2	8		3	0
	 * 			|	|			|
	 * 			7	5			9
	 * 
	 * 4 2	----1---				6
	 * 		|	|	|
	 * 		2	8	4---
	 * 		|	|	|	|
	 * 		7	5	3	0
	 * 					|
	 * 					9
	 */
}
