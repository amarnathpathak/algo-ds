package com.snap;

import java.util.ArrayList;
import java.util.List;

public class MaxDistance {
	public int solve(ArrayList<Integer> A) {
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < A.size(); ++i) {
            arr.add(new int[2]);
        }
        int maxDistance = 0;
        for (int i = A.size() - 1; i > 0; --i) {
            int element = A.get(i);
            int[] parent = arr.get(element);
            int currentLength = arr.get(i)[0] + 1;
            
            parent[1] = Math.max(parent[1], currentLength + parent[0]);
            parent[0] = Math.max(parent[0], currentLength);
            maxDistance = Math.max(maxDistance, parent[1]);
        }
        return maxDistance == 0 ? 0 : maxDistance;
    }
	public static void main(String[] args) {
		MaxDistance md = new MaxDistance();
		ArrayList<Integer> A = new ArrayList<>();
		A.add(-1);
		A.add(0);
		A.add(0);
		A.add(0);
		A.add(3);
		System.out.println(md.solve(A));
	}

}
