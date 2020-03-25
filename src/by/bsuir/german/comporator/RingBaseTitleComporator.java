package by.bsuir.german.comporator;

import by.bsuir.german.entity.RingBase;

import java.util.Comparator;

public class RingBaseTitleComporator implements Comparator<RingBase> {
    @Override
    public int compare(RingBase o1, RingBase o2){
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
