import java.util.*;
public class bag {
protected static ArrayList<String> arr;
protected static String bagName;
public bag(String name){
	arr = new ArrayList<String>();
	bagName = name;
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
public static String getXElement(int x) {
	
	return arr.get(x);
}
public static String getName() {
	return bagName;
}
}//end class
