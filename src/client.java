import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//have user choose which type they want then call methods based on that 
		GUI();
	}
	public static void GUI() {
		//set frame
		 JFrame f = new JFrame("GUI");
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 f.setSize(500,500);
		 
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
		 }  
}); 
		 
		 //panel stuff
		 welcome.add(label);
		 options.add(linked);
		 options.add(resize);
		 
		 
		 //frame stuff
		 f.getContentPane().add(BorderLayout.CENTER, options);
		 f.getContentPane().add(BorderLayout.NORTH, welcome);
		 f.setVisible(true);
	}
	public static void GUI_L() {
		//set up frames
		JFrame f = new JFrame("Linked");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,500);
		
		//Individual buttons and stuff
		JPanel options = new JPanel();
		JLabel l = new JLabel("This is for the LinkedData Type, options shown below");
		JButton b = new JButton("Back");
		
		
		//actions
		b.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    GUI();
		 }  
}); 
		
		//panel stuff
		options.add(b);
		options.add(l);
		
		//frame stuff
		f.getContentPane().add(BorderLayout.NORTH, options);
		f.setVisible(true);
		
	}
	
	
	
	public static void GUI_R() {
		//set up frames
		JFrame f = new JFrame("Linked");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,500);
		
		//Individual buttons and stuff
		JPanel options = new JPanel();
		JLabel l = new JLabel("This is for the LinkedData Type, options shown below");
		JButton b = new JButton("Back");
		
		
		//actions
		b.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    GUI();
		 }  
}); 
		
		//panel stuff
		options.add(b);
		options.add(l);
		
		//frame stuff
		f.getContentPane().add(BorderLayout.NORTH, options);
		f.setVisible(true);
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
