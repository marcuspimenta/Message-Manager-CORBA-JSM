package com.server.corbajms.business;

import com.server.corbajms.communication.corba.CorbaServer;
import com.server.corbajms.domain.HandlerMessageImpl;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 10:19:57 01/05/2013
 */
public class CorbaServerBusinessLogic{
	
	private CorbaServer corbaServer;
	private HandlerMessageImpl handlerMessageImpl;
	
	public CorbaServerBusinessLogic(IBusinessLogic iBusinessLogic){
		corbaServer = new CorbaServer();
		handlerMessageImpl = new HandlerMessageImpl(iBusinessLogic);
	}
	
	public void settingsCorbaService(String ipServer, String nameComponent, String kindNameComponent){
		try {
			corbaServer.initORB(ipServer);
			corbaServer.referencesNameService();
			corbaServer.searchReferencesNameService(nameComponent, kindNameComponent);
			corbaServer.referencesRootPOA();
			
			corbaServer.servantToRefecenreObject(handlerMessageImpl);
			corbaServer.bindObjectNameService();
			corbaServer.runORB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}