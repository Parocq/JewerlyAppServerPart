package by.bsuir.german.comporator;

import by.bsuir.german.entity.Metal;

import java.util.Comparator;

public class MetalTitleComparator implements Comparator<Metal> {
    @Override
    public int compare(Metal o1, Metal o2){
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
