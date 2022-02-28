import java.util.Arrays;
/**
   A class that implements a bag of objects by using an array.
	The bag is never full.
   @author Frank M. Carrano, Timothy M. Henry
   @version 5.0
*/
public final class ResizableArrayBag<T> implements BagInterface<T>
{
	private T[] bag; // Cannot be final due to doubling
	private int numberOfEntries;
   private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 25; // Initial capacity of bag
	private static final int MAX_CAPACITY = 10000;

	/** Creates an empty bag whose initial capacity is 25. */
	public ResizableArrayBag() 
	{
		this(DEFAULT_CAPACITY);
	} // end default constructor

	/** Creates an empty bag having a given initial capacity.
	    @param initialCapacity  The integer capacity desired. */
	public ResizableArrayBag(int initialCapacity)
	{
      checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempBag = (T[])new Object[initialCapacity]; // Unchecked cast
      bag = tempBag;
      numberOfEntries = 0;
      integrityOK = true;
	} // end constructor

	/** Creates a bag containing given entries.
	    @param contents  An array of objects. */
   public ResizableArrayBag(T[] contents) 
   {
      checkCapacity(contents.length);
      bag = Arrays.copyOf(contents, contents.length);
      numberOfEntries = contents.length;
      integrityOK = true;
   } // end constructor
       
	/** Adds a new entry to this bag.
       @param newEntry  The object to be added as a new entry.
       @return  True. */
	public boolean add(T newEntry)
	{
		checkintegrity();
      if (isArrayFull())
      {
         doubleCapacity();
      } // end if
      
      bag[numberOfEntries] = newEntry;
      numberOfEntries++;
      
      return true;
	} // end add

	/** Retrieves all entries that are in this bag.
       @return  A newly allocated array of all the entries in this bag. */
	public T[] toArray() 
	{
		checkintegrity();
      
      // The cast is safe because the new array contains null entries.
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
      for (int index = 0; index < numberOfEntries; index++)
      {
         result[index] = bag[index];
      } // end for
      
      return result;
	} // end toArray
   
	/** Sees whether this bag is empty.
       @return  True if this bag is empty, or false if not. */
	public boolean isEmpty()
	{
      return numberOfEntries == 0;
	} // end isEmpty
   
	/** Gets the current number of entries in this bag.
       @return  The integer number of entries currently in this bag. */
	public int getCurrentSize()
	{
      return numberOfEntries;
	} // end getCurrentSize
   
	/** Counts the number of times a given entry appears in this bag.
       @param anEntry  The entry to be counted.
       @return  The number of times anEntry appears in this ba. */
	public int getFrequencyOf(T anEntry)
	{
		checkintegrity();
      int counter = 0;
      
      for (int index = 0; index < numberOfEntries; index++)
      {
         if (anEntry.equals(bag[index]))
         {
            counter++;
         } // end if
      } // end for
      
      return counter;
	} // end getFrequencyOf
   
	/** Tests whether this bag contains a given entry.
       @param anEntry  The entry to locate.
       @return  True if this bag contains anEntry, or false otherwise. */
   public boolean contains(T anEntry)
	{
		checkintegrity();
      return getIndexOf(anEntry) > -1; // or >= 0
	} // end contains
   
	/** Removes all entries from this bag. */
	public void clear()
	{
      while (!isEmpty())
         remove();
	} // end clear
	
	/** Removes one unspecified entry from this bag, if possible.
       @return  Either the removed entry, if the removal
       was successful, or null. */
	public T remove()
	{
		checkintegrity();
      T result = removeEntry(numberOfEntries - 1);
      return result;
	} // end remove
	
	/** Removes one occurrence of a given entry from this bag.
       @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false if not. */
	public boolean remove(T anEntry)
	{
		checkintegrity();
      int index = getIndexOf(anEntry);
      T result = removeEntry(index);
      return anEntry.equals(result);
	} // end remove
   
 	// Locates a given entry within the array bag.
	// Returns the index of the entry, if located,
	// or -1 otherwise.
   // Precondition: checkintegrity has been called.
	private int getIndexOf(T anEntry)
	{
		int where = -1;
		boolean found = false;
		int index = 0;
      
      while (!found && (index < numberOfEntries))
		{
			if (anEntry.equals(bag[index]))
			{
				found = true;
				where = index;
			} // end if
         index++;
		} // end while
      
      // Assertion: If where > -1, anEntry is in the array bag, and it
      // equals bag[where]; otherwise, anEntry is not in the array.
      
		return where;
	} // end getIndexOf
   
   // Removes and returns the entry at a given index within the array.
   // If no such entry existos, returns null.
   // Precondition: 0 <= givenIndex < numberOfEntries.
   // Precondition: checkintegrity has been called.
	private T removeEntry(int givenIndex)
	{
		T result = null;
      
		if (!isEmpty() && (givenIndex >= 0))
		{
         result = bag[givenIndex];          // Entry to remove
         int lastIndex = numberOfEntries - 1;
         bag[givenIndex] = bag[lastIndex];  // Replace entry to remove with last entry
         bag[lastIndex] = null;             // Remove reference to last entry
         numberOfEntries--;
		} // end if
      
      return result;
	} // end removeEntry
   
