import java.util.*;
public class BagInterface {
public static int c = 0;
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
	public static void intersection(bag bag1, bag bag2, bag newBag) {
		// check which elements are in both bags and put them in the new one
		//check which bag is bigger
		//nested loop big to small and cross check on each one 
		
		if(bag1.arr.size() > bag2.arr.size()) {
			//bag1 is outer loop
			for(int i = 0; i < bag1.arr.size(); i++) {
				for(int j = 0; j < bag2.arr.size(); j++) {
					if(bag1.arr.get(i).equals(bag2.arr.get(j))) {
						ResizeableArrayBag.addElement(newBag.getName(),bag1.getXElement(i));
					}
				}
			}
		}
		else if(bag2.arr.size() > bag1.arr.size()) {
			//bag 2 is outer loop
			for(int i = 0; i < bag2.arr.size(); i++) {
				for(int j = 0; j < bag1.arr.size(); j++) {
					if(bag2.arr.get(i).equals(bag1.arr.get(j))) {
						ResizeableArrayBag.addElement(newBag.getName(),bag2.getXElement(i));
					}
				}
			}
			
		}
		else {
			//equal sizing 
			//any one is on the outside
			for(int i = 0; i < bag1.arr.size(); i++) {
				for(int j = 0; j < bag2.arr.size(); j++) {
					if(bag1.arr.get(i).equals(bag2.arr.get(j))) {
						ResizeableArrayBag.addElement(newBag.getName(),bag1.getXElement(i));
					}
				}
			}
		}
		System.out.println("The new bag is listed below: ");
		ResizeableArrayBag.list(newBag.getName());
	}
	public static void difference(bag bag1, bag bag2, bag newBag) {
		newBag.arr = new ArrayList<String>();
		newBag.arr.addAll(bag1.arr);
		//newBag.arr.removeAll(bag2.arr);
		for(int i = 0; i < bag2.arr.size(); i++) {
			c = i;
			newBag.arr.removeIf(n -> (n == bag2.getXElement(c)));
		}
//		if(bag1.arr.size() > bag2.arr.size()) {
//			//bag1 is outer loop
//			for(int i = 0; i < bag1.arr.size(); i++) {
//				for(int j = 0; j < bag2.arr.size(); j++) {
//					if((bag1.arr.get(i).equals(bag2.arr.get(j)))) {
//						
//					}
//					else {
//						ResizeableArrayBag.addElement(newBag.getName(),bag1.getXElement(i));
//					}
//				}
//			}
//		}
//		else if(bag2.arr.size() > bag1.arr.size()) {
//			//bag 2 is outer loop
//			for(int i = 0; i < bag2.arr.size(); i++) {
//				for(int j = 0; j < bag1.arr.size(); j++) {
//					if((bag2.arr.get(i).equals(bag1.arr.get(j)))) {
//					}
//					else {
//						ResizeableArrayBag.addElement(newBag.getName(),bag2.getXElement(i));
//
//					}
//				}
//			}
//			
//		}
//		else {
//			//equal sizing 
//			//any one is on the outside
//			for(int i = 0; i < bag1.arr.size(); i++) {
//				for(int j = 0; j < bag2.arr.size(); j++) {
//					if((bag1.arr.get(i).equals(bag2.arr.get(j)))) {
//					}
//					else {
//						ResizeableArrayBag.addElement(newBag.getName(),bag1.getXElement(i));
//
//					}
//				}
//			}
//		}
		System.out.println("The new bag is listed below: ");
		ResizeableArrayBag.list(newBag.getName());
	}

}
