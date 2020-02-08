package tp2;

import java.util.Arrays;

public class LinkedHashMap<KeyType, DataType> {

    private static final double COMPRESSION_FACTOR = 2; // 50%
    private static final int DEFAULT_CAPACITY = 20;
    private static final int CAPACITY_INCREASE_FACTOR = 2;

    private Node<KeyType, DataType>[] map;
    private int capacity;
    private int size = 0;

    public LinkedHashMap() {
        capacity = DEFAULT_CAPACITY;
        map = new Node[DEFAULT_CAPACITY];
    }

    public LinkedHashMap(int capacity) {
        this.capacity = capacity;
        map = new Node[capacity];
    }

    /**
     * Finds the index attached to a particular key
     * @param key Value used to access to a particular instance of a DataType within map
     * @return The index value attached to a particular key
     */
    private int getIndex(KeyType key){
        int keyHash = key.hashCode() % capacity;
        return keyHash < 0 ? -keyHash : keyHash;
    }

    private boolean shouldRehash() {
        return size * COMPRESSION_FACTOR > capacity;
    }

    /** TODO
     * Increases capacity by CAPACITY_INCREASE_FACTOR (multiplication) and
     * reassigns all contained values within the new map
     */
    private void rehash() {
    }

    public int size() {
        return size;
    }

    public int getCapacity(){
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /** TODO
     * Finds if map contains a key
     * @param key Key which we want to know if exists within map
     * @return if key is already used in map
     */
    public boolean containsKey(KeyType key) {
        // 1) Use getIndex to determine which list to traverse
        int idx = getIndex(key);

        // 2) Verify if there's actually a list
        if (map[idx] != null){

            Node node = map[idx];
            boolean foundKey;
            do {
                foundKey = (node.key == key);
                if (foundKey)
                        break;
                node = node.next;
            } while (node != null);
            return foundKey;

        }
        // No list at corresponding index thus no item with that key
        return false;
    }

    /** TODO
     * Finds the value attached to a key
     * @param key Key which we want to have its value
     * @return DataType instance attached to key (null if not found)
     */
    public DataType get(KeyType key) {
        return null;
    }

    /** TODO: TEST ME
     * Assigns a value to a key
     * @param key Key which will have its value assigned or reassigned
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType put(KeyType key, DataType value) {
        int idx = getIndex(key);
        if (containsKey(key)){
            DataType oldData;
            Node node = map[idx];
            if (node.key == key){
                oldData = (DataType) node.data;
                node.data = value;
            } else {
                Node nextNode = node.next;
                while (nextNode.key != key){
                    node = nextNode;
                    nextNode = node.next;
                }
                oldData = (DataType) nextNode.data;
                nextNode.data = value;
            }
            return oldData;
        } else {
            if (map[idx] != null) {
                Node newNode = new Node<>(key, value);
                newNode.next = map[idx];
                map[idx] = newNode;
            } else {
                map[idx] = new Node<>(key, value);
            }
        }
        return null;
    }

    /** TODO: Test Me
     * Removes the node attached to a key
     * @param key Key which is contained in the node to remove
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType remove(KeyType key) {
        if (containsKey(key)){
            int idx = getIndex(key);
            Node node = map[idx];
            if (node.key != key){
                Node nextNode = node.next;
                while (nextNode.key != key){
                    node = nextNode;
                    nextNode = nextNode.next;
                }
                node.next = nextNode.next;
                System.out.println(nextNode.data);
                return (DataType) nextNode.data;
            } else {
                DataType oldData = (DataType) node.data;
                map[idx] = node.next;
                return oldData;
            }
        }
        return null;
    }

    /** TODO: Test Me
     * Removes all nodes contained within the map
     */
    public void clear() {
        // Test asks for a map of same initial size and filled
        // with null objects
        Arrays.fill(map,null);
    }


    static class Node<KeyType, DataType> {
        final KeyType key;
        DataType data;
        Node next; // Pointer to the next node within a Linked List

        Node(KeyType key, DataType data)
        {
            this.key = key;
            this.data = data;
            next = null;
        }
    }
}


