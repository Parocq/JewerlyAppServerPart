package by.bsuir.german.service;

import by.bsuir.german.entity.*;
import by.bsuir.german.entity.tabled.AdornmentExtended;
import by.bsuir.german.interfaces.ITitle;

import java.util.List;

public class StorageWorker implements IStorageWorker {

    private Storage storage;

    public StorageWorker(Storage storage) {
        this.storage = storage;
    }

    public String getTitles(List<? extends ITitle> objects) {
        StringBuilder stringBuilder = new StringBuilder();
        if (objects.isEmpty()) {
            return stringBuilder.toString();
        }

        for (int i=0;i<objects.size();i++){
            stringBuilder.append((objects.get(i).getTitle()+" | "));
        }
        return stringBuilder.toString();
    }

    public String getAdormentTitles() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < storage.getAdornments().size(); i++){
            stringBuilder.append(i+1+storage.getAdornments().get(i).getTitle()+" ");
        }
        return stringBuilder.toString();
    }


    public void fillAdornmentObservableList (){
        for (Adornment adornment:storage.getAdornments()){
            storage.getAdornmentExtendedList().add(new AdornmentExtended(adornment));
        }
    }

    public void addRingBaseOnStock(RingBase ringBase) {
        storage.getRingBases().add(ringBase);
    }

    public void addNecklaceBaseOnStock(NecklaceBase necklaceBase) {
        storage.getNecklaceBases().add(necklaceBase);
    }

    public void addEarringBaseOnStock(EarringBase earringBase) {
        storage.getEarringBases().add(earringBase);
    }

    public void addStoneOnStock(Stone stone) {
        storage.getStones().add(stone);
    }

    public void addMetalOnStock(Metal metal) {
        storage.getMetals().add(metal);
    }

    public void addAdornmentOnStock(Adornment adornment) {
        storage.getAdornments().add(adornment);
    }

    public void addAdormentExtendedOnStock (AdornmentExtended adornmentExtended){storage.getAdornmentExtendedList().add(adornmentExtended);}


}
