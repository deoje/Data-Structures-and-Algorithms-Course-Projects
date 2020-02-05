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
        capacity *= CAPACITY_INCREASE_FACTOR; //On double la capacité , voir apres si on veut nombre premier

        Node<KeyType, DataType>[] map2 = new Node[capacity];  ;
        //On créé une nouvelle map vide avec la nouvelle capacité. Utiliser LinkedHashMap(int capacity)?

        for( int i =0; i< map.length; i++) { //On part à la recherche des Key de la premiere map pour les replacer dans la nouvelle
            while(map[i] != null && map[i].next != null){ //On continue dans le node [i] tant qu'il y a un next
                int index = getIndex(map[i].key); // Trouve le nouvel index pour la nouvelle capacité

                if(map2[index] == null) {
                    map2[index] = new Node<>(map[i].key, map[i].data);
                }
                else{
                    Node<KeyType, DataType> NouvellePremiereCase = new Node<>(map[i].key, map[i].data);
                    NouvellePremiereCase.next = map2[index]; //Nouvelle case pointe sur la premiere
                    map2[index] = NouvellePremiereCase; //Nouvelle case devient la premiere du node
                }
                map[i] = map[i].next; // Passe a la prochaine case du node [i] de la map initiale
            }
        }
        map = new Node[capacity];
        map = map2;
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

    /** TODO
     * Assigns a value to a key
     * @param key Key which will have its value assigned or reassigned
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType put(KeyType key, DataType value) {
        if (shouldRehash()){

        } else {
            int idx = getIndex(key);
            Node<KeyType, DataType> newNode = new Node<>(key,value);
            if (map[idx] != null) {
                Node<KeyType,DataType> currentNode = map[idx];
                while (currentNode.next != null)
                    currentNode = currentNode.next;
                currentNode.next = newNode;
            } else {
                map[idx] = newNode;
            }
        }
        return null;
    }

    /** TODO: Test Me
     * Removes the node attached to a key
     * @param key Key which is contained in the node to remove
     * @return Old DataType instance at key (null if none existed)
     */
    // Return the first node's data of the linked list at the given index
    // the second node of the linked list becomes the first one
    public DataType remove(KeyType key) {
        if (containsKey(key)){
            int idx = getIndex(key);
            Node<KeyType,DataType> node = map[idx];
            map[idx] = node.next;
            return node.data;
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


