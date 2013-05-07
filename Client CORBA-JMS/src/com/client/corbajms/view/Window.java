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

import com.client.corbajms.business.IBusinessLogic;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 17:25:27 06/05/2013
 */
public class Window extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private String selected = "";
	
	private JMenuItem menuAbout;
	private JMenuItem menuExit;
	private JMenuItem menuRestartCommunication;
	
	private JButton buttonUpdate;
	private JButton buttonSend;
	
	private JPanel panel;
	private JTextArea message;
	private JTextArea displayAreaMsg;
	
	private IBusinessLogic iBusinessLogic;
	
	public Window(IBusinessLogic iBusinessLogic){
		this.iBusinessLogic = iBusinessLogic;
	}
	
	public void builder(){
		final JMenu optionMenu = new JMenu("Options");
		
		menuRestartCommunication = new JMenuItem("Restart Communication");
		menuRestartCommunication.addActionListener(this);
		menuAbout = new JMenuItem("About");
		menuAbout.addActionListener(this);
		menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(this);
		
		optionMenu.add(menuRestartCommunication);
		optionMenu.add(menuAbout);
		optionMenu.add(menuExit);
		
		final JMenuBar menu = new JMenuBar();
		menu.add(optionMenu);
		
		settingsQueueAndTopic();
		settingsViewChat();
		
		setTitle("Client Communication CORBA-JMS");
		setJMenuBar(menu);
		setSize(550, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	public void settingsQueueAndTopic(){
		buttonUpdate = new JButton("Refresh");
		buttonUpdate.addActionListener(this);
		
		panel = new JPanel(new BorderLayout());
		panel.add(buttonUpdate, BorderLayout.NORTH);
		panel.setBorder(new TitledBorder("Available"));
		
		add(panel, BorderLayout.WEST);
	}
	
	public void addItens(String[] list){
		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		ButtonGroup group = new ButtonGroup();
		
		for (String string : list) {
			JRadioButton jRadioButton = new JRadioButton(string);
			jRadioButton.setActionCommand(string);
			jRadioButton.addActionListener(this);
			
			group.add(jRadioButton);
			radioPanel.add(jRadioButton);
		}
		
		JPanel jPanel = new JPanel();
		jPanel.setSize(1, 1); 
		jPanel.add(radioPanel);
		
		panel.add(jPanel, BorderLayout.CENTER);
		add(panel, BorderLayout.WEST);
		
		setVisible(true);
	}
	
	public void settingsViewChat(){
		displayAreaMsg = new JTextArea(10, 30);
		displayAreaMsg.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		displayAreaMsg.setLineWrap(true);
		displayAreaMsg.setEditable(false);
		
		JScrollPane scrollpane = new JScrollPane(displayAreaMsg);
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		message = new JTextArea(1, 25);
		message.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		message.getDocument().putProperty("filterNewlines", Boolean.TRUE);
		message.setEditable(true);

		buttonSend = new JButton("Send");
		buttonSend.addActionListener(this);
		
		JPanel jPanel = new JPanel();
		jPanel.setSize(1, 1);  

		final JPanel panelTextButton = new JPanel();
		panelTextButton.setLayout(new BorderLayout());
		panelTextButton.add(message, BorderLayout.WEST);
		panelTextButton.add(jPanel, BorderLayout.CENTER);
		panelTextButton.add(buttonSend, BorderLayout.EAST);
		
		final JPanel panelChat = new JPanel();
		panelChat.add(scrollpane, BorderLayout.CENTER);
		panelChat.add(panelTextButton, BorderLayout.SOUTH);
		panelChat.setBorder(new TitledBorder("Chat"));
		
		add(panelChat, BorderLayout.CENTER);
	}
	
	public String enterUserName(){
		String userName = "";
		
		while(userName == null || (userName != null && userName.trim().equals(""))){
			userName = JOptionPane.showInputDialog(getContentPane().getParent(),
										   		   "Enter your name", 
										   		   "Settings user name",
										   		   JOptionPane.INFORMATION_MESSAGE);
		}
		
		return userName;
	}
	
	public String enterIpServer(){
		String ipServer = "";
		
		while(ipServer == null || (ipServer != null && ipServer.trim().equals(""))){
			ipServer = JOptionPane.showInputDialog(getContentPane().getParent(),
										   		   "Enter ip server (198.168.1.10)", 
										   		   "Settings ip server communication",
										   		   JOptionPane.INFORMATION_MESSAGE);
		}
		
		return ipServer;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == menuRestartCommunication){
			displayAreaMsg.setText("");
			iBusinessLogic.settingConectionListener();
		}else if(event.getSource() == menuAbout){
			JOptionPane.showMessageDialog(getContentPane(),
										  "Communication CORBA-JMS\n\n" +
										  "Autor:        Marcus Pimenta\n" +
										  "email:        mvinicius.pimenta@gmail.com\n" +
										  "Data: 		         may 06, 2013",
										  "About", JOptionPane.PLAIN_MESSAGE);

		}else if(event.getSource() == menuExit){
			System.exit(0);
		}else if(event.getSource() == buttonUpdate){
			addItens(new String[]{"csd"});
		}else if(event.getSource() == buttonSend){
			if(!selected.equals("")){
				if(message.getText().length() > 0){
					iBusinessLogic.sendMessageListener(selected, message.getText());
					printMsgDisplay("You: " + message.getText());
	   				message.setText("");
				}else{
					printMsgDisplay("Input message empty");
				}
			}else{
				printMsgDisplay("Select destination from your message");
			}
		}else{
			selected = event.getActionCommand();
		}
	}
	
	public void printMsgDisplay(final String message){
		displayAreaMsg.append(message +"\n");
		displayAreaMsg.setCaretPosition(displayAreaMsg.getDocument().getLength());
	}
	
}