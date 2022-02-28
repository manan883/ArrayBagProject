import static org.junit.Assert.*;

import org.junit.Test;

public class ResizableArrayBagTest {

	@Test
	public void unionTest() {
		System.out.println("----- Resizable Array Bag Test -----");
		System.out.println("");
		
		System.out.println(" *** Union Tests *** ");
		System.out.println("Basic union between bag1 and bag 2");
		BagInterface<String> bag1 = new ResizableArrayBag<>();
		BagInterface<String> bag2 = new ResizableArrayBag<>();
		bag1.add("a");
		bag2.add("b");
		System.out.println("Bag 1: " + bag1);
		System.out.println("Bag 2: " + bag2);
		BagInterface<String> everything = bag1.union(bag2);
		System.out.println("Result Bag: " + everything);
		assertEquals("Result Bag: a b ", "Result Bag: " + everything);
		System.out.println("");
		
		System.out.println("Union of bag3 and an empty bag4");
		BagInterface<String> bag3 = new ResizableArrayBag<>();
		BagInterface<String> bag4 = new ResizableArrayBag<>();
		bag3.add("a");
		System.out.println("Bag 3: " + bag3);
		System.out.println("Bag 4: " + bag4);
		BagInterface<String> everything2 = bag3.union(bag4);
		System.out.println("Result Bag: " + everything2);
		assertEquals("Result Bag: a ", "Result Bag: " + everything2);
		System.out.println("");
		
		System.out.println("Union of an empty bag5 and bag6");
		BagInterface<String> bag5 = new ResizableArrayBag<>();
		BagInterface<String> bag6 = new ResizableArrayBag<>();
		bag6.add("b");
		System.out.println("Bag 5: " + bag5);
		System.out.println("Bag 6: " + bag6);
		BagInterface<String> everything3 = bag5.union(bag6);
		System.out.println("Result Bag: " + everything3);
		assertEquals("Result Bag: b ", "Result Bag: " + everything3);
		System.out.println("");
		
		System.out.println("Union of an empty bag7 and an empty bag8");
		BagInterface<String> bag7 = new ResizableArrayBag<>();
		BagInterface<String> bag8 = new ResizableArrayBag<>();
		System.out.println("Bag 7: " + bag7);
		System.out.println("Bag 8: " + bag8);
		BagInterface<String> everything4 = bag7.union(bag8);
		System.out.println("Result Bag: " + everything4);
		assertEquals("Result Bag: ", "Result Bag: " + everything4);
		System.out.println("");
	} // end of unionTest
	
	@Test
	public void intersectionTest() {
		System.out.println(" *** Intersection Tests *** ");
		System.out.println("Basic intersection between bag1 and bag2");
		BagInterface<Integer> bag1 = new ResizableArrayBag<>();
		BagInterface<Integer> bag2 = new ResizableArrayBag<>();
		bag1.add(1);
		bag1.add(1);
		bag1.add(2);
		bag2.add(2);
		bag2.add(2);
		bag2.add(1);
		System.out.println("Bag 1: " + bag1);
		System.out.println("Bag 2: " + bag2);
		System.out.println("Result Bag: " + bag1.intersection(bag2));
		assertEquals("Result Bag: 2 1 ", "Result Bag: " + bag1.intersection(bag2));
		System.out.println("");
		
		System.out.println("Intersection between smaller bag3 and bag4");
		BagInterface<Integer> bag3 = new ResizableArrayBag<>();
		BagInterface<Integer> bag4 = new ResizableArrayBag<>();
		bag3.add(1);
		bag4.add(2);
		bag4.add(3);
		bag4.add(1);
		bag4.add(1);
		System.out.println("Bag 3: " + bag3);
		System.out.println("Bag 4: " + bag4);
		System.out.println("Result Bag: " + bag3.intersection(bag4));
		assertEquals("Result Bag: 1 ", "Result Bag: " + bag3.intersection(bag4));
		System.out.println("");
		
		System.out.println("Intersection between bag5 and smaller bag6");
		BagInterface<Integer> bag5 = new ResizableArrayBag<>();
		BagInterface<Integer> bag6 = new ResizableArrayBag<>();
		bag5.add(1);
		bag5.add(1);
		bag5.add(3);
		bag5.add(4);
		bag6.add(3);
		System.out.println("Bag 5: " + bag5);
		System.out.println("Bag 6: " + bag6);
		System.out.println("Result Bag: " + bag5.intersection(bag6));
		assertEquals("Result Bag: 3 ", "Result Bag: " + bag5.intersection(bag6));
		System.out.println("");
		
		System.out.println("Intersection between two similiar bags, bag7 and  bag8");
		BagInterface<Integer> bag7 = new ResizableArrayBag<>();
		BagInterface<Integer> bag8 = new ResizableArrayBag<>();
		bag7.add(1);
		bag7.add(3);
		bag7.add(2);
		bag8.add(1);
		bag8.add(3);
		bag8.add(2);
		System.out.println("Bag 7: " + bag7);
		System.out.println("Bag 8: " + bag8);
		System.out.println("Result Bag: " + bag7.intersection(bag8));
		assertEquals("Result Bag: 1 3 2 ", "Result Bag: " + bag7.intersection(bag8));
		System.out.println("");
		
		System.out.println("Intersection between an empty bag9 and bag10");
		BagInterface<Integer> bag9 = new ResizableArrayBag<>();
		BagInterface<Integer> bag10 = new ResizableArrayBag<>();
		bag10.add(1);
		bag10.add(3);
		bag10.add(2);
		System.out.println("Bag 9: " + bag9);
		System.out.println("Bag 10: " + bag10);
		System.out.println("Result Bag: " + bag9.intersection(bag10));
		assertEquals("Result Bag: ", "Result Bag: " + bag9.intersection(bag10));
		System.out.println("");
		
		System.out.println("Intersection between bag11 and an empty bag12");
		BagInterface<Integer> bag11 = new ResizableArrayBag<>();
		BagInterface<Integer> bag12 = new ResizableArrayBag<>();
		bag11.add(1);
		bag11.add(3);
		bag11.add(2);
		System.out.println("Bag 11: " + bag11);
		System.out.println("Bag 12: " + bag12);
		System.out.println("Result Bag: " + bag11.intersection(bag12));
		assertEquals("Result Bag: ", "Result Bag: " + bag11.intersection(bag12));
		System.out.println("");
		
		System.out.println("Intersection between an empty bag13 and an empty bag14");
		BagInterface<Integer> bag13 = new ResizableArrayBag<>();
		BagInterface<Integer> bag14 = new ResizableArrayBag<>();
		System.out.println("Bag 13: " + bag13);
		System.out.println("Bag 14: " + bag14);
		System.out.println("Result Bag: " + bag13.intersection(bag14));
		assertEquals("Result Bag: ", "Result Bag: " + bag13.intersection(bag14));
		System.out.println("");
	} // end of intersectionTest
	
