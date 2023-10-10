package org.skillfactory.comparators;


import org.skillfactory.model.University;

public class UniversityYearOfFoundationComparator implements UniversityComparator{
    @Override
    public int compare(University v1, University v2) {
        return Integer.compare(v1.getYearOfFoundation(), v2.getYearOfFoundation());
    }
}
