import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerMethods extends Remote{
    public void setServerTurn() throws RemoteException;
    public void startServer() throws RemoteException;
    public void moveRemote(Location from, Location to) throws RemoteException;
    public void killRemote(Location whome, Location byWhome) throws RemoteException;
}
