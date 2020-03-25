package by.bsuir.german.comporator;

import by.bsuir.german.entity.Adornment;

import java.util.Comparator;

public class AdormentTitleComparator implements Comparator<Adornment> {
    @Override
    public int compare(Adornment o1, Adornment o2){return o1.getTitle().compareTo(o2.getTitle());}
}
