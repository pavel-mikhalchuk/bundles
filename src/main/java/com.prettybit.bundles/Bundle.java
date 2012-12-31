package com.prettybit.bundles;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author Pavel Mikhalchuk
 */
public class Bundle {

    private Java java;

    public Bundle() {
    }

    public Bundle(Java java) {
        this.java = java;
    }

    public Java getJava() {
        return java;
    }

    public void setJava(Java java) {
        this.java = java;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Bundle)) return false;
        if (!ObjectUtils.equals(java, ((Bundle) obj).java)) return false;
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}