import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JTextArea;
public interface ServerRemote extends Remote
{
      public void registerUser(String name, ClientRemote cr)throws RemoteException;
      public void sendMessage(String message)throws RemoteException;

    public void sendMessage(JTextArea jTextArea2);
}
