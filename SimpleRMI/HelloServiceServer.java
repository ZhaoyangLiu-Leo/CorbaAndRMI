import javax.naming.*;

public class HelloServiceServer {
	public static void main(String[] args) {
		try {
			HelloService service = new HelloServiceImpl("HelloService"); 
			Context namingContext=new InitialContext();
			java.rmi.registry.LocateRegistry.createRegistry(6006);
			namingContext.rebind("rmi://127.0.0.1:6006/HelloService", service); 

			System.out.println("register the helloService to JNDI");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}