package com.client.corbajms.business;

import com.client.corbajms.generatedfilesidl.Message;
import com.client.corbajms.view.Window;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 17:48:19 06/05/2013
 */
public class WindowBusinessLogic implements IBusinessLogic{

	private String ipServer;
	
	private Window window;
	
	private Message message;
	private CorbaClientBusiness corbaClientBusiness;
	
	
	public WindowBusinessLogic(){
		window = new Window(this);
		message = new Message();
		corbaClientBusiness = new CorbaClientBusiness();
	}
	
	public void settingsInitial(){
		builderWindow();
		retrieveUserName();
		retrieveIpServer();
		settingsCommunication();
		
		registerUser();
	}
	
	public void builderWindow(){
		window.builder();
	}
	
	public void retrieveUserName(){
		message.issuing = window.enterUserName();
	}
	
	public void retrieveIpServer(){
		ipServer = window.enterIpServer();
	}
	
	public void settingsCommunication(){
		try {
			corbaClientBusiness.settingsCorbaClient(ipServer, "HandlerMessage", "Corba");
		} catch (Exception e) {
			window.printMsgDisplay("Connection refused\n" + 
								   "Verify sure the server IP is correct and try again");
		}
	}
	
	public void registerUser(){
		corbaClientBusiness.registerUser(message.issuing);
	}
	
	@Override
	public void settingConectionListener() {
		retrieveIpServer();
		settingsCommunication();
		
		registerUser();
	}
	
	@Override
	public void sendMessageListener(String destination, String bodyMessage) {
		message.destination = destination;
		message.body = bodyMessage;
		
		corbaClientBusiness.sendMessage(message);
	}

	@Override
	public String[] retrieveQueueAndTopics() {
		return corbaClientBusiness.retrieveQueueAndTopics();
	}

}