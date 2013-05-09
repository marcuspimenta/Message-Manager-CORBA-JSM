package com.server.corbajms.domain;

import com.server.corbajms.business.IBusinessLogic;
import com.server.corbajms.generatedfilesidl.HandlerMessagePOA;
import com.server.corbajms.generatedfilesidl.Message;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 11:16:19 01/05/2013
 */
public class HandlerMessageImpl extends HandlerMessagePOA{
	
	private IBusinessLogic iBusinessLogic;
	
	public HandlerMessageImpl(IBusinessLogic iBusinessLogic){
		this.iBusinessLogic = iBusinessLogic;
	}

	@Override
	public void registerUser(String username) {
		iBusinessLogic.registerUser(username);
	}
	
	@Override
	public void sendMessage(Message message) {
		iBusinessLogic.sendMessage(message);
	}

	@Override
	public String[] retrieveQueueAndTopics() {
		return iBusinessLogic.retrieveQueueAndTopics();
	}

	@Override
	public String[] retrieveMessages(String origin) {
		return iBusinessLogic.retrieveMessages(origin);
	}

}