package chapterone.five;

public class K15 {

	public static void main(String[] args) {
		/*
		 * Binomial trees
		 * 
		 * 问题一：
		 * Binomial coefficient:
		 * 1
		 * 1 1
		 * 1 2 1
		 * 1 3 3 1
		 * 1 4 6 4 1
		 * ...
		 * 
		 * Each new level of the binomial coefficient is created by putting the previous level underneath it, but one positon lower.
		 * For example:
		 * 		1	1
		 * 	+	
		 * 			1	1
		 * 	=	1	2	1
		 * 	
		 * 		1	2	1
		 *  +
		 *  		1	2	1
		 *  =	1	3	3	1
		 *  
		 *  With weighted quick union, a worst case tree happens when in every union() call the 2 sub-trees hava the same size, starting from 1 and 1, and (1 1) and (1 1).
		 *  If we take a closer look, we can see that by putting one of the two subtrees underneath the other, we are actually following the same pattern than how the binomial coefficient is formed.
		 *  
		 *  归纳法证明：
		 *  1、	height = 0时，成立，其level 0的节点个数为C(0,0)=1.
		 *  	height = 1时，成立，其level 0的节点个数为C(1,0)=1，其level 1的节点个数为C(1,1)=1.
		 *  
		 *  2、	假设height = n-1时，每个level的节点个数都是二次项系数。
		 *  
		 *  3、	则height = n时，其是由两个height=n-1且节点个数符合二次项系数的tree组合而成的。（错位）
		 *  	故其level 0的节点个数为1，符合C(n,0). 其level n的节点个数为1，符合C(n,n).
		 *  	对level k（1 <= k <= n-1），其节点个数nodenumber = C(n-1,k) + C(n-1,k-1) = C(n,k)。
		 *  	最后，原命题得证。
		 *  
		 *  问题二：
		 *  Average depth of a node in a worst-case tree with N = 2^n nodes:
		 *  In a worst case tree the number of nodes in each level of the tree correspond to a number in each level of the binomial coefficient.
		 *  For a tree with N = 2^n nodes, there are n + 1 levels.
		 *  For example: 16 = 2^4 = 1 + 4 + 6 + 4 + 1 => 4 + 1 = 5 levels.
		 *  The root has depth 0.
		 *  The second level from the root has depth 1 and so on.
		 *  => For example with N = 16, the total depth is: 1 * 0 + 4 * 1 + 6 * 2 + 4 * 3 + 1 * 4 = 32
		 *  => The average node depth is: Total depth / N = 32 / 16 = 2 = 4 / 2 = n / 2
		 *  
		 *  We can make an assumption that the average depth of a node in a worst case tree will be n / 2.
		 *  
		 *  Proof by induction:
		 *  For N = 2 = 2^1 (n = 1), the total depth is: 1 * 0 + 1 * 1 = 1 and the average depth is 1 / 2 => true.
		 *  Generalize: for 2 subtrees of size K = 2^k, assuming that the average depth of all the nodes in each subtree is k / 2, we prove that the average depth of the resulting tree (size K * 2) is (k + 1) / 2.
		 *  This happens because one of the subtrees will be placed underneath the other, and all the nodes in that subtree will have their depths increased by 1 => the total increase will be equal to K (the number of nodes in one subtree) = 2^k.
		 *  The total depth after the union will be:
		 *  k / 2 * 2^k + (k / 2 * 2^k + 2^k) = 2^k * (k + 1)
		 *  
		 *  The number of nodes in the new tree is K * 2 = 2^(k + 1).
		 *  The new average node depth is: 2^k * (k + 1) / (2^(k + 1)) = (k + 1) / 2 => true.
		 *  
		 */
	}
}
