/**
    A class of bags whose entries are stored in a chain of linked nodes.
    The bag is never full.
    INCOMPLETE DEFINITION; includes definitions for the methods add,
    toArray, isEmpty, and getCurrentSize.
    @author Frank M. Carrano, Timothy M. Henry
    @version 5.0
*/
public final class LinkedBag<T> implements BagInterface<T>
{
	private Node firstNode;       // Reference to first node
	private int numberOfEntries;
	
	public LinkedBag()
	{
		firstNode = null;
      numberOfEntries = 0;
	} // end default constructor

	/** Adds a new entry to this bag.
	    @param newEntry  The object to be added as a new entry.
	    @return  True. */
	public boolean add(T newEntry) // OutOfMemoryError possible
	{
      // Add to beginning of chain:
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;  // Make new node reference rest of chain
                                 // (firstNode is null if chain is empty)
      firstNode = newNode;       // New node is at beginning of chain
		numberOfEntries++;
      
		return true;
	} // end add

	/** Retrieves all entries that are in this bag.
       @return  A newly allocated array of all the entries in this bag. */
	public T[] toArray()
	{
      // The cast is safe because the new array contains null entries.
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
      
      int index = 0;
      Node currentNode = firstNode;
      while ((index < numberOfEntries) && (currentNode != null))
      {
         result[index] = currentNode.data;
         index++;
         currentNode = currentNode.next;
      } // end while
      
      return result;
      // Note: The body of this method could consist of one return statement,
      // if you call Arrays.copyOf
	} // end toArray
   
	/** Sees whether this bag is empty.
       @return  True if the bag is empty, or false if not. */
	public boolean isEmpty()
	{
		return numberOfEntries == 0;
	} // end isEmpty
   
	/** Gets the number of entries currently in this bag.
       @return  The integer number of entries currently in the bag. */
	public int getCurrentSize()
	{
		return numberOfEntries;
	} // end getCurrentSize

	/** Removes one unspecified entry from this bag, if possible.
       @return  Either the removed entry, if the removal
                was successful, or null. */
	public T remove()
	{
	    T result = null;
	    if (firstNode != null)
	    {
	         result = firstNode.getData();
	         firstNode = firstNode.getNextNode(); // Remove first node from chain
	         numberOfEntries--;
	     } // end if
	      
	     return result;
	} // end remove
   
	/** Removes one occurrence of a given entry from this bag.
       @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false otherwise. */
	public boolean remove(T anEntry)
	   {
	      boolean result = false;
	      Node nodeN = getReferenceTo(anEntry);
	      
	      if (nodeN != null)
	      {
	// Replace located entry with entry in first node
	         nodeN.setData(firstNode.getData()); 
	// Remove first node
	         firstNode = firstNode.getNextNode(); 
	numberOfEntries--;
	         
	         result = true;
	      } // end if
	  
	      return result;
	   } // end remove
	
	/** Removes all entries from this bag. */
	public void clear()
   {
      while (!isEmpty())
    	  remove();
   } // end clear
	
	/** Counts the number of times a given entry appears in this bag.
		 @param anEntry  The entry to be counted.
		 @return  The number of times anEntry appears in the bag. */
	public int getFrequencyOf(T anEntry)
   {
		int frequency = 0;
      
		int counter = 0;
		Node currentNode = firstNode;
		while ((counter < numberOfEntries) && (currentNode != null))
		{
			if (anEntry.equals(currentNode.getData()))
			{
				frequency++;
			} // end if
			
			counter++;
			currentNode = currentNode.getNextNode();
		} //end while
		
		return frequency;
   } // end getFrequencyOf
	
	/** Tests whether this bag contains a given entry.
		 @param anEntry  The entry to locate.
		 @return  True if the bag contains anEntry, or false otherwise. */
	public boolean contains(T anEntry)
   {
      boolean found = false;
      Node currentNode = firstNode;
      
      while (!found && (currentNode != null))
      {
    	  if (anEntry.equals(currentNode.getData()))
    		  found = true;
    	  else
    		  currentNode = currentNode.getNextNode();
      } // end while
      
      return found;
   } // end contains
	
	// Locates a given entry within this bag.
	// Returns a reference to the node containing the 
	// entry, if located, or null otherwise.
	private Node getReferenceTo(T anEntry)
	{
		boolean found = false;
		Node currentNode = firstNode;
		while (!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		} // end while
	     
		return currentNode;
	} // end getReferenceTo
	
	private class Node
	{
	  private T    data; // Entry in bag
	  private Node next; // Link to next node

		private Node(T dataPortion)
		{
			this(dataPortion, null);	
		} // end constructor
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;	
		} // end constructor
		
		private T getData() 
		{
			return data;
		} // end getData
		
		private void setData(T newData) {
			data = newData;
		} // end setData
		
