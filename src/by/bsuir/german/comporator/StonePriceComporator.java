package by.bsuir.german.comporator;

import by.bsuir.german.entity.Stone;

import java.util.Comparator;

public class StonePriceComporator implements Comparator<Stone> {
    @Override
    public int compare(Stone o1, Stone o2) {
        return Double.compare(o1.getPrice(),o2.getPrice());
    }
}
