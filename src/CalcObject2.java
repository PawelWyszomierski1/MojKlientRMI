import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.Serializable;

public interface CalcObject2 extends Remote {
    public ResultType calculate(InputType inputParam) throws RemoteException;

}
