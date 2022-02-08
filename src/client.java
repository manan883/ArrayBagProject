import java.util.*;
public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//have user choose which type they want then call methods based on that 
		Start();
	}
	public static void Start() {
		Scanner sc = new Scanner(System.in);
		System.out.println("What type of bag do you want: \n1:LinkedBag\n2:ResizeableArrayBag\nType 1 or 2");
		String UI = sc.nextLine();
		if(UI.equals("1")) {
			LinkedBag.userInterfaceLinked();
		}
		else if(UI.equals("2")) {
			ResizeableArrayBag.userInterfaceResize();
		}
		else {
			System.out.println("Invalid Input!");
		}
	}

}
