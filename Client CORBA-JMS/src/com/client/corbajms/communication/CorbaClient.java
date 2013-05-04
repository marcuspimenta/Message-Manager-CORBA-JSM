package com.client.corbajms.communication;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 09:36:16 01/05/2013
 */
public class CorbaClient {
	
	private ORB orb;
	private org.omg.CORBA.Object referenceNameService;
	
	private NameComponent[] name;
	private NamingContext naming;
	
	public void initORB(String ipServer){
		orb = ORB.init(new String[]{ipServer},null);
	}
	
	public void referencesNameService() throws InvalidName{
		referenceNameService = orb.resolve_initial_references("NameService");
	}
	
	public void searchReferencesNameService(String nameComponent, String kindNameComponent) throws NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName{
		name = new NameComponent[]{new NameComponent(nameComponent,kindNameComponent)};
		naming = NamingContextHelper.narrow(referenceNameService);
	}

	public org.omg.CORBA.Object getReferenceObj() throws NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName{
		return naming.resolve(name);
	}
}