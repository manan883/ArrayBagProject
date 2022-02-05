import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
class ResizeableArrayBagTest {
	protected static ArrayList<String> arr;
	public static void main(String[] args) {
		test();
	}
	public static void test(){
		arr = new ArrayList<String>();
		arr.add("Apples");
		arr.add("Oranges");
		arr.add("lemons");
		arr.add("limes");
		arr.add("lmao");
		arr.add("lmao");
		arr.add("lmao");
		arr.add("testing");
		arr.add("item");
		Random r = new Random();
		for(int i = 0; i < 9; i++) {
			
			int m = r.nextInt(9);
			ResizeableArrayBag.newBag("bag" + i);
			for(int j = 0; j < m; j++) {
				int l = r.nextInt(arr.size()-1);
				ResizeableArrayBag.addElement(("bag" + i), arr.get(l));
			}
			System.out.println("OG list" + i);
			ResizeableArrayBag.list("bag" + i);
			System.out.println();
			System.out.println("Difference output ");
			ResizeableArrayBag.difference("bag" + i, "bag0", "newBag" + i);
			System.out.println();

		}
		
		
	}
	
	
	
}
