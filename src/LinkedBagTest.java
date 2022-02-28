import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedBagTest {

	@Test
	public void unionTest() {
		System.out.println("----- Linked Bag Test -----");
		System.out.println("");
		
		System.out.println(" *** Union Tests *** ");
		System.out.println("Basic union between bag1 and bag 2");
		BagInterface<String> bag1 = new LinkedBag<>();
		BagInterface<String> bag2 = new LinkedBag<>();
		bag1.add("a");
		bag2.add("b");
		System.out.println("Bag 1: " + bag1);
		System.out.println("Bag 2: " + bag2);
		BagInterface<String> everything = bag1.union(bag2);
		System.out.println("Result Bag: " + everything);
		assertEquals("Result Bag: b a ", "Result Bag: " + everything);
		System.out.println("");
	}

}
