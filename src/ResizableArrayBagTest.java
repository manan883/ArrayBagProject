import static org.junit.Assert.*;

import org.junit.Test;

public class ResizableArrayBagTest {

	@Test
	public void unionTest() {
		System.out.println("----- Resizable Array Bag Test -----");
		System.out.println("");
		
		System.out.println("");
		System.out.println(" *** Union Tests *** ");
		System.out.println("Test #1: Basic union between bag1 and bag 2");
		BagInterface<String> bag1 = new ResizableArrayBag<>();
		BagInterface<String> bag2 = new ResizableArrayBag<>();
		bag1.add("a");
		bag2.add("b");
		BagInterface<String> everything = bag1.union(bag2);
		assertEquals("Result Bag: a b ", "Result Bag: " + everything);
		System.out.println("Bag 1: " + bag1);
		System.out.println("Bag 2: " + bag2);
		System.out.println("Result Bag: " + everything);
		System.out.println("");
		
		System.out.println("Test #2: Union of bag3 and an empty bag4");
		BagInterface<String> bag3 = new ResizableArrayBag<>();
		BagInterface<String> bag4 = new ResizableArrayBag<>();
		bag3.add("a");
		BagInterface<String> everything2 = bag3.union(bag4);
		assertEquals("Result Bag: a ", "Result Bag: " + everything2);
		System.out.println("Bag 3: " + bag3);
		System.out.println("Bag 4: " + bag4);
		System.out.println("Result Bag: " + everything2);
		System.out.println("");
		
		System.out.println("Test #3: Union of an empty bag5 and bag6");
		BagInterface<String> bag5 = new ResizableArrayBag<>();
		BagInterface<String> bag6 = new ResizableArrayBag<>();
		bag6.add("b");		
		BagInterface<String> everything3 = bag5.union(bag6);
		assertEquals("Result Bag: b ", "Result Bag: " + everything3);
		System.out.println("Bag 5: " + bag5);
		System.out.println("Bag 6: " + bag6);
		System.out.println("Result Bag: " + everything3);
		System.out.println("");
		
		System.out.println("Test #4: Union of an empty bag7 and an empty bag8");
		BagInterface<String> bag7 = new ResizableArrayBag<>();
		BagInterface<String> bag8 = new ResizableArrayBag<>();
		BagInterface<String> everything4 = bag7.union(bag8);
		assertEquals("Result Bag: ", "Result Bag: " + everything4);
		System.out.println("Bag 7: " + bag7);
		System.out.println("Bag 8: " + bag8);
		System.out.println("Result Bag: " + everything4);
		System.out.println("");
		
		System.out.println("Test #5: Union of a bag9 and a null bag10");
		BagInterface<String> bag9 = new ResizableArrayBag<>();
		BagInterface<String> bag10 = null;
		bag9.add("b");
		var everything5 = assertThrows(NullPointerException.class, () -> {bag9.union(bag10);});
		System.out.println("Bag 9: " + bag9);
		System.out.println("Bag 10: " + bag10);
		System.out.println("Result Bag: " + everything5);
		System.out.println("");
		
		System.out.println("Test #6: Union of a bag11 and a bag12 with a null element");
		BagInterface<String> bag11 = new ResizableArrayBag<>();
		BagInterface<String> bag12 = new ResizableArrayBag<>();
		bag11.add("b");
		bag11.add("g");
		bag12.add("a");
		bag12.add(null);
		BagInterface<String> everything6 = bag11.union(bag12);
		assertEquals("Result Bag: b g a null ", "Result Bag: " + everything6);
		System.out.println("Bag 11: " + bag11);
		System.out.println("Bag 12: " + bag12);
		System.out.println("Result Bag: " + everything6);
		System.out.println("");
	} // end of unionTest
	
