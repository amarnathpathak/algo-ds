package com.hp.snap;

import java.util.Arrays;

public class SprialArray {
	public int[] spiralOrder(final int[][] A) {
		int[] res = new int[A.length * A[0].length];
		int startI = 0;
		int startJ = 0;
		int endI = A.length;
		int endJ = A[0].length;
		int count = 0;
		int i = -1;
		int j = -1;
		while (startI <= endI && startJ <= endJ) {
			i++;
			j++;
			while (j < endJ) {
				res[count++] = A[i][j++];
			}
			j--;
			i++;
			while (i < endI) {
				res[count++] = A[i++][j];
			}
			i--;
			j--;
			while (j >=startJ) {
				res[count++] = A[i][j--];
			}
			i--;
			j++;
			while (i > startI) {
				res[count++] = A[i--][j];
			}
			startI++;
			startJ++;
			endI--;
			endJ--;

		}
		return res;
	}

	public int[][] getSpiralArray(int n) {
		int[][] arr = new int[n][n];
		int count = 1;
		int i = -1;
		int j = -1;
		int endJ = n;
		int endI = n;
		int startI = 0;
		int startJ = 0;
		while (count <= Math.pow(n, 2)) {
			i++;
			j++;
			while (j < endJ) {
				arr[i][j++] = count++;
			}
			j--;
			i++;
			while (i < endI) {
				arr[i++][j] = count++;
			}
			i--;
			j--;
			while (j >= startJ) {
				arr[i][j--] = count++;
			}
			j++;
			i--;
			while (i > startI) {
				arr[i--][j] = count++;
			}

			endI--;
			startI++;
			startJ++;
			endJ--;

		}
		return arr;
	}

	public static void main(String[] args) {
		SprialArray sA = new SprialArray();
		//int[][] res = sA.getSpiralArray(4);
		int[][] A = { { 1,  2,  3,  4 },
					  { 12, 13, 14, 5 }, 
					  { 11, 16, 15, 6 }, 
					  { 10, 9, 8, 7 } };
		int[][] B = { { 1,  2,  3,  4 },
				  		{ 10, 11, 12, 5 }, 
				  		{ 9, 8, 7, 6 } 
				  	};
		int[] d = sA.spiralOrder(A);
		for(int i=0;i<d.length ; i++){
			System.out.println(" " + d[i]);
		}
		int[] c = sA.spiralOrder(B);
		for(int i=0;i<c.length ; i++){
			System.out.println(" " + c[i]);
		}
	}

}
