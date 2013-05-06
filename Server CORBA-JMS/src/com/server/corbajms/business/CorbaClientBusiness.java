package com.server.corbajms.business;

import com.server.corbajms.communication.CorbaClient;
import com.server.corbajms.generatedfilesidl.HandlerMessage;
import com.server.corbajms.generatedfilesidl.HandlerMessageHelper;
import com.server.corbajms.generatedfilesidl.Message;

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
	
	public void settingsCorbaClient(String ipServer, String nameComponent, String kindNameComponent){
		try {
			corbaClient.initORB(ipServer);
			corbaClient.referencesNameService();
			corbaClient.searchReferencesNameService(nameComponent, kindNameComponent);
			
			handlerMessage = HandlerMessageHelper.narrow(corbaClient.getReferenceObj());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(Message message){
		handlerMessage.sendMessage(message);
	}

}