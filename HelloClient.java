import helloworld.HelloWorld;  
import helloworld.HelloWorldHelper;  
  
import org.omg.CORBA.ORB;  
import org.omg.CORBA.ORBPackage.InvalidName;  
import org.omg.CosNaming.NamingContextExt;  
import org.omg.CosNaming.NamingContextExtHelper;  
import org.omg.CosNaming.NamingContextPackage.CannotProceed;  
import org.omg.CosNaming.NamingContextPackage.NotFound;  
  
  
public class HelloClient {  
    static HelloWorld helloWorldImpl;  
       
    static {  
        System.out.println("client start to connect with server.......");  
           
        String args[] = new String[4];  
        args[0] = "-ORBInitialHost";  
        args[1] = "127.0.0.1";  
        args[2] = "-ORBInitialPort";  
        args[3] = "1050";  
           
        ORB orb = ORB.init(args, null);  
           
        org.omg.CORBA.Object objRef = null;  
        try {  
            objRef = orb.resolve_initial_references("NameService");  
        } catch (InvalidName e) {  
            e.printStackTrace();  
        }  
        NamingContextExt neRef = NamingContextExtHelper.narrow(objRef);  
           
        String name = "Hello";  
        try {  
              
            helloWorldImpl = HelloWorldHelper.narrow(neRef.resolve_str(name));  
        } catch (NotFound e) {  
            e.printStackTrace();  
        } catch (CannotProceed e) {  
            e.printStackTrace();  
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {  
            e.printStackTrace();  
        }  
           
        System.out.println("client connected server.......");  
    }  
       
    public static void main(String args[]) throws Exception {  
        sayHello();  
    }  
       
    public static void sayHello() {  
        String str = helloWorldImpl.sayHello();  
        System.out.println(str);  
    }  
}  