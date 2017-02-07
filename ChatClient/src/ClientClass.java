import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JTextArea;
public class ClientClass extends UnicastRemoteObject implements ClientRemote
{
    public ClientClass(JList l, JTextArea t) throws RemoteException
    {
        super();
        this.l=l;
        this.t=t;
    }
    JList l;
    JTextArea t;
    @Override
    public void refreshList(Vector v) throws RemoteException {
        l.setListData(v);
    }

    @Override
    public void setMessage(String msg) throws RemoteException {
        String ee = t.getText();
        t.setText(ee+"\n"+msg);
    }
}
