package com.server.corbajms.communication.jms;

import java.util.ArrayList;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.QueueConnection;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.NamingException;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 21:57:55 07/05/2013
 */
public class JMSReceiver{
	
	private final int TIMER_INTERVAL = 300;
	
	private String user;

	private JMS jms;
	
	private Session session;
	private MessageConsumer  msgcConsumer;
	
	public JMSReceiver(){
		jms = new JMS();
	}
	
	public void settingsJMS(String url){
		try {
			jms.settginsJMS(url);
			
			QueueConnection qconnection = jms.createQueueConnection();
			session = qconnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			qconnection.start();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void settingsReceiver(String user){
		try {
			this.user = user;
			
			Destination destination = session.createQueue(user);
			msgcConsumer = session.createConsumer(destination);
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> retrieveMessages(){
		TextMessage textMessage = null;
		ArrayList<String> listMessage = new ArrayList<String>();
		
		try {
			while(true){
				textMessage = (TextMessage) msgcConsumer.receive(TIMER_INTERVAL);
				
				if(textMessage == null)
					break;
				
				listMessage.add(textMessage.getText());  
			}
		} catch (JMSException e) {
			System.out.println("No message to " + user);
		}
		
		return listMessage;
	}
	
}