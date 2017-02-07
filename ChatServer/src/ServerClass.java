import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ServerClass extends UnicastRemoteObject implements ServerRemote
{
    Vector v1 = new Vector(1,1);
    Vector v2 = new Vector(1,1);
    public ServerClass() throws RemoteException
    {
        super();
    }
    public static void main(String a[])
    {
        try{
            ServerClass sc = new ServerClass();
            Naming.rebind("chatserver",sc);
            System.out.println("Server Registered");
        }
        catch(Exception e)
        {}
    }

    @Override
    public void registerUser(String name, ClientRemote cr) throws RemoteException 
    {
        System.out.println(name);
        v1.addElement(name);
        v2.addElement(cr);
        for(int i=0;i<v2.size();i++)
        {
            try {
                ClientRemote c = (ClientRemote)v2.elementAt(i);
                c.refreshList(v1);
            } catch (Exception ex) {
                Logger.getLogger(ServerClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void sendMessage(String msg) throws RemoteException {
        for(int i = 0;i<v2.size();i++)
        {
            ClientRemote c = (ClientRemote)v2.elementAt(i);
            c.setMessage(msg);
        }
    }
}
