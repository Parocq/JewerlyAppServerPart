package by.bsuir.german.service;

import by.bsuir.german.entity.*;
import javafx.collections.ObservableList;

import java.util.List;

public interface ILogic {
    void fillStorage(Storage st);

    void sortMetalByTitle(List<Metal> list);

    void sortStonesByTitle(List<Stone> list);

    void sortRingBaseByTitle(List<RingBase> list);

    void sortEarringBaseByTitle(List<EarringBase> list);

    void sortNecklaceBaseByTitle(List<NecklaceBase> list);

    void sortAdornmentByTitle(List<Adornment> list);

    void sortStonesByPrice(List<Stone> list);

    double calculateWeight(Adornment adornment);

    double calculatePrice(Adornment adornment);

    List<Stone> searchForTransparence(double start, double finish);

    ObservableList<Stone> convertArrayListToObservableListS();

    ObservableList<Metal> convertArrayListToObservableListM();
}
