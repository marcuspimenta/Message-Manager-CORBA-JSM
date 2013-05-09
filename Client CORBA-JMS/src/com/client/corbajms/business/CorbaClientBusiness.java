package com.client.corbajms.business;

import com.client.corbajms.communication.CorbaClient;
import com.client.corbajms.generatedfilesidl.HandlerMessage;
import com.client.corbajms.generatedfilesidl.HandlerMessageHelper;
import com.client.corbajms.generatedfilesidl.Message;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 09:49:47 01/05/2013
 */
public class CorbaClientBusiness {
	
	private CorbaClient corbaClient;
	private HandlerMessage handlerMessage;
	
	public CorbaClientBusiness(){
		corbaClient = new CorbaClient();
	}
	
	public void settingsCorbaClient(String ipServer, String nameComponent, String kindNameComponent) throws Exception{
		corbaClient.initORB(ipServer);
		corbaClient.referencesNameService();
		corbaClient.searchReferencesNameService(nameComponent, kindNameComponent);
		
		handlerMessage = HandlerMessageHelper.narrow(corbaClient.getReferenceObj());
	}
	
	public void sendMessage(Message message){
		try{
			handlerMessage.sendMessage(message);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void registerUser(String userName){
		try{
			handlerMessage.registerUser(userName);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[] retrieveQueueAndTopics(){
		try{
			return handlerMessage.retrieveQueueAndTopics();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}