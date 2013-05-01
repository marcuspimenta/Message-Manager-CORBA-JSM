package com.corba.main;

import com.corba.business.CorbaClientBusiness;
import com.corba.generatedfilesidl.Message;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 09:29:17 01/05/2013
 */
public class Main {

	public static void main(String[] args) {
		Message message = new Message("Marcus", "Oi");
		
		CorbaClientBusiness corbaClientBusiness = new CorbaClientBusiness();
		corbaClientBusiness.settingsCorbaClient("yourip", "HandlerMessage", "Corba");
		
		corbaClientBusiness.sendMessage(message);
	}
	
}