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
			//test
			System.out.println("type bag name ");
			String s = sc.nextLine();
			bag b = bags.get(s);
			System.out.println(b.getXElement(0));
		}
		if((userInput.equals("R")) || (userInput.equals("r"))) {
			//Ask which bag
			//then remove from that bag
		}
		if(userInput.equals("1")) {
//			bags.put("test", new bag("test"));
//			bags.put("hem", new bag("hem"));
//			System.out.println(bags);
//			System.out.println("reference to test");
//			bag b = bags.get("test");
//			System.out.println(b + " B");
//			b.addItem("gfdgfd");
//			System.out.println(b.getXElement(0));
//			bag d = bags.get("hem");
//			System.out.println(d + " D");
//			d.addItem("hfskdfhksd");
//			System.out.println(d.getXElement(1));
//			System.out.println(bags);
			bag b = new bag("gfdg");
			bag d = new bag("hi");
//			b.addItem("fsdfds");
//			d.addItem("hi");
			System.out.println(b.getName());
			System.out.println(d);
		}
		
		
		}
	}
	public static void newBag(String str) {
		bags.put(str, new bag(str));
		bagNames.add(str);	
		System.out.println("Bag created: " + str);
	}
	public static void deleteBag(String str) {
		//all this does is delete it from the list of names so its simpler for the user to use
		for(int i = 0; i < bagNames.size(); i++) {
			if(bagNames.get(i) == str) {
				bagNames.remove(i);
			}
		}
	}
	public static void addElement(String str, String e) {
		bag b = bags.get(str);
		b.addItem(e);
	}
	

}
