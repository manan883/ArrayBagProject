
public class ResizableArrayBagTest {

	public static void main(String[] args) {
		System.out.println("----- Resizable Array Bag Test -----");
		System.out.println("Union Tests:");
		BagInterface<Integer> bag1 = new ResizableArrayBag<>();
		BagInterface<Integer> bag2 = new ResizableArrayBag<>();
		bag1.add(1);
		bag2.add(2);
		bag2.add(3);
		System.out.println("Bag 1: " + bag1);
		System.out.println("Bag 2: " + bag2);
		System.out.println(bag1.union(bag2));
		
		BagInterface<Integer> bag7 = new ResizableArrayBag<>();
		BagInterface<Integer> bag8 = null;
		bag7.add(5);
		System.out.println("Bag 7: " + bag7);
		System.out.println("Bag 8: " + bag8);
		System.out.println(bag7.union(bag8));

		System.out.println("");
		System.out.println("Intersection Tests:");
		BagInterface<Integer> bag3 = new ResizableArrayBag<>();
		BagInterface<Integer> bag4 = new ResizableArrayBag<>();
		bag3.add(1);
		bag3.add(2);
		bag3.add(2);
		bag4.add(1);
		bag4.add(1);
		bag4.add(2);
		System.out.println("Bag 3: " + bag3);
		System.out.println("Bag 4: " + bag4);
		System.out.println(bag3.intersection(bag4));
		
		System.out.println("");
		System.out.println("Difference Tests:");
		BagInterface<Integer> bag5 = new ResizableArrayBag<>();
		BagInterface<Integer> bag6 = new ResizableArrayBag<>();
		bag5.add(1);
		bag5.add(2);
		bag5.add(3);
		bag5.add(4);
		bag6.add(1);
		bag6.add(1);
		bag6.add(2);
		bag6.add(5);
		System.out.println("Bag 5: " + bag5);
		System.out.println("Bag 6: " + bag6);
		System.out.println(bag5.difference(bag6));
	}

}
