package com.prettybit.bundles.web;

import com.prettybit.bundles.entity.Bundle;
import net.minidev.json.JSONValue;
import org.glassfish.jersey.internal.ProcessingException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author Pavel Mikhalchuk
 */
public class BundleParser {

    public static Bundle decodeAndParse(String encodedJson) {
        try {
            return BundleParser.parse(URLDecoder.decode(encodedJson, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new ProcessingException(e);
        }
    }

    public static Bundle parse(String json) {
        return JSONValue.parse(json, Bundle.class);
    }

}