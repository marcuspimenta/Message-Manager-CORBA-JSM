package com.client.corbajms.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

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
		
		add(settingsQueueAndTopic(new String[]{"OI", "bls"}), BorderLayout.WEST);
		add(settingsViewChat(), BorderLayout.CENTER);
		
		setTitle("Client Communication CORBA-JMS");
		setJMenuBar(menu);
		setSize(550, 300);
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
		
		enterUserName();
		enterIpServer();
	}
	
	public JPanel settingsQueueAndTopic(String[] list){
		
		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		ButtonGroup group = new ButtonGroup();
		
		for (String string : list) {
			JRadioButton jRadioButton = new JRadioButton(string);
			jRadioButton.addActionListener(this);
			
			group.add(jRadioButton);
			radioPanel.add(jRadioButton);
		}
		
		JButton send = new JButton("Update");
		send.addActionListener(this);
		
		JPanel jPanel = new JPanel();
		jPanel.setSize(1, 1); 
		jPanel.add(radioPanel);
		
		final JPanel panelChat = new JPanel(new BorderLayout());
		panelChat.add(send, BorderLayout.NORTH);
		panelChat.add(jPanel, BorderLayout.CENTER);
		panelChat.setBorder(new TitledBorder("Available"));
		
		return panelChat;
	}
	
	public JPanel settingsViewChat(){
		JTextArea displayAreaMsg = new JTextArea(10, 30);
		displayAreaMsg.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		displayAreaMsg.setLineWrap(true);
		displayAreaMsg.setEditable(false);
		
		JScrollPane scrollpane = new JScrollPane(displayAreaMsg);
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JTextArea message = new JTextArea(1, 25);
		message.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		message.getDocument().putProperty("filterNewlines", Boolean.TRUE);
		message.setEditable(true);

		JButton send = new JButton("Send");
		send.addActionListener(this);
		
		JPanel jPanel = new JPanel();
		jPanel.setSize(1, 1);  

		final JPanel panelTextButton = new JPanel();
		panelTextButton.setLayout(new BorderLayout());
		panelTextButton.add(message, BorderLayout.WEST);
		panelTextButton.add(jPanel, BorderLayout.CENTER);
		panelTextButton.add(send, BorderLayout.EAST);
		
		final JPanel panelChat = new JPanel();
		panelChat.add(scrollpane, BorderLayout.CENTER);
		panelChat.add(panelTextButton, BorderLayout.SOUTH);
		panelChat.setBorder(new TitledBorder("Chat"));
		
		return panelChat;
	}
	
	public void enterUserName(){
		userName = "";
		
		while(userName == null || (userName != null && userName.trim().equals(""))){
			userName = JOptionPane.showInputDialog(getContentPane().getParent(),
										   		   "Enter your name", 
										   		   "Settings user name",
										   		   JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void enterIpServer(){
		ipServer = "";
		
		while(ipServer == null || (ipServer != null && ipServer.trim().equals(""))){
			ipServer = JOptionPane.showInputDialog(getContentPane().getParent(),
										   		   "Enter ip server (198.168.1.10)", 
										   		   "Settings ip server communication",
										   		   JOptionPane.INFORMATION_MESSAGE);
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