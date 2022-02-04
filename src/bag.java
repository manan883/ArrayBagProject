import java.util.*;
public class bag {
protected static ArrayList<String> arr;

public bag(){
	arr = new ArrayList<String>();
}
public static void addItem(String s) {
	arr.add(s);
}
public static void removeFirstAppearanceOfItem(String s) {
	for(int i = 0; i < arr.size(); i++) {
		if(arr.get(i) == s) {
			arr.remove(i);
		}
	}
}

public static void removeXElement(int k) {
	arr.remove(k);
}
public static String findXElement(int k) {
	
	return arr.get(k);
}

}//end class
