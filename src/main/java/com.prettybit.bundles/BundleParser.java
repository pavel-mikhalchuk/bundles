package com.prettybit.bundles;

import net.minidev.json.JSONValue;

/**
 * @author Pavel Mikhalchuk
 */
public class BundleParser {

    public static Bundle parse(String query) {
        return JSONValue.parse(query, Bundle.class);
    }

}