
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface ClientRemote extends Remote 
{
    public void refreshList(Vector v) throws RemoteException;
    public void setMessage(String msg)throws RemoteException; 
}
