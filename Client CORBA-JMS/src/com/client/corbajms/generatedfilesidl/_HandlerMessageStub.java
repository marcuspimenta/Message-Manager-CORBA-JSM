package com.client.corbajms.generatedfilesidl;

/**
 * Comminication/_HandlerMessageStub.java . Generated by the IDL-to-Java
 * compiler (portable), version "3.2" from CommicationIDL.idl Ter�a-feira, 7 de
 * Maio de 2013 15h54min44s GMT-03:00
 */

public class _HandlerMessageStub extends org.omg.CORBA.portable.ObjectImpl
		implements HandlerMessage {

	public void registerUser(String username) {
		org.omg.CORBA.portable.InputStream $in = null;
		try {
			org.omg.CORBA.portable.OutputStream $out = _request("registerUser",
					true);
			$out.write_string(username);
			$in = _invoke($out);
			return;
		} catch (org.omg.CORBA.portable.ApplicationException $ex) {
			$in = $ex.getInputStream();
			String _id = $ex.getId();
			throw new org.omg.CORBA.MARSHAL(_id);
		} catch (org.omg.CORBA.portable.RemarshalException $rm) {
			registerUser(username);
		} finally {
			_releaseReply($in);
		}
	} // registerUser

	public void sendMessage(Message message) {
		org.omg.CORBA.portable.InputStream $in = null;
		try {
			org.omg.CORBA.portable.OutputStream $out = _request("sendMessage",
					true);
			MessageHelper.write($out, message);
			$in = _invoke($out);
			return;
		} catch (org.omg.CORBA.portable.ApplicationException $ex) {
			$in = $ex.getInputStream();
			String _id = $ex.getId();
			throw new org.omg.CORBA.MARSHAL(_id);
		} catch (org.omg.CORBA.portable.RemarshalException $rm) {
			sendMessage(message);
		} finally {
			_releaseReply($in);
		}
	} // sendMessage

	public String[] retrieveQueueAndTopics() {
		org.omg.CORBA.portable.InputStream $in = null;
		try {
			org.omg.CORBA.portable.OutputStream $out = _request(
					"retrieveQueueAndTopics", true);
			$in = _invoke($out);
			String $result[] = CollectionStringHelper.read($in);
			return $result;
		} catch (org.omg.CORBA.portable.ApplicationException $ex) {
			$in = $ex.getInputStream();
			String _id = $ex.getId();
			throw new org.omg.CORBA.MARSHAL(_id);
		} catch (org.omg.CORBA.portable.RemarshalException $rm) {
			return retrieveQueueAndTopics();
		} finally {
			_releaseReply($in);
		}
	} // retrieveQueueAndTopics

	public String[] retrieveMessages(String origin) {
		org.omg.CORBA.portable.InputStream $in = null;
		try {
			org.omg.CORBA.portable.OutputStream $out = _request(
					"retrieveMessages", true);
			$out.write_string(origin);
			$in = _invoke($out);
			String $result[] = CollectionStringHelper.read($in);
			return $result;
		} catch (org.omg.CORBA.portable.ApplicationException $ex) {
			$in = $ex.getInputStream();
			String _id = $ex.getId();
			throw new org.omg.CORBA.MARSHAL(_id);
		} catch (org.omg.CORBA.portable.RemarshalException $rm) {
			return retrieveMessages(origin);
		} finally {
			_releaseReply($in);
		}
	} // retrieveMessages

	// Type-specific CORBA::Object operations
	private static String[] __ids = { "IDL:Comminication/HandlerMessage:1.0" };

	public String[] _ids() {
		return (String[]) __ids.clone();
	}

	private void readObject(java.io.ObjectInputStream s)
			throws java.io.IOException {
		String str = s.readUTF();
		String[] args = null;
		java.util.Properties props = null;
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, props);
		try {
			org.omg.CORBA.Object obj = orb.string_to_object(str);
			org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)
					._get_delegate();
			_set_delegate(delegate);
		} finally {
			orb.destroy();
		}
	}

	private void writeObject(java.io.ObjectOutputStream s)
			throws java.io.IOException {
		String[] args = null;
		java.util.Properties props = null;
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, props);
		try {
			String str = orb.object_to_string(this);
			s.writeUTF(str);
		} finally {
			orb.destroy();
		}
	}
} // class _HandlerMessageStub
