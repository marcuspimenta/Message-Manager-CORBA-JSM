package com.client.corbajms.business;

import com.client.corbajms.generatedfilesidl.Message;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 17:50:11 06/05/2013
 */
public interface IBusinessLogic {
	
	public abstract void sendMessageListener(Message message);
	
	public abstract void updateQueueAndTopicsListener();

}