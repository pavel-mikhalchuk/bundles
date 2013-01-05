package com.prettybit.bundles.entity.web;

import com.prettybit.bundles.entity.Bundle;
import com.prettybit.bundles.entity.Java;
import com.prettybit.bundles.web.BundleParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pavel Mikhalchuk
 */
public class BundleParserTest {

    @Test
    public void testParse() {
        assertEquals(new Bundle(new Java("1.6")), BundleParser.parse("{\"java\":{\"version\":\"1.6\"}}"));
        assertEquals(new Bundle(new Java("1.7")), BundleParser.parse("{\"java\":{\"version\":\"1.7\"}}"));
    }

}