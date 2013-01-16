package com.prettybit.bundles.entity;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author Pavel Mikhalchuk
 */
public class Bundle {

    private Java java;
    private Maven maven;

    public Bundle() {
    }

    public Bundle(Java java) {
        this.java = java;
    }

    public Bundle(Maven maven) {
        this.maven = maven;
    }

    public Bundle(Java java, Maven maven) {
        this.java = java;
        this.maven = maven;
    }

    public Java getJava() {
        return java;
    }

    public void setJava(Java java) {
        this.java = java;
    }

    public Maven getMaven() {
        return maven;
    }

    public void setMaven(Maven maven) {
        this.maven = maven;
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