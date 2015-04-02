import java.rmi.*;

public interface HelloService extends Remote {
	public String echo(String msg) throws RemoteException;
	public int findmax(int[] arrays) throws RemoteException;
}