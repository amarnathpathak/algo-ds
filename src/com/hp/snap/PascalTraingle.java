package com.hp.snap;

public class PascalTraingle {
    public int[][] generate(int A) {
        int[][] res = new int[A][];
        int[] col = new int[1];
        col[0]=1;
        res[0]=col;
        int count = 2;
        for(int i=1; i<A;i++){
            col = new int[count++];
            for(int j=0;j<count-1;j++){
                col[j] =  j==0 || i==j? 1 : res[i-1][j-1] + res[i-1][j];
            }
            res[i] = col;
        }
        return res;
    }
    public static void main(String[] args) {
        PascalTraingle pT = new PascalTraingle();
        int n=5;
        int[][] res = pT.generate(n);
        //System.out.println("[");
        for(int i=0;i<n;i++){
           // System.out.print("[");
            for(int j=0; j<res[i].length ; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
            //System.out.println("]");
        }
        //System.out.println("]");
    }
}
