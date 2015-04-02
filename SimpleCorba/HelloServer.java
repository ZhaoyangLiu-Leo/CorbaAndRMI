import helloworld.HelloWorld;  
import helloworld.HelloWorldHelper;  
  
import org.omg.CORBA.ORB;  
import org.omg.CORBA.ORBPackage.InvalidName;  
import org.omg.CosNaming.NameComponent;  
import org.omg.CosNaming.NamingContextExt;  
import org.omg.CosNaming.NamingContextExtHelper;  
import org.omg.CosNaming.NamingContextPackage.CannotProceed;  
import org.omg.CosNaming.NamingContextPackage.NotFound;  
import org.omg.PortableServer.POA;  
import org.omg.PortableServer.POAHelper;  
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;  
import org.omg.PortableServer.POAPackage.ServantNotActive;  
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class HelloServer {  
    public static void main(String[] args) throws ServantNotActive, WrongPolicy, InvalidName, AdapterInactive, org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound, CannotProceed {  
        args = new String[2];  
        args[0] = "-ORBInitialPort";  
        args[1] = "1050";  
           
        ORB orb = ORB.init(args, null);  
           
        org.omg.CORBA.Object obj=orb.resolve_initial_references("RootPOA");  
        POA rootpoa = POAHelper.narrow(obj);  
        rootpoa.the_POAManager().activate();  

        HelloWorldImpl helloImpl = new HelloWorldImpl();  
          
        org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);  
        HelloWorld href = HelloWorldHelper.narrow(ref);  
           
        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");  
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);  
          
        String name = "Hello";  
        NameComponent path[] = ncRef.to_name(name);  
        ncRef.rebind(path, href);  
          
        orb.run();  
          
        System.out.println("server startup...");  
    }  
} 