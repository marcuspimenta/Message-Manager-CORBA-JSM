package com.client.corbajms.generatedfilesidl;

/**
 * Comminication/HandlerMessageOperations.java . Generated by the IDL-to-Java
 * compiler (portable), version "3.2" from CommicationIDL.idl Ter�a-feira, 7 de
 * Maio de 2013 15h54min44s GMT-03:00
 */

public interface HandlerMessageOperations {
	void registerUser(String username);

	void sendMessage(Message message);

	String[] retrieveQueueAndTopics();

	String[] retrieveMessages(String origin);
} // interface HandlerMessageOperations
