package by.bsuir.german.comporator;

import by.bsuir.german.entity.Stone;

import java.util.Comparator;

public class StoneTitleComparator implements Comparator<Stone> {
    @Override
    public int compare(Stone o1, Stone o2){
        return (o1.getTitle().compareTo(o2.getTitle()));
    }
}
