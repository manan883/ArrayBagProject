public class BagInterfaceLinked {
	public static int c = 0;
	public static void union(bagLinked bag1, bagLinked bag2, bagLinked newBag) {
		for(int i = 0; i < bag1.arr.length; i++) {
			LinkedBag.addElement(newBag.getName(),bag1.getXElement(i));
		}
		for(int j = 0; j < bag2.arr.length; j++) {
			LinkedBag.addElement(newBag.getName(),bag2.getXElement(j));
		}
		System.out.println("Bags " + bag1.getName() + " and " + bag2.getName() + " have been combined into bag " + newBag.getName());
		System.out.println("The new bag is listed below: ");
		LinkedBag.list(newBag.getName());
	}
	public static void intersection(bagLinked bag1, bagLinked bag2, bagLinked newBag) {
		// check which elements are in both bags and put them in the new one
		//check which bag is bigger
		//nested loop big to small and cross check on each one 
		
		if(bag1.arr.length > bag2.arr.length) {
			//bag1 is outer loop
			for(int i = 0; i < bag1.arr.length; i++) {
				for(int j = 0; j < bag2.arr.length; j++) {
					if(bag1.arr[i].equals(bag2.arr[i])) {
						LinkedBag.addElement(newBag.getName(),bag1.getXElement(i));
					}
				}
			}
		}
		else if(bag2.arr.length > bag1.arr.length) {
			//bag 2 is outer loop
			for(int i = 0; i < bag2.arr.length; i++) {
				for(int j = 0; j < bag1.arr.length; j++) {
					if(bag2.arr[i].equals(bag1.arr[i])) {
						LinkedBag.addElement(newBag.getName(),bag2.getXElement(i));
					}
				}
			}
			
		}
		else {
			//equal sizing 
			//any one is on the outside
			for(int i = 0; i < bag1.arr.length; i++) {
				for(int j = 0; j < bag2.arr.length; j++) {
					if(bag1.arr[i].equals(bag2.arr[i])) {
						LinkedBag.addElement(newBag.getName(),bag1.getXElement(i));
					}
				}
			}
		}
		System.out.println("The new bag is listed below: ");
		LinkedBag.list(newBag.getName());
	}
	public static void difference(bagLinked bag1, bagLinked bag2, bagLinked newBag) {

		if(bag1.arr.length > bag2.arr.length) {
			//bag1 is outer loop
			for(int i = 0; i < bag1.arr.length; i++) {
				for(int j = 0; j < bag2.arr.length; j++) {
					if((bag1.arr[i].equals(bag2.arr[i]))) {
						
					}
					else {
						LinkedBag.addElement(newBag.getName(),bag1.getXElement(i));
					}
				}
			}
		}
		else if(bag2.arr.length > bag1.arr.length) {
			//bag 2 is outer loop
			for(int i = 0; i < bag2.arr.length; i++) {
				for(int j = 0; j < bag1.arr.length; j++) {
					if((bag2.arr[i].equals(bag1.arr[i]))) {
					}
					else {
						LinkedBag.addElement(newBag.getName(),bag2.getXElement(i));

					}
				}
			}
			
		}
		else {
			//equal sizing 
			//any one is on the outside
			for(int i = 0; i < bag1.arr.length; i++) {
				for(int j = 0; j < bag2.arr.length; j++) {
					if((bag1.arr[i].equals(bag2.arr[i]))) {
					}
					else {
						LinkedBag.addElement(newBag.getName(),bag1.getXElement(i));

					}
				}
			}
		}
		System.out.println("The new bag is listed below: ");
		LinkedBag.list(newBag.getName());
	}
}
