package by.bsuir.german;

import by.bsuir.german.entity.Storage;
import by.bsuir.german.service.IRemoteServer;
import by.bsuir.german.service.Logic;
import by.bsuir.german.service.RemoteServer;
import by.bsuir.german.service.StorageWorker;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Launcher {


    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname","127.0.0.1");
        RemoteServer obj;
        IRemoteServer stub;
        Storage storage = new Storage();
        StorageWorker storageWorker = new StorageWorker(storage);
        Logic logic = new Logic(storage,storageWorker);
        try {
            obj = new by.bsuir.german.service.RemoteServer(storage,storageWorker);
            Registry registry = LocateRegistry.createRegistry(1099);
            stub = (IRemoteServer) UnicastRemoteObject.exportObject(obj, 1099);
            registry.rebind("String", stub);
            System.out.println("Server is running...");
            while (true){

            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
