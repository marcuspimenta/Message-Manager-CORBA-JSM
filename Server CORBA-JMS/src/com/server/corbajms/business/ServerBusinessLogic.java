package com.server.corbajms.business;

import java.util.ArrayList;

import com.server.corbajms.generatedfilesidl.Message;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 20:47:47 08/05/2013
 */
public class ServerBusinessLogic implements IBusinessLogic{

	private ArrayList<String> nameUsers;
	private CorbaServerBusiness corbaServerBusiness;
	
	public ServerBusinessLogic(){
		nameUsers = new ArrayList<String>();
		corbaServerBusiness = new CorbaServerBusiness(this);
	}
	
	public void settingsCorbaService(){
		corbaServerBusiness.settingsCorbaService("localhost", "HandlerMessage", "Corba");
	}

	@Override
	public void registerUser(String username) {
		nameUsers.add(username);
	}

	@Override
	public void sendMessage(Message message) {
		System.out.println("Message receiver " + message.body);
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
	public String[] retrieveMessages(String origin) {
		// TODO Auto-generated method stub
		return null;
	}
	
}