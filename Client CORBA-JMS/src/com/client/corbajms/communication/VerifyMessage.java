package com.client.corbajms.communication;

import com.client.corbajms.business.CorbaClientBusinessLogic;
import com.client.corbajms.business.IBusinessLogic;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 16:32:47 18/05/2013
 */
public class VerifyMessage implements Runnable{
	
	private String destination;

	private IBusinessLogic iBusinessLogic;
	private CorbaClientBusinessLogic corbaClientBusiness;
	
	public VerifyMessage(CorbaClientBusinessLogic corbaClientBusiness, String destination,
						 IBusinessLogic iBusinessLogic){
		this.corbaClientBusiness = corbaClientBusiness;
		this.destination = destination;
		this.iBusinessLogic = iBusinessLogic;
	}
	
	@Override
	public void run() {
		String[] listMessage = corbaClientBusiness.retrieveMessage(destination);
		
		if(listMessage.length > 0){
			iBusinessLogic.retrieveMessages(listMessage);
		}
	}

}