		private Node getNextNode()
		{
			return next;
		} // end getNextNode
		
		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} // end setNextNode
	} // end Node
	
	// -------------------- Project 1 Additions --------------------
	
	   // Converts output into strings rather than addresses
	   public String toString() {
		   String result = "";
		   Node currentNode = firstNode;
		   while (currentNode != null) {
			   result += currentNode.getData() + " ";
			   currentNode = currentNode.next;
		   }
		   return result;
	   } // end toString

	   public BagInterface<T> union(BagInterface<T> parameterBag) throws NullPointerException {
		    // Sanitize input
		   if (parameterBag == null) {
	   			throw new NullPointerException("Inputted bag is null!");
	   		}
		   
	        // Convert parameterBag into an array, then initialize a new LinkedBag object result
	        T[] parameterBagCopy = parameterBag.toArray();
	        BagInterface<T> result = new LinkedBag<>();
	        
	        // - Special Cases -
	   		// If bag and parameterBag are empty
	   		if(this.isEmpty() && parameterBag.isEmpty()) {
	   			return result;
	   		}
	   		
	   	// If either bag or parameterBag is empty
	   		if(this.isEmpty() || parameterBag.isEmpty()) {
	   			if(this.isEmpty()) {
	   		   		for(int i = 0; i < parameterBagCopy.length; i++) {
	   		   			T tempElement = parameterBagCopy[i];
	   		   			result.add(tempElement);
	   		   		}
	   		   		return result;
	   			}
	   			if(parameterBag.isEmpty()) {
	   				Node currentNode = firstNode;
	   		        while (currentNode != null) {
	   		            result.add(currentNode.getData());
	   		            currentNode = currentNode.next;
	   		        }
	   		   		return result;
	   			}
	   		}
	   		
	        // Iterate through the first bag and add each element into result, then do the same
	        // for the parameter bag and return result
	        Node currentNode = firstNode;
	        while (currentNode != null) {
	            result.add(currentNode.getData());
	            currentNode = currentNode.next;
	        }
	        for(int i = 0; i < parameterBagCopy.length; i++) {
	            result.add(parameterBagCopy[i]);
	        }
	        return result;
	    } // end union

	   public BagInterface<T> intersection(BagInterface<T> parameterBag) throws NullPointerException {
		    // Sanitize input
		   if (parameterBag == null) {
	   			throw new NullPointerException("Inputted bag is null!");
	   		}
		   
	        // Convert parameterBag into an array, initialize an originalBagCopy to prevent
	        // tampering with the original bag, and initialize a result LinkedBag
	        T[] parameterBagCopy = parameterBag.toArray();
	        BagInterface<T> originalBagCopy = new LinkedBag<>();
	        BagInterface<T> result = new LinkedBag<>();
	        
	        // - Special Cases -
	   		// If bag or parameterBag is empty
	   		if(this.isEmpty() || parameterBag.isEmpty()) {
	   			return result;
	   		}
	        // Copy the original bag into a copied version to prevent tampering
	        Node currentNode = firstNode;
	        while (currentNode != null) {
	            originalBagCopy.add(currentNode.getData());
	               currentNode = currentNode.next;
	        }

	        // If originalBagCopy has an element in parameterBagCopy, add it to result and
	        // remove it from originalBagCopy
	        
	           for(int i = 0; i < parameterBagCopy.length; i++) {
	               if (originalBagCopy.contains(parameterBagCopy[i])) {
	                   result.add(parameterBagCopy[i]);
	                   originalBagCopy.remove(parameterBagCopy[i]);
	               }
	           }
	           return result;
	    } // end intersection
	   
	   public BagInterface<T> difference(BagInterface<T> parameterBag) throws NullPointerException {
		    // Sanitize input
		   if (parameterBag == null) {
	   			throw new NullPointerException("Inputted bag is null!");
	   		}
		   
	        // Converts parameterBag into an array and initializes originalBagCopy
	           T[] parameterBagCopy = parameterBag.toArray();
	           BagInterface<T> originalBagCopy = new LinkedBag<>();

	        // - Special Cases -
	      		// If bag and parameterBag is empty
	      		if(this.isEmpty() && parameterBag.isEmpty()) {
	      			return originalBagCopy;
	      		}
	      		// If bag is empty
	      		if(this.isEmpty()) {
	      			return originalBagCopy;
	      		}
	      		// If parameterBag is empty
	      		if(parameterBag.isEmpty()) {
	      			Node currentNode = firstNode;
	   		        while (currentNode != null) {
	   		        	originalBagCopy.add(currentNode.getData());
	   		            currentNode = currentNode.next;
	   		        }
	   		   		return originalBagCopy;
	      		}
	      		
	        // Copies the original bag into a copied version to prevent tampering
	        Node currentNode = firstNode;
	        while (currentNode != null) {
	            originalBagCopy.add(currentNode.getData());
	               currentNode = currentNode.next;
	        }

	        // If originalBagCopy shares an element with parameterBagCopy,
	        // remove it from originalBagCopy
	           for(int i = 0; i < parameterBagCopy.length; i++) {
	               if (originalBagCopy.contains(parameterBagCopy[i])) {
	                   originalBagCopy.remove(parameterBagCopy[i]);
	               }
	           } 
	           return originalBagCopy;
	    } // end difference
} // end LinkedBag



