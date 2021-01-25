package com.snap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RotateMatrix {
	public void rotate(ArrayList<ArrayList<Integer>> a) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(a.size());
		for (int i = 0; i < a.size(); i++) {
			int count = a.size() - 1;
			ArrayList<Integer> resRow = new ArrayList<Integer>(a.size());
			for (int j = 0; j < a.size(); j++) {
				resRow.add(a.get(j).get(i));
			}
			Collections.reverse(resRow);
			res.add(resRow);
		}
		a.clear();
		a.addAll(res);

	}

	public static void main(String[] args) {
		/*
		 * ArrayList<ArrayList<Integer>> res = new ArrayList<>(2); int count =1;
		 * for(int i=0;i<2;i++){ ArrayList<Integer> l = new ArrayList<>(2);
		 * for(int j =0;j<2;j++){ l.add(count++); } res.add(l); } RotateMatrix
		 * ro = new RotateMatrix(); System.out.println(res); ro.rotate(res);
		 * System.out.println(res);
		 */

		/*
		 * Read input from stdin and provide input before running Use either of
		 * these methods for input
		 * 
		 * //BufferedReader BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String line = br.readLine(); int N =
		 * Integer.parseInt(line);
		 */

		// Scanner
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = s.nextInt();
		}

		for (int i = 0; i < N; i++) {
			int num = arr[i];
			int count = 1;
			while (count <= num) {
				if (count % 15 == 0)
					System.out.println("FizzBuzz");
				else if (count % 3 == 0)
					System.out.println("Fizz");
				else if (count % 5 == 0)
					System.out.println("Buzz");
				else
					System.out.println(count);
				count++;
			}

		}
	}

}
