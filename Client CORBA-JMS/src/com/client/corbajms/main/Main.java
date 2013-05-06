package com.client.corbajms.main;

import com.client.corbajms.business.CorbaClientBusiness;
import com.client.corbajms.generatedfilesidl.Message;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 09:29:17 01/05/2013
 */
public class Main {

	public static void main(String[] args) {
		Message message = new Message("Marcus", "Default", "Oi");
		
		CorbaClientBusiness corbaClientBusiness = new CorbaClientBusiness();
		corbaClientBusiness.settingsCorbaClient("yourip", "HandlerMessage", "Corba");
		
		corbaClientBusiness.sendMessage(message);
	}
	
}