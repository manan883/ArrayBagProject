
public class BagDriver {

	public static void main(String[] args) {
		System.out.println("Welcome to BagDriver! This program is intended to showcase my code.");
		System.out.println("");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.println("First, let us initialize a few bags of the ResizableArrayBag type.");
		BagInterface<Integer> bag1 = new ResizableArrayBag<>();
		bag1.add(1);
		bag1.add(2);
		bag1.add(3);
		bag1.add(4);
		bag1.add(5);
		System.out.println("RA Bag 1: " + bag1);
		BagInterface<Integer> bag2 = new ResizableArrayBag<>();
		bag2.add(1);
		bag2.add(1);
		bag2.add(2);
		bag2.add(2);
		System.out.println("RA Bag 2: " + bag2);
		BagInterface<Integer> bag3 = new ResizableArrayBag<>();
		bag3.add(3);
		bag3.add(3);
		bag3.add(4);
		System.out.println("RA Bag 3: " + bag3);
		BagInterface<Integer> bag4 = new ResizableArrayBag<>();
		System.out.println("RA Bag 4: " + bag4);
		System.out.println("");
		System.out.println("Next, let us union bags 1+2 and 3+4 together.");
		System.out.println("RA Bag 1+2: " + bag1.union(bag2));
		System.out.println("RA Bag 3+4: " + bag3.union(bag4));
		System.out.println("");
		System.out.println("Next, let us find the intersections of bags 1&2 and 3&4.");
		System.out.println("RA Bag 1&2: " + bag1.intersection(bag2));
		System.out.println("RA Bag 3&4: " + bag3.intersection(bag4));
		System.out.println("");
		System.out.println("Lastly, let us find the differences between bags 1-2 and 3-4.");
		System.out.println("RA Bag 1-2: " + bag1.difference(bag2));
		System.out.println("RA Bag 3-4: " + bag3.difference(bag4));
		System.out.println("");
		System.out.println("--------------------------------------------------");
		System.out.println("");
		System.out.println("Now, I will be initializing four other bags of the LinkedBag type with the same elements as the ResizableArrayBag.");
		BagInterface<Integer> bag5 = new LinkedBag<>();
		bag5.add(1);
		bag5.add(2);
		bag5.add(3);
		bag5.add(4);
		bag5.add(5);
		System.out.println("L Bag 5: " + bag5);
		BagInterface<Integer> bag6 = new LinkedBag<>();
		bag6.add(1);
		bag6.add(1);
		bag6.add(2);
		bag6.add(2);
		System.out.println("L Bag 6: " + bag6);
		BagInterface<Integer> bag7 = new LinkedBag<>();
		bag7.add(3);
		bag7.add(3);
		bag7.add(4);
		System.out.println("L Bag 7: " + bag7);
		BagInterface<Integer> bag8 = new LinkedBag<>();
		System.out.println("L Bag 8: " + bag8);
		System.out.println("");
		System.out.println("Next, let us union bags 5+6 and 7+8 together.");
		System.out.println("L Bag 5+6: " + bag5.union(bag6));
		System.out.println("L Bag 7+8: " + bag7.union(bag8));
		System.out.println("");
		System.out.println("Next, let us find the intersections of bags 5&6 and 7&8.");
		System.out.println("L Bag 5&6: " + bag5.intersection(bag6));
		System.out.println("L Bag 7&8: " + bag7.intersection(bag8));
		System.out.println("");
		System.out.println("Lastly, let us find the differences between bags 5-6 and 7-8.");
		System.out.println("L Bag 5-6: " + bag5.difference(bag6));
		System.out.println("L Bag 7-8: " + bag7.difference(bag8));
	}

}
