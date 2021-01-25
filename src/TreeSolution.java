import com.ds.tree.BinaryTree;
import com.ds.tree.BinaryTreePrinter;
import com.ps.BinaryTreeProblem;
import com.ps.TreeToDList;

public class TreeSolution {


    public static void main(String[] args) {

          /*
                               1
                           /       \
                         2          3
                      /   \       /   \
                    4     5    6       7
                                   \
                                    8
        */
        BinaryTree<Integer> r1 = new BinaryTree<Integer>(1);
        BinaryTree<Integer> r2 = new BinaryTree<Integer>(2);
        BinaryTree<Integer> r3 = new BinaryTree<Integer>(3);
        BinaryTree<Integer> r4 = new BinaryTree<Integer>(4);
        BinaryTree<Integer> r5 = new BinaryTree<Integer>(5);
        BinaryTree<Integer> r6 = new BinaryTree<Integer>(6);
        BinaryTree<Integer> r7 = new BinaryTree<Integer>(7);
        BinaryTree<Integer> r8 = new BinaryTree<Integer>(8);
        r1.left(r2);
        r1.right(r3);
//        r2.left(r4);
//        r2.right(r5);
//        r3.left(r6);
//        r3.right(r7);
//        r6.right(r8);

        //System.out.println(r1.height());
        //r1.printLevelOrder();

        TreeToDList tdl = new TreeToDList();
        //r1 = tdl.convertToDList(r1);
        //System.out.println(r1);

        BinaryTreeProblem treeProblem = new BinaryTreeProblem();
        BinaryTreePrinter.printNode(r1);
        treeProblem.printAllAncestors(r1, 3);

        treeProblem.mirrorOf(r1);
        BinaryTreePrinter.printNode(r1);

    }


}
