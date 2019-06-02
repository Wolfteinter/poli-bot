package polibot_cliente;

import interfaces.Interface_cliente;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
/**
 *
 * @author wolfteinter
 */
public class Cliente extends UnicastRemoteObject implements Interface_cliente{
    private String nombre;
    private String email;
    
    public Cliente(String nombre,String email) throws RemoteException {
        super();
        this.nombre = nombre;
        this.email = email;
    }
    
    @Override
    public void enviarMsg(String msg) throws RemoteException {
        
    }

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getCorreo() throws RemoteException {
        return this.email;
    }
}
