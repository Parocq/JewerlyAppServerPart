package by.bsuir.german.entity.tabled;

import by.bsuir.german.entity.Adornment;
import by.bsuir.german.service.Logic;
import by.bsuir.german.service.Storage;

import java.util.List;

public class AdornmentExtended {
    private String title;
    private String type;
    private double price;
    private double weight;
    private String baseTitle;
    private String usedStones;

    private Storage storage = new Storage();
    private Logic logic = new Logic(storage);

    public AdornmentExtended(Logic logic, Storage storage) {
        this.logic = logic;
        this.storage = storage;
    }


    public AdornmentExtended(Adornment adornment) {
        this.title = adornment.getTitle();

        if (adornment.getEarring() != null) {
            this.type = adornment.getEarring().getType();
        } else if (adornment.getNecklace() != null) {
            this.type = adornment.getNecklace().getType();
        } else this.type = adornment.getRing().getType();

        this.price = logic.calculatePrice(adornment);
        this.weight = logic.calculateWeight(adornment);

        if (adornment.getEarring() != null) {
            this.baseTitle = adornment.getEarring().getTitle();
        } else if (adornment.getNecklace() != null) {
            this.baseTitle = adornment.getNecklace().getTitle();
        } else this.baseTitle = adornment.getRing().getTitle();

        this.usedStones = storage.getTitles(adornment.getUsedStones());
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public String getBaseTitle() {
        return baseTitle;
    }

    public String getUsedStones() {
        return usedStones;
    }
}

