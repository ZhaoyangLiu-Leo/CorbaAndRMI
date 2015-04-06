import javax.naming.*;

public class HelloServiceClient {
	public static void main(String[] args) {
		try {
			Context namingContext = new InitialContext();
			HelloService service = (HelloService)namingContext.lookup(
				"rmi://127.0.0.1:6006/HelloService");

			int[] arrays = {5, 9, 10, 3, 2};
			System.out.println(service.echo("RMI"));
			System.out.println("findMax: " + service.findmax(arrays)); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}