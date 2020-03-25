package by.bsuir.german.service;

import by.bsuir.german.entity.*;
import by.bsuir.german.entity.tabled.AdornmentExtended;
import by.bsuir.german.interfaces.ITitle;
import javafx.collections.ObservableList;

import java.rmi.Remote;
import java.util.List;

interface IStorageWorker extends Remote {

    void fillAdornmentObservableList();

    void addAdormentExtendedOnStock (AdornmentExtended adornmentExtended);

    void addRingBaseOnStock(RingBase ringBase);

    void addNecklaceBaseOnStock(NecklaceBase necklaceBase);

    void addEarringBaseOnStock(EarringBase earringBase);

    void addStoneOnStock(Stone stone);

    void addMetalOnStock(Metal metal);

    void addAdornmentOnStock(Adornment adornment);

    String getTitles(List<? extends ITitle> objects);

    String getAdormentTitles();
}
