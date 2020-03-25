package by.bsuir.german.service;

import by.bsuir.german.comporator.*;
import by.bsuir.german.entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Logic implements ILogic {

    private StorageWorker storageWorker;
    private Storage storage;

    public Logic(Storage storage, StorageWorker storageWorker) {
        this.storageWorker = storageWorker;
    }

    public void fillStorage(Storage st) {
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

    public void sortMetalByTitle(List<Metal> list) {
        Collections.sort(list, new MetalTitleComparator());
    }

    public void sortStonesByTitle(List<Stone> list) {
        Collections.sort(list, new StoneTitleComparator());
    }

    public void sortRingBaseByTitle(List<RingBase> list) {
        Collections.sort(list, new RingBaseTitleComporator());
    }

    public void sortEarringBaseByTitle(List<EarringBase> list) {
        Collections.sort(list, new EarringBaseTitleComparator());
    }

    public void sortNecklaceBaseByTitle(List<NecklaceBase> list) {
        Collections.sort(list, new NecklaceBaseTitleComparator());
    }

    public void sortAdornmentByTitle(List<Adornment> list) {
        Collections.sort(list, new AdormentTitleComparator());
    }

    public void sortStonesByPrice(List<Stone> list) {
        Collections.sort(list, new StonePriceComporator());
    }


    public double calculateWeight(Adornment adornment) {
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

    public double calculatePrice(Adornment adornment) {
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

    public List<Stone> searchForTransparence(double start, double finish) {
        List<Stone> suit = new ArrayList<>();
        for (int i = 0; i < storage.getStones().size(); i++) {
            if (storage.getStones().get(i).getTransparence() >= start && storage.getStones().get(i).getTransparence() <= finish) {
                suit.add(storage.getStones().get(i));
            }
        }
        return suit;
    }

    public ObservableList<Stone> convertArrayListToObservableListS() {
        ObservableList<Stone> observableList =  FXCollections.observableArrayList();
        observableList.addAll(storage.getStones());
        return observableList;
    }

    public ObservableList<Metal> convertArrayListToObservableListM() {
        ObservableList<Metal> observableList =  FXCollections.observableArrayList();
        observableList.addAll(storage.getMetals());
        return observableList;
    }
}