	@Test
	public void differenceTest() {
		System.out.println(" *** Difference Tests *** ");
		System.out.println("Basic difference between bag1 and bag 2");
		BagInterface<Integer> bag1 = new ResizableArrayBag<>();
		BagInterface<Integer> bag2 = new ResizableArrayBag<>();
		bag1.add(1);
		bag1.add(2);
		bag1.add(3);
		bag1.add(4);
		bag2.add(1);
		bag2.add(2);
		bag2.add(3);
		bag2.add(5);
		System.out.println("Bag 1: " + bag1);
		System.out.println("Bag 1: " + bag2);
		System.out.println("Result Bag: " + bag1.difference(bag2));
		assertEquals("Result Bag: 4 ", "Result Bag: " + bag1.difference(bag2));
		System.out.println("");

		System.out.println("Difference between smaller bag3 and bag4");
		BagInterface<Integer> bag3 = new ResizableArrayBag<>();
		BagInterface<Integer> bag4 = new ResizableArrayBag<>();
		bag3.add(1);
		bag3.add(4);
		bag4.add(2);
		bag4.add(3);
		bag4.add(1);
		bag4.add(1);
		System.out.println("Bag 3: " + bag3);
		System.out.println("Bag 4: " + bag4);
		System.out.println("Result Bag: " + bag3.difference(bag4));
		assertEquals("Result Bag: 4 ", "Result Bag: " + bag3.difference(bag4));
		System.out.println("");
		
		System.out.println("Differnece between bag5 and smaller bag6");
		BagInterface<Integer> bag5 = new ResizableArrayBag<>();
		BagInterface<Integer> bag6 = new ResizableArrayBag<>();
		bag5.add(1);
		bag5.add(1);
		bag5.add(3);
		bag5.add(4);
		bag6.add(3);
		System.out.println("Bag 5: " + bag5);
		System.out.println("Bag 6: " + bag6);
		System.out.println("Result Bag: " + bag5.difference(bag6));
		assertEquals("Result Bag: 1 1 4 ", "Result Bag: " + bag5.difference(bag6));
		System.out.println("");
		
		System.out.println("Difference between two similiar bags, bag7 and  bag8");
		BagInterface<Integer> bag7 = new ResizableArrayBag<>();
		BagInterface<Integer> bag8 = new ResizableArrayBag<>();
		bag7.add(1);
		bag7.add(3);
		bag7.add(2);
		bag8.add(1);
		bag8.add(3);
		bag8.add(2);
		System.out.println("Bag 7: " + bag7);
		System.out.println("Bag 8: " + bag8);
		System.out.println("Result Bag: " + bag7.difference(bag8));
		assertEquals("Result Bag: ", "Result Bag: " + bag7.difference(bag8));
		System.out.println("");
		
		System.out.println("Difference between an empty bag9 and bag10");
		BagInterface<Integer> bag9 = new ResizableArrayBag<>();
		BagInterface<Integer> bag10 = new ResizableArrayBag<>();
		bag10.add(1);
		bag10.add(3);
		bag10.add(2);
		System.out.println("Bag 9: " + bag9);
		System.out.println("Bag 10: " + bag10);
		System.out.println("Result Bag: " + bag9.difference(bag10));
		assertEquals("Result Bag: ", "Result Bag: " + bag9.difference(bag10));
		System.out.println("");
		
		System.out.println("Difference between bag11 and an empty bag12");
		BagInterface<Integer> bag11 = new ResizableArrayBag<>();
		BagInterface<Integer> bag12 = new ResizableArrayBag<>();
		bag11.add(1);
		bag11.add(3);
		bag11.add(2);
		System.out.println("Bag 11: " + bag11);
		System.out.println("Bag 12: " + bag12);
		System.out.println("Result Bag: " + bag11.difference(bag12));
		assertEquals("Result Bag: 1 3 2 ", "Result Bag: " + bag11.difference(bag12));
		System.out.println("");
		
		System.out.println("Difference between an empty bag13 and an empty bag14");
		BagInterface<Integer> bag13 = new ResizableArrayBag<>();
		BagInterface<Integer> bag14 = new ResizableArrayBag<>();
		System.out.println("Bag 13: " + bag13);
		System.out.println("Bag 14: " + bag14);
		System.out.println("Result Bag: " + bag13.difference(bag14));
		assertEquals("Result Bag: ", "Result Bag: " + bag13.difference(bag14));
		System.out.println("");
	} //end of differenceTest
}
