import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class client {
private static JFrame main = new JFrame();
private static JFrame linkedF = new JFrame();
private static JFrame resizeF = new JFrame();
private static JFrame input = new JFrame();
private static JFrame error = new JFrame();
private static String userText = "";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//have user choose which type they want then call methods based on that 
		GUI();
	}
	
	//main GUI
	public static void GUI() {
		//set frame
		 JFrame f = new JFrame("GUI");
		 main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 main.setSize(500,500);
		 
		 //Individual buttons and other stuff
		 JPanel welcome = new JPanel();
		 JLabel label = new JLabel("Welcome to the Bag");
		 JButton linked = new JButton("LinkedData");
		 JButton resize = new JButton("ResizeableArray");
		 JPanel options = new JPanel();
		 
		 //add listeners to buttons
		 linked.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    GUI_L();
		    main.dispose();
		 }  
}); 
		 
		 //panel stuff
		 welcome.add(label);
		 options.add(linked);
		 options.add(resize);
		 
		 
		 //frame stuff
		 main.getContentPane().add(BorderLayout.CENTER, options);
		 main.getContentPane().add(BorderLayout.NORTH, welcome);
		 main.setVisible(true);
	}
	
	//main GUI linked
	public static void GUI_L() {
		//set up frames
//		JFrame f = new JFrame("Linked");
		linkedF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		linkedF.setSize(500,500);
		
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
		    	JDialog jd = new JDialog(linkedF,"User Input");
		    	JLabel addL = new JLabel("Enter the name of the new bag");
		    	String name = JOptionPane.showInputDialog(linkedF,"Enter the bag name");
		    	JOptionPane.showMessageDialog(linkedF,name);
		    	//GUI_UI("Enter the name of the new bag: ", "Done", "linked");
		    	//System.out.println(userText);
		    	
		 }  
}); //end event makenewbag
		
		//panel stuff
		options.add(b);
		options.add(l);
		choices.add(makeNewBag);
		choices.add(del);
		choices.add(add);
		choices.add(remove);
		choices.add(list);
		choices.add(union);
		choices.add(intersect);
		choices.add(difference);
		
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
		resizeF.setSize(500,500);
		
		//Individual buttons and stuff
		JPanel options = new JPanel();
		JLabel l = new JLabel("This is for the LinkedData Type, options shown below");
		JButton b = new JButton("Back");
		
		
		//actions
		b.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    GUI();
		    resizeF.dispose();
		 }  
}); 
		
		//panel stuff
		options.add(b);
		options.add(l);
		
		//frame stuff
		resizeF.getContentPane().add(BorderLayout.NORTH, options);
		resizeF.setVisible(true);
	}
	
	//universal error message pop up
	public static void errorMessages(String message, String gui) {
		error.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		error.setSize(200,200);
		JPanel p = new JPanel();
		JLabel l = new JLabel(message);
		JButton back = new JButton("OK");
		
		if(gui.equals("linked")) {
			back.addActionListener(new ActionListener(){  
			    public void actionPerformed(ActionEvent e){  
			    GUI_L();
			    error.dispose();
			 }  
	}); //end action
		}
		else if(gui.equals("resize")) {
			back.addActionListener(new ActionListener(){  
			    public void actionPerformed(ActionEvent e){  
			    GUI_R();
			    error.dispose();
			 }  
	}); //end action
		}
		
		p.add(l);
		p.add(back);
		error.getContentPane().add(BorderLayout.CENTER, p);
		error.setVisible(true);
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
