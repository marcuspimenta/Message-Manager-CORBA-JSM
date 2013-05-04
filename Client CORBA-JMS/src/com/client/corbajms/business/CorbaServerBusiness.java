package com.client.corbajms.business;

import com.client.corbajms.communication.CorbaServer;
import com.client.corbajms.domain.HandlerMessageImpl;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 10:19:57 01/05/2013
 */
public class CorbaServerBusiness {
	
	private CorbaServer corbaServer;
	private HandlerMessageImpl handlerMessageImpl;
	
	public CorbaServerBusiness(){
		corbaServer = new CorbaServer();
		handlerMessageImpl = new HandlerMessageImpl();
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