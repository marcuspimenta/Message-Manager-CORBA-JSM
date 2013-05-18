package com.server.corbajms.communication.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.NamingException;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 21:57:37 07/05/2013
 */
public class JMSSender {
	
	private JMS jms;
	
	private Session session;
	private TextMessage textMessage;
	private MessageProducer messageProducer;
	
	public JMSSender(){
		jms = new JMS();
	}
	
	public void settingsJMS(String url){
		try {
			jms.settginsJMS(url);
			
			QueueConnection qconnection = jms.createQueueConnection();
			session = qconnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			textMessage = session.createTextMessage();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void settingsSender(String nameDestination){
		try {
			Destination destination = session.createQueue(nameDestination);
			messageProducer = session.createProducer(destination);
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMenssage(String message){
		try {
			textMessage.setText(message);
			messageProducer.send(textMessage);
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}