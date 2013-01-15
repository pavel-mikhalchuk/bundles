package com.prettybit.bundles;

import com.prettybit.bundles.entity.Bundle;
import com.prettybit.bundles.entity.Java;

import java.io.File;
import java.util.Map;

import static com.google.common.collect.Maps.toMap;

/**
 * @author Pavel Mikhalchuk
 */
public class MacOSBundleAssembler implements BundleAssembler {

    private static Map<Java.Version, String> java = toMap(Java.Version.list(), Java.Version.getFileFunction());

    @Override
    public File assemble(Bundle bundle) {
        return new File(java.get(bundle.getJava().getVersion()));
    }

}
