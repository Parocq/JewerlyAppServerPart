package by.bsuir.german.service;

import by.bsuir.german.entity.*;
import by.bsuir.german.entity.tabled.AdornmentExtended;
import by.bsuir.german.interfaces.ITitle;
import javafx.collections.ObservableList;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IStorageWorker extends Remote {

    void fillAdornmentObservableList() throws RemoteException;

//    ObservableList<AdornmentExtended> getAdornmentExtendedList() throws RemoteException;

//    void addAdornmentExtendedOnStock(AdornmentExtended adornmentExtended) throws RemoteException;

    void addRingBaseOnStock(RingBase ringBase) throws RemoteException;

    void addNecklaceBaseOnStock(NecklaceBase necklaceBase) throws RemoteException;

    void addEarringBaseOnStock(EarringBase earringBase) throws RemoteException;

    void addStoneOnStock(Stone stone) throws RemoteException;

    void addMetalOnStock(Metal metal) throws RemoteException;

    void addAdornmentOnStock(Adornment adornment) throws RemoteException;

    String getTitles(List<? extends ITitle> objects) throws RemoteException;

    String getAdornmentTitles() throws RemoteException;

     List<Stone> getStones()throws RemoteException;

    public List<Metal> getMetals()throws RemoteException ;

    public List<Adornment> getAdornments()throws RemoteException;

    public List<RingBase> getRingBases()throws RemoteException;
    public List<NecklaceBase> getNecklaceBases() throws RemoteException;

    public List<EarringBase> getEarringBases() throws RemoteException ;
}
