import javax.naming.*;

public class HelloServiceServer {
	public static void main(String[] args) {
		try {
			HelloService service = new HelloServiceImpl("HelloService"); 
			Context namingContext=new InitialContext();
			namingContext.rebind("rmi:HelloService", service); 

			System.out.println("register the helloService to JNDI");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}