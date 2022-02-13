//client
import java.util.*;
public class ResizeableArrayBag {
public static ArrayList<String> bagNames;
protected static Map<String, bag> bags = new HashMap<String, bag>();
	public static void userInterfaceResize() {
		bagNames = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		String userInput = "";
		while(!((userInput.equals("q")) || (userInput.equals("Q")))) {
		System.out.println("Welcome to the bag");
		System.out.println("Type 'M' to make a new bag");
		System.out.println("Type 'A' to add an element to a bag");
		System.out.println("Type 'R' to remove an element from a bag");
		System.out.println("Type 'D' to delete a bag");
		System.out.println("Type 'L' to list every bag name created");
		System.out.println("Type 'U' to combine 2 bags");
		System.out.println("Type 'I' to intersect 2 bags");
		System.out.println("Type 'F' to get the difference between 2 bags");
		System.out.println("Type 'Q' to quit");
		System.out.println();
		userInput = sc.nextLine();
		
		if((userInput.equals("M")) || (userInput.equals("m"))) {
			//prompt user to make new bag
			System.out.println("Enter the bag name you want");
			String s = sc.nextLine();
			if(checkIfBagExists(s) == true) {
				System.out.println("bag already exists ");
				
			}
			else {
				
			newBag(s);
			}
		}
		if((userInput.equals("D")) || (userInput.equals("d"))) {
			System.out.println("Enter the bag name you want to delete");
			String g = sc.nextLine();
			deleteBag(g);
		}
		if((userInput.equals("A")) || (userInput.equals("a"))) {
			//Ask for which bag
			//then add element to that bag
			String bagN;
			String element;
			System.out.println("Enter the bag name ");
			bagN = sc.nextLine();
			if(checkIfBagExists(bagN) == false) {
				System.out.println("ERROR: bag does not exist!");
			}
			else {
			System.out.println("Enter the element to add ");
			element = sc.nextLine();
			addElement(bagN,element);
			}
		}
		if((userInput.equals("L")) || (userInput.equals("l"))) {
			System.out.println("type the bag name you want to list: ");
			String s = sc.nextLine();
			list(s);
		}
		if((userInput.equals("R")) || (userInput.equals("r"))) {
			//Ask which bag
			//then remove from that bag
			System.out.println("Enter the bag name you wanna remove an item from: ");
			String bagN = sc.nextLine();
			//list the items in the bag
			if(checkIfBagExists(bagN) == false) {
				System.out.println("ERROR: bag does not exist!");
			}
			else {
			list(bagN);			
			System.out.println("Do you want to remove all instances of an item name, or remove one item? ");
			System.out.println("Type 1 to remove all instances of an item name: ");
			System.out.println("Type 2 to remove one item from the list: ");
			String c = sc.nextLine();
			if(c.equals("1")) {
				System.out.println("Type the item name you want to remove from the bag: ");
				String g = sc.nextLine();
				bag b = bags.get(bagN);
				b.removeAppearanceOfItem(g);
			}
			else if(c.equals("2")) {
				System.out.println("Type the item postion you want to remove. Start counting at 1!: ");
				String u = sc.nextLine();
				removePostion(u,bagN);
			}
			else {
				System.out.println("Invalid input!");
			}
			}
		}
		if((userInput.equals("U")) || (userInput.equals("u"))) {
			System.out.println("Enter the first bag: ");
			String b1 = sc.nextLine();
			System.out.println("Enter the second bag: ");
			String b2 = sc.nextLine();
			System.out.println("Enter the new bag name: ");
			String n = sc.nextLine();
			union(b1,b2,n);
		}
		if((userInput.equals("I")) || (userInput.equals("i"))) {
			System.out.println("Enter the first bag: ");
			String b1 = sc.nextLine();
			System.out.println("Enter the second bag: ");
			String b2 = sc.nextLine();
			System.out.println("Enter the new bag name: ");
			String n = sc.nextLine();
			intersection(b1,b2,n);
		}
		if((userInput.equals("F")) || (userInput.equals("f"))) {
			System.out.println("Enter the first bag: ");
			String b1 = sc.nextLine();
			System.out.println("Enter the second bag: ");
			String b2 = sc.nextLine();
			System.out.println("Enter the new bag name: ");
			String n = sc.nextLine();
			difference(b1,b2,n);
		}
		
		
		}
	}
	public static boolean checkIfBagExists(String s) {
		//error handling 
		if(bags.get(s) == null) {
			return false;
		}
		else {
			return true;
		}
	}
	public static boolean checkIfBagIsNull(String s) {
		//this is assuming the bag exists
		//true -- bag is null
		bag b = bags.get(s);
		if(b.getXElement(0) == null) {
			return true;
			//bag is null
		}
		else {
			return false;
			//bag is not null
		}
		
	}
	public static void removePostion(String s, String name) {
		//error handle the user input here
		if(s.matches("-?\\d+(\\.\\d+)?") == false) {
			System.out.println("Invalid Input!");
		}
		else {
			if(checkIfBagExists(name) == false) {
				System.out.println("ERROR: bag does not exist!");
			}
			else {
				bag b = bags.get(name);
				int g = Integer.parseInt(s);
				if(b.doesPosExist(g) == false) {
					System.out.println("The number given is invalid!");
				}
				else {
					b.removeXElement(g);
				}
			}
		}
	}
	public static void list(String s) {
		//lists the items
		if(checkIfBagExists(s) == false) {
			System.out.println("ERROR: bag does not exist!");
		}
		else {
		bag b = bags.get(s);
		b.list();
		}
	}
	public static void newBag(String str) {
		bags.put(str, new bag(str));
		System.out.println("Bag created: " + str);
	}
	public static void deleteBag(String str) {
		//error handle and remove bag
		if(checkIfBagExists(str) == false) {
			System.out.println("ERROR: bag does not exist!");
		}
		else {
		bags.remove(str);
		}
	}
	public static void addElement(String bagN, String e) {
		bag b = bags.get(bagN);
		b.addItem(e);
	}
	
//phase 2 UI, union etc
	public static void union(String bag1, String bag2, String newBag) {
		if((checkIfBagExists(bag1) == false) || (checkIfBagExists(bag2) == false)) {
			System.out.println("ERROR: at least one bag does not exist!");
		}
		else {
			//make new bag for the combined and call union in BagInterface class
			newBag(newBag);
			
			BagInterface.union(bags.get(bag1),bags.get(bag2),bags.get(newBag));
		}
	}
	public static void intersection(String bag1, String bag2, String newBag) {
		if((checkIfBagExists(bag1) == false) || (checkIfBagExists(bag2) == false)) {
			System.out.println("ERROR: at least one bag does not exist!");
		}
		else {
			newBag(newBag);
			BagInterface.intersection(bags.get(bag1),bags.get(bag2),bags.get(newBag));
		}
	}
	public static void difference(String bag1, String bag2, String newBag) {
		if((checkIfBagExists(bag1) == false) || (checkIfBagExists(bag2) == false)) {
			System.out.println("ERROR: at least one bag does not exist!");
		}
		else {
			newBag(newBag);
			BagInterface.difference(bags.get(bag1),bags.get(bag2),bags.get(newBag));
		}
	}

}
