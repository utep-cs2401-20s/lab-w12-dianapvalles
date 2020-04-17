import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class myBinarySearchTreeTester {

    /*
         * The purpose of this test is to check the correct implementation of the method insert
         * This method checks if the insertion method worked (creating each node where it is supposed to, not creating duplicates)
         * If it fails, the method could be adding duplicated values or putting the values in the wrong position
         * The root is assigned with 2
         * TEST: PASSED
     */
    @Test
    public void tree1(){
        int[] futureTree = {2,1,5};
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(futureTree);
        tree.insert(5);

        int[] expectedTree = {2,1,5};
        myBinarySearchTreeNode exp = new myBinarySearchTreeNode(expectedTree);

        tree.print();

        assertEquals(exp.myValue,tree.myValue);
        assertEquals(exp.left.myValue, tree.left.myValue);
        assertEquals(exp.right.myValue,tree.right.myValue);
        assertNull(tree.left.left);
        assertNull(tree.left.right);
        assertNull(tree.right.right);
        assertNull(tree.right.left);
    }

    /*
        * The purpose of this test is to check the correct implementation of the method height
        * This method calculates the height of the entire subtree and returns the greatest one (height of the entire tree)
        * If the test fails it means that something went wrong while creating the binary tree or there must be an error due to counting in the height
        * The root is assigned with 2
        * TEST: PASSED
    */
    @Test
    public void tree2(){
        int[] futureTree = {2,4,1,3,6,7,5};
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(futureTree);

        tree.print();

        assertEquals(3, tree.height());
    }

    /*
         * The purpose of this test is to check the correct implementation of the method size
         * The array passed contains a duplicated value (it should not be part of the tree)
         * If the test
         * It is supposed to calculate the number of nodes in the binary search tree, if it fails something went wrong while creating the binary tree (such as creating the duplicated value)
         * or the size count went wrong
         * The root is assigned with 8
         * TEST: PASSED
     */
    @Test
    public void tree3(){
        int[] futureTree = {8,3,10,1,6,14,12,4,3};
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(futureTree);

        tree.print();

        assertEquals(8, tree.size());
    }

    /*
         * The purpose of this test is to check the correct implementation of the method depth
         * The array passed includes negative values and duplicated values
         * It should return the depth of the value passed (edges between the root and the node with the value)
         * If the test fails it means that something went wrong while creating the binary tree or there must be an error due to counting in the depth method
         * The root is assigned with 1
         * TEST: PASSED
     */
    @Test
    public void tree4(){
        int[] futureTree = {1,0,-3,5,2,3,-1,6};
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(futureTree);

        tree.print();

        assertEquals(3, tree.depth(3));
    }

    /*
         * The purpose of this test is to check the depth of a node value that is not in the binary tree
         * The array passed has positive integers
         * If it fails, then it might be the case that the "edges" might be counting and not subtracted after
         * The root is assigned with 1
         * TEST: PASSED
     */
    @Test
    public void tree5(){
        int[] futureTree = {5,4,2,6,8,0,7};
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(futureTree);

        tree.print();

        assertEquals(-1,tree.depth(3));

    }
}
