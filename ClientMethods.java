import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientMethods extends Remote {
    public void setClientTurn() throws RemoteException;
    public void moveRemote(Location from, Location to) throws RemoteException;
    public void killRemote(Location whome, Location byWhome) throws RemoteException;
}
