package com.server.corbajms.generatedfilesidl;

/**
 * Comminication/HandlerMessageHolder.java . Generated by the IDL-to-Java
 * compiler (portable), version "3.2" from CommicationIDL.idl Ter�a-feira, 7 de
 * Maio de 2013 15h54min44s GMT-03:00
 */

public final class HandlerMessageHolder implements
		org.omg.CORBA.portable.Streamable {
	public HandlerMessage value = null;

	public HandlerMessageHolder() {
	}

	public HandlerMessageHolder(HandlerMessage initialValue) {
		value = initialValue;
	}

	public void _read(org.omg.CORBA.portable.InputStream i) {
		value = HandlerMessageHelper.read(i);
	}

	public void _write(org.omg.CORBA.portable.OutputStream o) {
		HandlerMessageHelper.write(o, value);
	}

	public org.omg.CORBA.TypeCode _type() {
		return HandlerMessageHelper.type();
	}

}
