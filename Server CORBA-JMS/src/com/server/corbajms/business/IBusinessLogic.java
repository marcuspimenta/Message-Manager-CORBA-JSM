package com.server.corbajms.business;

import com.server.corbajms.generatedfilesidl.Message;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 20:37:01 08/05/2013
 */
public interface IBusinessLogic {

	public abstract void registerUser(String username);
	
	public abstract void sendMessage(Message message);
	
	public abstract String[] retrieveQueueAndTopics();
	
	public abstract String[] retrieveMessages(String origin);
	
}