package by.bsuir.german.comporator;

import by.bsuir.german.entity.NecklaceBase;

import java.util.Comparator;

public class NecklaceBaseTitleComparator implements Comparator<NecklaceBase> {
    @Override
    public int compare(NecklaceBase o1, NecklaceBase o2){return o1.getTitle().compareTo(o2.getTitle());}
}
