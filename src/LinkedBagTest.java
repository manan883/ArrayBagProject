import java.util.*;

//client
public class LinkedBagTest {
	protected static ArrayList<String> arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}
	public static void test() {
		arr = new ArrayList<String>();
		arr.add("Apples");
		arr.add("Oranges");
		arr.add("lemons");
		arr.add("limes");
		arr.add("lmao");
		arr.add("testing");
		arr.add("item");
		Random r = new Random();
	for(int i = 0; i < 3; i++) {
			
			int m = r.nextInt(9);
			LinkedBag.newBag("bag" + i);
			for(int j = 0; j < m; j++) {
				int l = r.nextInt(arr.size()-1);
				LinkedBag.addElement(("bag" + i), arr.get(l));
			}
			System.out.println("OG list" + i);
			LinkedBag.list("bag" + i);
			System.out.println();
			System.out.println("Difference output ");
			LinkedBag.difference("bag" + i, "bag0", "newBag" + i);
			System.out.println();

		}
	}
}
