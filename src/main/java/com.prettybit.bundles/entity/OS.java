package com.prettybit.bundles.entity;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author Pavel Mikhalchuk
 */
public abstract class OS {

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof OS)) return false;
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}