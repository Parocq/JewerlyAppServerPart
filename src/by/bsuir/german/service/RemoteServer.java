package by.bsuir.german.service;

import by.bsuir.german.comporator.*;
import by.bsuir.german.entity.*;
import by.bsuir.german.entity.tabled.AdornmentExtended;
import by.bsuir.german.interfaces.ITitle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoteServer implements IRemoteServer {

    private Storage storage;
    private StorageWorker storageWorker;

    public RemoteServer(Storage storage, StorageWorker storageWorker) {
        this.storage = storage;
        this.storageWorker = storageWorker;
    }

    public void fillStorage(Storage st) throws RemoteException {
        List<Stone> stones = st.getStones();
        List<Metal> metals = st.getMetals();
        List<Adornment> adornments = st.getAdornments();
        List<RingBase> ringBases = st.getRingBases();
        List<NecklaceBase> necklaceBases = st.getNecklaceBases();
        List<EarringBase> earringBases = st.getEarringBases();

        for (int i = 0; i < stones.size(); i++) {
            storageWorker.addStoneOnStock(stones.get(i));
        }
        for (int i = 0; i < metals.size(); i++) {
            storageWorker.addMetalOnStock(metals.get(i));
        }
        for (int i = 0; i < adornments.size(); i++) {
            storageWorker.addAdornmentOnStock(adornments.get(i));
        }
        for (int i = 0; i < ringBases.size(); i++) {
            storageWorker.addRingBaseOnStock(ringBases.get(i));
        }
        for (int i = 0; i < necklaceBases.size(); i++) {
            storageWorker.addNecklaceBaseOnStock(necklaceBases.get(i));
        }
        for (int i = 0; i < earringBases.size(); i++) {
            storageWorker.addEarringBaseOnStock(earringBases.get(i));
        }
    }

    public void sortMetalByTitle(List<Metal> list) throws RemoteException {
        Collections.sort(list, new MetalTitleComparator());
    }

    public void sortStonesByTitle(List<Stone> list) throws RemoteException {
        Collections.sort(list, new StoneTitleComparator());
    }

    public void sortRingBaseByTitle(List<RingBase> list) throws RemoteException {
        Collections.sort(list, new RingBaseTitleComporator());
    }

    public void sortEarringBaseByTitle(List<EarringBase> list)throws RemoteException {
        Collections.sort(list, new EarringBaseTitleComparator());
    }

    public void sortNecklaceBaseByTitle(List<NecklaceBase> list)throws RemoteException {
        Collections.sort(list, new NecklaceBaseTitleComparator());
    }

    public void sortAdornmentByTitle(List<Adornment> list)throws RemoteException {
        Collections.sort(list, new AdormentTitleComparator());
    }

    public void sortStonesByPrice(List<Stone> list)throws RemoteException {
        Collections.sort(list, new StonePriceComporator());
    }


    public double calculateWeight(Adornment adornment) throws RemoteException {
        double sum = 0;

        double weight = 0;
        if (adornment.getEarring() != null) {
            weight = adornment.getEarring().getWeight();
        } else if (adornment.getNecklace() != null) {
            weight = adornment.getNecklace().getWeight();
        } else weight += adornment.getRing().getWeight();

        for (int i = 0; i < adornment.getUsedStones().size(); i++) {
            sum += adornment.getUsedStones().get(i).getWeight();
        }
        return sum + weight;
    }

    public double calculatePrice(Adornment adornment) throws RemoteException {
        double sum = 0;

        double price = 0;
        if (adornment.getEarring() != null) {
            price = adornment.getEarring().getPrice();
        } else if (adornment.getNecklace() != null) {
            price = adornment.getNecklace().getPrice();
        } else price += adornment.getRing().getPrice();

        for (int i = 0; i < adornment.getUsedStones().size(); i++) {
            sum += adornment.getUsedStones().get(i).getPrice();
        }
        return sum + price;
    }

    public List<Stone> searchForTransparence(double start, double finish) throws RemoteException {
        List<Stone> suit = new ArrayList<>();
        for (int i = 0; i < storage.getStones().size(); i++) {
            if (storage.getStones().get(i).getTransparence() >= start && storage.getStones().get(i).getTransparence() <= finish) {
                suit.add(storage.getStones().get(i));
            }
        }
        return suit;
    }

//    public ObservableList<Stone> convertArrayListToObservableListS() throws RemoteException {
//        ObservableList<Stone> observableList =  FXCollections.observableArrayList();
//        observableList.addAll(storage.getStones());
//        return observableList;
//    }
//
//    public ObservableList<Metal> convertArrayListToObservableListM() throws RemoteException {
//        ObservableList<Metal> observableList =  FXCollections.observableArrayList();
//        observableList.addAll(storage.getMetals());
//        return observableList;
//    }

    public String getTitles(List<? extends ITitle> objects) throws RemoteException {
        StringBuilder stringBuilder = new StringBuilder();
        if (objects.isEmpty()) {
            return stringBuilder.toString();
        }

        for (int i=0;i<objects.size();i++){
            stringBuilder.append((objects.get(i).getTitle()+" | "));
        }
        return stringBuilder.toString();
    }

    public String getAdornmentTitles() throws RemoteException {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < storage.getAdornments().size(); i++){
            stringBuilder.append(i+1+storage.getAdornments().get(i).getTitle()+" ");
        }
        return stringBuilder.toString();
    }


    public void fillAdornmentObservableList () throws RemoteException{
        for (Adornment adornment:storage.getAdornments()){
            storage.getAdornmentExtendedList().add(new AdornmentExtended(adornment));
        }
    }

//    @Override
//    public ObservableList<AdornmentExtended> getAdornmentExtendedList() throws RemoteException {
//        return  storage.getAdornmentExtendedList();
//    }

    public void addRingBaseOnStock(RingBase ringBase) throws RemoteException {
        storage.getRingBases().add(ringBase);
    }

    public void addNecklaceBaseOnStock(NecklaceBase necklaceBase) throws RemoteException {
        storage.getNecklaceBases().add(necklaceBase);
    }

    public void addEarringBaseOnStock(EarringBase earringBase) throws RemoteException {
        storage.getEarringBases().add(earringBase);
    }

    public void addStoneOnStock(Stone stone) throws RemoteException {
        storage.getStones().add(stone);
    }

    public void addMetalOnStock(Metal metal) throws RemoteException {
        storage.getMetals().add(metal);
    }

    public void addAdornmentOnStock(Adornment adornment) throws RemoteException {
        storage.getAdornments().add(adornment);
    }

//    public ObservableList<AdornmentExtended> getAdornmentExtendedList () {return  adornmentExtendedList;}

    public List<Stone> getStones()throws RemoteException {
        return storage.getStones();
    }

    public List<Metal> getMetals()throws RemoteException {
        return storage.getMetals();
    }

    public List<Adornment> getAdornments()throws RemoteException {
        return storage.getAdornments();
    }

    public List<RingBase> getRingBases()throws RemoteException {
        return storage.getRingBases();
    }

    public List<NecklaceBase> getNecklaceBases() throws RemoteException {
        return storage.getNecklaceBases();
    }

    public List<EarringBase> getEarringBases() throws RemoteException {
        return storage.getEarringBases();
    }

//    public void addAdornmentExtendedOnStock(AdornmentExtended adornmentExtended) throws RemoteException {
//        storage.getAdornmentExtendedList().add(adornmentExtended);
//    }
}
