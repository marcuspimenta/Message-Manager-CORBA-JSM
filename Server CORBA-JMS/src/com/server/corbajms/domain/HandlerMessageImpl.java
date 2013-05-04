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
	public String send_msg(Message message) {
		System.out.println(message.emissor);
		System.out.println(message.corpo);
		
		return "Mensagem Recebida com sucesso";
	}

}