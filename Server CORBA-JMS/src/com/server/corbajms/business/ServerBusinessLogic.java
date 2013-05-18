package com.server.corbajms.business;

import java.util.ArrayList;

import com.server.corbajms.communication.jms.JMSReceiver;
import com.server.corbajms.communication.jms.JMSSender;
import com.server.corbajms.generatedfilesidl.Message;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 20:47:47 08/05/2013
 */
public class ServerBusinessLogic implements IBusinessLogic{

	private final String URL_SERVER_JMS = "tcp://localhost:3035/";
	
	private ArrayList<String> nameUsers;
	
	private JMSSender jmsSende;
	private JMSReceiver jmsReceiver;
	private CorbaServerBusinessLogic corbaServerBusiness;
	
	public ServerBusinessLogic(){
		nameUsers = new ArrayList<String>();
		jmsSende = new JMSSender();
		jmsReceiver = new JMSReceiver();
		corbaServerBusiness = new CorbaServerBusinessLogic(this);
	}
	
	public void settingsCommunication(){
		System.out.println("Server ruing");
		
		jmsSende.settingsJMS(URL_SERVER_JMS);
		jmsReceiver.settingsJMS(URL_SERVER_JMS);
		corbaServerBusiness.settingsCorbaService("localhost", "HandlerMessage", "Corba");
	}

	@Override
	public void registerUser(String username) {
		if(!nameUsers.contains(username)){
			nameUsers.add(username);
			
			System.out.println("Registered user with name: " + username);
		}
	}

	@Override
	public void sendMessage(Message message) {
		System.out.println("Message receiver - [origin: " + message.issuing + 
						   ", destination: " + message.destination + 
						   ", message: " + message.body + "]");
		
		jmsSende.settingsSender(message.destination);
		jmsSende.sendMenssage(message.issuing + ": " + message.body);
	}

	@Override
	public String[] retrieveQueueAndTopics() {
		String[] users = new String[nameUsers.size()];

		for (int i = 0; i < nameUsers.size(); i++) {
			users[i] = nameUsers.get(i);
		}
		
		return users;
	}

	@Override
	public String[] retrieveMessages(String destination) {
		jmsReceiver.settingsReceiver(destination);
		ArrayList<String> listMessage = jmsReceiver.retrieveMessages();
		
		String[] messages = new String[listMessage.size()];

		for (int i = 0; i < listMessage.size(); i++) {
			messages[i] = listMessage.get(i);
		}
		
		return messages;
	}
	
}