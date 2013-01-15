package com.prettybit.bundles.entity.web;

import com.prettybit.bundles.entity.Bundle;
import com.prettybit.bundles.entity.Java;
import com.prettybit.bundles.web.BundleParser;
import org.junit.Test;

import static com.prettybit.bundles.entity.Java.Version.JSE_7_U10_MAC_OS_X_68;
import static org.junit.Assert.assertEquals;

/**
 * @author Pavel Mikhalchuk
 */
public class BundleParserTest {

    @Test
    public void testParse() {
        assertEquals(new Bundle(new Java(JSE_7_U10_MAC_OS_X_68)),
                BundleParser.parse("{\"java\":{\"version\":\"JSE_7_U10_MAC_OS_X_68\"}}"));
    }

}