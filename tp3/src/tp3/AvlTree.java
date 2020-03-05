package tp3;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class AvlTree<ValueType extends Comparable<? super ValueType> > {

    private BinaryNode<ValueType> root;

    public AvlTree() { }

    /**
     * Adds value to the tree and keeps it as a balanced AVL Tree
     * @param value value to add to the tree
     */
    public void insert(ValueType value) {
        if (root == null) {
            root = new BinaryNode<ValueType>(value, null);
        } else {
            insert(value, root);
        }
    }

    /**
     * Removes value from the tree and keeps it as a balanced AVL Tree
     * @param value value to remove from the tree
     */
    public void remove(ValueType value){
        remove(value, root);
    }

    /**
     * Verifies if the tree contains value
     * @param value value to verify
     * @return if value already exists in the tree
     */
    public boolean contains(ValueType value) {
        return contains(value, root);
    }

    /**
     * Returns the max level contained in our root tree
     * @return Max level contained in our root tree
     */
    public int getHeight() {
        return getLevelCount(root) - 1;
    }

    /**
     * Returns the minimal value contained in our root tree
     * @return Minimal value contained in our root tree
     */
    public ValueType findMin() {
        BinaryNode<ValueType> minimalNode = findMin(root);
        if (minimalNode == null) return null;
        return minimalNode.value;
    }

    /**
     * Returns all values contained in the root tree in ascending order
     * @return Values contained in the root tree in ascending order
     */
    public List<ValueType> infixOrder() {
        List<ValueType> items = new LinkedList<ValueType>();
        infixOrder(root, items);
        return items;
    }

    /**
     * Returns all values contained in the root tree in level order from top to bottom
     * @return Values contained in the root tree in level order from top to bottom
     */
    public List<ValueType> levelOrder(){
        List<ValueType> items = new LinkedList<ValueType>();

        ArrayDeque<BinaryNode<ValueType>> nodesToCheck = new ArrayDeque<BinaryNode<ValueType>>();

        if (root != null){
            nodesToCheck.push(root);
            levelOrder(nodesToCheck, items);
        }

        return items;
    }

    /** TODO O( log n )
     * Adds value to the tree and keeps it as a balanced AVL Tree
     * Should call balance only if insertion succeeds
     * AVL Trees do not contain duplicates
     *
     * @param value value to add to the tree
     * @param currentNode Node currently being accessed in this recursive method
     * @return if parent node should balance
     */
    private boolean insert (ValueType value, BinaryNode<ValueType> currentNode){

        if (currentNode == null)
            return false;

        boolean needsBalancing = false;
        int compareResult = value.compareTo(currentNode.value);

        if (compareResult < 0)
            if (currentNode.left == null){
                currentNode.left = new BinaryNode<ValueType>(value, currentNode);
                return true;
            } else { // Keep looking left for space
                needsBalancing = insert(value, currentNode.left);
            }
        else if (compareResult > 0){
            if (currentNode.right == null){
                currentNode.right = new BinaryNode<ValueType>(value, currentNode);
                return true;
            } else { // Keep searching right for space
                needsBalancing = insert(value, currentNode.right);
            }
        }

        if (needsBalancing) balance(currentNode); // Keep the O(log(n)) with balancing

        return needsBalancing;
    }

    /** TODO O ( log n )
     * Removes value from the tree and keeps it as a balanced AVL Tree
     * Should call balance only if removal succeeds
     * @param value value to remove from the tree
     * @param currentNode Node currently being accessed in this recursive method
     * @return if parent node should balance
     */
    private boolean remove(ValueType value, BinaryNode<ValueType> currentNode) {

        // Value not found, no balancing needed
        if (currentNode == null)
            return false;

        boolean needsBalancing;
        int compareResult = value.compareTo(currentNode.value);

        // Value to insert is lower than currentNode's data
        if (compareResult < 0)
            needsBalancing = remove(value, currentNode.left);
        // Value to insert is lower than currentNode's data
        else if (compareResult > 0)
             needsBalancing = remove(value, currentNode.right);
        //
        // Value to insert is equal to currentNode's data
        // currentNode has two children
        else if (currentNode.left != null && currentNode.right != null)
        {
                currentNode.value = findMin(currentNode.right).value;
                 needsBalancing = remove(currentNode.value, currentNode.right);
        }
        else { // one child or none
            if (currentNode.left != null) { // if child is on left
                currentNode.value = currentNode.left.value;
                currentNode.left = null;
            } else if (currentNode.right != null) { // if child is on right
                currentNode.value = currentNode.right.value;
                currentNode.right = null;
            } else if (currentNode.parent != null) { // Leaf

                BinaryNode<ValueType> leftChildOfParent = currentNode.parent.left;

                if (leftChildOfParent != null) {
                    if (leftChildOfParent.value.equals(value))
                        // currentNode is a left child
                        currentNode.parent.left = null;
                } else // currentNode is a right child
                    currentNode.parent.right = null;

            } else // tree of one node
                root = null;

            needsBalancing = true;
        }

        if (needsBalancing)
            balance(currentNode);
        return needsBalancing;
    }

    /** TODO O( n )
     * Balances the subTree
     * @param subTree SubTree currently being accessed to verify if it respects the AVL balancing rule
     */
    private void balance(BinaryNode<ValueType> subTree) { // Code from the course addapted

        if (subTree == null)
            return;

        if ( getLevelCount(subTree.left) - getLevelCount(subTree.right) > 1 )
        {
            // Left-Left case
            if (getLevelCount(subTree.left.left) >= getLevelCount(subTree.left.right) )
                rotateLeft(subTree);
            // Left-Right case
            else
                doubleRotateOnLeftChild(subTree);
        }
        else if (getLevelCount(subTree.right) - getLevelCount(subTree.left) > 1)
        {
            // Right-Right case
            if (getLevelCount(subTree.right.right) >= getLevelCount(subTree.right.left))
                rotateRight(subTree);
            // Right-Left case
            else
                doubleRotateOnRightChild(subTree);
        }
    }

    /** TODO O( 1 )
     * Single rotation to the left child, AVR Algorithm
     * @param node1 Node to become child of its left child
     */
    private void rotateLeft(BinaryNode<ValueType> node1){
        BinaryNode<ValueType> k1 = node1.left;
        
        if (node1.parent != null){
            if (node1.parent.left.value.equals(node1.value))
                node1.parent.left = k1;
            else
                node1.parent.right = k1;
        } else
            root = k1;

        k1.parent = node1.parent;
        node1.parent = k1;
        node1.left = k1.right;
        k1.right = node1;
        if (node1.left != null)
            node1.left.parent = node1;
    }

    /** TODO O( 1 )
     * Single rotation to the right, AVR Algorithm
     * @param node1 Node to become child of its right child
     */
    private void rotateRight(BinaryNode<ValueType> node1){

        BinaryNode<ValueType> k2 = node1.right;

        if (node1.parent != null){
            if (node1.parent.left.value.equals(node1.value))
                node1.parent.left = k2;
            else
                node1.parent.right = k2;
        } else
            root = k2;

        k2.parent = node1.parent;
        node1.parent = k2;
        node1.right = k2.left;
        k2.left = node1;
        if (node1.right != null)
            node1.right.parent = node1;
    }

    /** TODO O( 1 )
     * Double rotation on left child, AVR Algorithm
     * @param node1 Node to become child of the right child of its left child
     */
    private void doubleRotateOnLeftChild(BinaryNode<ValueType> node1){
       rotateRight(node1.left);
       rotateLeft(node1);
    }

    /** TODO O( 1 )
     * Double rotation on right child, AVR Algorithm
     * @param node1 Node to become child of the left child of its right child
     */
    private void doubleRotateOnRightChild(BinaryNode<ValueType> node1){
        rotateLeft(node1.right);
        rotateRight(node1);
    }

    /** TODO O( log n )
     * Verifies if the root tree contains value
     * @param value value to verify
     * @param currentNode Node currently being accessed in this recursive method
     * @return if value already exists in the root tree
     */
    private boolean contains(ValueType value, BinaryNode<ValueType> currentNode){
        // No match
        if (currentNode == null)
            return false;

        // Calculate the difference between the value and the current value to decide where to continue to search
        int compareResult = value.compareTo(currentNode.value);

        if ( compareResult < 0 ) // value is lower than the currentNode's, so check to the left
                return contains(value, currentNode.left);
        else if ( compareResult > 0 ) // value is higher than the currentNode's, so check to the right
                return contains(value, currentNode.right);
        else // value found yay \o/
            return true;
    }

    /** TODO O( n )
     * Returns the number of level contained in subTree including subTree node level
     * @return Number of level contained in subTree including subTree node level
     *         With the following tree, we should get
     *                  3   (1 level)
     *               /   \
     *             1      5 (2 levels)
     *           / \    / \
     *          0   2  4   6 (3 levels)
     */
    private int getLevelCount(BinaryNode<ValueType> subTree){
        if (subTree == null)
            return 0;
        else
            return 1 + Math.max( getLevelCount(subTree.left), getLevelCount(subTree.right) );
    }

    /** TODO O( log n )
     * Returns the node which has the minimal value contained in our root tree
     * @return Node which has the minimal value contained in our root tree
     */
    private BinaryNode<ValueType> findMin(BinaryNode<ValueType> currentNode) {
        if (currentNode == null)
            return  null;
        else if (currentNode.left == null)
            return currentNode;

        return findMin(currentNode.left);
    }

    /** TODO O( n )
     * Builds items which should contain all values within the root tree in ascending order
     * @param currentNode Node currently being accessed in this recursive method
     * @param items List being modified to contain all values in the root tree in ascending order
     */
    private void infixOrder(BinaryNode<ValueType> currentNode, List<ValueType> items){
        if (currentNode != null){
            infixOrder(currentNode.left, items);
            items.add(currentNode.value);
            infixOrder(currentNode.right,items);
        }

    }

    /** TODO O( n )
     * Builds items which should contain all values within the root tree in level order from top to bottom
     * @param nodesToCheck Queue for non-recursive algorithm
     * @param items List being modified to contain all values in the root tree in level order from top to bottom
     */
    private void levelOrder(ArrayDeque<BinaryNode<ValueType>> nodesToCheck, List<ValueType> items) {

        while (!nodesToCheck.isEmpty()){

            // Pop the following node to process (FIFO)
            BinaryNode<ValueType> currentNode = nodesToCheck.poll();

            // Save value
            items.add(currentNode.value);

            // Add children from left to right
            if (currentNode.left != null)
                nodesToCheck.add(currentNode.left);
            if (currentNode.right != null)
                nodesToCheck.add(currentNode.right);

        }
    }
    
    static class BinaryNode<ValueType> {
        ValueType value;

        BinaryNode<ValueType> parent; // Pointer to the node containing this node

        BinaryNode<ValueType> left = null; // Pointer to the node on the left which should contain a value below this.value
        BinaryNode<ValueType> right = null; // Pointer to the node on the right which should contain a value above this.value

        BinaryNode(ValueType value, BinaryNode<ValueType> parent)
        {
            this.value = value;
            this.parent = parent;
        }
    }
}