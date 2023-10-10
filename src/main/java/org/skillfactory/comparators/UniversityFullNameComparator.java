package org.skillfactory.comparators;

import org.apache.commons.lang3.StringUtils;
import org.skillfactory.model.University;

public class UniversityFullNameComparator implements UniversityComparator{
    @Override
    public int compare(University v1, University v2) {
        return StringUtils.compare(v1.getFullName(), v2.getFullName());
    }
}
