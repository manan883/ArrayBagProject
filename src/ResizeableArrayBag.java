//client
import java.util.*;
public class ResizeableArrayBag {
public static ArrayList<String> bagNames;
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
		
		if(userInput.equals("M")) {
			//prompt user to make new bag
			System.out.println("Enter the bag name you want");
			String s = sc.nextLine();
			newBag(s);
		}
		if(userInput.equals("D")) {
			System.out.println("Enter the bag name you want to delete");
			String g = sc.nextLine();
		}
		if(userInput.equals("A")) {
			//Ask for which bag
			//then add element to that bag
		}
		if(userInput.equals("R")) {
			//Ask which bag
			//then remove from that bag
		}
		
		}
	}
	public static void newBag(String str) {
		bag bag = new bag(str);
		bagNames.add(str);		
	}
	public static void deleteBag(String str) {
		//all this does is delete it from the list of names so its simpler for the user to use
		for(int i = 0; i < bagNames.size(); i++) {
			if(bagNames.get(i) == str) {
				bagNames.remove(i);
			}
		}
	}
	

}
