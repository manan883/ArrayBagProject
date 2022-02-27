
public class LinkedBagTest {

	public static void main(String[] args) {
		System.out.println("Union Tests:");
		BagInterface<Integer> bag1 = new LinkedBag<>();
		BagInterface<Integer> bag2 = new LinkedBag<>();
		bag1.add(1);
		bag1.add(2);
		bag2.add(4);
		bag2.add(5);
		System.out.println("Bag 1: " + bag1);
		System.out.println("Bag 2: " + bag2);
		BagInterface<Integer> everything = bag1.union(bag2);
		System.out.println(everything);
		
		System.out.println("");
		System.out.println("Intersection Tests:");
		BagInterface<Integer> bag3 = new LinkedBag<>();
		BagInterface<Integer> bag4 = new LinkedBag<>();
		bag3.add(1);
		bag3.add(1);
		bag4.add(1);
		bag4.add(3);
		bag4.add(4);
		System.out.println("Bag 3: " + bag3);
		System.out.println("Bag 4: " + bag4);
		System.out.println(bag3.intersection(bag4));
		
		System.out.println("");
		System.out.println("Difference Tests:");
		BagInterface<Integer> bag5 = new LinkedBag<>();
		BagInterface<Integer> bag6 = new LinkedBag<>();
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
