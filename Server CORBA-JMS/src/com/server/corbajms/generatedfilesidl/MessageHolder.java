package com.server.corbajms.generatedfilesidl;

/**
 * Comminication/MessageHolder.java . Generated by the IDL-to-Java compiler
 * (portable), version "3.2" from CommicationIDL.idl Quarta-feira, 1 de Maio de
 * 2013 11h03min57s GMT-03:00
 */

public final class MessageHolder implements org.omg.CORBA.portable.Streamable {
	
	public Message value = null;

	public MessageHolder() {
	}

	public MessageHolder(Message initialValue) {
		value = initialValue;
	}

	public void _read(org.omg.CORBA.portable.InputStream i) {
		value = MessageHelper.read(i);
	}

	public void _write(org.omg.CORBA.portable.OutputStream o) {
		MessageHelper.write(o, value);
	}

	public org.omg.CORBA.TypeCode _type() {
		return MessageHelper.type();
	}

}