package by.bsuir.german.comporator;

import by.bsuir.german.entity.EarringBase;

import java.util.Comparator;

public class EarringBaseTitleComparator implements Comparator<EarringBase> {
    @Override
    public int compare(EarringBase o1, EarringBase o2){ return o1.getTitle().compareTo(o2.getTitle());}
}
