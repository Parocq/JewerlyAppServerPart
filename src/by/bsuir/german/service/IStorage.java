package by.bsuir.german.service;

import by.bsuir.german.entity.*;
import by.bsuir.german.entity.tabled.AdornmentExtended;
import by.bsuir.german.interfaces.ITitle;
import javafx.collections.ObservableList;

import java.util.List;

interface IStorage {

    void fillAdornmentObservableList();

    ObservableList<AdornmentExtended> getAdornmentExtendedList();

    void addAdormentExtendedOnStock (AdornmentExtended adornmentExtended);

    List<Stone> getStones();

    List<Metal> getMetals();

    List<Adornment> getAdornments();

    List<RingBase> getRingBases();

    List<NecklaceBase> getNecklaceBases();

    List<EarringBase> getEarringBases();

    void addRingBaseOnStock(RingBase ringBase);

    void addNecklaceBaseOnStock(NecklaceBase necklaceBase);

    void addEarringBaseOnStock(EarringBase earringBase);

    void addStoneOnStock(Stone stone);

    void addMetalOnStock(Metal metal);

    void addAdornmentOnStock(Adornment adornment);

    String getTitles(List<? extends ITitle> objects);

    void printAll();

    String getAdormentTitles();
}
