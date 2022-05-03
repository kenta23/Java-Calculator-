import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class CalcuFrame extends JFrame implements ActionListener, KeyListener {
   //global scope
	
	JRadioButton radio;
	JButton[] numberButtons = new JButton[10];   //JButton Arrays
	JButton[] functionals = new JButton[6];  //JButton Arrays
	JButton addButton, minusButton, multiplyButton, divideButton, equalButton, decimalButton; //array values 
	JButton  clearButton, deleteButton, negativeButton;
	ImageIcon icon;
	Image image;
	JButton button;
	JTextField textBox; 
	JLabel Label;
	JPanel panel;
	Font textFont = new Font("Sans serif", Font.PLAIN, 30 ); //font style, font weight, pixel size
	
	
	CalcuFrame() { //constructor 
		
		//Initiate Calculator icon
	  image = Toolkit.getDefaultToolkit().getImage("E:\\Users\\admin.DESKTOP-RD36MUF\\eclipse-workspace\\Java Calculator Project\\src\\calcuIcon.png");
		
		
		//JFrame 
		this.setLayout(null);         //we will setting bounds of all the components 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(420,530);
		this.setTitle("Calculator");
		this.setLocation(520, 200);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(244, 245, 237, 07));
		this.setIconImage(image);  //set icon for JFrame  
		this.getContentPane().setBackground(Color.decode("#c5d4c8"));
		
		//this.getContentPane().setBackground(Color.BLACK);
		
		//JTextField
	textBox = new JTextField();
	textBox.setBounds(25, 55, 350, 55); //int x, int y, width , height 
	textBox.setFont(new Font("Sans serif", Font.PLAIN, 35));
	textBox.setForeground(Color.green);
	textBox.setCaretColor(Color.white);
	textBox.setHorizontalAlignment(JTextField.RIGHT);  //set the texts align to the right 
	textBox.setEditable(false);
	textBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	textBox.addKeyListener(this);
	textBox.setBackground(Color.decode("#060807"));  //decode the hex color 
	
		//initiate all the functionals button
		addButton = new JButton("+");
		minusButton = new JButton("-");
		multiplyButton = new JButton("*");
		divideButton = new JButton("/");
		equalButton = new JButton("=");
		decimalButton = new JButton(".");
		
				
		//next is add values these buttons to the array indexes one by one
		 functionals[0] = addButton;
		 functionals[1] = minusButton;
		 functionals[2] = multiplyButton;
		 functionals[3] = divideButton;
		 functionals[4] = equalButton;
		 functionals[5] = decimalButton;

		 //then edit buttons with for loop technique
		 
		 for(int i = 0; i < 6; i++) {
			 functionals[i].addActionListener(this);
			 functionals[i].setFont(textFont);
			 functionals[i].setFocusable(false);
			 functionals[i].setBackground(Color.decode("#84a6ad"));
		 }
		 
		 clearButton = new JButton("C");   		  //initiates the two buttons separated from the panels 
	     deleteButton = new JButton("x");         //initiates the two buttons separated from the panels 
	     negativeButton = new JButton("N"); 
		
	     clearButton.setBounds(185, 120, 60, 45);  
	     clearButton.setFocusable(false);
	     clearButton.addActionListener(this);
	     clearButton.setFont(textFont);
	     clearButton.setBackground(Color.decode("#a0c493"));
	     
	     deleteButton.setBounds(250, 120, 60, 45);  
	     deleteButton.addActionListener(this);
	     deleteButton.setFocusable(false);
	     deleteButton.setFont(textFont);
	     deleteButton.setBackground(Color.decode("#a0c493"));
	     
	     negativeButton.setBounds(315,120,60,45);
	     negativeButton.setFocusable(false);
	     negativeButton.addActionListener(this);
	     negativeButton.setFont(textFont);
	     negativeButton.setBackground(Color.decode("#a0c493"));
	     	     	     	     
	     //create new For loops and instantiate the numberButtons
	     
	     for(int i = 0; i < 10; i++) {  
	    	 numberButtons[i] = new JButton(String.valueOf(i));  //instantiate the JButton array then the value of i will be the title of buttons 
	    	 numberButtons[i].setFocusable(false);
	    	 numberButtons[i].addActionListener(this); 
	    	 numberButtons[i].addKeyListener(this); 
	    	 numberButtons[i].setFont(textFont);
	    	 numberButtons[i].setBackground(Color.decode("#84a6ad"));
	     }
	     
	     //JPanel 
			panel = new JPanel();
			panel.setLayout( new GridLayout(4, 4, 5, 5)); //rows columns margin x, margin y 
			panel.setBackground(Color.decode("#e6f7e8"));
			panel.setBounds(25, 170, 350, 280);     //x y width height
			
	    //add all functional and numberButton arrays to JPanel one by one 
			panel.add(numberButtons[7]);
			panel.add(numberButtons[8]);
			panel.add(numberButtons[9]);
			panel.add(functionals[0]);
			panel.add(numberButtons[4]);
			panel.add(numberButtons[5]);
			panel.add(numberButtons[6]);
			panel.add(functionals[1]);
			panel.add(numberButtons[1]);
			panel.add(numberButtons[2]);
			panel.add(numberButtons[3]);
			panel.add(functionals[2]);
			panel.add(functionals[5]);
			panel.add(functionals[3]);
			panel.add(numberButtons[0]);
			panel.add(functionals[4]);
					     
	    this.add(clearButton);
	    this.add(negativeButton);
	    this.add(deleteButton);
		this.add(textBox);
		this.add(panel);
		this.setVisible(true);
			
		
	}
	
	char operator;
    double num1;
    double num2;
    double  result;
	@Override
	public void actionPerformed(ActionEvent e) {
	  for(int i = 0; i < 10; i++) {
		if(e.getSource()== numberButtons[i]) {
	    	  textBox.setText(textBox.getText().concat(String.valueOf(i))); //Let the JTextField update on what we click buttons on any numberButtons  
	    	  textBox.setText(textBox.getText().concat(""));
		}
	  }
	  
	
	if(e.getSource() == addButton) {
		  num1 = Double.parseDouble(textBox.getText());
		  operator = '+';
		  textBox.setText("");
	  }
	  
	  if(e.getSource() == minusButton) {
		  num1 = Double.parseDouble(textBox.getText());
		  operator = '-';
		  textBox.setText("");
	  }
	  
	  if(e.getSource() == multiplyButton) {
		  num1 = Double.parseDouble(textBox.getText());
		  operator = '*';
		  textBox.setText("");
	  }
	  
	  if(e.getSource() == divideButton) {
		  num1 = Double.parseDouble(textBox.getText());
		  operator = '/';
		  textBox.setText("");
	  }
	  
	  if(e.getSource()==equalButton) {
		  num2 = Double.parseDouble(textBox.getText());
		  
		  switch(operator) {
	      
		  case '+':
			  result = num1 + num2;
			  break;
		  
	      case '-':
		     result = num1 -  num2;
		      break;
		  
	      case '*':
			  result = num1 *  num2;
			  break;
			  
	      case '/':
			  result = num1 /  num2;
			  break;
	  }
		  
		  textBox.setText(String.valueOf(result));
		  num1 = result;
		 
	  }
	  
	  if(e.getSource()==deleteButton) {
		   String del = textBox.getText();
		   textBox.setText("");
		  for(int i = 0; i < del.length()-1;i++) {
			  textBox.setText(textBox.getText()+del.charAt(i));
		  }
	  }
	  
	  if(e.getSource()==clearButton) {
		  textBox.setText("");
	  }
	  
	  if(e.getSource()==negativeButton) {
		  double negative = Double.parseDouble(textBox.getText());
		  negative *= -1;
		  textBox.setText(String.valueOf(negative));
		  
	  }
	  if(e.getSource()==decimalButton) {
		  textBox.setText(textBox.getText().concat("."));
	  }
	}


	@Override
	public void keyTyped(KeyEvent e) {
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		 char n;   //declare a variable that can hold the Buttons 
		 int p;
		 n = e.getKeyChar();   //set equal to e.getKeyChar();
		 p = e.getKeyCode();
		 
		 
		 //numberButtons 
		 if(n == '1') actionPerformed (new ActionEvent(numberButtons[1], 1, "1"));         //OBJECTS, ID, COMMAND/TEXT
		 if(n == '2') actionPerformed (new ActionEvent(numberButtons[2], 2, "2"));
		 if(n == '3') actionPerformed (new ActionEvent(numberButtons[3], 3, "3"));
		 if(n == '4') actionPerformed (new ActionEvent(numberButtons[4], 4, "4"));
		 if(n == '5') actionPerformed (new ActionEvent(numberButtons[5], 5, "5"));
		 if(n == '6') actionPerformed (new ActionEvent(numberButtons[6], 6, "6"));
		 if(n == '7') actionPerformed (new ActionEvent(numberButtons[7], 7, "7"));
		 if(n == '8') actionPerformed (new ActionEvent(numberButtons[8], 8, "8"));
		 if(n == '9') actionPerformed (new ActionEvent(numberButtons[9], 9, "9"));
		 if(n == '0') actionPerformed (new ActionEvent(numberButtons[0], 0, "0"));
		 
		 //functionals
		 if(n == '+') actionPerformed (new ActionEvent(functionals[0], 00, ""));
		 if(n == '-') actionPerformed (new ActionEvent(functionals[1], 01, "")); 
		 if(n == '*') actionPerformed (new ActionEvent(functionals[2], 02, ""));
		 if(n == '/') actionPerformed (new ActionEvent(functionals[3], 03, ""));
		 if(p == 10) actionPerformed (new ActionEvent(functionals[4], 04, ""));
		 if(n == '.') actionPerformed (new ActionEvent(functionals[5], 05, "."));
		 if(p == 8) actionPerformed (new ActionEvent(deleteButton, 00, ""));
		 if(p == 127) actionPerformed (new ActionEvent(clearButton, 00, ""));
		
		 
		 
		 
		 
	}		 

	@Override
	public void keyReleased(KeyEvent e) {
	//	System.out.println(e.getKeyCode());
	//	System.out.println(e.getKeyChar());
		
	
	
	}

}
