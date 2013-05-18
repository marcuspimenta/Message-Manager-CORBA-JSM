package com.server.corbajms.communication.jms;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 21:45:43 07/05/2013
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class JMS {
	
	private Context context;
	private QueueConnectionFactory qfactory;

	public void settginsJMS(String url) throws NamingException, JMSException{
		Hashtable properties = new Hashtable();
		properties.put(Context.INITIAL_CONTEXT_FACTORY,"org.exolab.jms.jndi.InitialContextFactory");
		properties.put(Context.PROVIDER_URL, url);

		context = new InitialContext(properties);
		qfactory = (QueueConnectionFactory) context.lookup("ConnectionFactory");
	}
	
	public QueueConnection createQueueConnection() throws JMSException{
		return qfactory.createQueueConnection();
	}
	
	public QueueSession createQueueSession() throws JMSException{
		return createQueueConnection().createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
	}
	
	public Context getContext(){
		return context;
	}
	
	public void cloceJMS() throws NamingException{
		context.close();
	}
	
}