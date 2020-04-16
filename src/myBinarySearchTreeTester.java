import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class myBinarySearchTreeTester {

    /*
        * Test description
        *
        *
    */
    @Test
    public void tree1(){
        int[] futureTree = {2,4,1,3,6,7};
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(futureTree);

        tree.print();

        assertEquals(3, tree.height());

    }
}
