package by.bsuir.german;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

public class Launcher {

    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname","127.0.0.1");
        RemoteServer obj;
        IRemoteServer stub;
        try {
            obj = new RemoteServer();
            Registry registry = LocateRegistry.createRegistry(1099);
            stub = (IRemoteServer) UnicastRemoteObject.exportObject(obj, 1099);
            registry.rebind("Sum", stub);
            System.out.println("Server is running...");
            while (true){

            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
