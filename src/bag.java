import java.util.*;
public class bag {
protected ArrayList<String> arr;
private String bagName;
 public bag(String name){
	arr = new ArrayList<String>();
	bagName = name;
}
 // hi
public void addItem(String s) {
	arr.add(s);
}
public void removeAppearanceOfItem(String s) {
	for(int i = 0; i < arr.size(); i++) {
		if(arr.get(i) == s) {
			arr.remove(i);
		}
	}
}
public boolean doesPosExist(int k) {
	if((arr.size()) < k) {		
		return false;
	}
	else if(k == 0) {
		return false;
	}
	else {
	return true;

	}
}
public void removeXElement(int k) {
	arr.remove(k-1);
}
public String getXElement(int x) {
	return arr.get(x);
}
public String getName() {
	return bagName;
}
public StringBuilder list() {
	StringBuilder sb = new StringBuilder();
	sb.append("Contents of bag: " + getName());
	sb.append(System.lineSeparator());
	for(int i = 0; i < arr.size(); i++) {
		if(arr.get(i) == null) {
			break;
		}
		else {
			sb.append(arr.get(i)).append(System.lineSeparator());
		}
		
	}
	return sb;
}
public boolean doesItemExist(String s) {
	for(int i = 0; i < arr.size(); i++) {
		if(arr.get(i) == s) {
			return true;
		}
	}
	
	return false;
}
}//end class
