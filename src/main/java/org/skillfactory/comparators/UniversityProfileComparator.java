package org.skillfactory.comparators;

import org.apache.commons.lang3.StringUtils;
import org.skillfactory.model.University;

public class UniversityProfileComparator implements UniversityComparator{
    @Override
    public int compare(University v1, University v2) {
        if (null == v1.getMainProfile()) {
            return 1;
        } else if (null == v2.getMainProfile()) {
            return -1;
        }
        return StringUtils.compare(v1.getMainProfile().name(), v2.getMainProfile().name());
    }
}
