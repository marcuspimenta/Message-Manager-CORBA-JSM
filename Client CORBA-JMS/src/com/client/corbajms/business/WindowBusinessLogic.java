package com.client.corbajms.business;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.client.corbajms.communication.VerifyMessage;
import com.client.corbajms.generatedfilesidl.Message;
import com.client.corbajms.view.Window;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 17:48:19 06/05/2013
 */
public class WindowBusinessLogic implements IBusinessLogic{
	
	private final int THREAD_POOL = 1;
	private final int TIMER_REPET = 2;

	public static String userName;
	
	private String ipServer;
	
	private Window window;
	
	private Message message;
	private CorbaClientBusinessLogic corbaClientBusiness;
	
	private ScheduledExecutorService executor;
	
	public WindowBusinessLogic(){
		window = new Window(this);
		message = new Message();
		corbaClientBusiness = new CorbaClientBusinessLogic();
		
		executor = Executors.newScheduledThreadPool(THREAD_POOL);
	}
	
	public void settingsInitial(){
		builderWindow();
		retrieveUserName();
		retrieveIpServer();
		settingsCommunication();
		
		registerUser();
		startVerify();
	}
	
	public void builderWindow(){
		window.builder();
	}
	
	public void retrieveUserName(){
		message.issuing = window.enterUserName();
		userName = message.issuing;
	}
	
	public void retrieveIpServer(){
		ipServer = window.enterIpServer();
	}
	
	public void settingsCommunication(){
		try {
			corbaClientBusiness.settingsCorbaClient(ipServer, "HandlerMessage", "Corba");
		} catch (Exception e) {
			window.printMsgDisplay("Connection refused\n" + 
								   "Verify sure the server IP is correct and try again");
		}
	}
	
	public void registerUser(){
		corbaClientBusiness.registerUser(message.issuing);
	}
	
	public void startVerify(){
		executor.scheduleWithFixedDelay((new VerifyMessage(corbaClientBusiness, message.issuing, this)), 0, TIMER_REPET, TimeUnit.SECONDS);
	}
	
	public void stopVerify(){
		executor.shutdownNow();
	}
	
	@Override
	public void settingConectionListener() {
		retrieveIpServer();
		settingsCommunication();
		
		registerUser();
	}
	
	@Override
	public void sendMessageListener(String destination, String bodyMessage) {
		message.destination = destination;
		message.body = bodyMessage;
		
		corbaClientBusiness.sendMessage(message);
	}

	@Override
	public String[] retrieveQueueAndTopics() {
		return corbaClientBusiness.retrieveQueueAndTopics();
	}

	@Override
	public void retrieveMessages(String[] listMessage) {
		window.printListMsgDisplay(listMessage);
	}

}