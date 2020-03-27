import java.util.*; 


public class BinaryHeap<AnyType extends Comparable<? super AnyType>> extends AbstractQueue<AnyType>
{
    private static final int DEFAULT_CAPACITY = 100;
    private int currentSize;      // Nombre d'elements
    private AnyType [ ] array;    // Tableau contenant les donnees (premier element a l'indice 1)
    private boolean min;
    private int modifications;    // Nombre de modifications apportees a ce monceau
    
    @SuppressWarnings("unchecked")
    public BinaryHeap( boolean min ){
	    this.min = min;
	    currentSize = 0;
	    array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];
    }
    
    @SuppressWarnings("unchecked")
    public BinaryHeap( AnyType[] items, boolean min ){
	    this.min = min;
        currentSize = items.length;
        array = (AnyType[]) new Comparable[ (currentSize + 2) ];

        int i = 1;
        for ( AnyType item : items )
            array[ i++ ] = item;

        if (!min){
            buildMaxHeap();
        } else {
            buildMinHeap();
        }
    }

    /**
     * @param x Element to insert
     * @return Boolean indicating the success of the insertion
     */
    public boolean offer( AnyType x ){
	    if (x == null)
	        throw new NullPointerException("Cannot insert null in a BinaryHeap");
	
	    if( currentSize + 1 == array.length )
	        doubleArray();

        int hole = ++currentSize;
        array[ 0 ] = x; // in case the element to be inserted is the extremum

        boolean filledHole = false;
        while (!filledHole) {
            if (min && // Working with min heap
                    x.compareTo(array[hole / 2]) < 0 // The parent's key is greater
                    || !min && // Working with max heap
                    x.compareTo(array[hole / 2]) > 0) // The parent's key is lesser
            {
                // Utiliser swapReferences ici ???
                array[hole] = array[hole / 2];
                hole /= 2;
            } else {
                array[hole] = x;
                filledHole = true;
            }
        }
	    return true;
    }
    
    public AnyType peek(){
	    if(!isEmpty())
	    return array[1];
	
	    return null;
    }
    
    public AnyType poll(){

        AnyType extremum = peek();
        array[1] = array[--currentSize];

        if (!min)
            percolateDownMaxHeap(1, currentSize);
        else
            percolateDownMinHeap(1, currentSize);

    	return extremum;
    }
    
    public Iterator<AnyType> iterator(){
	    return new HeapIterator();
    }
    
    private void buildMinHeap(){
	    for(int i = currentSize / 2; i > 0; i--){
	        percolateDownMinHeap(i, currentSize);
        }
    }
    
    private void buildMaxHeap(){
        for(int i = currentSize / 2; i > 0; i--){
            percolateDownMaxHeap(i, currentSize);
        }
    }
    
    public boolean isEmpty(){
	    return currentSize == 0;
    }
    
    public int size(){
	    return currentSize;
    }
    
    public void clear(){
	    currentSize = 0;
	    modifications = 0;
	    array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];
    }
    
    private static int leftChild( int i, boolean heapIndexing ){
	            return ( heapIndexing ? 2*i : 2*i+1 );
    }
    
    private void swapReferences( int index1, int index2 ){
	    swapReferences(array, index1, index2);
    }
    
    private static <AnyType extends Comparable<? super AnyType>>
				    void swapReferences( AnyType[] array, int index1, int index2 ){
	
    	AnyType tmp = array[ index1 ];
	    array[ index1 ] = array[ index2 ];
	    array[ index2 ] = tmp;
    }
    
    @SuppressWarnings("unchecked")
	private void doubleArray(){
	    AnyType [ ] newArray;
	
	    newArray = (AnyType []) new Comparable[ array.length * 2 ];
	for( int i = 0; i < array.length; i++ )
	    newArray[ i ] = array[ i ];
	    array = newArray;
    }
    
    
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMinHeap( int hole, int size ){
	     percolateDownMinHeap(array, hole, size, true);
    }
    
    /**
     * @param array   Tableau d'element
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     * @param heapIndexing  True si les elements commencent a l'index 1, false sinon
     */
    private static <AnyType extends Comparable<? super AnyType>>
				    void percolateDownMinHeap( AnyType[] array, int hole, int size, boolean heapIndexing ) {
        int child;

        while( heapIndexing && hole * 2 <= size
                || !heapIndexing && (hole * 2) + 1 <= size){

            child = leftChild(hole, heapIndexing);

            if( child != size && //  hole has a right child
                    array[ child + 1 ].compareTo( array[ child ] ) < 0) //  Right child's key is lesser than left
                child++;
            if( array[ child ].compareTo( array[ hole ] ) < 0 ) // Child's key is lesser than hole
                swapReferences( array, hole, child );
            else // Child's key is greater or equal to  hole's key
                break;

            hole = child;

        }
    }
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMaxHeap( int hole, int size ){
	    percolateDownMaxHeap(array, hole, size, true);
    }
    
    /**
     * @param array         Tableau d'element
     * @param hole          Position a percoler
     * @param size          Indice max du tableau
     * @param heapIndexing  True si les elements commencent a l'index 1, false sinon
     */
    private static <AnyType extends Comparable<? super AnyType>> 
				    void percolateDownMaxHeap( AnyType[] array, int hole, int size, boolean heapIndexing )
    {

        int child;

        while( heapIndexing && hole * 2 <= size
                || !heapIndexing && (hole * 2) + 1 <= size){

            child = leftChild(hole, heapIndexing);

            if( child != size && //  hole has a right child
                    array[ child + 1 ].compareTo( array[ child ] ) > 0) //  Right child's key is greater than left
                child++;
            if( array[ child ].compareTo( array[ hole ] ) > 0 ) // Child's key is greater than hole's
                swapReferences( array, hole, child );
            else // Child's key is less or equal to hole's key
                break;

            hole = child;

        }

    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSort( AnyType[] a )
    {
        for( int i = a.length / 2 - 1; i >= 0; i-- ){
            percolateDownMaxHeap(a, i, a.length - 1, false);
        }
        for( int i = a.length - 1; i > 0; i-- ){
            swapReferences(a, 0, i);
            percolateDownMaxHeap(a, 0, i - 1, false);
        }
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSortReverse( AnyType[] a )
    {
        for( int i = a.length / 2 - 1; i >= 0; i-- ){
            percolateDownMinHeap(a, i, a.length - 1, false);
        }
        for( int i = a.length - 1; i > 0; i-- ){
            swapReferences(a, 0, i);
            percolateDownMinHeap(a, 0, i - 1, false);
        }
    }
    
    public String nonRecursivePrintFancyTree()
    {
	String outputString = "";
	
	//COMPLETEZ

	return outputString;
    }
    
    public String printFancyTree()
    {
	return printFancyTree(1, "");
    }
    
    private String printFancyTree( int index, String prefix)
    {
	String outputString = "";
	
	outputString = prefix + "|__";
	
	if( index <= currentSize )
	    {
		boolean isLeaf = index > currentSize/2;
		
		outputString += array[ index ] + "\n";
		
		String _prefix = prefix;
		
		if( index%2 == 0 )
		    _prefix += "|  "; // un | et trois espace
		else
		    _prefix += "   " ; // quatre espaces
		
		if( !isLeaf ) {
		    outputString += printFancyTree( 2*index, _prefix);
		    outputString += printFancyTree( 2*index + 1, _prefix);
		}
	    }
	else
	    outputString += "null\n";
	
	return outputString;
    }
    
    private class HeapIterator implements Iterator {
	
	public boolean hasNext() {
	    //COMPLETEZ
            return false/**/;
	}

	public Object next() throws NoSuchElementException, 
				    ConcurrentModificationException, 
				    UnsupportedOperationException {
	    //COMPLETEZ
		return null/**/;
	}
	
	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }
}
