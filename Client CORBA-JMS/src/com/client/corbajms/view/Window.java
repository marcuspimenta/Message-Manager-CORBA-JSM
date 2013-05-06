package com.client.corbajms.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 17:25:27 06/05/2013
 */
public class Window extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String ipServer;

	private JMenuItem menuAbout;
	private JMenuItem menuExit;
	
	public void builder(){
		final JMenu optionMenu = new JMenu("Options");
		
		menuAbout = new JMenuItem("About");
		menuAbout.addActionListener(this);
		menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(this);
		
		optionMenu.add(menuAbout);
		optionMenu.add(menuExit);
		
		final JMenuBar menu = new JMenuBar();
		menu.add(optionMenu);
		
		setTitle("Client Communication CORBA-JMS");
		setJMenuBar(menu);
		setSize(600, 350);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		enterUserName();
		enterIpServer();
	}
	
	public void enterUserName(){
		userName = "";
		
		while(userName == null || (userName != null && userName.trim().equals(""))){
			userName = JOptionPane.showInputDialog(getContentPane().getParent(),
										   		   "Enter your name", 
										   		   "Settings user name",
										   		   JOptionPane.QUESTION_MESSAGE);
		}
	}
	
	public void enterIpServer(){
		ipServer = "";
		
		while(ipServer == null || (ipServer != null && ipServer.trim().equals(""))){
			ipServer = JOptionPane.showInputDialog(getContentPane().getParent(),
										   		   "Enter ip server (198.168.1.10)", 
										   		   "Settings ip server communication",
										   		   JOptionPane.QUESTION_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == menuAbout){
			JOptionPane.showMessageDialog(getContentPane(),
										  "Communication CORBA-JMS\n\n" +
										  "Autor:        Marcus Pimenta\n" +
										  "email:        mvinicius.pimenta@gmail.com\n" +
										  "Data: 		         may 06, 2013",
										  "About", JOptionPane.PLAIN_MESSAGE);

		}else if(event.getSource() == menuExit){
			System.exit(0);
		}
	}
	
}