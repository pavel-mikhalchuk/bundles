package com.prettybit.bundles.entity;

import com.google.common.base.Function;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author Pavel Mikhalchuk
 */
public class Maven {

    private Version version;

    public Maven() {
    }

    public Maven(Version version) {
        this.version = version;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Maven)) return false;
        if (!ObjectUtils.equals(this.version, ((Maven) obj).version)) return false;
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public enum Version {

        MVN_2_0_10("Maven 2.0.10", "/maven/2/apache-maven-2.0.10-bin.zip");

        private static final String BASE = "/Users/pacan/bundles";

        private String display;
        private String file;

        private Version(String display, String file) {
            this.display = display;
            this.file = file;
        }

        public String getDisplay() {
            return display;
        }

        public String getFile() {
            return BASE + file;
        }

        public static List<Version> list() { return newArrayList(values()); }

        public static Function<Version, String> getFileFunction() {
            return new Function<Version, String>() {
                @Override
                public String apply(Version version) { return version.getFile(); }
            };
        }

    }

}