package com.server.corbajms.domain;

import com.server.corbajms.generatedfilesidl.HandlerMessagePOA;
import com.server.corbajms.generatedfilesidl.Message;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 11:16:19 01/05/2013
 */
public class HandlerMessageImpl extends HandlerMessagePOA{

	@Override
	public void sendMessage(Message message) {
		System.out.println(message.issuing);
		System.out.println(message.destination);
		System.out.println(message.body);
		
		System.out.println("Mensagem recebida com sucesso");
	}

	@Override
	public String retrieveQueueAndTopics() {
		return "Oi";
	}

}