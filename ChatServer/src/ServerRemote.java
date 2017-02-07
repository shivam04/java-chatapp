import java.rmi.Remote;
import java.rmi.RemoteException;
public interface ServerRemote extends Remote
{
    public void registerUser(String name, ClientRemote cr) throws RemoteException;
    public void sendMessage(String message)throws RemoteException;
}
