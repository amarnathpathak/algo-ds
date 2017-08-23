package com.hp.snap;

import static com.hp.snap.AlgoUtils.getBst;
import static com.hp.snap.AlgoUtils.inOrder;
import static com.hp.snap.AlgoUtils.titleToNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.snap.tree.BinaryTreePrinter;
import com.hp.snap.tree.TreeNode;

public class Practice {
    public static void main(String[] args) {

        /*
         * System.out.println(); System.out.println("--Largest Number --");
         * LargestNumber s = new LargestNumber(); int[] V = { 30, 3, 34, 9, 5 };
         * System.out.print("Array Value -> "); for (int b : V) {
         * System.out.print(b + ", "); } System.out.println();
         * System.out.print("Resulet -> "); System.out.println(s.getLargest(V));
         * 
         * System.out.println();
         * System.out.println("--Plus 1 in Given Value---");
         * 
         * PlusOneInArray ss = new PlusOneInArray();
         * 
         * int[] A = { 0, 4, 4, 6 }; System.out.print("Array Value -> "); for
         * (int b : A) { System.out.print(b + ", "); } System.out.println();
         * System.out.print("Result -> "); for (int b : ss.plusOne(A)) {
         * System.out.print(b + ", "); } System.out.println();
         * System.out.print("Array Value 2 : "); int[] B = { 0, 0, 4, 4, 6 };
         * for (int b : B) { System.out.print(b + ", "); } System.out.println();
         * System.out.println("Result -> "); for (int b : ss.plusOne(B)) {
         * System.out.print(b + ", "); } System.out.println();
         * System.out.println("<- Largest Distance SubArray ->");
         * LargestDistanceAdjecentValue ld = new LargestDistanceAdjecentValue();
         * int L1[] = {1,4,7,3,3,5}; for (int b : L1) { System.out.print(b +
         * ", "); } System.out.println(); System.out.println("Result -> " +
         * ld.getDistance(L1)); int L2[] = {0,3,3,7,5,3,11,1}; for (int b : L2)
         * { System.out.print(b + ", "); } System.out.println();
         * System.out.println("Result -> " + ld.getDistance(L2));
         * 
         * System.out.println("Minimum Sum Triangel"); MinimumPathTriangle
         * minSum = new MinimumPathTriangle(); ArrayList<ArrayList<Integer>> a =
         * new ArrayList<ArrayList<Integer>>(); ArrayList<Integer> b = new
         * ArrayList<>(); ArrayList<Integer> c = new ArrayList<>();
         * ArrayList<Integer> e = new ArrayList<>(); ArrayList<Integer> f = new
         * ArrayList<>(); a.add(b); a.add(c); a.add(e); a.add(f);
         * 
         * b.add(2); c.add(3); c.add(4); e.add(6); e.add(5);e.add(7);
         * f.add(4);f.add(1);f.add(8);f.add(3); System.out.println("Result -> "
         * + minSum.minimumTotal(a));
         */

        ArrayWave aw = new ArrayWave();
        System.out.println(aw.fizzBuzz(25));
        List<Integer> sample = new ArrayList<>();
        sample.add(5);
        sample.add(3);
        sample.add(2);
        sample.add(7);
        sample.add(6);
        sample.add(4);
        System.out.println(aw.wave(sample));
        int[] ar = new int[sample.size()];
        System.out.println(aw.wave(5, 3, 2, 7, 6, 4));
        Map<Integer, int[]> hash = new HashMap<>();
        int[] pair = { 9, 7 };
        hash.put(10, pair);
        String a = "BAQTZ";
        System.out.println("char " + a + " is: " + titleToNumber(a));
        TreeNode<Integer> root = getBst(5, 9, 10, 8, 7, 3, 4);
        System.out.println(inOrder(root));
        BinaryTreePrinter.printTree(root);
        System.out.println("Left View");
        TreeNode.printLeftView(root);
        System.out.println();
        System.out.println("Right View");
        TreeNode.printRightView(root);
        System.out.println();
        RobotMovement rm = new RobotMovement();
        String[] moves = { "G", "L", "L", "L" };
        for(String m : moves){
            System.out.print(m);
        }
        System.out.println();
        System.out.println("Above Move Is Circle : " + rm.isCircle(0, 0, moves));

    }

}
