package com.client.corbajms.business;

import com.client.corbajms.generatedfilesidl.Message;
import com.client.corbajms.view.Window;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 17:48:19 06/05/2013
 */
public class WindowBusinessLogic {

	private Window window;
	
	public WindowBusinessLogic(){
		window = new Window();
	}
	
	public void builderWindow(){
		window.builder();
	}
	
	public void settingsCommunication(){
		Message message = new Message("Marcus", "Default", "Oi");
		
		CorbaClientBusiness corbaClientBusiness = new CorbaClientBusiness();
		corbaClientBusiness.settingsCorbaClient("localhost", "HandlerMessage", "Corba");
		
		corbaClientBusiness.sendMessage(message);
	}
	
}