	@Test
	public void intersectionTest() {
		System.out.println("");
		System.out.println(" *** Intersection Tests *** ");
		System.out.println("Test #1: Basic intersection between bag1 and bag2");
		BagInterface<Integer> bag1 = new ResizableArrayBag<>();
		BagInterface<Integer> bag2 = new ResizableArrayBag<>();
		bag1.add(1);
		bag1.add(1);
		bag1.add(2);
		bag2.add(2);
		bag2.add(2);
		bag2.add(1);
		assertEquals("Result Bag: 2 1 ", "Result Bag: " + bag1.intersection(bag2));
		System.out.println("Bag 1: " + bag1);
		System.out.println("Bag 2: " + bag2);
		System.out.println("Result Bag: " + bag1.intersection(bag2));
		System.out.println("");
		
		System.out.println("Test #2: Intersection between smaller bag3 and bag4");
		BagInterface<Integer> bag3 = new ResizableArrayBag<>();
		BagInterface<Integer> bag4 = new ResizableArrayBag<>();
		bag3.add(1);
		bag4.add(2);
		bag4.add(3);
		bag4.add(1);
		bag4.add(1);
		assertEquals("Result Bag: 1 ", "Result Bag: " + bag3.intersection(bag4));
		System.out.println("Bag 3: " + bag3);
		System.out.println("Bag 4: " + bag4);
		System.out.println("Result Bag: " + bag3.intersection(bag4));
		System.out.println("");
		
		System.out.println("Test #3: Intersection between bag5 and smaller bag6");
		BagInterface<Integer> bag5 = new ResizableArrayBag<>();
		BagInterface<Integer> bag6 = new ResizableArrayBag<>();
		bag5.add(1);
		bag5.add(1);
		bag5.add(3);
		bag5.add(4);
		bag6.add(3);
		assertEquals("Result Bag: 3 ", "Result Bag: " + bag5.intersection(bag6));
		System.out.println("Bag 5: " + bag5);
		System.out.println("Bag 6: " + bag6);
		System.out.println("Result Bag: " + bag5.intersection(bag6));
		System.out.println("");
		
		System.out.println("Test #4: Intersection between two similiar bags, bag7 and  bag8");
		BagInterface<Integer> bag7 = new ResizableArrayBag<>();
		BagInterface<Integer> bag8 = new ResizableArrayBag<>();
		bag7.add(1);
		bag7.add(3);
		bag7.add(2);
		bag8.add(1);
		bag8.add(3);
		bag8.add(2);
		assertEquals("Result Bag: 1 3 2 ", "Result Bag: " + bag7.intersection(bag8));
		System.out.println("Bag 7: " + bag7);
		System.out.println("Bag 8: " + bag8);
		System.out.println("Result Bag: " + bag7.intersection(bag8));
		System.out.println("");
		
		System.out.println("Test #5: Intersection between an empty bag9 and bag10");
		BagInterface<Integer> bag9 = new ResizableArrayBag<>();
		BagInterface<Integer> bag10 = new ResizableArrayBag<>();
		bag10.add(1);
		bag10.add(3);
		bag10.add(2);
		assertEquals("Result Bag: ", "Result Bag: " + bag9.intersection(bag10));
		System.out.println("Bag 9: " + bag9);
		System.out.println("Bag 10: " + bag10);
		System.out.println("Result Bag: " + bag9.intersection(bag10));
		System.out.println("");
		
		System.out.println("Test #6: Intersection between bag11 and an empty bag12");
		BagInterface<Integer> bag11 = new ResizableArrayBag<>();
		BagInterface<Integer> bag12 = new ResizableArrayBag<>();
		bag11.add(1);
		bag11.add(3);
		bag11.add(2);
		assertEquals("Result Bag: ", "Result Bag: " + bag11.intersection(bag12));
		System.out.println("Bag 11: " + bag11);
		System.out.println("Bag 12: " + bag12);
		System.out.println("Result Bag: " + bag11.intersection(bag12));
		System.out.println("");
		
		System.out.println("Test #7: Intersection between an empty bag13 and an empty bag14");
		BagInterface<Integer> bag13 = new ResizableArrayBag<>();
		BagInterface<Integer> bag14 = new ResizableArrayBag<>();
		assertEquals("Result Bag: ", "Result Bag: " + bag13.intersection(bag14));
		System.out.println("Bag 13: " + bag13);
		System.out.println("Bag 14: " + bag14);
		System.out.println("Result Bag: " + bag13.intersection(bag14));
		System.out.println("");
		
		System.out.println("Test #8: Intersection between a bag15 with an element null and a null bag16");
		BagInterface<Integer> bag15 = new ResizableArrayBag<>();
		BagInterface<Integer> bag16 = null;
		bag15.add(5);
		bag15.add(null);
		bag15.add(7);
		var commonItems = assertThrows(NullPointerException.class, () -> {bag15.intersection(bag16);});
		System.out.println("Bag 15: " + bag15);
		System.out.println("Bag 16: " + bag16);
		System.out.println("Result Bag: " + commonItems);
		System.out.println("");
	} // end of intersectionTest
	
