package com.hp.snap.tree;

import java.util.List;

import static com.hp.snap.AlgoUtils.getBst;
import static com.hp.snap.AlgoUtils.print2DArray;
import static com.hp.snap.tree.BinaryTreePrinter.printTree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.hp.snap.AlgoUtils;

public class VerticalTreeTraversal {

	public int[][] verticalOrderTraversal(TreeNode A) {
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		verticalOrder(A, 0, map);
		int[][] result = new int[map.size()][];
		int i = -1;
		for (Integer k : map.keySet()) {
			List<Integer> l = map.get(k);
			int[] row = new int[l.size()];
			for (int j = 0; j < l.size(); j++) {
				row[j] = l.get(j);
			}
			result[++i] = row;
		}
		return result;

	}

	private void verticalOrder(TreeNode<Integer> root, int hd, Map<Integer, List<Integer>> map) {
		if (root == null) {
			return;
		}
		List<Integer> ent = map.get(hd);
		if (ent == null) {
			ent = new ArrayList<Integer>();
		}
		ent.add(root.data);
		map.put(hd, ent);
		verticalOrder(root.left, hd + 1, map);
		verticalOrder(root.right, hd - 1, map);

	}

	public static void main(String[] args) {
		TreeNode root = getBst(5, 7, 1, 562, 12, 90);
		printTree(root);
		VerticalTreeTraversal vTT = new VerticalTreeTraversal();
		int[][] res = vTT.verticalOrderTraversal(root);
		print2DArray(res);
	}
}
