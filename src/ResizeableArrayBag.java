//client
import java.util.*;
public class ResizeableArrayBag {
public static ArrayList<String> bagNames;
protected static Map<String, bag> bags = new HashMap<String, bag>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BagInterface.union();
		BagInterface.intersection();
		BagInterface.difference();
		userInterface();
	}
	public static void userInterface() {
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
		System.out.println("Type 'Q' to quit");
		userInput = sc.nextLine();
		
		if((userInput.equals("M")) || (userInput.equals("m"))) {
			//prompt user to make new bag
			System.out.println("Enter the bag name you want");
			String s = sc.nextLine();
			if(bagNames.contains(s) == true) {
				System.out.println("bag already exists ");
				
			}
			else {
				
			newBag(s);
			}
		}
		if((userInput.equals("D")) || (userInput.equals("d"))) {
			System.out.println("Enter the bag name you want to delete");
			String g = sc.nextLine();
		}
		if((userInput.equals("A")) || (userInput.equals("a"))) {
			//Ask for which bag
			//then add element to that bag
			String bagN;
			String element;
			System.out.println("Enter the bag name ");
			bagN = sc.nextLine();
			System.out.println("Enter the element to add ");
			element = sc.nextLine();
			addElement(bagN,element);
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

		
		
		}
	}
	public static boolean checkIfBagExists(String s) {
		if(bags.get(s) == null) {
			return false;
		}
		else {
			return true;
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
		bag b = bags.get(s);
		b.list();
	}
	public static void newBag(String str) {
		bags.put(str, new bag(str));
		bagNames.add(str);	
		System.out.println("Bag created: " + str);
	}
	public static void deleteBag(String str) {
		//error handle and remove bag
		if(checkIfBagExists(str) == false) {
			System.out.println("ERROR: bag does not exist!");
		}
		else {
		for(int i = 0; i < bagNames.size(); i++) {
			if(bagNames.get(i) == str) {
				bagNames.remove(i);
			}
		}
		bags.remove(str);
		}
	}
	public static void addElement(String str, String e) {
		bag b = bags.get(str);
		b.addItem(e);
	}
	
	

}
