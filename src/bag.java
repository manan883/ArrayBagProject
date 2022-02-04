import java.util.*;
public class bag {
private static ArrayList<String> arr = new ArrayList<String>();;
private static String bagName = "";
public bag(String name){
	arr = new ArrayList<String>();
	bagName = name;
}
public void addItem(String s) {
	arr.add(s);
}
public void removeFirstAppearanceOfItem(String s) {
	for(int i = 0; i < arr.size(); i++) {
		if(arr.get(i) == s) {
			arr.remove(i);
		}
	}
}

public void removeXElement(int k) {
	arr.remove(k);
}
public String getXElement(int x) {
	return arr.get(x);
}
public String getName() {
	return bagName;
}

}//end class