	@Test
	public void differenceTest() {
		System.out.println("");
		System.out.println(" *** Difference Tests *** ");
		System.out.println("Test #1: Basic difference between bag1 and bag 2");
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
		assertEquals("Result Bag: 4 ", "Result Bag: " + bag1.difference(bag2));
		System.out.println("Bag 1: " + bag1);
		System.out.println("Bag 1: " + bag2);
		System.out.println("Result Bag: " + bag1.difference(bag2));
		System.out.println("");

		System.out.println("Test #2: Difference between smaller bag3 and bag4");
		BagInterface<Integer> bag3 = new ResizableArrayBag<>();
		BagInterface<Integer> bag4 = new ResizableArrayBag<>();
		bag3.add(1);
		bag3.add(4);
		bag4.add(2);
		bag4.add(3);
		bag4.add(1);
		bag4.add(1);
		assertEquals("Result Bag: 4 ", "Result Bag: " + bag3.difference(bag4));
		System.out.println("Bag 3: " + bag3);
		System.out.println("Bag 4: " + bag4);
		System.out.println("Result Bag: " + bag3.difference(bag4));
		System.out.println("");
		
		System.out.println("Test #3: Differnece between bag5 and smaller bag6");
		BagInterface<Integer> bag5 = new ResizableArrayBag<>();
		BagInterface<Integer> bag6 = new ResizableArrayBag<>();
		bag5.add(1);
		bag5.add(1);
		bag5.add(3);
		bag5.add(4);
		bag6.add(3);
		assertEquals("Result Bag: 1 1 4 ", "Result Bag: " + bag5.difference(bag6));
		System.out.println("Bag 5: " + bag5);
		System.out.println("Bag 6: " + bag6);
		System.out.println("Result Bag: " + bag5.difference(bag6));
		System.out.println("");
		
		System.out.println("Test #4: Difference between two similiar bags, bag7 and  bag8");
		BagInterface<Integer> bag7 = new ResizableArrayBag<>();
		BagInterface<Integer> bag8 = new ResizableArrayBag<>();
		bag7.add(1);
		bag7.add(3);
		bag7.add(2);
		bag8.add(1);
		bag8.add(3);
		bag8.add(2);
		assertEquals("Result Bag: ", "Result Bag: " + bag7.difference(bag8));
		System.out.println("Bag 7: " + bag7);
		System.out.println("Bag 8: " + bag8);
		System.out.println("Result Bag: " + bag7.difference(bag8));
		System.out.println("");
		
		System.out.println("Test #5: Difference between an empty bag9 and bag10");
		BagInterface<Integer> bag9 = new ResizableArrayBag<>();
		BagInterface<Integer> bag10 = new ResizableArrayBag<>();
		bag10.add(1);
		bag10.add(3);
		bag10.add(2);
		assertEquals("Result Bag: ", "Result Bag: " + bag9.difference(bag10));
		System.out.println("Bag 9: " + bag9);
		System.out.println("Bag 10: " + bag10);
		System.out.println("Result Bag: " + bag9.difference(bag10));
		System.out.println("");
		
		System.out.println("Test #6: Difference between bag11 and an empty bag12");
		BagInterface<Integer> bag11 = new ResizableArrayBag<>();
		BagInterface<Integer> bag12 = new ResizableArrayBag<>();
		bag11.add(1);
		bag11.add(3);
		bag11.add(2);
		assertEquals("Result Bag: 1 3 2 ", "Result Bag: " + bag11.difference(bag12));
		System.out.println("Bag 11: " + bag11);
		System.out.println("Bag 12: " + bag12);
		System.out.println("Result Bag: " + bag11.difference(bag12));
		System.out.println("");
		
		System.out.println("Test #7: Difference between an empty bag13 and an empty bag14");
		BagInterface<Integer> bag13 = new ResizableArrayBag<>();
		BagInterface<Integer> bag14 = new ResizableArrayBag<>();
		assertEquals("Result Bag: ", "Result Bag: " + bag13.difference(bag14));
		System.out.println("Bag 13: " + bag13);
		System.out.println("Bag 14: " + bag14);
		System.out.println("Result Bag: " + bag13.difference(bag14));
		System.out.println("");
		
		System.out.println("Test #8: Difference between a bag15 with an element null and a null bag16");
		BagInterface<Integer> bag15 = new ResizableArrayBag<>();
		BagInterface<Integer> bag16 = null;
		bag15.add(5);
		bag15.add(null);
		bag15.add(7);
		var commonItems = assertThrows(NullPointerException.class, () -> {bag15.difference(bag16);});
		System.out.println("Bag 15: " + bag15);
		System.out.println("Bag 16: " + bag16);
		System.out.println("Result Bag: " + commonItems);
		System.out.println("");
	} //end of differenceTest
}
