
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

	}

}
