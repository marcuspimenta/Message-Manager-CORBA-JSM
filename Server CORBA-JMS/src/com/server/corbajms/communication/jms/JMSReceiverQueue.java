package com.server.corbajms.communication.jms;

import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueReceiver;
import javax.jms.TextMessage;
import javax.naming.NamingException;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 21:57:55 07/05/2013
 */
public class JMSReceiverQueue extends Thread{

	private boolean execute;
	
	private JMS jms;
	private QueueReceiver qreceiver;
	
	public JMSReceiverQueue(){
		execute = true;
		
		jms = new JMS();
	}
	
	public void settingsReceiverQueueJMS(String url, String queue){
		try {
			jms.settginsJMS(url);
			
			QueueConnection qconnection = jms.createQueueConnection();
			qconnection.start();
			
			javax.jms.Queue dest = (javax.jms.Queue)jms.getContext().lookup(queue);
        	qreceiver = jms.createQueueSession().createReceiver(dest);
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		super.run();
		
		TextMessage textMessage = null;
		
		try {
			while(execute){
				textMessage = (TextMessage) qreceiver.receive();
				System.out.println(" Mensagem Recebida: " + textMessage.getText());  
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
}