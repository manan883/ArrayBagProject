import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class client {
private static Color eggShell = new Color(255, 255, 204);
private static JFrame main = new JFrame();
private static JFrame linkedF = new JFrame();
private static JFrame resizeF = new JFrame();
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		//have user choose which type they want then call methods based on that 
		splashGUI();
		GUI();
		//Start();
	}
	public static void splashGUI() throws MalformedURLException {
		JWindow window = new JWindow();
		window.getContentPane().add(				
			new JLabel("", new ImageIcon("ezgif.com-gif-maker.gif"),SwingConstants.CENTER));
		window.setBounds(500, 150, 500, 500);
		window.setVisible(true);
		try {
		    Thread.sleep(3500);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		window.setVisible(false);
		window.dispose();
	}
	//main GUI
	public static void GUI() {
		//make a new color
		
		//set frame
		 main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 main.setBounds(500,150,500,500);
		 //main.setSize(500,500); 
		 

		 //Individual buttons and other stuff
		 JPanel welcome = new JPanel();
		 JLabel label = new JLabel("Welcome to the Bag");
		 JButton linked = new JButton("LinkedData");
		 JButton resize = new JButton("ResizeableArray");
		 JPanel options = new JPanel();
		 JLabel cart = new JLabel("", new ImageIcon("cart-148964__340.png"),SwingConstants.CENTER);
		 label.setFont(new Font("Serif", Font.PLAIN, 20));
		 //label.setForeground(Color.RED);
		 //add listeners to buttons
		 linked.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    GUI_L();
		    main.dispose();
		 }  
}); 
		 resize.addActionListener(new ActionListener(){  
			    public void actionPerformed(ActionEvent e){  
			    GUI_R();
			    main.dispose();
			 }  
	}); 
		 
		 //panel stuff
		 welcome.setBackground(eggShell);
		 options.setBackground(eggShell);
		 welcome.add(label);
		 options.add(linked);
		 options.add(resize);
		 options.add(cart);
		 
		 //frame stuff
		 main.getContentPane().add(BorderLayout.CENTER, options);
		 main.getContentPane().add(BorderLayout.NORTH, welcome);
		 main.getContentPane().setBackground(eggShell);
		 main.setVisible(true);
	}
	
	//main GUI linked
	public static void GUI_L() {
		//set up frames
//		JFrame f = new JFrame("Linked");
		linkedF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		linkedF.setBounds(500,150,500,500);
		
		//Individual buttons and stuff
		JPanel options = new JPanel();
		JLabel l = new JLabel("This is for the LinkedData Type, options shown below");
		JButton b = new JButton("Back");
		JPanel choices = new JPanel();
		JButton makeNewBag = new JButton("Make a new bag");
		JButton add = new JButton("Add Element to a bag");
		JButton remove = new JButton("Remove an Element from a Bag");
		JButton del = new JButton("Delete a bag");
		JButton list = new JButton("List the contents of a bag");
		JButton union = new JButton("Combine 2 bags into a new one");
		JButton intersect = new JButton("Intersect 2 bags");
		JButton difference = new JButton("Get the Diffence of 2 bags");
		l.setFont(new Font("Serif", Font.PLAIN, 20));
		//actions
		b.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    GUI();
		    linkedF.dispose();
		 }  
}); //end event b
		//start event makenewbag
		makeNewBag.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
		    	String name = JOptionPane.showInputDialog(linkedF,"Enter the bag name");
		    	if(LinkedBag.checkIfBagExists(name) == true) {
		    		JOptionPane.showMessageDialog(linkedF,"ERROR: Bag already exists");
		    	}
		    	else if(name == null) {
		    		JOptionPane.showMessageDialog(linkedF,"Name can not be empty");
		    	}
		    	else if(name.equals("")) {
		    		JOptionPane.showMessageDialog(linkedF, "Name can not be empty");
		    	}
		    	else {
		    		LinkedBag.newBag(name);
			    	JOptionPane.showMessageDialog(linkedF,"The new bag name is: " + name);
		    	}
		    	
		 }  
}); //end event makenewbag
		//start event list bag
		list.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	String name = JOptionPane.showInputDialog(linkedF,"Enter the name of the bag you want listed: ");
		    	if(LinkedBag.checkIfBagExists(name) == false) {
		    		JOptionPane.showMessageDialog(linkedF,"ERROR: Bag does not exist");
		    	}
		    	else if(LinkedBag.checkIfBagIsNull(name) == true) {
		    		JOptionPane.showMessageDialog(linkedF,"Bag is empty");
		    	}
		    	else {
		    		bagLinked b = LinkedBag.lBags.get(name);
		    		StringBuilder sb = b.list();
		    		JOptionPane.showMessageDialog(linkedF,sb);
		    	}
		 }  
}); //end event list
		//start event add element
		add.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    String name = JOptionPane.showInputDialog(linkedF,"Enter the bag you want to append to");
		    if(LinkedBag.checkIfBagExists(name) == false) {
	    		JOptionPane.showMessageDialog(linkedF,"ERROR: Bag does not exist");
	    	}
		    else {
		    	String element = JOptionPane.showInputDialog(linkedF,"Enter the element you want to add");
		    	LinkedBag.addElement(name,element);
		    }
		 }  
}); //end event add element
		//start event deletebag
		del.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    String name = JOptionPane.showInputDialog(linkedF,"Enter the bag you want to delete");
		    if(LinkedBag.checkIfBagExists(name) == false) {
	    		JOptionPane.showMessageDialog(linkedF,"ERROR: Bag does not exist");
	    	}
		    else {
		    	LinkedBag.deleteBag(name);
		    }
		 }  
}); //end event deletebag
		//start event remove element
		remove.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    String name = JOptionPane.showInputDialog(linkedF,"Enter the bag name");
		    if(LinkedBag.checkIfBagExists(name) == false) {
	    		JOptionPane.showMessageDialog(linkedF,"ERROR: Bag does not exist");
	    	}
		    else {
		    	String element = JOptionPane.showInputDialog(linkedF,"Enter the element you want to remove. This will remove ALL INSTANCES of the element");
		    	bagLinked b = LinkedBag.lBags.get(name);
		    	if(b.doesItemExist(element) == false) {
		    		JOptionPane.showMessageDialog(linkedF,"There is no such element in the bag");
		    	}
		    	else {
		    		b.removeAppearanceOfItem(element);
		    	}
		    	
		    }
		 }  
}); //end event remove element
		//start union
		union.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    String name1 = JOptionPane.showInputDialog(linkedF,"Enter the first bags name");
		    String name2 = JOptionPane.showInputDialog(linkedF,"Enter the second bags name");
		    String newb = JOptionPane.showInputDialog(linkedF,"Enter the new bags name");
		    if((LinkedBag.checkIfBagExists(name1) == false) || (LinkedBag.checkIfBagExists(name2) == false)) {
	    		JOptionPane.showMessageDialog(linkedF,"ERROR: At least 1 bag does not exist");
	    	}
		    else {
		    	LinkedBag.union(name1,name2,newb);
		    	bagLinked b = LinkedBag.lBags.get(newb);
	    		StringBuilder sb = b.list();
	    		JOptionPane.showMessageDialog(linkedF,sb);
		    }
		 }  
}); //end event union
		//start intersect
		intersect.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    String name1 = JOptionPane.showInputDialog(linkedF,"Enter the first bags name");
		    String name2 = JOptionPane.showInputDialog(linkedF,"Enter the second bags name");
		    String newb = JOptionPane.showInputDialog(linkedF,"Enter the new bags name");
		    if((LinkedBag.checkIfBagExists(name1) == false) || (LinkedBag.checkIfBagExists(name2) == false)) {
	    		JOptionPane.showMessageDialog(linkedF,"ERROR: At least 1 bag does not exist");
	    	}
		    else {
		    	LinkedBag.intersection(name1,name2,newb);
		    	bagLinked b = LinkedBag.lBags.get(newb);
	    		StringBuilder sb = b.list();
	    		JOptionPane.showMessageDialog(linkedF,sb);
		    }
		 }  
}); //end event intersect
		//start difference
		difference.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    String name1 = JOptionPane.showInputDialog(linkedF,"Enter the first bags name");
		    String name2 = JOptionPane.showInputDialog(linkedF,"Enter the second bags name");
		    String newb = JOptionPane.showInputDialog(linkedF,"Enter the new bags name");
		    if((LinkedBag.checkIfBagExists(name1) == false) || (LinkedBag.checkIfBagExists(name2) == false)) {
	    		JOptionPane.showMessageDialog(linkedF,"ERROR: At least 1 bag does not exist");
	    	}
		    else {
		    	LinkedBag.difference(name1,name2,newb);
		    	bagLinked b = LinkedBag.lBags.get(newb);
	    		StringBuilder sb = b.list();
	    		JOptionPane.showMessageDialog(linkedF,sb);
		    }
		 }  
}); //end event difference
		//panel stuff
		options.add(b);
		//options.add(l);
		choices.add(makeNewBag);
		choices.add(del);
		choices.add(add);
		choices.add(remove);
		choices.add(list);
		choices.add(union);
		choices.add(intersect);
		choices.add(difference);
		options.setBackground(eggShell);
		choices.setBackground(eggShell);
		//frame stuff
		linkedF.getContentPane().add(BorderLayout.NORTH, options);
		linkedF.getContentPane().add(BorderLayout.CENTER, choices);
		linkedF.setVisible(true);
		
	}
	
	
	//main GUI resize
	public static void GUI_R() {
		//set up frames
//		JFrame f = new JFrame("Linked");
		resizeF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		resizeF.setBounds(500,150,500,500);
		
		//Individual buttons and stuff
		JPanel options = new JPanel();
		JLabel l = new JLabel("This is for the ResizableData Type, options shown below");
		JButton b = new JButton("Back");
		JPanel choices = new JPanel();
		JButton makeNewBag = new JButton("Make a new bag");
		JButton add = new JButton("Add Element to a bag");
		JButton remove = new JButton("Remove an Element from a Bag");
		JButton del = new JButton("Delete a bag");
		JButton list = new JButton("List the contents of a bag");
		JButton union = new JButton("Combine 2 bags into a new one");
		JButton intersect = new JButton("Intersect 2 bags");
		JButton difference = new JButton("Get the Diffence of 2 bags");
		
		//actions
		b.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    GUI();
		    resizeF.dispose();
		 }  
}); //end back event
		//start makenewbag event
		makeNewBag.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	String name = JOptionPane.showInputDialog(resizeF,"Enter the bag name");
		    	if(ResizeableArrayBag.checkIfBagExists(name) == true) {
		    		JOptionPane.showMessageDialog(resizeF,"ERROR: Bag already exists");
		    	}
		    	else if(name == null) {
		    		JOptionPane.showMessageDialog(resizeF,"Name can not be empty");
		    	}
		    	else if(name.equals("")) {
		    		JOptionPane.showMessageDialog(resizeF, "Name can not be empty");
		    	}
		    	else {
		    		ResizeableArrayBag.newBag(name);
			    	JOptionPane.showMessageDialog(resizeF,"The new bag name is: " + name);
		    	}
		 }  
}); //end makenewbag event
		//start list event
		list.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	String name = JOptionPane.showInputDialog(resizeF,"Enter the name of the bag you want listed: ");
		    	if(ResizeableArrayBag.checkIfBagExists(name) == false) {
		    		JOptionPane.showMessageDialog(resizeF,"ERROR: Bag does not exist");
		    	}
		    	else if(ResizeableArrayBag.checkIfBagIsNull(name) == true) {
		    		JOptionPane.showMessageDialog(resizeF,"Bag is empty");
		    	}
		    	else {
		    		bag b = ResizeableArrayBag.bags.get(name);
		    		StringBuilder sb = b.list();
		    		JOptionPane.showMessageDialog(resizeF,sb);
		    	}
		 }  
}); //end event list
		//start add event
		add.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    String name = JOptionPane.showInputDialog(resizeF,"Enter the bag you want to append to");
		    if(ResizeableArrayBag.checkIfBagExists(name) == false) {
	    		JOptionPane.showMessageDialog(resizeF,"ERROR: Bag does not exist");
	    	}
		    else {
		    	String element = JOptionPane.showInputDialog(resizeF,"Enter the element you want to add");
		    	ResizeableArrayBag.addElement(name,element);
		    }
		 }  
}); //end event add element
		//start deletebag event
		del.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    String name = JOptionPane.showInputDialog(resizeF,"Enter the bag you want to delete");
		    if(ResizeableArrayBag.checkIfBagExists(name) == false) {
	    		JOptionPane.showMessageDialog(resizeF,"ERROR: Bag does not exist");
	    	}
		    else {
		    	ResizeableArrayBag.deleteBag(name);
		    }
		 }  
}); //end event deletebag
		//start event remove item
		remove.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    String name = JOptionPane.showInputDialog(resizeF,"Enter the bag name");
		    if(ResizeableArrayBag.checkIfBagExists(name) == false) {
	    		JOptionPane.showMessageDialog(resizeF,"ERROR: Bag does not exist");
	    	}
		    else {
		    	String element = JOptionPane.showInputDialog(resizeF,"Enter the element you want to remove. This will remove ALL INSTANCES of the element");
		    	bag b = ResizeableArrayBag.bags.get(name);
		    	if(b.doesItemExist(element) == false) {
		    		JOptionPane.showMessageDialog(resizeF,"There is no such element in the bag");
		    	}
		    	else {
		    		b.removeAppearanceOfItem(element);
		    	}
		    	
		    }
		 }  
}); //end event remove element
		//start union
		union.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    String name1 = JOptionPane.showInputDialog(resizeF,"Enter the first bags name");
		    String name2 = JOptionPane.showInputDialog(resizeF,"Enter the second bags name");
		    String newb = JOptionPane.showInputDialog(resizeF,"Enter the new bags name");
		    if((ResizeableArrayBag.checkIfBagExists(name1) == false) || (ResizeableArrayBag.checkIfBagExists(name2) == false)) {
	    		JOptionPane.showMessageDialog(resizeF,"ERROR: At least 1 bag does not exist");
	    	}
		    else {
		    	ResizeableArrayBag.union(name1,name2,newb);
		    	bag b = ResizeableArrayBag.bags.get(newb);
	    		StringBuilder sb = b.list();
	    		JOptionPane.showMessageDialog(resizeF,sb);
		    }
		 }  
}); //end event union
		//start even intersection 
		intersect.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    String name1 = JOptionPane.showInputDialog(resizeF,"Enter the first bags name");
		    String name2 = JOptionPane.showInputDialog(resizeF,"Enter the second bags name");
		    String newb = JOptionPane.showInputDialog(resizeF,"Enter the new bags name");
		    if((ResizeableArrayBag.checkIfBagExists(name1) == false) || (ResizeableArrayBag.checkIfBagExists(name2) == false)) {
	    		JOptionPane.showMessageDialog(resizeF,"ERROR: At least 1 bag does not exist");
	    	}
		    else {
		    	ResizeableArrayBag.intersection(name1,name2,newb);
		    	bag b = ResizeableArrayBag.bags.get(newb);
	    		StringBuilder sb = b.list();
	    		JOptionPane.showMessageDialog(resizeF,sb);
		    }
		 }  
}); //end event intersect
		//start event difference
		difference.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    String name1 = JOptionPane.showInputDialog(resizeF,"Enter the first bags name");
		    String name2 = JOptionPane.showInputDialog(resizeF,"Enter the second bags name");
		    String newb = JOptionPane.showInputDialog(resizeF,"Enter the new bags name");
		    if((ResizeableArrayBag.checkIfBagExists(name1) == false) || (ResizeableArrayBag.checkIfBagExists(name2) == false)) {
	    		JOptionPane.showMessageDialog(resizeF,"ERROR: At least 1 bag does not exist");
	    	}
		    else {
		    	ResizeableArrayBag.difference(name1,name2,newb);
		    	bag b = ResizeableArrayBag.bags.get(newb);
	    		StringBuilder sb = b.list();
	    		JOptionPane.showMessageDialog(resizeF,sb);
		    }
		 }  
}); //end event difference
		
		//panel stuff
		options.add(b);
		//options.add(l);
		choices.add(makeNewBag);
		choices.add(del);
		choices.add(add);
		choices.add(remove);
		choices.add(list);
		choices.add(union);
		choices.add(intersect);
		choices.add(difference);
		options.setBackground(eggShell);
		choices.setBackground(eggShell);
		
		//frame stuff
		resizeF.getContentPane().add(BorderLayout.NORTH, options);
		resizeF.getContentPane().add(BorderLayout.CENTER, choices);
		resizeF.setVisible(true);
	}
	//archive method, console commands
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
