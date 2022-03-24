package assignment2;

/**
 * ICSI 311 Principles of Programming Languages
 * Fall 2021
 * TA Phipps
 * Student ID: 001440162
 * 
 * Represents a generic binary search tree, which is the data structure for the
 * ADT People Database where each Person is made into a Node.
 * @author Kiran Aziz
 * @version 1.0
 */
public class BinarySearchTree<E extends Comparable<E>>{
    /**
     * A reference to the Binary Search Tree - the root Node where the element is a person's name and birthday.
     */
    protected Node<E> root;

    /**
     * Constructs an empty binary search tree.
     */
    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * Constructs a one node binary search tree.
     * @param element The reference to the data to create the root node.
     */
    public BinarySearchTree(E element) {
        this.root = new Node<E>(element);
    }

    /**
     * Returns the binary search tree's root element.
     * @return A reference to the element of the root.
     * @throws BinarySearchTreeException A BinarySearchTreeException is thrown if the tree is empty.
     */
    public E getRoot() throws BinarySearchTreeException {
        if (this.root == null) {
            throw new BinarySearchTreeException("TreeException: The tree is empty");
        }else{
            return this.root.getElement();
        }
    }

    /**
     * Replaces the data of the root node or creates a root node with the value.
     * @param element A reference to the root's new value.
     */
    public void setRoot(E element) {
        if (this.root != null) {
            this.root.setElement(element);
        }else{
            this.root = new Node<E>(element);
        }
    }

   /**
     * Returns whether the binary search tree is empty or not.
     * @return A boolean specifying if the tree is empty.
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * Removes all nodes from the binary search tree by setting the root to null.
     */
    public void makeEmpty() {
        this.root = null;
    }

    /**
     * Inserts a new Node into this tree.
     * @param element A reference to the data of the new Node.
     */
    public void insert(E element) {
        this.root = insert(this.root, element);
    }

    /**
     * Returns the new modified binary search tree and inserts the new node.
     * @param node Node to insert the new node to.
     * @param element  A reference to the new node's data.
     * @return Node new binary search tree with the new node inserted.
     */
    private Node<E> insert(Node<E> node, E element) {
        //If the root node is null, make a root node with the element.
    	if(node == null){
            return new Node<E>(element);
        }else{
        	//Compares elements. 
        	//If the node's element is smaller than the root, node will be 
        	//placed on the left side of the binary search tree.
        	//Otherwise, the node is placed on the right.
            if(node.getElement().compareTo(element) > 0) {
                node.setLeft(insert(node.getLeft(), element)); 
            }else{
                node.setRight(insert(node.getRight(), element)); 
            }
        }
        return node;
    }

    /**
     * 
     * @param element A reference to the data to be compare to each node's data.
     * @return A boolean specifying if the binary search tree contains a certain element.
     */
    public boolean contains(E element) {
    	//Temporary node while searching all nodes of the binary search tree.
       	Node<E> temp = this.root; 
        
       	while(temp != null){
       		//If the integer value for the comparison is zero, then the 
       		//elements of both nodes are equal.
            if(temp.getElement().compareTo(element) == 0){
                return true;
            }
            //Otherwise, check the left node(s).
            else if(temp.getElement().compareTo(element) > 0){
                temp = temp.getLeft(); 
            }
          //Otherwise, check the right node(s).
            else{
                temp = temp.getRight(); 
            }
        }
       	
       	//If no node with equivalent element/node is found, return false.
        return false; 
    }

    /**
     * Removes a Node through its value.
     * @param element A reference to the data of the removed Node.
     */
    public Node<E> remove(E element) {
        return this.root = remove(this.root, element);
    }

    /**
     * Returns the new modified binary search tree.
     * @param node Node to remove from the binary search tree.
     * @param element  A reference to the removed node's data.
     * @return Node new binary search tree with the specified node removed.
     * @exception BinarySearchTreeException A BinarySearchTreeException thrown when node doesn't exist.
     */
    private Node<E> remove(Node<E> node, E element) throws BinarySearchTreeException {
        if(node == null){
            throw new BinarySearchTreeException("BinarySearchTreeException: Value doesn't exist!");
        }
        //If the element is greater, 
        else if(node.getElement().compareTo(element) > 0){
            node.setLeft(remove(node.getLeft(), element)); 
        }
        //If the element is smaller
        else if(node.getElement().compareTo(element) < 0){
            node.setRight(remove(node.getRight(), element));    
        }
        //If neither smaller nor greater nor null
        else{
            if(node.getLeft() == null){
            	//Node with only left child
                return node.getRight();
            }else if(node.getRight() == null) {
            	// Node with only right child
            	return node.getLeft();
            }else{
            	//Finds the right most child
                Node<E> rightMostChild = findRightMostChild(node.getLeft()); 
                //Swap the values of the right most child and the node
                swapElement(node, rightMostChild); 
                //Remove the right most child
                node.setLeft(remove(node.getLeft(), rightMostChild.getElement()));                            
            }
        }
        return node;
    }

    /**
     * Traverses and returns the right most child.
     * @param node A reference to the Node whom most right child will be returned.
     * @return Node the rightmost child of the given Node.
     */
    private Node<E> findRightMostChild(Node<E> node) {
        while (node.getElement() != null) {
            //Recursively looks through the nodes until rightmost child is found.
        	node.setRight(findRightMostChild(node.getRight()));
        }
        return node.getRight();
    }

    /**
     * Swaps the data of two given Nodes.
     * @param node1 The first Node.
     * @param node2 The second Node.
     */
    private void swapElement(Node<E> node1, Node<E> node2) {
    	// Temporary node to hold value of first Node.
    	E tempElement = node1.getElement();
    	
    	//Sets value of first Node with value of second Node.
        node1.setElement(node2.getElement());
        
        //Sets value of second Node with value of first Node.
        node2.setElement(tempElement);
    }
}
