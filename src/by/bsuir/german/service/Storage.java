package by.bsuir.german.service;

import by.bsuir.german.entity.*;
import by.bsuir.german.entity.tabled.AdornmentExtended;
import by.bsuir.german.interfaces.ITitle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Storage implements Serializable {

    private Logic logic;

    public Storage(Logic logic) {
        this.logic = logic;
    }

    private List<Stone> stones;// = new ArrayList<>();
    private List<Metal> metals;// = new ArrayList<>();
    private List<Adornment> adornments;// = new ArrayList<>();
    private List<RingBase> ringBases;// = new ArrayList<>();
    private List<NecklaceBase> necklaceBases;// = new ArrayList<>();
    private List<EarringBase> earringBases;// = new ArrayList<>();

    private ObservableList<AdornmentExtended> adornmentExtendedList;

    public Storage(List<Stone> stones, List<Metal> metals, List<Adornment> adornments,
                   List<RingBase> ringBases, List<NecklaceBase> necklaceBases, List<EarringBase> earringBases) {
        this.stones = stones;
        this.metals = metals;
        this.adornments = adornments;
        this.ringBases = ringBases;
        this.necklaceBases = necklaceBases;
        this.earringBases = earringBases;
    }

    public Storage() {
        this.stones = new ArrayList<>();
        this.metals = new ArrayList<>();
        this.adornments = new ArrayList<>();
        this.ringBases = new ArrayList<>();
        this.necklaceBases = new ArrayList<>();
        this.earringBases = new ArrayList<>();
        this.adornmentExtendedList = FXCollections.observableArrayList();
    }

    public void fillAdornmentObservableList (){
        for (Adornment adornment:adornments){
            adornmentExtendedList.add(new AdornmentExtended(adornment));
        }
    }

    public ObservableList<AdornmentExtended> getAdornmentExtendedList () {return  adornmentExtendedList;}

    public void addAdormentExtendedOnStock (AdornmentExtended adornmentExtended){adornmentExtendedList.add(adornmentExtended);}

    public List<Stone> getStones() {
        return stones;
    }

    public List<Metal> getMetals() {
        return metals;
    }

    public List<Adornment> getAdornments() {
        return adornments;
    }

    public List<RingBase> getRingBases() {
        return ringBases;
    }

    public List<NecklaceBase> getNecklaceBases() {
        return necklaceBases;
    }

    public List<EarringBase> getEarringBases() {
        return earringBases;
    }

    public void addRingBaseOnStock(RingBase ringBase) {
        ringBases.add(ringBase);
    }

    public void addNecklaceBaseOnStock(NecklaceBase necklaceBase) {
        necklaceBases.add(necklaceBase);
    }

    public void addEarringBaseOnStock(EarringBase earringBase) {
        earringBases.add(earringBase);
    }

    public void addStoneOnStock(Stone stone) {
        stones.add(stone);
    }

    public void addMetalOnStock(Metal metal) {
        metals.add(metal);
    }

    public void addAdornmentOnStock(Adornment adornment) {
        adornments.add(adornment);
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


    public void printAll() {
        System.out.println("-------------Металлы, хранящиеся на складе:");
        System.out.println(getTitles(metals));
        System.out.println("-------------Камни, хранящиеся на складе:");
        System.out.println(getTitles(stones));
        System.out.println("-------------Основы для колец, хранящиеся на складе:");
        System.out.println(getTitles(ringBases));
        System.out.println("-------------Основы для ожерелий, хранящиеся на складе:");
        System.out.println(getTitles(ringBases));
        System.out.println("-------------Основы для серег, хранящиеся на складе:");
        System.out.println(getTitles(earringBases));
        System.out.println("-------------Украшения, хранящиеся на складе:");
        System.out.println(getTitles(adornments));
    }

    public String getAdormentTitles() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < getAdornments().size(); i++){
            stringBuilder.append(i+1+adornments.get(i).getTitle()+" ");
        }
        return stringBuilder.toString();
    }
}
