package com.prettybit.bundles.entity.web;

import com.prettybit.bundles.entity.Bundle;
import com.prettybit.bundles.entity.Java;
import com.prettybit.bundles.entity.Maven;
import com.prettybit.bundles.web.BundleParser;
import org.junit.Test;

import static com.prettybit.bundles.entity.Java.Version.JSE_7_U10_MAC_OS_X_68;
import static com.prettybit.bundles.entity.Maven.Version.MVN_2_0_10;
import static org.junit.Assert.assertEquals;

/**
 * @author Pavel Mikhalchuk
 */
public class BundleParserTest {

    @Test
    public void testParse() {
        assertEquals(new Bundle(new Java(JSE_7_U10_MAC_OS_X_68)), BundleParser.parse("{\"java\":{\"version\":\"JSE_7_U10_MAC_OS_X_68\"}}"));
        assertEquals(new Bundle(new Maven(MVN_2_0_10)), BundleParser.parse("{\"maven\":{\"version\":\"MVN_2_0_10\"}}"));
        assertEquals(new Bundle(new Java(JSE_7_U10_MAC_OS_X_68), new Maven(MVN_2_0_10)),
                BundleParser.parse("{\"java\":{\"version\":\"JSE_7_U10_MAC_OS_X_68\"},\"maven\":{\"version\":\"MVN_2_0_10\"}}"));
    }

}