
public class LinkedBagTest {

	public static void main(String[] args) {
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

	}

}
