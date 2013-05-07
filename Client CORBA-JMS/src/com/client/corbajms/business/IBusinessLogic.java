package com.client.corbajms.business;


/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 17:50:11 06/05/2013
 */
public interface IBusinessLogic {
	
	public abstract void settingConectionListener();
	
	public abstract void sendMessageListener(String destination, String bodyMessage);
	
}