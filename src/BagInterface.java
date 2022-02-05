//client
public class BagInterface {

	public static void union(bag bag1, bag bag2, bag newBag) {
		for(int i = 0; i < bag1.arr.size(); i++) {
			ResizeableArrayBag.addElement(newBag.getName(),bag1.getXElement(i));
		}
		for(int j = 0; j < bag2.arr.size(); j++) {
			ResizeableArrayBag.addElement(newBag.getName(),bag2.getXElement(j));
		}
		System.out.println("Bags " + bag1.getName() + " and " + bag2.getName() + " have been combined into bag " + newBag.getName());
		System.out.println("The new bag is listed below: ");
		ResizeableArrayBag.list(newBag.getName());
	}
	public static void intersection() {
		
	}
	public static void difference() {
		
	}

}
