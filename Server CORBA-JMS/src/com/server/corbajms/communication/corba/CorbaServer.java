package com.server.corbajms.communication.corba;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.Servant;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

/**
 * 
 * @author Marcus Pimenta
 * @email mvinicius.pimenta@gmail.com
 * @date 10:15:34 01/05/2013
 */
public class CorbaServer {
	
	private ORB orb;
	private POA rootPOA;
	private org.omg.CORBA.Object referenceNameService;
	private org.omg.CORBA.Object referenceOject;
	
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
	
	public void referencesRootPOA() throws InvalidName, AdapterInactive{
		org.omg.CORBA.Object referenceRootPOA = orb.resolve_initial_references("RootPOA");
		rootPOA = POAHelper.narrow(referenceRootPOA);
		rootPOA.the_POAManager().activate();
	}
	
	public void servantToRefecenreObject(Servant servant) throws ServantNotActive, WrongPolicy{
		referenceOject = rootPOA.servant_to_reference(servant);
	}
	
	public void bindObjectNameService() throws NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName{
		naming.rebind(name,referenceOject);
	}
	
	public void runORB(){
		orb.run();
	}
	
}