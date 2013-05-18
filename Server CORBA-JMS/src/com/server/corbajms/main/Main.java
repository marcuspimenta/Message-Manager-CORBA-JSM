package com.server.corbajms.main;

import com.server.corbajms.business.ServerBusinessLogic;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 09:29:17 01/05/2013
 */
public class Main {

	public static void main(String[] args) {
		ServerBusinessLogic serverBusinessLogic = new ServerBusinessLogic();
		serverBusinessLogic.settingsCommunication();
	}
	
}