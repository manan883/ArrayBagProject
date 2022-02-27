public class bagLinked {
	public String[] arr;
	private String bagName;
	public bagLinked(String name) {
		arr = new String[10000];
		bagName = name;
	}
	
	public void addItem(String s) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == null) {
				arr[i] = s;
				break;
			}
		}
	}
	public void removeAppearanceOfItem(String s) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == s) {
				arr[i] = "";
			}
		}
	}
	public boolean doesItemExist(String s) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == s) {
				return true;
			}
		}
		
		return false;
	}
	public void removeXElement(int k) {
		for(int i = 0; i < arr.length; i++) {
			if(i == k-1) {
				arr[i] = "";
			}
		}
	}
	public String getXElement(int x) {
		for(int i = 0; i < arr.length; i++) {
			if(i == x-1) {
				return arr[i];
			}
		}
		return "";
	}
	public StringBuilder list() {
		StringBuilder sb = new StringBuilder();
		sb.append("Contents of bag: " + getName());
		sb.append(System.lineSeparator());
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == null) {
				break;
			}
			else {
				sb.append(arr[i]).append(System.lineSeparator());
			}
			
		}
		return sb;
	}
	public String getName() {
		return bagName;
	}
	
	public boolean doesPosExist(int k) {
		if((arr.length) < k) {		
			return false;
		}
		else if(k == 0) {
			return false;
		}
		else {
		return true;

		}
	}
	
}
