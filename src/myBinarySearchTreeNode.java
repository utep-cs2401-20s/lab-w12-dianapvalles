class myBinarySearchTreeNode{
  int myValue;
  myBinarySearchTreeNode left;
  myBinarySearchTreeNode right;
    
  myBinarySearchTreeNode(int inValue){
    // created a new node with empty child pointers
    myValue = inValue;
    left = null;
    right = null;
  }
  
  myBinarySearchTreeNode(int[] A){
    // creates a new Binary Search Tree rooted at the first value in the array
    /// by inserting elements into the tree in the order they are given in A.
    myValue = A[0];

    for(int i = 1; i < A.length; i++){
      this.insert(A[i]);
    }
  }
  
  public void insert(int inValue){
    // This method takes a new integer as input and decides 
    // if it should be place: 
    //    * as the left child,
    //    * as the right child, 
    //    * in the left subtree,
    //    * or in the right subtree.
    // If the value already exists in the tree, no action is taken.

    //compares the values to find the correct position
    if(inValue > this.myValue){
      if(right == null){
        right = new myBinarySearchTreeNode(inValue); //inserts the node -- correct position
      }
      else{
        right.insert(inValue); //recursive call
      }
    }
    else if(inValue < this.myValue){
      if(left == null){
        left = new myBinarySearchTreeNode(inValue); //inserts the node -- correct position
      }
      else{
        left.insert(inValue); //recursive call
      }
    }
    if(inValue == this.myValue){
      // do not insert duplicates
      System.out.println("Couldn't create node, duplicated value"); //Error message
    }
  }
  
  public int height(){
     // This method recursively calculates the height of the entire (sub)tree.
     // This method will take O(n) time

    int leftH = 0; // value that will hold the left subtree's number of edges
    int rightH = 0; // value that will hold the right subtree's number of edges

    if(left != null){
      leftH = left.height() + 1; //adds one to the height of the left side
    }
    if(right != null){
      rightH = right.height() + 1; //adds one to the height of the right side
    }

    return (leftH > rightH) ? (leftH) : (rightH); //compares which of the subtrees has a greater height
  }
  
  public int depth(int search){
     // This method recursively calculates the depth of a given search value. 
     // If the given value is not in the tree, this method returns -1. 
     // Note that if the tree is a proper BST, this method should complete in O(log n) time.
     // Additionally, remember that the depth is the number of nodes on the path from a node to the root 
     // (i.e. the number of the recursive calls).

    if (search < myValue) { //looks for the possible position of the node by comparing it to the root first
      if (left != null) {
        int leftS = left.depth(search);

        if(leftS == -1) // checks if the returned value was -1 so that it keeps returning -1
          return -1;

        return 1 + left.depth(search); // if the returned value was not -1 then it keeps counting the edges
      }
    }

    if (search > myValue) {
      if (right != null) {
        int rightS = right.depth(search);

        if(rightS == -1) // checks if the returned value was -1 so that it keeps returning -1
          return -1;

        return 1 + right.depth(search); // if the returned value was not -1 then it keeps counting the edges
      }
    }

    if(search == myValue) // the value was found then it returns 0
      return 0;

    return -1; // the pointers reached null and no value was found
  }

  public int size(){
    // This method recursively calculates the number of nodes in the (sub)tree.
    // Iterates over the binary tree to return the size
    int sum = 1;

    if(left != null){
      sum += left.size(); // increments the sum by 1
    }
    if(right != null){
      sum += right.size(); //increments the sum by 1
    }

    return sum;
  }

  // Utility function included so you can debug your solution. 
  public void print() { print(""); }
  private void print(String prefix) {
    System.out.println(prefix + myValue);
    prefix = prefix.replace('\u251C', '\u2502');
    prefix = prefix.replace('\u2514', ' ');
    if(left != null) left.print(prefix + "\u251C ");
    if(right != null) right.print(prefix + "\u2514 ");
  }
  
} 
