package codepack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Team9GUI implements ActionListener{	
	public  JFrame frame;
	public JButton loginB;
	public JButton signUpButton;
	JTextField userSF;
	JTextField emailSF;
	JPasswordField passwordSF;
	JPanel messagePanel;
	JLabel message;
	JTextField userF;
	JPasswordField passF;
	User u = new User(null, null, null);
	UserList l = new UserList();
	
	
	
		public static void main(String[] args) {
			Team9GUI GUI = new Team9GUI();
			
		}
		private Team9GUI() {
			frame = new JFrame("Hello");
			frame.setMinimumSize(new Dimension(500,500));
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			loginPanel();
			SignUpPanel();
			
	
			
			
			frame.pack();
			frame.setVisible(true);
		}
		
		private void loginPanel(){
			 
			JPanel login = new JPanel();
			JLabel userL = new JLabel("Username:"); 
			userF = new JTextField(15);
			JLabel passL = new JLabel("Password:");
			passF = new JPasswordField(15);
			loginB = new JButton("Login");
			loginB.addActionListener(this);
			login.add(userL);
			login.add(userF);
			login.add(passL);
			login.add(passF);
			login.add(loginB);
			frame.getContentPane().add(BorderLayout.NORTH,login);
			
		}
		private void SignUpPanel(){
			JPanel signUp = new JPanel();
			signUp.setLayout(new BoxLayout(signUp,BoxLayout.Y_AXIS));
			signUp.setAlignmentY(Panel.LEFT_ALIGNMENT);
			JLabel userSL = new JLabel("Username");
			userSF = new JTextField(15);
//			userSF.setMaximumSize(new Dimension(500,TextField.HEIGHT));
			userSF.setMinimumSize(new Dimension(500,TextField.HEIGHT));
			JLabel emailSL = new JLabel("email");
			emailSF = new JTextField(15);
			emailSF.setMaximumSize(new Dimension(500,TextField.HEIGHT));
			emailSF.setMinimumSize(new Dimension(500,TextField.HEIGHT));
			JLabel passwordSL = new JLabel("Password");
			passwordSF = new JPasswordField(15);
			passwordSF.setMaximumSize(new Dimension(500,TextField.HEIGHT));
			passwordSF.setMinimumSize(new Dimension(500,TextField.HEIGHT));
			signUpButton = new JButton("Sign Up");
			signUpButton.addActionListener(this);
			signUp.add(userSL);
			signUp.add(userSF);
			signUp.add(emailSL);
			signUp.add(emailSF);
			signUp.add(passwordSL);
			signUp.add(passwordSF);
			signUp.add(signUpButton);
			frame.getContentPane().add(BorderLayout.CENTER,signUp);
		}
		private void messagePanel() {
			messagePanel = new JPanel();
			message= new JLabel("");
			messagePanel.add(message);
			frame.getContentPane().add(BorderLayout.SOUTH,messagePanel);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if(e.getSource().equals(loginB)) {
				User check =l.findUser(userF.getText(), new String(passF.getPassword()));
				
			if(userF.getText().equals("")||passF.getPassword().length==0) {
					JOptionPane.showMessageDialog(frame,"Fill in all fields");
			}else if(check==null) {
					JOptionPane.showMessageDialog(frame,"You have provided the wrong credentials");
				}else {
					u = check;
					System.out.println(u.getEmail());
					JOptionPane.showMessageDialog(frame,"You have logged in");
					frame.getContentPane().removeAll();
					frame.repaint();
				}
			}
			
			if(e.getSource().equals(signUpButton)) {
				if(userSF.getText().equals("")||emailSF.getText().equals("")||passwordSF.getPassword().length==0) {
					JOptionPane.showMessageDialog(frame,"Fill in all fields");
					
				}else if(!u.checkEmail(emailSF.getText())) {
					JOptionPane.showMessageDialog(frame,"Please fill in valid email");
				}else if(l.doesEmailExist(emailSF.getText())){
					JOptionPane.showMessageDialog(frame,"This email already exists");
				}else if(l.doesUserNameExist(userSF.getText())) {
					JOptionPane.showMessageDialog(frame,"This username already exists");
				}else if(!u.checkPasswd(new String(passwordSF.getPassword()) )){
					JOptionPane.showMessageDialog(frame,"Please fill in valid password");
				}else {
					l.addUser(userSF.getText(), (new String(passwordSF.getPassword())), emailSF.getText());
					JOptionPane.showMessageDialog(frame,"Your account has been created");
				}
				
		}
		}	
}
