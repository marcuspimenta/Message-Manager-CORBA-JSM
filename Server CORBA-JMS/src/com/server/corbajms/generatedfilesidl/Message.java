package com.server.corbajms.generatedfilesidl;

/**
 * Comminication/Message.java . Generated by the IDL-to-Java compiler
 * (portable), version "3.2" from CommicationIDL.idl Ter�a-feira, 7 de Maio de
 * 2013 15h54min44s GMT-03:00
 */

public final class Message implements org.omg.CORBA.portable.IDLEntity {

	private static final long serialVersionUID = 1L;
	
	public String issuing = null;
	public String destination = null;
	public String body = null;

	public Message() {
	} // ctor

	public Message(String _issuing, String _destination, String _body) {
		issuing = _issuing;
		destination = _destination;
		body = _body;
	} // ctor

} // class Message