   // Returns true if the array bag is full, or false if not.
	private boolean isArrayFull()
	{
		return numberOfEntries >= bag.length;
	} // end isArrayFull
   
   // Doubles the size of the array bag.
   // Precondition: checkInitialization has been called.
	private void doubleCapacity()
	{
      int newLength = 2 * bag.length;
      checkCapacity(newLength);
      bag = Arrays.copyOf(bag, newLength);
	} // end doubleCapacity
   
   // Throws an exception if the client requests a capacity that is too large.
   private void checkCapacity(int capacity)
   {
      if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " +
                                         "allowed maximum of " + MAX_CAPACITY);
   } // end checkCapacity
   
   // Throws an exception if receiving object is not initialized.
   private void checkintegrity()
   {
      if (!integrityOK)
         throw new SecurityException ("ArrayBag object is corrupt.");
   } // end checkintegrity
   
	// -------------------- Project 1 Additions --------------------
   
   // Converts output into strings rather than addresses
   public String toString() {
	   String result = "";
	   for(int i = 0; i < numberOfEntries; i++) {
		   result += this.bag[i] + " ";
	   }
	   return result;
   } // end toString
   
   	public BagInterface<T> union(BagInterface<T> parameterBag) throws NullPointerException {
   		// Sanitize input
   		if (parameterBag == null) {
   			throw new NullPointerException("Inputted bag is null!");
   		}
   		
   		// Check integrity
   		checkintegrity();
   	
   		// Convert parameterBag into an array and create a result ResizableArrayBag
   		T[] parameterBagCopy = parameterBag.toArray();
   		BagInterface<T> result = new ResizableArrayBag<>();
   		
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
   		   		for(int i = 0; i < this.numberOfEntries; i++) {
   		   			result.add(this.bag[i]);
   		   		}
   	   			return result;
   			}
   		}
   		
   		// Copy the original bag into result, then copy parameterBagArray into result
   		for(int i = 0; i < this.numberOfEntries; i++) {
   			result.add(this.bag[i]);
   		}
   		
   		for(int i = 0; i < parameterBagCopy.length; i++) {
   			T tempElement = parameterBagCopy[i];
   			result.add(tempElement);
   		}
   		return result;
   	} // end union
   		
   	public BagInterface<T> intersection(BagInterface<T> parameterBag) {
   		// Sanitize input

   		
   		// Check integrity
   		checkintegrity();
   		
   		// Convert parameterBag into an array, create an originalBagCopy to prevent tampering 
   		// with the original bag, and create a result ResizableArrayBag
   		T[] parameterBagCopy = parameterBag.toArray();
   		BagInterface<T> originalBagCopy = new ResizableArrayBag<>();
   		BagInterface<T> result = new ResizableArrayBag<>();
   		
   		// - Special Cases -
   		// If bag or parameterBag is empty
   		if(this.isEmpty() || parameterBag.isEmpty()) {
   			return result;
   		}
   		
   		// Copy the original bag into originalBagCopy
   		for(int i = 0; i < this.numberOfEntries; i++) {
   			originalBagCopy.add(this.bag[i]);
   		}
   		
   		// If there is an element in parameterBagCopy that is also in originalBagCopy,
   		// add the element to result and remove the element in originalBagCopy
   		for(int i = 0; i < parameterBagCopy.length; i++) {
   			T tempElement = parameterBagCopy[i];
   			if (originalBagCopy.contains(tempElement)) {
   				result.add(tempElement);
   				originalBagCopy.remove(tempElement);
   			}
   		}
   		return result;
   	} // end intersection
   	
   	public BagInterface<T> difference(BagInterface<T> parameterBag) {
   		// Sanitize input

   		
   		// Check integrity
   		checkintegrity();
   		
   		// Convert parameterBag into an array, create an originalBagCopy to prevent tampering
   		// with the original bag
   		T[] parameterBagCopy = parameterBag.toArray();
   		BagInterface<T> originalBagCopy = new ResizableArrayBag<>();
   		
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
   	   		for(int i = 0; i < this.numberOfEntries; i++) {
   	   			originalBagCopy.add(this.bag[i]);
   	   		}
   	   		return originalBagCopy;
   		}
   		
   		// Copy the original bag into originalBagCopy
   		for(int i = 0; i < this.numberOfEntries; i++) {
   			originalBagCopy.add(this.bag[i]);
   		}
   		
   		// If there is an element in parameterBagCopy that is also in originalBagCopy,
   		// remove the element in originalBagCopy
   		for(int i = 0; i < parameterBagCopy.length; i++) {
   			T tempElement = parameterBagCopy[i];
   			if (originalBagCopy.contains(tempElement)) {
   				originalBagCopy.remove(tempElement);
   			}
   		} 
   		return originalBagCopy;
   	} // end difference
} // end ResizableArrayBag