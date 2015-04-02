import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {
	private String name;

	public HelloServiceImpl(String name) throws RemoteException {
		this.name=name;
	}

	public String echo(String msg) throws RemoteException {
		System.out.println("call echo function");
		return "echo:" + msg + " from " + name;
	}

	public int findmax(int[] arrays) throws RemoteException {
		int max = arrays[0];
		for (int i : arrays) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}
}