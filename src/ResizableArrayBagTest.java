import static org.junit.Assert.*;

import org.junit.Test;

public class ResizableArrayBagTest {

	@Test
	public void test() {
		System.out.println("----- Resizable Array Bag Test -----");
		
		
		System.out.println("Union Tests:");
		System.out.println("Basic union between bag1 and bag 2");
		BagInterface<String> bag1 = new ResizableArrayBag<>();
		BagInterface<String> bag2 = new ResizableArrayBag<>();
		bag1.add("a");
		bag1.add("c");
		bag2.add("b");
		System.out.println("Bag 1: " + bag1);
		System.out.println("Bag 2: " + bag2);
		BagInterface<String> everything = bag1.union(bag2);
		System.out.println("Result Bag: " + everything);
		assertEquals("Result Bag: a c b ", "Result Bag: " + everything);
		System.out.println("");
		
		System.out.println("Intersection Tests:");
		System.out.println("Basic intersection between bag1 and bag 2");
		BagInterface<Integer> bag3 = new ResizableArrayBag<>();
		BagInterface<Integer> bag4 = new ResizableArrayBag<>();
		bag3.add(1);
		bag3.add(1);
		bag3.add(2);
		bag4.add(2);
		bag4.add(2);
		bag4.add(1);
		System.out.println("Bag 3: " + bag3);
		System.out.println("Bag 4: " + bag4);
		System.out.println("Result Bag: " + bag3.intersection(bag4));
		assertEquals("Result Bag: 2 1 ", "Result Bag: " + bag3.intersection(bag4));
		System.out.println("");
		
		System.out.println("Difference Tests:");
		System.out.println("Basic difference between bag1 and bag 2");
		BagInterface<Integer> bag5 = new ResizableArrayBag<>();
		BagInterface<Integer> bag6 = new ResizableArrayBag<>();
		bag5.add(1);
		bag5.add(2);
		bag5.add(3);
		bag5.add(4);
		bag6.add(1);
		bag6.add(2);
		bag6.add(3);
		bag6.add(5);
		System.out.println("Bag 5: " + bag5);
		System.out.println("Bag 6: " + bag6);
		System.out.println("Result Bag: " + bag5.difference(bag6));
		assertEquals("Result Bag: 4 ", "Result Bag: " + bag5.difference(bag6));

	}

}
